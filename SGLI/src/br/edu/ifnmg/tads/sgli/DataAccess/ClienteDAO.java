/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ClienteDAO extends PessoaDAO<Cliente> {

    private DAO bd;

    public ClienteDAO() {
        super();
        bd = new DAO();
    }
    //Salvar

    public boolean Salvar(Cliente obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into cliente(FisicaouJuridica,CNPJ,Ativo,Idpessoa) values(?,?,?,?)");
                sql.setInt(1, obj.getFisicaouJuridica());
                sql.setString(2, obj.getCNPJ());
                sql.setInt(3, obj.getAtivo());
                sql.setInt(4, obj.getCodigo());  // Verificar

                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.Salvar(obj);
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Cliente set FisicaouJuridica=?, CNPJ=?, ATIVO=? where IdPessoa=?");

                sql.setInt(1, obj.getFisicaouJuridica());
                sql.setString(2, obj.getCNPJ());
                sql.setInt(3, obj.getAtivo());
                sql.setInt(4, obj.getCodigo());

                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    public Cliente AbrirCliente(int id) {
        try {
            Cliente cliente = new Cliente();

            super.AbrirPessoa(cliente, id);




            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Cliente where IdPessoa=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                cliente.setCNPJ(resultado.getString("CNPJ"));
                cliente.setFisicaouJuridica(resultado.getInt("FisicaouJuridica"));
                return cliente;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update cliente set ativo = 0 where IdPessoa = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Cliente> buscar(Cliente filtro) {
        try {

            String sql = "select * from pessoa p join cliente c on p.IdPessoa = c.IdPessoa where ativo = 1 ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " Idpessoa = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            // Cria uma lista de produtos vazia
            List<Cliente> clientes = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Cliente tmp = new Cliente();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {
                    tmp.setCodigo(resultado.getInt("IdPessoa"));
                    tmp.setCNPJ(resultado.getString("CNPJ"));
                    tmp.setFisicaouJuridica(resultado.getInt("Ativo"));
                    tmp.setFisicaouJuridica(resultado.getInt("FisicaouJuridica"));
                } catch (Exception ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                clientes.add(tmp);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Cliente> ListarTodosCli() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Cliente C on P.IdPessoa = C.IdPessoa where C.ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Cliente> lista = new ArrayList<Cliente>();

            while (resultado.next()) {
                Cliente obj = new Cliente();

                super.CarregaObjetoPessoa(obj, resultado);

                obj.setCodigo(resultado.getInt("IdPessoa"));
                obj.setCNPJ(resultado.getString("CNPJ"));
                obj.setFisicaouJuridica(resultado.getInt("FisicaouJuridica"));


                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
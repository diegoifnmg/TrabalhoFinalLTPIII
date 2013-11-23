/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cliente;
import br.edu.ifnmg.tads.sgli.DomainModel.Email;
import br.edu.ifnmg.tads.sgli.DomainModel.Endereco;
import br.edu.ifnmg.tads.sgli.DomainModel.Pessoa;
import br.edu.ifnmg.tads.sgli.DomainModel.Telefone;
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
public class ClienteDAO extends PessoaDAO {

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
            super.Salvar(obj);
            try {
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

    public Cliente Abrir(int cod){
        Cliente cliente = new Cliente();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from cliente where Idcliente = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            cliente.setCodigo(resultado.getInt("IdCliente"));
            cliente.setFisicaouJuridica(resultado.getInt("FisicaOuJuridica"));
            cliente.setCNPJ(resultado.getString("CNPJ"));
            cliente.setCodigo(resultado.getInt("Idpessoa"));
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    

    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update cliente set ativo = 0 where IdCliente = ?");
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
                sql = sql  + where;
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
                    super.carregaObjeto(tmp, resultado);
                    tmp.setCNPJ(resultado.getString("CNPJ"));
                    tmp.setFisicaouJuridica(resultado.getInt("Ativo"));
                    tmp.setFisicaouJuridica(resultado.getInt("FisicaouJuridica"));
                } catch (Exception ex) {
                    Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                clientes.add(tmp);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public List<Cliente> ListarTodos(){
        
        try {
            List<Cliente> clientes = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from professores where ativo = 1 ORDER BY codprofessor ASC");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("IdCliente"));
                cliente.setFisicaouJuridica(resultado.getInt("FisicaOuJuridica"));
                cliente.setCNPJ(resultado.getString("CNPJ"));
                cliente.setCodigo(resultado.getInt("Idpessoa"));

                cliente.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
    
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Fornecedor;
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
public class FornecedorDAO extends PessoaDAO<Fornecedor> {

    private DAO bd;

    public FornecedorDAO() {
        super();
        bd = new DAO();
    }
    //Salvar

    public boolean Salvar(Fornecedor obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into fornecedor(CNPJ,Ativo,Idpessoa) values(?,?,?)");
                sql.setString(1, obj.getCNPJ());
                sql.setInt(2, obj.getAtivo());
                sql.setInt(3, obj.getCodigo());

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
                PreparedStatement sql = con.prepareStatement("update Fornecedor set CNPJ=?, ATIVO=? where IdPessoa=?");

                sql.setString(1, obj.getCNPJ());
                sql.setInt(2, obj.getAtivo());
                sql.setInt(3, obj.getCodigo());

                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    public Fornecedor AbrirFornecedor(int id) {
        try {
            Fornecedor fornecedor = new Fornecedor();

            super.AbrirPessoa(fornecedor, id);

            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Fornecedor where IdPessoa=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                fornecedor.setCNPJ(resultado.getString("CNPJ"));

                return fornecedor;
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
                    prepareStatement("update fornecedor set ativo = 0 where IdPessoa = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Fornecedor> buscar(Fornecedor filtro) {
        try {

            String sql = "select * from pessoa p join Fornecedor f on p.IdPessoa = f.IdPessoa where ativo = 1 ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "and nome like '%" + filtro.getNome() + "%'";
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
            List<Fornecedor> fornecedores = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Fornecedor tmp = new Fornecedor();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {

                    tmp.setCodigo(resultado.getInt("IdPessoa"));
                    tmp.setNome(resultado.getString("Nome"));
                    tmp.setCPF(resultado.getString("CPF"));
                    tmp.setRG(resultado.getString("RG"));
                    tmp.setDataNascimento(resultado.getDate("DataNascimento"));
                    tmp.setCNPJ(resultado.getString("CNPJ"));
                    tmp.setAtivo(resultado.getInt("Ativo"));

                } catch (Exception ex) {
                    Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                fornecedores.add(tmp);
            }
            return fornecedores;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Fornecedor> ListarTodosFornec() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Fornecedor f on P.IdPessoa = f.IdPessoa where C.ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Fornecedor> lista = new ArrayList<Fornecedor>();

            while (resultado.next()) {
                Fornecedor obj = new Fornecedor();

                super.CarregaObjetoPessoa(obj, resultado);

                obj.setCodigo(resultado.getInt("IdPessoa"));
                obj.setCNPJ(resultado.getString("CNPJ"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}

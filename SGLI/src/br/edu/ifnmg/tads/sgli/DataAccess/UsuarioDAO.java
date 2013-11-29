/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cliente;
import br.edu.ifnmg.tads.sgli.DomainModel.Usuario;
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
public class UsuarioDAO extends DAO{
    

    public UsuarioDAO() {
        super();
    }
    
    public boolean Salvar(Usuario obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into usuario(login,senha,IdPessoa) values(?,?,?)");
                sql.setString(1, obj.getLogin());
                sql.setString(2, obj.getSenha());
                sql.setInt(3, obj.getFuncionario().getCodigo());
                sql.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select IdUsuario from Usuario where login = ? and senha = ? and IdPessoa = ?");
                sqlConsulta.setString(1, obj.getLogin());
                sqlConsulta.setString(2, obj.getSenha());
                sqlConsulta.setInt(3, obj.getFuncionario().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("IdUsuario"));
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Usuario set login=?, senha=? where IdUsuario=? and IdPessoa=?");
                sqlUpdate.setString(1, obj.getLogin());
                sqlUpdate.setString(2, obj.getSenha());
                sqlUpdate.setInt(3, obj.getCodigo());
                sqlUpdate.setInt(4, obj.getFuncionario().getCodigo());

                sqlUpdate.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    public Usuario AbrirUsuario(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from Usuario where IdUsuario=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Usuario obj = new Usuario();                
                FuncionarioDAO fDAO = new FuncionarioDAO();
                
                obj.setCodigo(resultado.getInt("IdUsuario"));
                obj.setLogin(resultado.getString("login"));
                obj.setSenha(resultado.getString("senha"));
                obj.setFuncionario(fDAO.AbrirFuncionario(resultado.getInt("IdPessoa")));
           
                return obj;
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
            PreparedStatement comando = getConexao().
                    prepareStatement("update Usuario set ativo = 0 where IdPessoa = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Usuario> buscar(Usuario filtro) {
        try {

            String sql = "select * from Usuario where ativo = 1 ";
            String where = "";

            if (filtro.getLogin().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "and nome like '%" + filtro.getLogin() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " IdUsuario = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + where;
            }

            Statement comando = getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            // Cria uma lista de produtos vazia
            List<Usuario> usuarios = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Usuario tmp = new Usuario();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {
                    
                    tmp.setCodigo(resultado.getInt("IdUsuario"));
                    tmp.setLogin(resultado.getString("Login"));
                   
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                usuarios.add(tmp);
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Usuario> ListarTodosUsuarios() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from usuario where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Usuario> lista = new ArrayList<Usuario>();

            while (resultado.next()) {
                Usuario obj = new Usuario();

                obj.setCodigo(resultado.getInt("IdUsuario"));
                obj.setLogin(resultado.getString("Login"));
           
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}

    
    
    


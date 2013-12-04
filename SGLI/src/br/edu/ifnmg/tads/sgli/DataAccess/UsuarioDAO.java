/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

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

    //Método Salvar
    public boolean Salvar(Usuario obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into usuarios(login,senha,codFuncionario) values(?,?,?)");
                sql.setString(1, obj.getLogin());
                sql.setString(2, obj.getSenha());
                sql.setInt(3, obj.getFuncionario().getCodigo());
                sql.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codUsuario from Usuarios where login = ? and senha = ? and codFuncionario = ?");
                sqlConsulta.setString(1, obj.getLogin());
                sqlConsulta.setString(2, obj.getSenha());
                sqlConsulta.setInt(3, obj.getFuncionario().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codUsuario"));
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                //Atualiza os dados
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement
                        ("update Usuarios set login=?, senha=? where codUsuario=? and codFuncionario=?");
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

    //Método Remover Usuario
    public boolean RemoverUsuario(int codFuncionario) {
        try {
            PreparedStatement sqlRemover = getConexao().prepareStatement
                    ("delete from Usuarios where codFuncionario = ?");
            sqlRemover.setInt(1, codFuncionario);
            sqlRemover.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    //Método AbrirUsuario
    public Usuario AbrirUsuario(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Usuarios where codUsuario=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Usuario obj = new Usuario();
                FuncionarioDAO fDAO = new FuncionarioDAO();

                obj.setCodigo(resultado.getInt("codUsuario"));
                obj.setLogin(resultado.getString("login"));
                obj.setSenha(resultado.getString("senha"));
                obj.setFuncionario(fDAO.AbrirFuncionario(resultado.getInt("codFuncionario")));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Buscar usuarios
    public boolean AutenticarUsuario(Usuario usuario) {
        try {            
            PreparedStatement sql = getConexao().prepareStatement("select login,senha from usuarios");
            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                if ((usuario.getLogin().equals(resultado.getString("login")))
                        && (usuario.getSenha().equals(resultado.getString("senha")))) {
                    
                    return true;
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return false;
    }
    
}

    
    
    


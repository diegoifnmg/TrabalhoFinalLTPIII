/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                //Atualiza os dados
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement
                        ("update Usuario set login=?, senha=? where IdUsuario=? and IdPessoa=?");
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
    public boolean RemoverUsuario(int IdPessoa) {
        try {
            PreparedStatement sqlRemover = getConexao().prepareStatement
                    ("delete from Usuario where IdPessoa = ?");
            sqlRemover.setInt(1, IdPessoa);
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
            PreparedStatement sql = getConexao().prepareStatement("select * from Usuario where IdPessoa=?");
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

    //Buscar usuarios
    public boolean AutenticarUsuario(Usuario usuario) {
        try {            
            PreparedStatement sql = getConexao().prepareStatement("select login,senha from usuario");
            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
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
    
    public int RetornaCodFuncionario(Usuario usuario){
        try {            
            PreparedStatement sql = getConexao().prepareStatement("select * from usuario");
            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                if ((usuario.getLogin().equals(resultado.getString("login")))
                        && (usuario.getSenha().equals(resultado.getString("senha")))) {
                    
                    return resultado.getInt("IdPessoa");
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }
}

    
    
    


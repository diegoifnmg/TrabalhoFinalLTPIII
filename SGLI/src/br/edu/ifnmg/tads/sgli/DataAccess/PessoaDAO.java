/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

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
public class PessoaDAO<T extends Pessoa> extends DAO {

    private DAO bd;

    public PessoaDAO() {
        super();
        bd = new DAO();
    }
    //Salvar

    public boolean Salvar(T obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,DataNascimento,CPF,RG) values(?,?,?,?)");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setString(3, obj.getCPF());
                sql.setString(4, obj.getRG());

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select IdPessoa from pessoa where nome = ? and DataNascimento = ? and CPF = ? and RG = ?");
                sql2.setString(1, obj.getNome());
                sql2.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql2.setString(3, obj.getCPF());
                sql2.setString(4, obj.getRG());

                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("IdPessoa"));
                }

                // Salva o email
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                //Salva o Endereco 
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                // Salva o Telefone 
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set nome=?, DataNascimento=?, CPF=?, RG=? where IdPessoa=?");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setString(3, obj.getCPF());
                sql.setString(4, obj.getRG());
                sql.setInt(5, obj.getCodigo());
                sql.executeUpdate();

                // Salva o email
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                //Salva o Endereco 
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                // Salva o Telefone 
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    // Método Remover 

    public boolean Remover(T obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where IdPessoa=?");
                sql.setInt(1, obj.getCodigo());
                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
    //Abrir

    public void AbrirPessoa(T obj,int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where IdPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                
                
                CarregaObjetoPessoa(obj, resultado);

                AbrirTelefones(obj);
                AbrirEmails(obj);
                AbrirEnderecos(obj);

                
            } 
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            
        }
    }
    // Listar 

    public List<Pessoa> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa");

            ResultSet resultado = sql.executeQuery();

            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("IdPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));
                obj.setCPF(resultado.getString("CPF"));
                obj.setRG(resultado.getString("RG"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Telefone> ListarTodosTelefones() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Telefones");

            ResultSet resultado = sql.executeQuery();

            List<Telefone> lista = new ArrayList<Telefone>();

            while (resultado.next()) {
                Telefone obj = new Telefone();

                obj.setCodigo(resultado.getInt("IdTelefone"));
                obj.setDDD(resultado.getInt("DDD"));
                obj.setTelefone(resultado.getInt("telefone"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Endereco> ListarTodosEnderecos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Enderecos");

            ResultSet resultado = sql.executeQuery();

            List<Endereco> lista = new ArrayList<Endereco>();

            while (resultado.next()) {
                Endereco obj = new Endereco();

                obj.setCodigo(resultado.getInt("IdEndereco"));
                obj.setBairro(resultado.getString("bairro"));
                obj.setCidade(resultado.getString("cidade"));
                obj.setComplemento(resultado.getString("complemento"));
                obj.setCep(resultado.getString("cep"));
                obj.setRua(resultado.getString("rua"));
                obj.setEstado(resultado.getString("estado"));
                obj.setPais(resultado.getString("pais"));
                obj.setNumero(resultado.getInt("numero"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Endereco> ListarTodosEmais() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Emails");

            ResultSet resultado = sql.executeQuery();

            List<Endereco> lista = new ArrayList<Endereco>();

            while (resultado.next()) {
                Endereco obj = new Endereco();

                obj.setCodigo(resultado.getInt("IdEmail"));
                obj.setBairro(resultado.getString("Email"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    // Salvar Email 
    private void SalvarEmail(T pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into emails(IdPessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update emails set IdPessoa = ?, email = ? where IdEmail= ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //Salvar Endereco 

    private void SalvarEndereco(T pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into enderecos(IdPessoa,numero,rua,bairro,cidade,cep,complemento,estado,pais) values(?,?,?,?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getCep());
                sql.setString(7, obj.getComplemento());
                sql.setString(8, obj.getEstado());
                sql.setString(9, obj.getPais());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update enderecos set IdPessoa=?, numero=?, rua=?, bairro=?,cidade=?, complemento=?, estado=?, pais=? where IdEndereco = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getComplemento());
                sql.setString(7, obj.getEstado());
                sql.setString(8, obj.getPais());
                sql.setInt(9, obj.getCodigo());

                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //Salvar Telefones 

    private void SalvarTelefone(T pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefones(IdPessoa,telefone,DDD) values(?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getDDD());

                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefones set IdPessoa = ?, telefone = ?, DDD = ? where IdTelefone=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getDDD());

                sql.setInt(5, obj.getCodigo());

                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public List<Pessoa> buscar(Pessoa filtro) {
        try {

            String sql = "select * from pessoa ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " Idpessoa = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Pessoa> pessoas = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Pessoa tmp = new Pessoa();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {
                    tmp.setCodigo(resultado.getInt("Idpessoa"));
                    tmp.setNome(resultado.getString("nome"));
                    tmp.setDataNascimento(resultado.getDate("DataNascimento"));
                    tmp.setCPF(resultado.getString("CPF"));
                    tmp.setRG(resultado.getString("RG"));
                } catch (Exception ex) {
                    Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                pessoas.add(tmp);
            }
            return pessoas;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void AbrirTelefones(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from telefones where IdPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addTelefone(AbreTelefone(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Telefone AbreTelefone(ResultSet resultado) {
        Telefone tel = new Telefone();
        try {
            tel.setCodigo(resultado.getInt("IdTelefone"));
            tel.setDDD(resultado.getInt("DDD"));
            tel.setTelefone(resultado.getInt("telefone"));
            return tel;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void AbrirEnderecos(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from enderecos where IdPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addEndereco(AbreEndereco(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Endereco AbreEndereco(ResultSet resultado) {
        Endereco end = new Endereco();
        try {
            end.setCodigo(resultado.getInt("IdEndereco"));
            end.setBairro(resultado.getString("bairro"));
            end.setCep(resultado.getString("cep"));
            end.setCidade(resultado.getString("cidade"));
            end.setNumero(resultado.getInt("numero"));
            end.setRua(resultado.getString("rua"));
            end.setComplemento(resultado.getString("complemento"));
            end.setEstado(resultado.getString("estado"));
            end.setPais(resultado.getString("Pais"));

            return end;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void AbrirEmails(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from emails where IdPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addEmail(AbreEmail(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Email AbreEmail(ResultSet resultado) {
        Email ema = new Email();
        try {
            ema.setCodigo(resultado.getInt("IdEmail"));
            ema.setEmail(resultado.getString("email"));

            return ema;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }


    protected void CarregaObjetoPessoa(Pessoa obj, ResultSet resultado) throws SQLException, Exception {
        obj.setCodigo(resultado.getInt("IdPessoa"));
        obj.setNome(resultado.getString("Nome"));
        obj.setCPF(resultado.getString("CPF"));
        obj.setRG(resultado.getString("RG"));
        obj.setDataNascimento(resultado.getDate("DataNascimento"));
    }
}


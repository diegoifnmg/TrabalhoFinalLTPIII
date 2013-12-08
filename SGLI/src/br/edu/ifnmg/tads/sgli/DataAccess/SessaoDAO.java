/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class SessaoDAO extends DAO{
    
    //Construtor
    public SessaoDAO() {
        super();
    }

    //Salvar Sessão
    public boolean Salvar(Sessao obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into sessao(dataInicio,saldoAbertura,IdCaixa,IdUsuario) values(?,?,?,?)");

                sqlInsert.setDate(1, new java.sql.Date(obj.getDataInicio().getTime()));
                sqlInsert.setDouble(2, obj.getSaldoAbertura());
                sqlInsert.setInt(3, obj.getCaixa().getCodCaixa());
                sqlInsert.setInt(4, obj.getUsuario().getCodigo());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select max(IdSessao) from Sessao where dataInicio=? and saldoAbertura=? and IdUsuario=? and IdCaixa=?");
                sqlConsulta.setDate(1, new java.sql.Date(obj.getDataInicio().getTime()));
                sqlConsulta.setDouble(2, obj.getSaldoAbertura());
                sqlConsulta.setInt(3, obj.getUsuario().getCodigo());
                sqlConsulta.setInt(4, obj.getCaixa().getCodCaixa());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("max(IdSessao)"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Sessao set dataTermino=?, saldoFechamento=? where IdSessao=?");
                sql.setDate(1, new java.sql.Date(obj.getDataTermino().getTime()));
                sql.setDouble(2, obj.getSaldoFechamento());
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    public boolean Remover(Sessao obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement("delete from Sessao where IdSessao=?");
                sqlDelete.setInt(1, obj.getCodigo());
                sqlDelete.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }


    public Sessao Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from sessao where IdSessao=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Sessao obj = new Sessao();
                UsuarioDAO user = new UsuarioDAO();
                CaixaDAO caixa = new CaixaDAO();

                CarregaObjetoSessao(obj, resultado, user, caixa);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Listar Sessões
    public List<Sessao> ListarSessoes() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Sessao");

            ResultSet resultado = sql.executeQuery();

            List<Sessao> lista = new ArrayList<Sessao>();

            while (resultado.next()) {
                Sessao obj = new Sessao();
                UsuarioDAO user = new UsuarioDAO();
                CaixaDAO caixa = new CaixaDAO();

                CarregaObjetoSessao(obj, resultado, user, caixa);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Buscar
    public List<Sessao> Buscar(Sessao filtro) {
        try {
            String sql = "select * from Sessao ";
            String where = "";

            if (filtro.getDataInicio() != null) {
                where = " dataInicio > " + filtro.getDataInicio();
            }

            if (filtro.getDataTermino() != null) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = " dataTermino < " + filtro.getDataTermino();
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " IdSessao = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            List<Sessao> lista = new ArrayList<Sessao>();

            while (resultado.next()) {
                Sessao obj = new Sessao();
                UsuarioDAO user = new UsuarioDAO();
                CaixaDAO caixa = new CaixaDAO();

                CarregaObjetoSessao(obj, resultado, user, caixa);
                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }


    protected void CarregaObjetoSessao(Sessao obj, ResultSet resultado, UsuarioDAO user, CaixaDAO caixa) throws SQLException, Exception {
        obj.setCodigo(resultado.getInt("IdSessao"));
        obj.setDataInicio(resultado.getDate("dataAbertura"));
        obj.setDataTermino(resultado.getDate("dataTermino"));
        obj.setSaldoAbertura(resultado.getDouble("saldoAbertura"));
        obj.setSaldoFechamento(resultado.getDouble("saldoFechamento"));
        obj.setUsuario(user.AbrirUsuario(resultado.getInt("IdUsuario")));
        obj.setCaixa(caixa.AbrirCaixa(resultado.getInt("IdCaixa")));
    }
}

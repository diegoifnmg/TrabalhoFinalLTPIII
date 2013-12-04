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
                        ("insert into sessoes(dataInicio,saldoAbertura,codCaixa,codUsuario) values(?,?,?,?)");

                sqlInsert.setDate(1, new java.sql.Date(obj.getDataInicio().getTime()));
                //sqlInsert.setDate(2, new java.sql.Date(obj.getDataTermino().getTime()));
                sqlInsert.setDouble(3, obj.getSaldoAbertura());
                //sqlInsert.setDouble(4, obj.getSaldoFechamento());
                sqlInsert.setInt(5, obj.getCaixa().getCodCaixa());
                sqlInsert.setInt(6, obj.getUsuario().getCodigo());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codSessao from Sessoes where dataInicio=? and saldoAbertura=? and codUsuario=? and codCaixa=?");
                sqlConsulta.setDate(1, new java.sql.Date(obj.getDataInicio().getTime()));
                sqlConsulta.setDouble(2, obj.getSaldoAbertura());
                sqlConsulta.setInt(3, obj.getUsuario().getCodigo());
                sqlConsulta.setInt(4, obj.getCaixa().getCodCaixa());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codSessao"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Sessoes set dataTermino=?, saldoFechamento=? where codSessao=?");
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

    //Método Remover Sessão
    public boolean Remover(Sessao obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement("delete from Sessoes where codSessao=?");
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

    //Método Abrir Sessao
    public Sessao Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from sessoes where codSessao=?");
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
            PreparedStatement sql = getConexao().prepareStatement("select * from Sessoes");

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
            String sql = "select * from Sessoes ";
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
                where = where + " codSessao = " + filtro.getCodigo();
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

    //Método que carrega os dados da sessão
    protected void CarregaObjetoSessao(Sessao obj, ResultSet resultado, UsuarioDAO user, CaixaDAO caixa) throws SQLException, Exception {
        obj.setCodigo(resultado.getInt("codSessao"));
        obj.setDataInicio(resultado.getDate("dataAbertura"));
        obj.setDataTermino(resultado.getDate("dataTermino"));
        obj.setSaldoAbertura(resultado.getDouble("saldoAbertura"));
        obj.setSaldoFechamento(resultado.getDouble("saldoFechamento"));
        obj.setUsuario(user.AbrirUsuario(resultado.getInt("codUsuario")));
        obj.setCaixa(caixa.AbrirCaixa(resultado.getInt("codCaixa")));
    }
    
}

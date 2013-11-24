/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.GrupoProdutos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GrupoProdutosDAO extends DAO {

    private DAO bd;

    public GrupoProdutosDAO() {

        bd = new DAO();
    }

    public boolean Salvar(GrupoProdutos grupoProdutos) {
        try {
            if (grupoProdutos.getCodGrupoProdutos() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into grupoprodutos(nome) values(?)");
                comando.setString(1, grupoProdutos.getNome());

                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update grupoprodutos set nome = ? where idGrupoProdutos = ?");
                comando.setString(1, grupoProdutos.getNome());
                comando.setInt(2, grupoProdutos.getCodGrupoProdutos());

                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public GrupoProdutos Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from grupoprodutos where Idgrupoprodutos=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                GrupoProdutos obj = new GrupoProdutos();

                obj.setCodGrupoProdutos(resultado.getInt("Idgrupoprodutos"));
                obj.setNome(resultado.getString("Nome"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public List<GrupoProdutos> ListarTodosGrupos() {
        
        List<GrupoProdutos> gruposProdutos = new LinkedList<>();
        
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from grupoprodutos");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                
                GrupoProdutos grupoProdutos = new GrupoProdutos();
                
                grupoProdutos.setCodGrupoProdutos(resultado.getInt("IdGrupoProdutos"));
                grupoProdutos.setNome(resultado.getString("nome"));
                
                
                gruposProdutos.add(grupoProdutos);
            }
            return gruposProdutos;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<GrupoProdutos> BuscarGrupoProdutos(GrupoProdutos filtro){
        try {
            List<GrupoProdutos> gruposProdutos = new LinkedList<>();

            String sql = "select * from grupoprodutos";
            String where = "";
            String order = " order by Idgrupoprodutos";

            if (filtro.getCodGrupoProdutos() > 0){
                where = "idGrupoProdutos = " + filtro.getCodGrupoProdutos();
            }

            if (filtro.getNome().length() > 0){
                where  = "nome like '%" + filtro.getNome() + "%'";
            }

          

            sql = sql + order;
        
            Statement comando = bd.getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                GrupoProdutos grupoProdutos = new GrupoProdutos();
                grupoProdutos.setCodGrupoProdutos(resultado.getInt("IdGrupoProdutos"));
                grupoProdutos.setNome(resultado.getString("nome"));
                
                
                gruposProdutos.add(grupoProdutos);   
            }
            
            return gruposProdutos;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    } 
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update grupoprodutos where idGrupoProdutos = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
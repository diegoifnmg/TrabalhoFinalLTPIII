/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.GrupoProdutos;
import br.edu.ifnmg.tads.sgli.DomainModel.Marca;
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
public class MarcaDAO extends DAO {

    private DAO bd;

    public MarcaDAO() {

        bd = new DAO();
    }

    public boolean Salvar(Marca marca) {
        try {
            if (marca.getCodMarca() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into marca(nome) values(?)");
                comando.setString(1, marca.getNome());

                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update marca set nome = ? where idmarca = ?");
                comando.setString(1, marca.getNome());
                comando.setInt(2, marca.getCodMarca());

                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Marca Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from marca where Idmarca=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Marca obj = new Marca();

                obj.setCodMarca(resultado.getInt("Idmarca"));
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

    public List<Marca> ListarTodasMarcas() {

        List<Marca> marcas = new LinkedList<>();

        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from marca");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {

                Marca marca = new Marca();
                try {
                    marca.setCodMarca(resultado.getInt("IdMarca"));
                } catch (Exception ex) {
                    Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    marca.setNome(resultado.getString("nome"));
                } catch (Exception ex) {
                    Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }


                marcas.add(marca);
            }
            return marcas;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Marca> BuscarMarcas(Marca filtro) {
        try {
            List<Marca> marcas = new LinkedList<>();

            String sql = "select * from marca";
            String where = "";
            String order = " order by Idmarca";

            if (filtro.getCodMarca() > 0) {
                where = "idmarca = " + filtro.getCodMarca();
            }

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }



            sql = sql + order;

            Statement comando = bd.getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            while (resultado.next()) {
                Marca marca = new Marca();
                try {
                    marca.setCodMarca(resultado.getInt("Idmarca"));
                    marca.setNome(resultado.getString("nome"));
                } catch (Exception ex) {
                    Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                


                marcas.add(marca);
            }

            return marcas;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update marca where idmarca = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class CargoDAO extends DAO{

    public CargoDAO() {
        super();
    }
    
    public boolean Salvar(Cargo obj) {
        if (obj.getCodigo() == 0) {
            try {
                
                PreparedStatement sql = getConexao().prepareStatement("insert into Cargo(cargo) values(?)");
                sql.setString(1, obj.getCargo());
                sql.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select IdCargo from Cargo where cargo = ? ");
                sqlConsulta.setString(1, obj.getCargo());


                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("IdCargo"));
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
                PreparedStatement sqlUpdate = con.prepareStatement("update Cargo set cargo=? where IdCargo=?");
                sqlUpdate.setString(1, obj.getCargo());
                sqlUpdate.setInt(2, obj.getCodigo());

                sqlUpdate.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    public Cargo AbrirCargo(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Cargo where IdCargo=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("IdCargo"));
                obj.setCargo(resultado.getString("cargo"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Cargo> ListarCargos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Cargo");

            ResultSet resultado = sql.executeQuery();

            List<Cargo> lista = new ArrayList<Cargo>();

            while (resultado.next()) {
                Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("IdCargo"));
                obj.setCargo(resultado.getString("cargo"));
                

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Cargo> BuscarCargos(Cargo filtro) {
        try {
            String sql = "select * from Cargo ";
            String where = " ";

            if (filtro.getCargo().length() > 0) {
                where = " cargo like '%" + filtro.getCargo() + "%' ";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " IdCargo = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Cargo> lista = new ArrayList<Cargo>();

            while (resultado.next()) {
                Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("IdCargo"));
                obj.setCargo(resultado.getString("Cargo"));
                

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
    
    


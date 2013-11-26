/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
    
    
}

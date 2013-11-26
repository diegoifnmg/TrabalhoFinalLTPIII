/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cargo;
import br.edu.ifnmg.tads.sgli.DomainModel.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Diego
 */
public class FuncionarioDAO extends PessoaDAO<Funcionario>{
    
    private Cargo cargo;
    
     public FuncionarioDAO() {
        super();
    }
     
     public boolean Salvar(Funcionario obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Funcionario(IdCargo,Idpessoa) values(?,?)");
                sql.setInt(1, obj.getCargo().getCodigo());
                sql.setInt(4, obj.getCodigo());  

                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.Salvar(obj);
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Funcionario set IdCargo=? where IdPessoa=?");

                sql.setInt(1, obj.getCargo().getCodigo());
                sql.setInt(2, obj.getCodigo());

                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
     
    public Funcionario AbrirFuncionario(int id) {
        try {
            Funcionario funcionario = new Funcionario();

            super.AbrirPessoa(funcionario, id);

            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionario where IdPessoa=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                //funcionario.setCargo(CargoDAO.AbrirCargo(resultado.getInt("IdCargo")));
                
                return funcionario;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
     
     
}

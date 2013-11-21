/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cliente;
import br.edu.ifnmg.tads.sgli.DomainModel.Email;
import br.edu.ifnmg.tads.sgli.DomainModel.Endereco;
import br.edu.ifnmg.tads.sgli.DomainModel.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Diego
 */
public class ClienteDAO extends PessoaDAO {

    private DAO bd;

    public ClienteDAO() {
        super();
        bd = new DAO();
    }
    //Salvar

    public boolean Salvar(Cliente obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);
        
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into cliente(FisicaouJuridica,CNPJ,Ativo,Idpessoa) values(?,?,?,?)");
                sql.setInt(1, obj.getFisicaouJuridica());
                sql.setString(2,obj.getCNPJ());
                sql.setInt(3, obj.getAtivo());
                sql.setInt(4, obj.getCodigo());  // Verificar
                
                sql.executeUpdate();
   
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            super.Salvar(obj);
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Cliente set FisicaouJuridica=?, CNPJ=?, ATIVO=? where IdPessoa=?");
                
                sql.setInt(1, obj.getFisicaouJuridica());
                sql.setString(2,obj.getCNPJ());
                sql.setInt(3, obj.getAtivo());
                sql.setInt(4, obj.getCodigo());
                
                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
}
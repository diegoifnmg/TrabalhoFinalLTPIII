/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Cargo;
import br.edu.ifnmg.tads.sgli.DomainModel.Cliente;
import br.edu.ifnmg.tads.sgli.DomainModel.Funcionario;
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
public class FuncionarioDAO extends PessoaDAO<Funcionario> {

    private DAO bd;

    public FuncionarioDAO() {
        super();
        bd = new DAO();
    }

    public boolean Salvar(Funcionario obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {

                PreparedStatement sql = getConexao().prepareStatement("insert into Funcionario(IdCargo,Idpessoa,Ativo) values(?,?,?)");
                sql.setInt(1, obj.getCargo().getCodigo());
                sql.setInt(2, obj.getCodigo());
                sql.setInt(3, obj.getAtivo());
                
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
                PreparedStatement sql = con.prepareStatement("update Funcionario set IdCargo=?, ATIVO=?  where IdPessoa=?");

                sql.setInt(1, obj.getCargo().getCodigo());
                sql.setInt(2, obj.getAtivo());
                sql.setInt(3, obj.getCodigo());
                

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

            CargoDAO cargoDAO = new CargoDAO();


            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionario where IdPessoa=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {
                
                funcionario.setCargo(cargoDAO.AbrirCargo(resultado.getInt("IdCargo")));

                return funcionario;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Funcionario> ListarTodosFun() {
        try {

            CargoDAO cargoDAO = new CargoDAO();

            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Funcionario F on P.IdPessoa = F.IdPessoa where F.ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Funcionario> lista = new ArrayList<Funcionario>();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

                super.CarregaObjetoPessoa(obj, resultado);


                
                obj.setCargo(cargoDAO.AbrirCargo(resultado.getInt("IdCargo")));


                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Funcionario> buscar(Funcionario filtro) {
        try {

            String sql = "select * from pessoa p join funcionario f on p.IdPessoa = f.IdPessoa where ativo = 1 ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "and nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " Idpessoa = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            // Cria uma lista de produtos vazia
            List<Funcionario> funcionarios = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Funcionario tmp = new Funcionario();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {

                    tmp.setCodigo(resultado.getInt("IdPessoa"));
                    

                } catch (Exception ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                funcionarios.add(tmp);
            }
            return funcionarios;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean RemoverFuncionario(Funcionario fun) {
        if ((fun.getCodigo() >= 0) && (fun.getAtivo() == 1)){
            try {
                UsuarioDAO user = new UsuarioDAO();

                user.RemoverUsuario(fun.getCodigo());
                super.Remover(fun);

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    
    
}

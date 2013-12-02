/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Funcionario;
import br.edu.ifnmg.tads.sgli.DomainModel.GrupoProdutos;
import br.edu.ifnmg.tads.sgli.DomainModel.Marca;
import br.edu.ifnmg.tads.sgli.DomainModel.Produto;
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
public class ProdutoDAO extends DAO {

    private DAO bd;
    private Marca marca;
    private GrupoProdutos grupoProdutos;
    private Produto produto;

    public ProdutoDAO() {

        bd = new DAO();
        marca = new Marca();
        grupoProdutos = new GrupoProdutos();
        produto = new Produto();
    }

    public boolean Salvar(Produto produto) {
        try {
            if (grupoProdutos.getCodGrupoProdutos() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into Produto(nome,idmarca,idfornecedor,qtd,preco,descricao) values(?,?,?,?,?,?)");
                comando.setString(1, produto.getNome());
                comando.setInt(2, produto.getMarca().getCodMarca());
                comando.setInt(3, produto.getFornecedor().getCodigo());
                comando.setInt(4, produto.getQtd());
                comando.setFloat(5, produto.getPreco());
                comando.setString(6, produto.getDescricao());

                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update Produto set nome = ? and idmarca=? and idfornecedor=? and qtd=? and preco=? and descricao=? where idProduto = ?");
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

    
    
    public Produto AbrirProduto(int id) {
        try {

            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            MarcaDAO marcaDAO = new MarcaDAO();

            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Produto where IdProduto=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                produto.setFornecedor(fornecedorDAO.AbrirFornecedor(resultado.getInt("IdFornecedor")));
                produto.setMarca(marcaDAO.Abrir(resultado.getInt("IdMarca")));

                return produto;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    

     public List<Produto> ListarTodosProdutos() {
        try {

            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            MarcaDAO marcaDAO = new MarcaDAO();

            PreparedStatement sql = getConexao().prepareStatement("select * from Produto where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                obj.setFornecedor(fornecedorDAO.AbrirFornecedor(resultado.getInt("IdFornecedor")));
                obj.setMarca(marcaDAO.Abrir(resultado.getInt("IdMarca")));
                


                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    public List<Produto> buscar(Produto filtro) {
        try {

            String sql = "select * from Produto ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodProduto() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " IdProduto = " + filtro.getCodProduto();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Produto tmp = new Produto();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {

                    tmp.setCodProduto(resultado.getInt("IdProduto"));
                    tmp.setNome(resultado.getString("nome"));
                   
                } catch (Exception ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update produto where idProduto = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    
}

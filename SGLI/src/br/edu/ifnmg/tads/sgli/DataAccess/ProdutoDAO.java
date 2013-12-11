/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DataAccess;

import br.edu.ifnmg.tads.sgli.DomainModel.Fornecedor;
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
    private Fornecedor fornecedor;
    private Produto produto;

    public ProdutoDAO() {

        bd = new DAO();
        marca = new Marca();
        grupoProdutos = new GrupoProdutos();
        produto = new Produto();
        fornecedor = new Fornecedor();
    }

    public boolean Salvar(Produto produto) {
        if (produto.getCodProduto() == 0) {
            try {

                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into Produto(nome,marca,fornecedor,qtd,preco,descricao,ativo) values(?,?,?,?,?,?,?)");
                comando.setString(1, produto.getNome());
                comando.setInt(2, produto.getMarca().getCodMarca());
                comando.setInt(3, produto.getFornecedor().getCodigo());
                comando.setInt(4, produto.getQtd());
                comando.setFloat(5, produto.getPreco());
                comando.setString(6, produto.getDescricao());
                comando.setInt(7, produto.getAtivo());

                comando.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select IdProduto from Produto where nome= ? and marca= ? and fornecedor= ? and qtd= ? and preco= ? and descricao = ? and ativo=?");
                sqlConsulta.setString(1, produto.getNome());
                sqlConsulta.setString(2, produto.getMarca().getNome());
                sqlConsulta.setInt(3, produto.getFornecedor().getCodigo());
                sqlConsulta.setInt(4, produto.getQtd());
                sqlConsulta.setFloat(5, produto.getPreco());
                sqlConsulta.setString(6, produto.getDescricao());
                sqlConsulta.setInt(7, produto.getAtivo());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    produto.setCodProduto(resultado.getInt("IdProduto"));
                }
                
                
                
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }

        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update Produto set Nome=?, marca=? , fornecedor=?, qtd=?, preco=?, descricao=?,ativo=? where IdProduto=?");
                sql.setString(1, produto.getNome());
                sql.setString(2, produto.getMarca().getNome());
                sql.setInt(3, produto.getFornecedor().getCodigo());
                sql.setInt(4, produto.getQtd());
                sql.setFloat(5, produto.getPreco());
                sql.setString(6, produto.getDescricao());
                sql.setInt(7, produto.getAtivo());

                sql.executeUpdate();

                return true;

            } catch (SQLException ex) {
                Logger.getLogger(GrupoProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

    public Produto Abrir(int id) {
        try {
            PreparedStatement sqlConsultaProduto = getConexao().prepareStatement("select * from produto where IdProduto=? and ativo = 1");
            sqlConsultaProduto.setInt(1, id);



            ResultSet resultadoProduto = sqlConsultaProduto.executeQuery();


            if (resultadoProduto.next()) {
                Produto obj = new Produto();

                CarregaObjetoProduto(obj, resultadoProduto);



                return obj;
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

                CarregaObjetoProduto(obj, resultado);



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
                    Logger.getLogger(ProdutoDAO.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;








        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);




            return null;
        }
    }

    public boolean Remover(Produto obj) {
        if ((obj.getCodProduto() > 0) && (obj.getAtivo() == 1)) {
            try {
                //Seta o atributo ativo com valor '0'
                PreparedStatement sqlUpdate = getConexao().prepareStatement("update produto set ativo = 0 where IdProduto=?");
                sqlUpdate.setInt(1, obj.getCodProduto());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    protected void CarregaObjetoProduto(Produto obj, ResultSet resultado) throws Exception, SQLException {
        MarcaDAO marcaDAO = new MarcaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        obj.setCodProduto(resultado.getInt("idProduto"));
        obj.setNome(resultado.getString("Nome"));
        obj.setQtd(resultado.getInt("qtd"));
        obj.setDescricao(resultado.getString("Descricao"));
        obj.setPreco(resultado.getFloat("Preco"));
        obj.setMarca(marcaDAO.Abrir(resultado.getInt("marca")));
        obj.setFornecedor(fornecedorDAO.AbrirFornecedor(resultado.getInt("fornecedor")));
    }
}
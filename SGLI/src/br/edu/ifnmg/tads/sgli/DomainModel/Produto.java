/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Produto {

    private int CodProduto;
    private Marca marca;
    private Fornecedor fornecedor;
    private String Nome;
    private int qtd;
    private float Preco;
    private int ativo;
    private String descricao;

    public Produto() {
        this.ativo = 1;
    }

    public Produto(int CodProduto, Marca marca, Fornecedor fornecedor, String Nome, int qtd, float Preco, int ativo, String descricao) {
        this.CodProduto = CodProduto;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.Nome = Nome;
        this.qtd = qtd;
        this.Preco = Preco;
        this.ativo = ativo;
        this.descricao = descricao;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.CodProduto;
        hash = 43 * hash + Objects.hashCode(this.marca);
        hash = 43 * hash + Objects.hashCode(this.fornecedor);
        hash = 43 * hash + Objects.hashCode(this.Nome);
        hash = 43 * hash + this.qtd;
        hash = 43 * hash + Float.floatToIntBits(this.Preco);
        hash = 43 * hash + this.ativo;
        hash = 43 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.CodProduto != other.CodProduto) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        if (Float.floatToIntBits(this.Preco) != Float.floatToIntBits(other.Preco)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "CodProduto=" + CodProduto + ", marca=" + marca + ", fornecedor=" + fornecedor + ", Nome=" + Nome + ", qtd=" + qtd + ", Preco=" + Preco + ", ativo=" + ativo + ", descricao=" + descricao + '}';
    }
}

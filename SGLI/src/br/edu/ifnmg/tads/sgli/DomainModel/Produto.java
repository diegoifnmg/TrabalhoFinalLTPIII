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
    private int CodMarca;
    private int CodFornecedor;
    private String Nome;
    private float Preco;

    public Produto() {
    }

    public Produto(int CodProduto, int CodMarca, int CodFornecedor, String Nome, float Preco) {
        this.CodProduto = CodProduto;
        this.CodMarca = CodMarca;
        this.CodFornecedor = CodFornecedor;
        this.Nome = Nome;
        this.Preco = Preco;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
    }

    public int getCodMarca() {
        return CodMarca;
    }

    public void setCodMarca(int CodMarca) {
        this.CodMarca = CodMarca;
    }

    public int getCodFornecedor() {
        return CodFornecedor;
    }

    public void setCodFornecedor(int CodFornecedor) {
        this.CodFornecedor = CodFornecedor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.CodProduto;
        hash = 13 * hash + this.CodMarca;
        hash = 13 * hash + this.CodFornecedor;
        hash = 13 * hash + Objects.hashCode(this.Nome);
        hash = 13 * hash + Float.floatToIntBits(this.Preco);
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
        if (this.CodMarca != other.CodMarca) {
            return false;
        }
        if (this.CodFornecedor != other.CodFornecedor) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (Float.floatToIntBits(this.Preco) != Float.floatToIntBits(other.Preco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "CodProduto=" + CodProduto + ", CodMarca=" + CodMarca + ", CodFornecedor=" + CodFornecedor + ", Nome=" + Nome + ", Preco=" + Preco + '}';
    }
}

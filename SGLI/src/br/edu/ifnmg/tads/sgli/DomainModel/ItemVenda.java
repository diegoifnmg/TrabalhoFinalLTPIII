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
public class ItemVenda {
    
    private int codigo;
    private int quantidade;
    private Venda venda;
    private Produto produto;

    public ItemVenda() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public double getValorTotalItem() 
    {
        double total =  getQuantidade() * produto.getPreco();
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.codigo;
        hash = 11 * hash + this.quantidade;
        hash = 11 * hash + Objects.hashCode(this.venda);
        hash = 11 * hash + Objects.hashCode(this.produto);
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", venda=" + venda + ", produto=" + produto + '}';
    }
    
    
    
}

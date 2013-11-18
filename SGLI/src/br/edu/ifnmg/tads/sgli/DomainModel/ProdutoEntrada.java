/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class ProdutoEntrada {
    
    private int CodProdutoEntrada;
    private int CodProduto;
    private int CodEntrada;
    private int QTD;
    private float Total;
    private float ValorUnitario;

    public ProdutoEntrada() {
    }

    public ProdutoEntrada(int CodProdutoEntrada, int CodProduto, int CodEntrada, int QTD, float Total, float ValorUnitario) {
        this.CodProdutoEntrada = CodProdutoEntrada;
        this.CodProduto = CodProduto;
        this.CodEntrada = CodEntrada;
        this.QTD = QTD;
        this.Total = Total;
        this.ValorUnitario = ValorUnitario;
    }

    public int getCodProdutoEntrada() {
        return CodProdutoEntrada;
    }

    public void setCodProdutoEntrada(int CodProdutoEntrada) {
        this.CodProdutoEntrada = CodProdutoEntrada;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
    }

    public int getCodEntrada() {
        return CodEntrada;
    }

    public void setCodEntrada(int CodEntrada) {
        this.CodEntrada = CodEntrada;
    }

    public int getQTD() {
        return QTD;
    }

    public void setQTD(int QTD) {
        this.QTD = QTD;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public float getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(float ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.CodProdutoEntrada;
        hash = 23 * hash + this.CodProduto;
        hash = 23 * hash + this.CodEntrada;
        hash = 23 * hash + this.QTD;
        hash = 23 * hash + Float.floatToIntBits(this.Total);
        hash = 23 * hash + Float.floatToIntBits(this.ValorUnitario);
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
        final ProdutoEntrada other = (ProdutoEntrada) obj;
        if (this.CodProdutoEntrada != other.CodProdutoEntrada) {
            return false;
        }
        if (this.CodProduto != other.CodProduto) {
            return false;
        }
        if (this.CodEntrada != other.CodEntrada) {
            return false;
        }
        if (this.QTD != other.QTD) {
            return false;
        }
        if (Float.floatToIntBits(this.Total) != Float.floatToIntBits(other.Total)) {
            return false;
        }
        if (Float.floatToIntBits(this.ValorUnitario) != Float.floatToIntBits(other.ValorUnitario)) {
            return false;
        }
        return true;
    }
}

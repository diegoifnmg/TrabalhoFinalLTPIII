/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class FornecedorEntrada {
    
    private int CodFornecedorEntrada;
    private int CodEntrada;

    public FornecedorEntrada() {
    }

    public FornecedorEntrada(int CodFornecedorEntrada, int CodEntrada) {
        this.CodFornecedorEntrada = CodFornecedorEntrada;
        this.CodEntrada = CodEntrada;
    }

    public int getCodFornecedorEntrada() {
        return CodFornecedorEntrada;
    }

    public void setCodFornecedorEntrada(int CodFornecedorEntrada) {
        this.CodFornecedorEntrada = CodFornecedorEntrada;
    }

    public int getCodEntrada() {
        return CodEntrada;
    }

    public void setCodEntrada(int CodEntrada) {
        this.CodEntrada = CodEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.CodFornecedorEntrada;
        hash = 79 * hash + this.CodEntrada;
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
        final FornecedorEntrada other = (FornecedorEntrada) obj;
        if (this.CodFornecedorEntrada != other.CodFornecedorEntrada) {
            return false;
        }
        if (this.CodEntrada != other.CodEntrada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FornecedorEntrada{" + "CodFornecedorEntrada=" + CodFornecedorEntrada + ", CodEntrada=" + CodEntrada + '}';
    }
    
    
    
}

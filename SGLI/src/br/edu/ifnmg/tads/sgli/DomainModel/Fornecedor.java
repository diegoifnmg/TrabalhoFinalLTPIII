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
public class Fornecedor extends Pessoa{
    

    private String CNPJ;
    private int Ativo;

    public Fornecedor() {
        this.Ativo = 1;
        
    }

    public Fornecedor(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getAtivo() {
        return Ativo;
    }

    public void setAtivo(int Ativo) {
        this.Ativo = Ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.CNPJ);
        hash = 79 * hash + this.Ativo;
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.CNPJ, other.CNPJ)) {
            return false;
        }
        if (this.Ativo != other.Ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "CNPJ=" + CNPJ + ", Ativo=" + Ativo + '}';
    }

    
    

    
}

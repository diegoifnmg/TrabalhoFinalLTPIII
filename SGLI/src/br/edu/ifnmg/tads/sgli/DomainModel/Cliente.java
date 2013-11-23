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
public class Cliente extends Pessoa{
    
    private int Codigo;
    private int FisicaouJuridica;
    private String CNPJ;
    private int Ativo;

    public Cliente() {
    }

    public Cliente(int Codigo, int FisicaouJuridica, String CNPJ, int Ativo) {
        this.Codigo = Codigo;
        this.FisicaouJuridica = FisicaouJuridica;
        this.CNPJ = CNPJ;
        this.Ativo = Ativo;
    }
    
    
    public int getFisicaouJuridica() {
        return FisicaouJuridica;
    }

    public void setFisicaouJuridica(int FisicaouJuridica) {
        this.FisicaouJuridica = FisicaouJuridica;
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
        int hash = 3;
        hash = 67 * hash + this.Codigo;
        hash = 67 * hash + this.FisicaouJuridica;
        hash = 67 * hash + Objects.hashCode(this.CNPJ);
        hash = 67 * hash + this.Ativo;
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
        final Cliente other = (Cliente) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (this.FisicaouJuridica != other.FisicaouJuridica) {
            return false;
        }
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
        return "Cliente{" + "Codigo=" + Codigo + ", FisicaouJuridica=" + FisicaouJuridica + ", CNPJ=" + CNPJ + ", Ativo=" + Ativo + '}';
    }
    
    
   
    
}

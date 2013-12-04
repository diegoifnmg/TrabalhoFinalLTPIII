/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego
 */
public class Cliente extends Pessoa{
    
    private int fisicaouJuridica;
    private String cnpj;
    private int ativo;

    public Cliente() {
        this.ativo = 1;
        
    }

    public int getFisicaouJuridica() {
        return fisicaouJuridica;
    }

    public void setFisicaouJuridica(int fisicaouJuridica) {
        this.fisicaouJuridica = fisicaouJuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.fisicaouJuridica;
        hash = 53 * hash + Objects.hashCode(this.cnpj);
        hash = 53 * hash + this.ativo;
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
        if (this.fisicaouJuridica != other.fisicaouJuridica) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

    
}

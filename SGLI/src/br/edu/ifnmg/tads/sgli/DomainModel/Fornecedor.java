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
public class Fornecedor extends Pessoa{
    

    private String cnpj;
    private int ativo;

    public Fornecedor() {
        this.ativo = 1;
        
    }

    public Fornecedor(String CNPJ) {
        this.cnpj = CNPJ;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) throws Exception{
        Pattern CNPJ = Pattern.compile("\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}");
        Matcher verifica = CNPJ.matcher(cnpj);

        if (verifica.matches()) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("Entrada para o campo CNPJ INVALIDA!");
        }
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) throws Exception {
        if ((ativo == 0) || (ativo == 1)) {
            this.ativo = ativo;
        } else {
            throw new Exception("Campo 'ativo' deve receber valor '1' ou '0'");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cnpj);
        hash = 79 * hash + this.ativo;
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

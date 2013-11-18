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
public class Fornecedor {
    
    private int CodFornecedor;
    private String Nome;
    private String Site;
    private int Telefone;
    private int DDD;
    private String Email;
    private String CNPJ;

    public Fornecedor() {
    }

    public Fornecedor(int CodFornecedor, String Nome, String Site, int Telefone, int DDD, String Email, String CNPJ) {
        this.CodFornecedor = CodFornecedor;
        this.Nome = Nome;
        this.Site = Site;
        this.Telefone = Telefone;
        this.DDD = DDD;
        this.Email = Email;
        this.CNPJ = CNPJ;
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

    public String getSite() {
        return Site;
    }

    public void setSite(String Site) {
        this.Site = Site;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.CodFornecedor;
        hash = 97 * hash + Objects.hashCode(this.Nome);
        hash = 97 * hash + Objects.hashCode(this.Site);
        hash = 97 * hash + this.Telefone;
        hash = 97 * hash + this.DDD;
        hash = 97 * hash + Objects.hashCode(this.Email);
        hash = 97 * hash + Objects.hashCode(this.CNPJ);
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
        if (this.CodFornecedor != other.CodFornecedor) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Site, other.Site)) {
            return false;
        }
        if (this.Telefone != other.Telefone) {
            return false;
        }
        if (this.DDD != other.DDD) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.CNPJ, other.CNPJ)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "CodFornecedor=" + CodFornecedor + ", Nome=" + Nome + ", Site=" + Site + ", Telefone=" + Telefone + ", DDD=" + DDD + ", Email=" + Email + ", CNPJ=" + CNPJ + '}';
    }
    
    
    
    
}

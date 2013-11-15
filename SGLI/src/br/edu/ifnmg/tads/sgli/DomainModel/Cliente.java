/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class Cliente {
    
    private int CodCliente;
    private int FisicaouJuridica;
    private int CNPJ;
    private int CodPessoa;

    public Cliente() {
    }

    public Cliente(int CodCliente, int FisicaouJuridica, int CNPJ, int CodPessoa) {
        this.CodCliente = CodCliente;
        this.FisicaouJuridica = FisicaouJuridica;
        this.CNPJ = CNPJ;
        this.CodPessoa = CodPessoa;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public int getFisicaouJuridica() {
        return FisicaouJuridica;
    }

    public void setFisicaouJuridica(int FisicaouJuridica) {
        this.FisicaouJuridica = FisicaouJuridica;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(int CodPessoa) {
        this.CodPessoa = CodPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.CodCliente;
        hash = 59 * hash + this.FisicaouJuridica;
        hash = 59 * hash + this.CNPJ;
        hash = 59 * hash + this.CodPessoa;
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
        if (this.CodCliente != other.CodCliente) {
            return false;
        }
        if (this.FisicaouJuridica != other.FisicaouJuridica) {
            return false;
        }
        if (this.CNPJ != other.CNPJ) {
            return false;
        }
        if (this.CodPessoa != other.CodPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "CodCliente=" + CodCliente + ", FisicaouJuridica=" + FisicaouJuridica + ", CNPJ=" + CNPJ + ", CodPessoa=" + CodPessoa + '}';
    }
    
    
    
    
}

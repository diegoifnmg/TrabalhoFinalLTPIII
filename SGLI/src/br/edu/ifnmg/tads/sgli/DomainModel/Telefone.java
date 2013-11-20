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
public class Telefone {
    
    private int DDD;
    private int Telefone;
    private int Codigo;
    private String Operadora;

    public Telefone() {
    }

    public Telefone(int DDD, int Telefone, int Codigo, String Operadora) {
        this.DDD = DDD;
        this.Telefone = Telefone;
        this.Codigo = Codigo;
        this.Operadora = Operadora;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getOperadora() {
        return Operadora;
    }

    public void setOperadora(String Operadora) {
        this.Operadora = Operadora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.DDD;
        hash = 47 * hash + this.Telefone;
        hash = 47 * hash + this.Codigo;
        hash = 47 * hash + Objects.hashCode(this.Operadora);
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
        final Telefone other = (Telefone) obj;
        if (this.DDD != other.DDD) {
            return false;
        }
        if (this.Telefone != other.Telefone) {
            return false;
        }
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Operadora, other.Operadora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "DDD=" + DDD + ", Telefone=" + Telefone + ", Codigo=" + Codigo + ", Operadora=" + Operadora + '}';
    }

    
}

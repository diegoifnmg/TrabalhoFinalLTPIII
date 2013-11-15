/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class Telefone {
    
    private int DDD;
    private int Telefone;
    private int Codigo;

    public Telefone(int DDD, int Telefone, int Codigo) {
        this.DDD = DDD;
        this.Telefone = Telefone;
        this.Codigo = Codigo;
    }

    public Telefone() {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.DDD;
        hash = 97 * hash + this.Telefone;
        hash = 97 * hash + this.Codigo;
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
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "DDD=" + DDD + ", Telefone=" + Telefone + ", Codigo=" + Codigo + '}';
    }

    
    
}

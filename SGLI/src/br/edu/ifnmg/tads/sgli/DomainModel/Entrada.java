/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class Entrada {
    
    private int CodEntrada;

    public Entrada() {
    }

    public Entrada(int CodEntrada) {
        this.CodEntrada = CodEntrada;
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
        hash = 61 * hash + this.CodEntrada;
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
        final Entrada other = (Entrada) obj;
        if (this.CodEntrada != other.CodEntrada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrada{" + "CodEntrada=" + CodEntrada + '}';
    }
    
    
    
}

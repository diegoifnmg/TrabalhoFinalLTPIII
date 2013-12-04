/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Caixa {
    
    private int CodCaixa;
    private float Saldo;

    public Caixa() {
    }

    public int getCodCaixa() {
        return CodCaixa;
    }

    public void setCodCaixa(int CodCaixa) {
        this.CodCaixa = CodCaixa;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.CodCaixa;
        hash = 29 * hash + Float.floatToIntBits(this.Saldo);
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
        final Caixa other = (Caixa) obj;
        if (this.CodCaixa != other.CodCaixa) {
            return false;
        }
        if (Float.floatToIntBits(this.Saldo) != Float.floatToIntBits(other.Saldo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "CodCaixa=" + CodCaixa + ", Saldo=" + Saldo + '}';
    }

    
}

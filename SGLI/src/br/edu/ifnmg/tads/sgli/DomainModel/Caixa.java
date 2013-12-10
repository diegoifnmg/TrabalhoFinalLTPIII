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
    private int codigo;
    private double saldo;

    //Construtor 
    public Caixa() {
        this.codigo = 0;
        this.saldo = 0;
    }
    
    //Getters
    public int getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
    }
    
    //Setters
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setSaldo(double saldo) throws Exception{
        if(saldo >= 0)
            this.saldo = saldo;
        else
            throw new Exception("Valor passado para o campo 'Saldo' não pode ser negativo!");
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        return hash;
    }

    //Equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caixa other = (Caixa) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "Caixa{" + "Codigo do Caixa = " + codigo + ", Saldo = R$ " + saldo + '}';
    }   
}
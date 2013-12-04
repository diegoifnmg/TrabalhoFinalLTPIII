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

    private int ddd;
    private int telefone;
    private int codigo;

    public Telefone() {
    }

    public Telefone(int ddd, int telefone, int codigo, String Operadora) {
        this.ddd = ddd;
        this.telefone = telefone;
        this.codigo = codigo;

    }

    public int getDDD() {
        return ddd;
    }

    public void setDDD(int ddd) throws Exception {
        if ((ddd > 9) && (ddd < 100)) {
            this.ddd = ddd;
        } else {
            throw new Exception("Valor passado para o campo 'DDD' é Invalido!");
        }
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) throws Exception {
        if (telefone > 11111111) {
            this.telefone = telefone;
        } else {
            throw new Exception("Valor passado para o campo 'Telefone' é Invalido!");
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado Inválido");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.ddd;
        hash = 47 * hash + this.telefone;
        hash = 47 * hash + this.codigo;
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
        if (this.ddd != other.ddd) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "DDD=" + ddd + ", Telefone=" + telefone + ", Codigo=" + codigo + '}';
    }
}

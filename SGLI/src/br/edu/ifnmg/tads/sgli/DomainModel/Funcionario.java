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
public class Funcionario extends Pessoa {
    
    private Cargo cargo;
    private int Ativo;

    public Funcionario() {
        this.Ativo = 1;
    }

    public Funcionario(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getAtivo() {
        return Ativo;
    }

    public void setAtivo(int Ativo) {
        this.Ativo = Ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.cargo);
        hash = 19 * hash + this.Ativo;
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (this.Ativo != other.Ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + '}';
    }

    
    
}

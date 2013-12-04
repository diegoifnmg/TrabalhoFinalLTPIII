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
    private int ativo;

    public Funcionario() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.cargo);
        hash = 61 * hash + this.ativo;
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
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + ", Ativo=" + ativo + '}';
    }

    
}

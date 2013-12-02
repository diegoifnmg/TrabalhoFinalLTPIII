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
    private String Login;
    private String Senha;

    public Funcionario() {
        this.Ativo = 1;
    }

    public Funcionario(Cargo cargo, int Ativo, String Login, String Senha) {
        this.cargo = cargo;
        this.Ativo = Ativo;
        this.Login = Login;
        this.Senha = Senha;
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

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.cargo);
        hash = 17 * hash + this.Ativo;
        hash = 17 * hash + Objects.hashCode(this.Login);
        hash = 17 * hash + Objects.hashCode(this.Senha);
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
        if (!Objects.equals(this.Login, other.Login)) {
            return false;
        }
        if (!Objects.equals(this.Senha, other.Senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + '}';
    }
}

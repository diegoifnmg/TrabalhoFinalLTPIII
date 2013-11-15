/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class Funcionario {
    
    private int CodFuncionario;
    private int CodPessoa;

    public Funcionario() {
    }

    public Funcionario(int CodFuncionario, int CodPessoa) {
        this.CodFuncionario = CodFuncionario;
        this.CodPessoa = CodPessoa;
    }

    public int getCodFuncionario() {
        return CodFuncionario;
    }

    public void setCodFuncionario(int CodFuncionario) {
        this.CodFuncionario = CodFuncionario;
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
        hash = 73 * hash + this.CodFuncionario;
        hash = 73 * hash + this.CodPessoa;
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
        if (this.CodFuncionario != other.CodFuncionario) {
            return false;
        }
        if (this.CodPessoa != other.CodPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "CodFuncionario=" + CodFuncionario + ", CodPessoa=" + CodPessoa + '}';
    }
    
}

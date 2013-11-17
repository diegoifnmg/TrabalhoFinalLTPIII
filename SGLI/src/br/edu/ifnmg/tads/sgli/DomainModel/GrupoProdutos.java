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
public class GrupoProdutos {
    
    private int CodGrupoProdutos;
    private String Nome;

    public GrupoProdutos() {
    }

    public GrupoProdutos(int CodGrupoProdutos, String Nome) {
        this.CodGrupoProdutos = CodGrupoProdutos;
        this.Nome = Nome;
    }

    public int getCodGrupoProdutos() {
        return CodGrupoProdutos;
    }

    public void setCodGrupoProdutos(int CodGrupoProdutos) {
        this.CodGrupoProdutos = CodGrupoProdutos;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.CodGrupoProdutos;
        hash = 83 * hash + Objects.hashCode(this.Nome);
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
        final GrupoProdutos other = (GrupoProdutos) obj;
        if (this.CodGrupoProdutos != other.CodGrupoProdutos) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupoProdutos{" + "CodGrupoProdutos=" + CodGrupoProdutos + ", Nome=" + Nome + '}';
    }
    
    
}

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
public class Marca {
    
    private int CodMarca;
    private int CodGrupoProdutos;
    private String Nome;

    public Marca() {
    }

    public Marca(int CodMarca, int CodGrupoProdutos, String Nome) {
        this.CodMarca = CodMarca;
        this.CodGrupoProdutos = CodGrupoProdutos;
        this.Nome = Nome;
    }

    public int getCodMarca() {
        return CodMarca;
    }

    public void setCodMarca(int CodMarca) {
        this.CodMarca = CodMarca;
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
        int hash = 3;
        hash = 59 * hash + this.CodMarca;
        hash = 59 * hash + this.CodGrupoProdutos;
        hash = 59 * hash + Objects.hashCode(this.Nome);
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
        final Marca other = (Marca) obj;
        if (this.CodMarca != other.CodMarca) {
            return false;
        }
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
        return "Marca{" + "CodMarca=" + CodMarca + ", CodGrupoProdutos=" + CodGrupoProdutos + ", Nome=" + Nome + '}';
    }
    
    
    
}

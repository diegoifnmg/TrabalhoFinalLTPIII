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
public class Servicos {
    
    private int CodServico;
    private String Nome;
    private String Problema;
    private String Solucao;
    private String Descricao;
    private Date DataEntrega;
    private Date DataEntrada;
    private float Valor;
    private int OsAberta;

    public Servicos() {
    }

    public Servicos(int CodServico, String Nome, String Problema, String Solucao, String Descricao, Date DataEntrega, Date DataEntrada, float Valor, int OsAberta) {
        this.CodServico = CodServico;
        this.Nome = Nome;
        this.Problema = Problema;
        this.Solucao = Solucao;
        this.Descricao = Descricao;
        this.DataEntrega = DataEntrega;
        this.DataEntrada = DataEntrada;
        this.Valor = Valor;
        this.OsAberta = OsAberta;
    }

    public int getCodServico() {
        return CodServico;
    }

    public void setCodServico(int CodServico) {
        this.CodServico = CodServico;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getProblema() {
        return Problema;
    }

    public void setProblema(String Problema) {
        this.Problema = Problema;
    }

    public String getSolucao() {
        return Solucao;
    }

    public void setSolucao(String Solucao) {
        this.Solucao = Solucao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(Date DataEntrega) {
        this.DataEntrega = DataEntrega;
    }

    public Date getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public int getOsAberta() {
        return OsAberta;
    }

    public void setOsAberta(int OsAberta) {
        this.OsAberta = OsAberta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.CodServico;
        hash = 79 * hash + Objects.hashCode(this.Nome);
        hash = 79 * hash + Objects.hashCode(this.Problema);
        hash = 79 * hash + Objects.hashCode(this.Solucao);
        hash = 79 * hash + Objects.hashCode(this.Descricao);
        hash = 79 * hash + Objects.hashCode(this.DataEntrega);
        hash = 79 * hash + Objects.hashCode(this.DataEntrada);
        hash = 79 * hash + Float.floatToIntBits(this.Valor);
        hash = 79 * hash + this.OsAberta;
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
        final Servicos other = (Servicos) obj;
        if (this.CodServico != other.CodServico) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Problema, other.Problema)) {
            return false;
        }
        if (!Objects.equals(this.Solucao, other.Solucao)) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        if (!Objects.equals(this.DataEntrega, other.DataEntrega)) {
            return false;
        }
        if (!Objects.equals(this.DataEntrada, other.DataEntrada)) {
            return false;
        }
        if (Float.floatToIntBits(this.Valor) != Float.floatToIntBits(other.Valor)) {
            return false;
        }
        if (this.OsAberta != other.OsAberta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicos{" + "CodServico=" + CodServico + ", Nome=" + Nome + ", Problema=" + Problema + ", Solucao=" + Solucao + ", Descricao=" + Descricao + ", DataEntrega=" + DataEntrega + ", DataEntrada=" + DataEntrada + ", Valor=" + Valor + ", OsAberta=" + OsAberta + '}';
    }
    
    
    
    
    
    
}

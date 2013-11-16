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
public class Sessao {
    
    private int CodSessao;
    private Date DataInicio;
    private Date DataFim;
    private int CodLogin;

    public Sessao() {
    }

    public Sessao(int CodSessao, Date DataInicio, Date DataFim, int CodLogin) {
        this.CodSessao = CodSessao;
        this.DataInicio = DataInicio;
        this.DataFim = DataFim;
        this.CodLogin = CodLogin;
    }

    public int getCodSessao() {
        return CodSessao;
    }

    public void setCodSessao(int CodSessao) {
        this.CodSessao = CodSessao;
    }

    public Date getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(Date DataInicio) {
        this.DataInicio = DataInicio;
    }

    public Date getDataFim() {
        return DataFim;
    }

    public void setDataFim(Date DataFim) {
        this.DataFim = DataFim;
    }

    public int getCodLogin() {
        return CodLogin;
    }

    public void setCodLogin(int CodLogin) {
        this.CodLogin = CodLogin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.CodSessao;
        hash = 79 * hash + Objects.hashCode(this.DataInicio);
        hash = 79 * hash + Objects.hashCode(this.DataFim);
        hash = 79 * hash + this.CodLogin;
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
        final Sessao other = (Sessao) obj;
        if (this.CodSessao != other.CodSessao) {
            return false;
        }
        if (!Objects.equals(this.DataInicio, other.DataInicio)) {
            return false;
        }
        if (!Objects.equals(this.DataFim, other.DataFim)) {
            return false;
        }
        if (this.CodLogin != other.CodLogin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sessao{" + "CodSessao=" + CodSessao + ", DataInicio=" + DataInicio + ", DataFim=" + DataFim + ", CodLogin=" + CodLogin + '}';
    }
    
    
}

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
    
    private int CodCaixa;
    private Date DataInicioCaixa;
    private Date DataFimCaixa;
    private float ValorCaixa;

    public Caixa() {
    }

    public Caixa(int CodCaixa, Date DataInicioCaixa, Date DataFimCaixa, float ValorCaixa) {
        this.CodCaixa = CodCaixa;
        this.DataInicioCaixa = DataInicioCaixa;
        this.DataFimCaixa = DataFimCaixa;
        this.ValorCaixa = ValorCaixa;
    }

    public int getCodCaixa() {
        return CodCaixa;
    }

    public void setCodCaixa(int CodCaixa) {
        this.CodCaixa = CodCaixa;
    }

    public Date getDataInicioCaixa() {
        return DataInicioCaixa;
    }

    public void setDataInicioCaixa(Date DataInicioCaixa) {
        this.DataInicioCaixa = DataInicioCaixa;
    }

    public Date getDataFimCaixa() {
        return DataFimCaixa;
    }

    public void setDataFimCaixa(Date DataFimCaixa) {
        this.DataFimCaixa = DataFimCaixa;
    }

    public float getValorCaixa() {
        return ValorCaixa;
    }

    public void setValorCaixa(float ValorCaixa) {
        this.ValorCaixa = ValorCaixa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.CodCaixa;
        hash = 29 * hash + Objects.hashCode(this.DataInicioCaixa);
        hash = 29 * hash + Objects.hashCode(this.DataFimCaixa);
        hash = 29 * hash + Float.floatToIntBits(this.ValorCaixa);
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
        final Caixa other = (Caixa) obj;
        if (this.CodCaixa != other.CodCaixa) {
            return false;
        }
        if (!Objects.equals(this.DataInicioCaixa, other.DataInicioCaixa)) {
            return false;
        }
        if (!Objects.equals(this.DataFimCaixa, other.DataFimCaixa)) {
            return false;
        }
        if (Float.floatToIntBits(this.ValorCaixa) != Float.floatToIntBits(other.ValorCaixa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "CodCaixa=" + CodCaixa + ", DataInicioCaixa=" + DataInicioCaixa + ", DataFimCaixa=" + DataFimCaixa + ", ValorCaixa=" + ValorCaixa + '}';
    }
    
}

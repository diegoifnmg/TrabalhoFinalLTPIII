/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Sessao {
    private int codigo;
    private Date dataInicio;
    private Date dataTermino;
    private double saldoAbertura;
    private double saldoFechamento;
    private Caixa caixa;
    private Usuario usuario;

    //Construtor
    public Sessao() {
        this.codigo = 0;
        this.dataInicio = new Date();
        this.saldoAbertura = caixa.getSaldo();
    }


    //Getters
    public int getCodigo() {
        return codigo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public double getSaldoAbertura() {
        return saldoAbertura;
    }

    public double getSaldoFechamento() {
        return saldoFechamento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setDataInicio(Date dataInicio) throws Exception{
        
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(dataInicio)) {
            this.dataInicio = dataInicio;
        } else {
            throw new ErroValidacaoException("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public void setDataTermino(Date dataTermino) throws Exception{        
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(dataTermino)) {
            this.dataTermino = new Date();
        } else {
            throw new ErroValidacaoException("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public void setSaldoAbertura(double saldoAbertura) throws Exception {
        if (saldoAbertura >= 0) {
            this.saldoAbertura = saldoAbertura;
        } else {
            throw new Exception("Valor passado para o campo 'Saldo de Abertura' não pode ser negativo!");
        }
    }
    
    public void setSaldoFechamento(double saldoFechamento) throws Exception {
        if (saldoFechamento >= 0) {
            this.saldoFechamento = saldoFechamento;
        } else {
            throw new Exception("Valor passado para o campo 'Saldo de Abertura' não pode ser negativo!");
        }
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.dataInicio);
        hash = 59 * hash + Objects.hashCode(this.dataTermino);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.saldoAbertura) ^ (Double.doubleToLongBits(this.saldoAbertura) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.saldoFechamento) ^ (Double.doubleToLongBits(this.saldoFechamento) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.caixa);
        hash = 59 * hash + Objects.hashCode(this.usuario);
        return hash;
    }
    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldoAbertura) != Double.doubleToLongBits(other.saldoAbertura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldoFechamento) != Double.doubleToLongBits(other.saldoFechamento)) {
            return false;
        }
        if (!Objects.equals(this.caixa, other.caixa)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Sessao{" + "Codigo = " + codigo + ", Inicio = " + dataInicio 
                + ", Termino = " + dataTermino + ", Saldo de Abertura=" + saldoAbertura 
                + ", Saldo de Fechamento = " + saldoFechamento + ", Codido do Caixa=" + caixa.getCodCaixa()
                + ", Usuario=" + usuario.getLogin() + '}';
    }
    
}

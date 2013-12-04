/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego
 */
public class Cliente extends Pessoa{
    
    private int fisicaouJuridica;
    private String cnpj;
    private int ativo;

    public Cliente() {
        this.ativo = 1;
        
    }

    public Cliente(int Codigo, int FisicaouJuridica, String CNPJ, int Ativo) throws Exception {
        setCodigo(Codigo);
        this.fisicaouJuridica = FisicaouJuridica;
        this.cnpj = CNPJ;
        this.ativo = Ativo;
    }
    
    
    public int getFisicaouJuridica() {
        return fisicaouJuridica;
    }

    public void setFisicaouJuridica(int FisicaouJuridica) throws Exception{
        if ((ativo == 0) || (ativo == 1)) {
            this.fisicaouJuridica = FisicaouJuridica;
        }else{
            throw new Exception("Campo 'ativo' deve receber valor '1' ou '0'");
        }
    }

    
    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) throws Exception{
        Pattern CNPJ = Pattern.compile("\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}");
        Matcher verifica = CNPJ.matcher(cnpj);

        if (verifica.matches()) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("Entrada para o campo CNPJ INVALIDA!");
        }
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
        int hash = 3;
        hash = 67 * hash + this.getCodigo();
        hash = 67 * hash + this.fisicaouJuridica;
        hash = 67 * hash + Objects.hashCode(this.cnpj);
        hash = 67 * hash + this.ativo;
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
        final Cliente other = (Cliente) obj;
        if (this.getCodigo() != other.getCodigo()) {
            return false;
        }
        if (this.fisicaouJuridica != other.fisicaouJuridica) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Codigo=" + getCodigo() + ", FisicaouJuridica=" + fisicaouJuridica + ", CNPJ=" + cnpj + ", Ativo=" + ativo + '}';
    }
    
    
   
    
}

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
public class Endereco {

    private int codigo;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;
    private String cep;
    private String complemento;
    private String pais;
    private String estado;

    public Endereco() {
    }

    public Endereco(int codigo, String rua, String bairro, String cidade, int numero, String cep, String complemento, String pais, String estado) {
        this.codigo = codigo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.pais = pais;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws Exception {
        Pattern Rua = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Rua.matcher(rua);

        if (verifica.matches()) {
            this.rua = rua;
        } else {
            throw new Exception("Valor passado para o campo 'Rua' é Invalido!");
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws Exception {
        Pattern Bairro = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Bairro.matcher(bairro);

        if (verifica.matches()) {
            this.bairro = bairro;
        } else {
            throw new Exception("Valor passado para o campo 'Bairro' é Invalido!");
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        Pattern Cidade = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Cidade.matcher(cidade);

        if (verifica.matches()) {
            this.cidade = cidade;
        } else {
            throw new Exception("Valor passado para o campo 'Cidade' é Invalido!");
        }
    }

    public int getNumero() {
        return numero;
    }   

    public void setNumero(int numero) throws Exception {
        if (numero >= 1) {
            this.numero = numero;
        } else {
            throw new Exception("Valor passado para o campo 'Numero' não pode ser negativo!");
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) throws Exception {
        Pattern Complemento = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{1,}");
        Matcher verifica = Complemento.matcher(complemento);

        if (verifica.matches()) {
            this.complemento = complemento;
        } else {
            throw new Exception("Valor passado para o campo 'Complemento' é Invalido!");
        }
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) throws Exception {
        Pattern Pais = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{1,}");
        Matcher verifica = Pais.matcher(pais);
        
        if (verifica.matches()) {
            this.pais = pais;
        } else {
            throw new Exception("Valor passado para o campo 'Pais' é Invalido!");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        Pattern Estado = Pattern.compile("\\w*{2,}");
        Matcher verifica = Estado.matcher(estado);

        if (verifica.matches()) {
            this.estado = estado;
        } else {
            throw new Exception("Valor passado para o campo 'UF' é Invalido!");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.rua);
        hash = 23 * hash + Objects.hashCode(this.bairro);
        hash = 23 * hash + Objects.hashCode(this.cidade);
        hash = 23 * hash + this.numero;
        hash = 23 * hash + Objects.hashCode(this.cep);
        hash = 23 * hash + Objects.hashCode(this.complemento);
        hash = 23 * hash + Objects.hashCode(this.pais);
        hash = 23 * hash + Objects.hashCode(this.estado);
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
        final Endereco other = (Endereco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "codigo=" + codigo 
                + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" 
                + cidade + ", numero=" + numero + ", cep=" + cep + ", "
                + "complemento=" + complemento + ", pais=" + pais 
                + ", estado=" + estado + '}';
    }
}

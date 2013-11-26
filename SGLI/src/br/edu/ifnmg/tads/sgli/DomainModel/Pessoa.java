/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego
 */
public class Pessoa {
    
    private int Codigo;
    private String nome;
    private String CPF;
    private String RG;
    private Date DataNascimento;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    //construtor
    public Pessoa() {
        Codigo = 0;
        emails = new ArrayList<Email>();
        enderecos = new ArrayList<Endereco>();
        telefones = new ArrayList<Telefone>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);

        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Formato de nome Inválido!");

        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(DataNascimento)) {
            this.DataNascimento = DataNascimento;
        }
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo >= 0) {
            this.Codigo = codigo;
        } 
    }



    public void addEmail(Email email) {
        if (!emails.contains(email)) {
            emails.add(email);
        }
    }

    public void removeEmail(Email email) {
        if (emails.contains(email)) {
            emails.remove(email);
        }
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void addEndereco(Endereco endereco) {
        if (!enderecos.contains(endereco)) {
            enderecos.add(endereco);
        }
    }

    public void removeEndereco(Endereco endereco) {
        if (enderecos.contains(endereco)) {
            enderecos.remove(endereco);
        }
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    //adicionar telefone
    public void addTelefone(Telefone telefone) {
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
        }
    }
    //Remover um Telefone

    public void removeTelefone(Telefone telefone) {
        if (telefones.contains(telefone)) {
            telefones.remove(telefone);
        }
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.Codigo;
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.CPF);
        hash = 73 * hash + Objects.hashCode(this.RG);
        hash = 73 * hash + Objects.hashCode(this.DataNascimento);
        hash = 73 * hash + Objects.hashCode(this.emails);
        hash = 73 * hash + Objects.hashCode(this.enderecos);
        hash = 73 * hash + Objects.hashCode(this.telefones);
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
        final Pessoa other = (Pessoa) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.CPF, other.CPF)) {
            return false;
        }
        if (!Objects.equals(this.RG, other.RG)) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "CodPessoa=" + Codigo + ", nome=" + nome + ", CPF=" + CPF + ", RG=" + RG + ", DataNascimento=" + DataNascimento + ", emails=" + emails + ", enderecos=" + enderecos + ", telefones=" + telefones + '}';
    }
    
    
  
    
}

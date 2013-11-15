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
    
    private int CodPessoa;
    private String nome;
    private int CPF;
    private int RG;
    private Date DataNascimento;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    //construtor
    public Pessoa() {
        CodPessoa = 0;
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
        return CodPessoa;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.CodPessoa = codigo;
        } else {
            throw new Exception("Codigo Inválido!");
        }
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
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
    // hashCode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + this.CodPessoa;
        hash = 43 * hash + Objects.hashCode(this.DataNascimento);
        return hash;
    }
    // Equals 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.CodPessoa != other.CodPessoa) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nome ;
    }
    
  
    
}

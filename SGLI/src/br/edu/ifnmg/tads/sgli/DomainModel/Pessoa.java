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

    private int codigo;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    //construtor
    public Pessoa() {
        codigo = 0;
        emails = new ArrayList<Email>();
        enderecos = new ArrayList<Endereco>();
        telefones = new ArrayList<Telefone>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Nome.matcher(nome);

        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Campo 'Nome' deve ter no mínimo 3 caracteres");
        }
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        
            this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(dataNascimento)) {
            this.dataNascimento = dataNascimento;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void addEmail(Email email) throws Exception {
        if (!emails.contains(email)) {
            emails.add(email);
        } else {
            throw new Exception("Esse email ja foi cadastrado!");
        }
    }

    public void removeEmail(Email email) throws Exception {
        if (emails.contains(email)) {
            emails.remove(email);
        } else {
            throw new Exception("O email pedido não existe!");
        }
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void addEndereco(Endereco endereco) throws Exception {
        if (!enderecos.contains(endereco)) {
            enderecos.add(endereco);
        } else {
            throw new Exception("O valor passado para o campo endereco ja existe!");
        }
    }

    public void removeEndereco(Endereco endereco) throws Exception {
        if (enderecos.contains(endereco)) {
            enderecos.remove(endereco);
        } else {
            throw new Exception("Não foi possivel remover o endereço, pois ele não existe!");
        }

    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    //adicionar telefone
    public void addTelefone(Telefone telefone) throws Exception {
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
        } else {
            throw new Exception("O valor passado para o campo telefone ja existe!");
        }
    }
    //Remover um Telefone

    public void removeTelefone(Telefone telefone) throws Exception {
        if (telefones.contains(telefone)) {
            telefones.remove(telefone);
        } else {
            throw new Exception("Não foi possivel remover o telefone, pois ele não existe!");
        }
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    

    @Override
    public String toString() {
        return "Pessoa{" + "CodPessoa=" + codigo + ", nome=" + nome + ", CPF=" + cpf + ", RG=" + rg + ", DataNascimento=" + dataNascimento + ", emails=" + emails + ", enderecos=" + enderecos + ", telefones=" + telefones + '}';
    }
}

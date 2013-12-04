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

    public void setCPF(String cpf) throws Exception {
        Pattern Pcpf = Pattern.compile("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
        Matcher verificacao = Pcpf.matcher(cpf);

        if (verificacao.matches()) {
            this.cpf = cpf;
        } else {
            throw new Exception("Entrada para o campo CPF INVALIDA!");
        }

    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) throws Exception {
        Pattern PRG = Pattern.compile("[\\d\\w\\.-]{6,20}");
        Matcher verificacao = PRG.matcher(rg);

        if (verificacao.matches()) {
            this.rg = rg;
        } else {
            throw new Exception("Entrada para o campo RG INVALIDA!");
        }
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) throws Exception {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(dataNascimento)) {
            this.dataNascimento = dataNascimento;
        } else {
            throw new ErroValidacaoException("Valor passado para o campo 'Data' é invalido!");
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
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.codigo;
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.cpf);
        hash = 73 * hash + Objects.hashCode(this.rg);
        hash = 73 * hash + Objects.hashCode(this.dataNascimento);
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
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
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
        return "Pessoa{" + "CodPessoa=" + codigo + ", nome=" + nome + ", CPF=" + cpf + ", RG=" + rg + ", DataNascimento=" + dataNascimento + ", emails=" + emails + ", enderecos=" + enderecos + ", telefones=" + telefones + '}';
    }
    
    
  
    
}

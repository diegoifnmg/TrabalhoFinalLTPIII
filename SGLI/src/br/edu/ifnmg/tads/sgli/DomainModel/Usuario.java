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
public class Usuario {

    private int codigo;
    private String login;
    private String senha;
    private Funcionario funcionario;

    //Construtor 
    public Usuario() {
        this.codigo = 0;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setLogin(String login) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(login);

        if (verifica.matches()) {
            this.login = login;
        } else {
            throw new Exception("Campo 'login' deve ter no mínimo 3 caracteres");
        }
    }

    public void setSenha(String senha) throws Exception {
        Pattern Nome = Pattern.compile("[\\w]{3,}");
        Matcher verifica = Nome.matcher(login);

        if (verifica.matches()) {
            this.senha = senha;
        } else {
            throw new Exception("Campo 'senha' deve ter no mínimo 6 caracteres");
        }
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + Objects.hashCode(this.login);
        hash = 41 * hash + Objects.hashCode(this.senha);
        hash = 41 * hash + Objects.hashCode(this.funcionario);
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
        final Usuario other = (Usuario) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Usuario {" + "Codigo = " + codigo + ", Login = " + login 
                + ", Senha = " + senha + ", Funcionario = " + funcionario.getNome() + '}';
    }
    
}

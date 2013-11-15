/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Login {
    
    private int CodLogin;
    private String Login;
    private String Senha;
    private int CodFuncionario;

    public Login() {
    }

    public Login(int CodLogin, String Login, String Senha, int CodFuncionario) {
        this.CodLogin = CodLogin;
        this.Login = Login;
        this.Senha = Senha;
        this.CodFuncionario = CodFuncionario;
    }

    public int getCodLogin() {
        return CodLogin;
    }

    public void setCodLogin(int CodLogin) {
        this.CodLogin = CodLogin;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getCodFuncionario() {
        return CodFuncionario;
    }

    public void setCodFuncionario(int CodFuncionario) {
        this.CodFuncionario = CodFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.CodLogin;
        hash = 89 * hash + Objects.hashCode(this.Login);
        hash = 89 * hash + Objects.hashCode(this.Senha);
        hash = 89 * hash + this.CodFuncionario;
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
        final Login other = (Login) obj;
        if (this.CodLogin != other.CodLogin) {
            return false;
        }
        if (!Objects.equals(this.Login, other.Login)) {
            return false;
        }
        if (!Objects.equals(this.Senha, other.Senha)) {
            return false;
        }
        if (this.CodFuncionario != other.CodFuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Login{" + "CodLogin=" + CodLogin + ", Login=" + Login + ", Senha=" + Senha + ", CodFuncionario=" + CodFuncionario + '}';
    }
    
    
    
    
}

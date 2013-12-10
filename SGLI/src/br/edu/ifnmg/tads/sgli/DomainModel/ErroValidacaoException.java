/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.DomainModel;

/**
 *
 * @author Diego
 */
public class ErroValidacaoException extends Exception {

     String campo;
    public ErroValidacaoException(String msg, String cmp){
        super(msg);
        setCampo(cmp);
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}

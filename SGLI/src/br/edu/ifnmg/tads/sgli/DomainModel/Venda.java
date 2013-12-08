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
public class Venda {

    private int codigo;
    private Date data;
    private double valorTotal;
    private String formaPagamento;
    private Sessao sessao;
    private Cliente cliente;
    private Funcionario funcionario;
    private List<ItemVenda> itensVenda;

    public Venda() {
        itensVenda = new ArrayList<ItemVenda>();
        this.codigo = 0;
        this.valorTotal = 0;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) throws Exception{
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(data)) {
            this.data = data;
        } else {
            throw new Exception("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) throws Exception {
        if (valorTotal >= 0) {
            this.valorTotal = valorTotal;
        } else {
            throw new Exception("Valor passado para o campo 'Valor Total' não pode ser negativo!");
        }
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) throws Exception{
        Pattern FormaPagamento = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = FormaPagamento.matcher(formaPagamento);

        if (verifica.matches()) {
            this.formaPagamento = formaPagamento;
        } else {
            throw new Exception("Campo 'Forma de Pagamento' deve ter no mínimo 3 caracteres");
        }
        
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    public void addItemVenda(ItemVenda itemVenda) throws Exception{
        if(!itensVenda.contains(itemVenda)){
            itensVenda.add(itemVenda);
            
            double valor = itemVenda.getValorTotalItem() + getValorTotal();
            setValorTotal(valor);
        }
        else{
         throw new Exception("Esse item já esta na lista de Vendas");
        }
    }
    
    //Remove um item da venda
    public void removeItemVenda(ItemVenda itemVenda) throws Exception{
        if(itensVenda.contains(itemVenda)){
            itensVenda.remove(itemVenda);
            
            double valor = getValorTotal() - itemVenda.getValorTotalItem();
            setValorTotal(valor);
        }
        else{
         throw new Exception("Esse item não existe na lista de Vendas!");
        }
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
        final Venda other = (Venda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        if (!Objects.equals(this.sessao, other.sessao)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.itensVenda, other.itensVenda)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Venda de Produto {" + "Codigo = " + codigo + ", Data = " + data 
                + ", Valor = " + valorTotal + ", Forma de Pagamento=" + formaPagamento 
                + ", Codigo da Sessao = " + sessao.getCodigo() 
                + ", Cliente = " + cliente.getNome() 
                + ", Funcionario=" + funcionario.getNome() + '}';
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.Presentation;

import br.edu.ifnmg.tads.sgli.DataAccess.CaixaDAO;
import br.edu.ifnmg.tads.sgli.DataAccess.ClienteDAO;
import br.edu.ifnmg.tads.sgli.DataAccess.ProdutoDAO;
import br.edu.ifnmg.tads.sgli.DataAccess.VendaDAO;
import br.edu.ifnmg.tads.sgli.DomainModel.Caixa;
import br.edu.ifnmg.tads.sgli.DomainModel.Cliente;
import br.edu.ifnmg.tads.sgli.DomainModel.Funcionario;
import br.edu.ifnmg.tads.sgli.DomainModel.ItemVenda;
import br.edu.ifnmg.tads.sgli.DomainModel.Produto;
import br.edu.ifnmg.tads.sgli.DomainModel.Sessao;
import br.edu.ifnmg.tads.sgli.DomainModel.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class frmVenda extends javax.swing.JInternalFrame {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    Venda venda = new Venda();
    ItemVenda itemVenda;
    ClienteDAO clienteDAO = new ClienteDAO();
    Funcionario funcionario = new Funcionario();
    Sessao sessao;
    Caixa caixa;
    CaixaDAO caixaDAO = new CaixaDAO();
    
    /**
     * Creates new form frmVenda
     */
    public frmVenda(Funcionario funcionario, Sessao sessao) {
        initComponents();
        
        this.funcionario = funcionario;
        this.sessao = sessao;
        this.caixa = caixaDAO.AbrirCaixa(1);
        carregaClientes();
        carregaProdutos();
        preencheTabela(null);
        
    }

   

    private void carregaVenda() {
        String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();
        Cliente clienteSelecionado = (Cliente) cbxCliente.getSelectedItem();

        try {
            venda.setSessao(sessao);
            venda.setData(new Date());
            venda.setFormaPagamento(formaPagamento);
            venda.setCliente(clienteSelecionado);
            venda.setFuncionario(funcionario);
        } catch (Exception ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Carrega o comboBox dos clientes
    private void carregaClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = clienteDAO.ListarTodosCli();

        cbxCliente.removeAllItems();
        for (Cliente c : clientes) {
            cbxCliente.addItem(c);
        }
    }

    //Carrega o comboBox dos Produtos
    private void carregaProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        produtos = produtoDAO.ListarTodosProdutos();

        cbxProduto.removeAllItems();
        for (Produto p : produtos) {
            cbxProduto.addItem(p);
        }
    }
    
    private void preencheTabela(List<ItemVenda> listaItemVenda) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Nome");
            model.addColumn("Preço");
            model.addColumn("Quantidade");
            model.addColumn("Total");
            

            if (listaItemVenda != null) {
                for (ItemVenda i : listaItemVenda) {
                    Vector valores = new Vector();
                    valores.add(0, i.getProduto().getCodProduto());
                    valores.add(1, i.getProduto().getNome());
                    valores.add(2, i.getProduto().getPreco());
                    valores.add(3, i.getQuantidade());
                    valores.add(4, i.getValorTotalItem());
                    

                    model.addRow(valores);
                }
            }
            tblListagem.setModel(model);
            tblListagem.repaint();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFormaPagamento = new javax.swing.JLabel();
        cbxFormaPagamento = new javax.swing.JComboBox();
        lblCliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        lblProduto = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        lblTotalVenda = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        lblFormaPagamento.setText("Forma Pagamento:");

        cbxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCliente.setText("Cliente:");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblProduto.setText("Produto:");

        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblQuantidade.setText("Quantidade:");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListagem);

        lblTotalVenda.setText("Total da Venda:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemover))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblProduto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblQuantidade)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblFormaPagamento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lblTotalVenda)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalVenda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalVenda)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar os dados?") == 0) {
            try {
                VendaDAO vendaDAO = new VendaDAO();

                vendaDAO.Salvar(venda);
                caixa.setSaldo((float) (caixa.getSaldo() + venda.getValorTotal()));
                caixaDAO.Salvar(caixa);

                JOptionPane.showMessageDialog(rootPane, "Dados Salvos com Sucesso!");
                
                //Fecha a tela atual e abre a tela de busca
                this.setVisible(false);
                frmProdutoListagem janela = new frmProdutoListagem();
                this.getParent().add(janela);
                janela.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar os dados! " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cadastro cancelado pelo usuario");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente Cancelar?") == 0) {

            this.setVisible(false);
            frmProdutoListagem janela = new frmProdutoListagem();
            this.getParent().add(janela);
            janela.setVisible(true);
        }
             
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            carregaVenda();
            Produto prodSelecionado = (Produto) cbxProduto.getSelectedItem();
            prodSelecionado = produtoDAO.Abrir(prodSelecionado.getCodProduto());
            int quantidade = Integer.parseInt(txtQuantidade.getText());

            if (prodSelecionado.getQtd() >= quantidade) {
                prodSelecionado.setQtd(prodSelecionado.getQtd() - quantidade);   
                itemVenda = new ItemVenda();
                itemVenda.setProduto(prodSelecionado);
                itemVenda.setQuantidade(quantidade);
                itemVenda.setVenda(venda);
                venda.addItemVenda(itemVenda);
                txtTotalVenda.setText("R$  " + venda.getValorTotal());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não há estoque suficiente para este produto.");
            }
            preencheTabela(venda.getItensVenda());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Adicionar Produto! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            carregaVenda();
            Produto prodSelecionado = (Produto) cbxProduto.getSelectedItem();

            for (ItemVenda i : venda.getItensVenda()) {
                if (i.getProduto() == prodSelecionado) {
                    venda.removeItemVenda(i);
                    break;
                }
            }

            txtTotalVenda.setText("R$  " + venda.getValorTotal());
            preencheTabela(venda.getItensVenda());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Remover Produto! " + ex.getMessage());
        }
                                              

    }//GEN-LAST:event_btnRemoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxFormaPagamento;
    private javax.swing.JComboBox cbxProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}

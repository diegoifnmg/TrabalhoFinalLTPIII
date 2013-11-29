/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sgli.Presentation;

/**
 *
 * @author Diego
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuControle = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        Ferramentas = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        imnuCadastroClientes = new javax.swing.JMenuItem();
        imnuCadastroProdutos = new javax.swing.JMenuItem();
        imnuCadastroFuncionarios = new javax.swing.JMenuItem();
        imnuCadastroFornecedores = new javax.swing.JMenuItem();
        imnuCadastroCargos = new javax.swing.JMenuItem();
        imnuCadastroGrupoProdutos = new javax.swing.JMenuItem();
        imnuUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGLI - Sistema Loja de Informática");

        mnuControle.setText("Controle");

        jMenuItem3.setText("Estatística de Caixa");
        mnuControle.add(jMenuItem3);
        mnuControle.add(jSeparator1);

        jMenuItem4.setText("Trocar de Funcionário");
        mnuControle.add(jMenuItem4);

        Ferramentas.setText("Ferramentas");
        mnuControle.add(Ferramentas);

        jMenuItem6.setText("Fechar");
        mnuControle.add(jMenuItem6);

        jMenuBar1.add(mnuControle);

        jMenu3.setText("Cadastro");

        imnuCadastroClientes.setText("Cadastro de Clientes");
        imnuCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuCadastroClientesActionPerformed(evt);
            }
        });
        jMenu3.add(imnuCadastroClientes);

        imnuCadastroProdutos.setText("Cadastro de Produtos");
        jMenu3.add(imnuCadastroProdutos);

        imnuCadastroFuncionarios.setText("Cadastro de Funcionários");
        imnuCadastroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuCadastroFuncionariosActionPerformed(evt);
            }
        });
        jMenu3.add(imnuCadastroFuncionarios);

        imnuCadastroFornecedores.setText("Cadastro de Fornecedores");
        imnuCadastroFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuCadastroFornecedoresActionPerformed(evt);
            }
        });
        jMenu3.add(imnuCadastroFornecedores);

        imnuCadastroCargos.setText("Cadastro de Cargos");
        imnuCadastroCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuCadastroCargosActionPerformed(evt);
            }
        });
        jMenu3.add(imnuCadastroCargos);

        imnuCadastroGrupoProdutos.setText("Cadastro de Grupo de Produtos");
        imnuCadastroGrupoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuCadastroGrupoProdutosActionPerformed(evt);
            }
        });
        jMenu3.add(imnuCadastroGrupoProdutos);

        imnuUsuario.setText("Cadastrar Usuarios");
        imnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(imnuUsuario);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Vendas");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("OS");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Relatórios");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imnuCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuCadastroClientesActionPerformed
        frmClienteListagem janela = new frmClienteListagem();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_imnuCadastroClientesActionPerformed

    private void imnuCadastroGrupoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuCadastroGrupoProdutosActionPerformed
        frmGrupoProdutosListagem janela = new frmGrupoProdutosListagem();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_imnuCadastroGrupoProdutosActionPerformed

    private void imnuCadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuCadastroFuncionariosActionPerformed
        frmFuncionarioListagem janela = new frmFuncionarioListagem();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_imnuCadastroFuncionariosActionPerformed

    private void imnuCadastroFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuCadastroFornecedoresActionPerformed
        frmFornecedorListagem janela = new frmFornecedorListagem();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_imnuCadastroFornecedoresActionPerformed

    private void imnuCadastroCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuCadastroCargosActionPerformed
        frmCargoListagem janela = new frmCargoListagem();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_imnuCadastroCargosActionPerformed

    private void imnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuUsuarioActionPerformed
        frmUsuarioListagem janela = new frmUsuarioListagem();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_imnuUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */





        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Ferramentas;
    private javax.swing.JMenuItem imnuCadastroCargos;
    private javax.swing.JMenuItem imnuCadastroClientes;
    private javax.swing.JMenuItem imnuCadastroFornecedores;
    private javax.swing.JMenuItem imnuCadastroFuncionarios;
    private javax.swing.JMenuItem imnuCadastroGrupoProdutos;
    private javax.swing.JMenuItem imnuCadastroProdutos;
    private javax.swing.JMenuItem imnuUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mnuControle;
    // End of variables declaration//GEN-END:variables
}

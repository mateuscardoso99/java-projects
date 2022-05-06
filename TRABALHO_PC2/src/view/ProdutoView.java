package view;

import conexao.ConnectionFactory;
import controller.ProdutoController;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.validacao;
import tablemodel.ProdutoTableModel;

public class ProdutoView extends javax.swing.JFrame {

    ProdutoController con = new ProdutoController();
    ProdutoTableModel pt;
    
    public ProdutoView() {
        initComponents();
        
        populaTabela();
        
        btnatualizar.setEnabled(false);
        btnexcluir.setEnabled(false);
    }

    public void populaTabela(){
        tabelaProdutos.removeAll();
        pt = new ProdutoTableModel(con.read());
        tabelaProdutos.setModel(pt);
    }
    
    public void populaTabelaPorDescricao(){
        tabelaProdutos.removeAll();
        pt = new ProdutoTableModel(con.buscaPorDescricao(txtbusca.getText()));
        tabelaProdutos.setModel(pt);
    }
    
    public void limpar(){
        txtdescricaoproduto.setText("");
        txtprecoproduto.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdescricaoproduto = new javax.swing.JTextField();
        txtprecoproduto = new javax.swing.JTextField();
        btncadastrar = new javax.swing.JButton();
        btnatualizar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnrelatorioprodutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        jLabel1.setText("DESCRIÇÃO:");

        jLabel2.setText("PREÇO:");

        btncadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save-icon.png"))); // NOI18N
        btncadastrar.setText("CADASTRAR");
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        btnatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-validated-icon.png"))); // NOI18N
        btnatualizar.setText("ATUALIZAR");
        btnatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatualizarActionPerformed(evt);
            }
        });

        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close-icon.png"))); // NOI18N
        btnexcluir.setText("EXCLUIR");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("CADASTRO DE PRODUTOS");

        jLabel4.setText("BUSCAR POR DESCRIÇÃO:");

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnrelatorioprodutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Office-Client-Male-Dark-icon.png"))); // NOI18N
        btnrelatorioprodutos.setText("PRODUTOS CADASTRADOS");
        btnrelatorioprodutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrelatorioprodutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnrelatorioprodutos)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprecoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescricaoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnbuscar)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(336, 336, 336))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescricaoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtprecoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncadastrar)
                    .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexcluir)
                    .addComponent(btnrelatorioprodutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        if (validaCamposProdutos()) {
            if (!txtdescricaoproduto.getText().isEmpty()) {
                if (con.create(txtdescricaoproduto.getText(), Double.parseDouble(txtprecoproduto.getText()))) {
                    populaTabela();
                    limpar();
                }
            }
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if(tabelaProdutos.getSelectedRow()>=0){
            btnatualizar.setEnabled(true);
            btnexcluir.setEnabled(true);
            txtdescricaoproduto.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
            txtprecoproduto.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        if (validaCamposProdutos()) {
            if (!txtdescricaoproduto.getText().isEmpty()) {
                
                Produto prod = pt.getProdutos(tabelaProdutos.getSelectedRow());
                
                if (con.update(prod.getId(),
                        txtdescricaoproduto.getText(), Double.parseDouble(txtprecoproduto.getText()))) {
                    populaTabela();
                    limpar();
                    btnatualizar.setEnabled(false);
                    btnexcluir.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        if(tabelaProdutos.getSelectedRow()>=0){
            Produto prod = pt.getProdutos(tabelaProdutos.getSelectedRow());
            con.delete(prod);
            populaTabela();
            limpar();
            btnexcluir.setEnabled(false);
            btnatualizar.setEnabled(false);
        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal p = new ViewPrincipal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        if(txtbusca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "digite a sua busca", "", JOptionPane.WARNING_MESSAGE);
        }else{
            populaTabelaPorDescricao();
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnrelatorioprodutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrelatorioprodutosActionPerformed
        Connection con = ConnectionFactory.getConnection();
        String src = "src/reports/relatorioProdutos.jasper";
        
        JasperPrint jp = null;
        
        try{
            jp = JasperFillManager.fillReport(src, null, con);
            
        }catch(JRException ex){
            System.out.println("erro ao gerar relatório dos produtos"+ex);
        }
        
        JasperViewer view = new JasperViewer(jp, false);
        view.setVisible(true);
    }//GEN-LAST:event_btnrelatorioprodutosActionPerformed

    private boolean validaCamposProdutos(){
        if(!validacao.validaDescricao(txtdescricaoproduto.getText())){
            JOptionPane.showMessageDialog(this, "descrição inválida","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaPreco(txtprecoproduto.getText())){
            JOptionPane.showMessageDialog(this, "preço inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        
        return true;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnrelatorioprodutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtdescricaoproduto;
    private javax.swing.JTextField txtprecoproduto;
    // End of variables declaration//GEN-END:variables
}

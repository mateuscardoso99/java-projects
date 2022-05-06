package view;

import conexao.ConnectionFactory;
import controller.ComissaoController;
import controller.ItensVendaController;
import controller.ProdutoController;
import controller.VendaController;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ItensVenda;
import model.bean.Produto;
import model.bean.Venda;
import model.bean.Vendedor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.validacao;
import tablemodel.ItensVendaTableModel;
import tablemodel.ProdutoTableModel;

public class ViewItensVenda extends javax.swing.JFrame {

    ItensVendaController ivc = new ItensVendaController();
    ItensVendaTableModel it;
    DefaultTableModel modelo;
    int idvenda;
    String data;
    Vendedor vendedor;
    
    ProdutoTableModel pt;
    
    public ViewItensVenda(Venda v) {
        initComponents();
        
        this.idvenda = v.getId();
        this.vendedor = v.getVendedor();
        this.data = v.getData();
        
        modelo = (DefaultTableModel) tabelaItensVenda.getModel();
        populaProduto();
        populaTabela();
    }

    public void populaTabela(){
        tabelaItensVenda.removeAll();
        it = new ItensVendaTableModel(ivc.read(this.idvenda));
        tabelaItensVenda.setModel(it);
    }
    
    public void populaProduto(){
        ProdutoController pc = new ProdutoController();
        for(Produto prod : pc.read()){
            jComboBoxProdutoItenVenda.addItem(prod);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItensVenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProdutoItenVenda = new javax.swing.JComboBox<>();
        btnadd = new javax.swing.JButton();
        btnremover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();
        btnfinalizarvenda = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaItensVenda);

        jLabel1.setText("PRODUTO:");

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save-icon.png"))); // NOI18N
        btnadd.setText("ADICIONAR");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnremover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close-icon.png"))); // NOI18N
        btnremover.setText("REMOVER");
        btnremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoverActionPerformed(evt);
            }
        });

        jLabel2.setText("QUANTIDADE:");

        btnfinalizarvenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Sales-report-icon.png"))); // NOI18N
        btnfinalizarvenda.setText("FINALIZAR VENDA");
        btnfinalizarvenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizarvendaActionPerformed(evt);
            }
        });

        jLabel3.setText("TOTAL A PAGAR R$:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("ITENS DA VENDA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfinalizarvenda)
                .addGap(86, 86, 86)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnadd)
                        .addGap(90, 90, 90)
                        .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(8, 8, 8)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxProdutoItenVenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel4)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProdutoItenVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnremover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnfinalizarvenda))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        if (validaCamposItensVenda()) {
            Produto p = (Produto) jComboBoxProdutoItenVenda.getSelectedItem();
            double total = 0;
            
            try {
                ivc.create(this.idvenda, p, Integer.parseInt(txtqtd.getText()), p.getPreco());
                populaTabela();
                
            if(!txttotal.getText().equals("")){
                total = Double.parseDouble(txttotal.getText());
            }
            total += Integer.parseInt(txtqtd.getText()) * p.getPreco();
            
            
            
            } catch (SQLException ex) {
                Logger.getLogger(ViewItensVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtqtd.setText("");
            txttotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnfinalizarvendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizarvendaActionPerformed
        if (tabelaItensVenda.getRowCount() > 0) {
            VendaController vc = new VendaController();
            ComissaoController cc = new ComissaoController();

            double valorComissao = (Double.parseDouble(txttotal.getText()) * vendedor.getPercentual()) / 100;

            vc.update(Double.parseDouble(txttotal.getText()), this.idvenda);
            cc.create(valorComissao, this.data, vendedor);

            Connection con = ConnectionFactory.getConnection();
            String src = "src/reports/relatorioVendas.jasper";

            JasperPrint jp = null;
            Map m = new HashMap();
            m.put("id", this.idvenda);

            try {
                jp = JasperFillManager.fillReport(src, m, con);

            } catch (JRException ex) {
                System.out.println("erro ao gerar relatório da venda" + ex);
            }

            JasperViewer view = new JasperViewer(jp, false);
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "não há produtos para salvar", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnfinalizarvendaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal vp = new ViewPrincipal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverActionPerformed
        if(tabelaItensVenda.getRowCount() > 0){          
            double valorExcluido = (double) it.getValueAt(tabelaItensVenda.getSelectedRow(), 2);
            double total = Double.parseDouble(txttotal.getText());
            total = total - valorExcluido;
            
            ItensVenda iv = (ItensVenda) it.getItensVenda(tabelaItensVenda.getSelectedRow());
            ivc.delete(this.idvenda, iv);
            populaTabela();
            
            txttotal.setText(String.valueOf(total));
       
       }else{
            JOptionPane.showMessageDialog(this, "não há produtos para remover","",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnremoverActionPerformed

    private boolean validaCamposItensVenda(){
        if(!validacao.validaQuantidade(txtqtd.getText())){
            JOptionPane.showMessageDialog(this, "quantidade inválida","",JOptionPane.ERROR_MESSAGE);
            txtqtd.setText("");
            return false;
        }
        
        return true;
    }
    
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
            java.util.logging.Logger.getLogger(ViewItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewItensVenda(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnfinalizarvenda;
    private javax.swing.JButton btnremover;
    private javax.swing.JComboBox<Object> jComboBoxProdutoItenVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaItensVenda;
    private javax.swing.JTextField txtqtd;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}

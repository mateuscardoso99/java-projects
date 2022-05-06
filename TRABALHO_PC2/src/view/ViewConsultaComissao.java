package view;

import conexao.ConnectionFactory;
import controller.VendedorController;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Vendedor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tablemodel.VendedorTableModel;

public class ViewConsultaComissao extends javax.swing.JFrame {

    VendedorController vc = new VendedorController();
    VendedorTableModel vt;
    
    public ViewConsultaComissao() {
        initComponents();
        
        btnrelatorio.setEnabled(false);
    }

    public void buscaNome(){
        tabelaVendedoresComissao.removeAll();
        vt = new VendedorTableModel(vc.buscaNome(txtbuscar.getText()));
        tabelaVendedoresComissao.setModel(vt);
    }
    
    public void buscaCpf(){
        tabelaVendedoresComissao.removeAll();
        vt = new VendedorTableModel(vc.buscacpf(txtbuscar.getText()));
        tabelaVendedoresComissao.setModel(vt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonCPF = new javax.swing.JRadioButton();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendedoresComissao = new javax.swing.JTable();
        btnrelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("CONSULTA DE COMISSÕES");

        jLabel2.setText("BUSCAR:");

        buttonGroup1.add(jRadioButtonNome);
        jRadioButtonNome.setText("Nome");

        jLabel3.setText("Buscar por:");

        buttonGroup1.add(jRadioButtonCPF);
        jRadioButtonCPF.setText("CPF");

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tabelaVendedoresComissao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaVendedoresComissao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendedoresComissaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVendedoresComissao);

        btnrelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Reports-icon.png"))); // NOI18N
        btnrelatorio.setText("RELATÓRIO DE COMISSÕES");
        btnrelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnrelatorio)
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButtonNome)
                    .addComponent(jRadioButtonCPF)
                    .addComponent(btnbuscar))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        if(txtbuscar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "digite a sua busca", "", JOptionPane.WARNING_MESSAGE);
        }else if(jRadioButtonNome.isSelected()==false && jRadioButtonCPF.isSelected()==false){
            JOptionPane.showMessageDialog(null, "selecione o tipo de busca", "", JOptionPane.WARNING_MESSAGE);
        }else{
            if(jRadioButtonNome.isSelected()){
                buscaNome();
            }else{
                buscaCpf();
            }
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal vp = new ViewPrincipal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void tabelaVendedoresComissaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendedoresComissaoMouseClicked
        if(tabelaVendedoresComissao.getSelectedRow() >= 0){
        btnrelatorio.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaVendedoresComissaoMouseClicked

    private void btnrelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrelatorioActionPerformed
        if (tabelaVendedoresComissao.getSelectedRow() >= 0) {
            Vendedor vendedor = vt.getVendedor(tabelaVendedoresComissao.getSelectedRow());

            try {

                Connection con = ConnectionFactory.getConnection();
                String src = "src/reports/relatorioComissao.jasper";

                JasperPrint jp = null;
                Map m = new HashMap();
                m.put("id", vendedor.getId());

                try {
                    jp = JasperFillManager.fillReport(src, m, con);

                } catch (JRException ex) {
                    System.out.println("erro ao gerar relatório da venda" + ex);
                }

                JasperViewer view = new JasperViewer(jp, false);
                view.setVisible(true);

            } catch (NullPointerException ne) {
                JOptionPane.showMessageDialog(null, "cliente não possui vendas registradas");
            }

        } else {
            JOptionPane.showMessageDialog(null, "não há registradas com esse vendedor");
        }
    }//GEN-LAST:event_btnrelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(ViewConsultaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConsultaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConsultaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConsultaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConsultaComissao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnrelatorio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonCPF;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVendedoresComissao;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}

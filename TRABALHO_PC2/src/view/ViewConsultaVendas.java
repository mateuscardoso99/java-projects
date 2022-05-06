package view;

import conexao.ConnectionFactory;
import controller.ClienteController;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tablemodel.ClienteTableModel;

public class ViewConsultaVendas extends javax.swing.JFrame {

    ClienteController cc = new ClienteController();
    ClienteTableModel ct;
    
    public ViewConsultaVendas() {
        initComponents();
        
        btnRelatorioCliente.setEnabled(false);
    }
    
    public void buscaNome(){
        tabelaClienteVendas.removeAll();
        ct = new ClienteTableModel(cc.buscaNome(txtbuscar.getText()));
        tabelaClienteVendas.setModel(ct);
    }
    
    public void buscaCpf(){
        tabelaClienteVendas.removeAll();
        ct = new ClienteTableModel(cc.buscacpf(txtbuscar.getText()));
        tabelaClienteVendas.setModel(ct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jRadioButtonCPF = new javax.swing.JRadioButton();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClienteVendas = new javax.swing.JTable();
        btnRelatorioCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("BUSCAR:");

        jLabel2.setText("CONSULTAR VENDAS DOS CLIENTES");

        jLabel3.setText("Buscar por:");

        buttonGroup1.add(jRadioButtonNome);
        jRadioButtonNome.setText("Nome");

        buttonGroup1.add(jRadioButtonCPF);
        jRadioButtonCPF.setText("CPF:");

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tabelaClienteVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaClienteVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClienteVendas);

        btnRelatorioCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Reports-icon.png"))); // NOI18N
        btnRelatorioCliente.setText("RELATÓRIO DE VENDAS DO CLIENTE");
        btnRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRelatorioCliente)
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButtonNome)
                    .addComponent(jRadioButtonCPF)
                    .addComponent(btnbuscar))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRelatorioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal vp = new ViewPrincipal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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

    private void btnRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioClienteActionPerformed
        if (tabelaClienteVendas.getSelectedRow() >= 0) {
            Cliente cliente = ct.getCliente(tabelaClienteVendas.getSelectedRow());

            try {

                Connection con = ConnectionFactory.getConnection();
                String src = "src/reports/vendasCliente.jasper";

                JasperPrint jp = null;
                Map m = new HashMap();
                m.put("id", cliente.getId());

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
            JOptionPane.showMessageDialog(null, "não há registradas com esse cliente");
        }
    }//GEN-LAST:event_btnRelatorioClienteActionPerformed

    private void tabelaClienteVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteVendasMouseClicked
        if(tabelaClienteVendas.getSelectedRow() >= 0){
        btnRelatorioCliente.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaClienteVendasMouseClicked

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
            java.util.logging.Logger.getLogger(ViewConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConsultaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRelatorioCliente;
    private javax.swing.JButton btnbuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonCPF;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClienteVendas;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}

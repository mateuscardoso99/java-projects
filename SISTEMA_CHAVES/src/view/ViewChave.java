package view;

import controller.ChaveController;
import controller.PorteiroController;
import javax.swing.JOptionPane;
import model.bean.Chave;
import model.bean.Porteiro;
import tablemodel.ChaveTableModel;

public class ViewChave extends javax.swing.JFrame {
    
    ChaveController ccon = new ChaveController();
    ChaveTableModel tb = new ChaveTableModel();
    
    public ViewChave() {
        initComponents();
        listaPorteiros();
        atualizaTabela();
    }

    public void atualizaTabela(){
        tabelaChaves.removeAll();
        tb = new ChaveTableModel(ccon.read());
        tabelaChaves.setModel(tb);   
    }
    
    public void listaPorteiros(){
        PorteiroController pcon = new PorteiroController();
        
        for(Porteiro pt:pcon.porteirosAtivados()){
            jComboBoxPorteiroChaves.addItem(pt);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncadastrar = new javax.swing.JButton();
        btnatualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaChaves = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtsala = new javax.swing.JTextField();
        jComboBoxPorteiroChaves = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Chaves");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btncadastrar.setBackground(new java.awt.Color(0, 102, 102));
        btncadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btncadastrar.setText("CADASTRAR");
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        btnatualizar.setBackground(new java.awt.Color(51, 51, 255));
        btnatualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnatualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnatualizar.setText("ATUALIZAR");
        btnatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatualizarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(255, 0, 0));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnexcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnexcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnexcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnexcluir.setText("EXCLUIR");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        tabelaChaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaChaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaChavesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaChaves);

        jLabel1.setText("SALA:");

        jLabel2.setText("PORTEIRO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtsala)
                        .addComponent(jComboBoxPorteiroChaves, 0, 358, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtsala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPorteiroChaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncadastrar)
                    .addComponent(btnexcluir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnatualizar)
                    .addComponent(btncancelar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        if(!txtsala.getText().isEmpty() && jComboBoxPorteiroChaves.getItemCount() > 0){
            Porteiro pt = (Porteiro) jComboBoxPorteiroChaves.getSelectedItem();
            ccon.inserir(txtsala.getText(),pt);
            txtsala.setText("");
            atualizaTabela();
        }
        else if(txtsala.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a sala", "", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "É preciso ter um porteiro ativado", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        if(!txtsala.getText().isEmpty() && jComboBoxPorteiroChaves.getItemCount() > 0){
            
            Chave ch = tb.getChave(tabelaChaves.getSelectedRow());
            Porteiro pt = (Porteiro) jComboBoxPorteiroChaves.getSelectedItem();
            
            if(ccon.update(ch.getId(),txtsala.getText(),pt)){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados", "", JOptionPane.ERROR_MESSAGE);
            }
            atualizaTabela();
            txtsala.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Preencha a sala", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        ViewPrincipal view = new ViewPrincipal();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        if(tabelaChaves.getSelectedRow()>=0){
            Chave ch = tb.getChave(tabelaChaves.getSelectedRow());
            ccon.delete(ch.getId());
            atualizaTabela();
            txtsala.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma chave", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void tabelaChavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaChavesMouseClicked
        tb = (ChaveTableModel) tabelaChaves.getModel();
        Chave ch = tb.getChave(tabelaChaves.getSelectedRow());
        String nome = (String) tabelaChaves.getValueAt(tabelaChaves.getSelectedRow(), 2);
        txtsala.setText(ch.getSala());
        
        for(int i=0; i<jComboBoxPorteiroChaves.getItemCount(); i++){
            Porteiro pt = (Porteiro) jComboBoxPorteiroChaves.getItemAt(i);
            if(pt.getNome().equals(nome)){
                jComboBoxPorteiroChaves.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tabelaChavesMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal view = new ViewPrincipal();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ViewChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewChave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatualizar;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JComboBox<Object> jComboBoxPorteiroChaves;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaChaves;
    private javax.swing.JTextField txtsala;
    // End of variables declaration//GEN-END:variables
}

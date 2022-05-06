package view;

import controller.AlunoController;
import controller.ProfessorController;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Professor;
import tablemodel.AlunoTableModel;

public class ViewAluno extends javax.swing.JFrame {

    AlunoController ac = new AlunoController();
    AlunoTableModel att = new AlunoTableModel();
    
    public ViewAluno() {
        initComponents();
        listaProfessores();
        atualizaTabela();
    }

    public void listaProfessores(){
        ProfessorController pfc = new ProfessorController();
        
        for(Professor p:pfc.professoresAtivados()){
            jComboBoxProfessorResponsavel.addItem(p);
        }
    }
    
    public void atualizaTabela(){
        tabelaAlunos.removeAll();
        att = new AlunoTableModel(ac.read());
        tabelaAlunos.setModel(att);   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncadastrar = new javax.swing.JButton();
        btnatualizar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtcurso = new javax.swing.JTextField();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxProfessorResponsavel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Alunos");
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

        btnexcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnexcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnexcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnexcluir.setText("EXCLUIR");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
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

        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAlunos);

        jLabel1.setText("NOME:");

        jLabel2.setText("SITUAÇÃO:");

        jLabel3.setText("CURSO:");

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));

        jLabel4.setText("PROFESSOR RESPONSÁVEL:");

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
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(35, 35, 35)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtcurso)
                            .addComponent(txtnome)
                            .addComponent(jComboBoxSituacao, 0, 424, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxProfessorResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxProfessorResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnatualizar)
                    .addComponent(btnexcluir)
                    .addComponent(btncancelar)
                    .addComponent(btncadastrar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        if(!txtnome.getText().isEmpty() && !txtcurso.getText().isEmpty() && jComboBoxProfessorResponsavel.getItemCount() > 0){
            Professor prof = (Professor) jComboBoxProfessorResponsavel.getSelectedItem();
            ac.inserir(txtnome.getText(),txtcurso.getText(),jComboBoxSituacao.getSelectedItem().toString(),prof);
            txtnome.setText("");
            txtcurso.setText("");
            atualizaTabela();
        }
        else if(txtnome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o nome", "", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtcurso.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o curso", "", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "É preciso ter um professor ativado", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        if(!txtnome.getText().isEmpty() && !txtcurso.getText().isEmpty() && jComboBoxProfessorResponsavel.getItemCount() > 0){
            
            Aluno a = att.getAluno(tabelaAlunos.getSelectedRow());
            Professor prof = (Professor) jComboBoxProfessorResponsavel.getSelectedItem();
            
            if(ac.update(a.getId(),txtnome.getText(),txtcurso.getText(),jComboBoxSituacao.getSelectedItem().toString(),prof)){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados", "", JOptionPane.ERROR_MESSAGE);
            }
            atualizaTabela();
            txtnome.setText("");
            txtcurso.setText("");
        }
        else if(txtnome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o nome", "", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtcurso.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o curso", "", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "É preciso ter um professor ativado", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        if(tabelaAlunos.getSelectedRow()>=0){
            Aluno a = att.getAluno(tabelaAlunos.getSelectedRow());
            ac.delete(a.getId());
            atualizaTabela();
            txtnome.setText("");
            txtcurso.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um aluno", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        ViewPrincipal view = new ViewPrincipal();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tabelaAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunosMouseClicked
        txtnome.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 0).toString());
        txtcurso.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 1).toString());
        jComboBoxSituacao.setSelectedItem(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 2));
        
        String nome = (String) tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 3);
        for(int i=0; i<jComboBoxProfessorResponsavel.getItemCount(); i++){
            Professor prof = (Professor) jComboBoxProfessorResponsavel.getItemAt(i);
            if(prof.getNome().equals(nome)){
                jComboBoxProfessorResponsavel.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tabelaAlunosMouseClicked

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
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatualizar;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JComboBox<Object> jComboBoxProfessorResponsavel;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField txtcurso;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables
}

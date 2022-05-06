package view;

import controller.AlunoController;
import controller.AulaController;
import controller.ChaveController;
import controller.PorteiroController;
import controller.ProfessorController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Chave;
import model.bean.Porteiro;
import model.bean.Professor;

public class ViewIniciarAula extends javax.swing.JFrame {

    ChaveController chcon = new ChaveController();
    AulaController aulacon = new AulaController();
    
    public ViewIniciarAula() {
        initComponents();
        professoresAtivados();
        alunosAtivados();
        porteirosAtivados();
        chavesLiberadas();
        dataAtual();
    }
    
    public void dataAtual(){
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        txtdata.setText(formatarDate.format(data));
    }
    
    public void chavesLiberadas(){
        for(Chave ch:chcon.chavesLiberadas()){
            jComboBoxChaves.addItem(ch.getSala());
        }
    }

    public void professoresAtivados(){
        ProfessorController profcon = new  ProfessorController();
        
        for(Professor pf:profcon.professoresAtivados()){
            jComboBoxProfessores.addItem(pf);
        }
    }
    
    public void alunosAtivados(){
        AlunoController ac = new AlunoController();
        
        for(Aluno a:ac.alunosAtivados()){
            jComboBoxAlunos.addItem(a);
        }
    }
    
    public void porteirosAtivados(){
        PorteiroController pcon = new PorteiroController();
        
        for(Porteiro pt:pcon.porteirosAtivados()){
            jComboBoxPorteiros.addItem(pt);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxChaves = new javax.swing.JComboBox<>();
        jComboBoxProfessores = new javax.swing.JComboBox<>();
        jComboBoxAlunos = new javax.swing.JComboBox<>();
        jComboBoxPorteiros = new javax.swing.JComboBox<>();
        txtdata = new javax.swing.JFormattedTextField();
        btniniciaraula = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar Aula");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("CHAVE:");

        jLabel2.setText("PROFESSOR RESPONSÁVEL:");

        jLabel3.setText("ALUNO RESPONSÁVEL:");

        jLabel4.setText("DATA:");

        jLabel5.setText("PORTEIRO:");

        jComboBoxProfessores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

        jComboBoxAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

        try {
            txtdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btniniciaraula.setBackground(new java.awt.Color(0, 153, 153));
        btniniciaraula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btniniciaraula.setForeground(new java.awt.Color(255, 255, 255));
        btniniciaraula.setText("INICIAR AULA");
        btniniciaraula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciaraulaActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxChaves, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPorteiros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxProfessores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxAlunos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btniniciaraula)
                        .addGap(98, 98, 98)
                        .addComponent(btncancelar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxChaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPorteiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btniniciaraula)
                    .addComponent(btncancelar))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal view = new ViewPrincipal();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btniniciaraulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciaraulaActionPerformed
        if(txtdata.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Preencha a data", "", JOptionPane.ERROR_MESSAGE);
        }else if(jComboBoxChaves.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "É preciso ter chaves liberadas", "", JOptionPane.ERROR_MESSAGE);
        }else if(jComboBoxPorteiros.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "É preciso ter um porteiro ativado", "", JOptionPane.ERROR_MESSAGE);
        }else{
                if(jComboBoxAlunos.getSelectedItem().equals("Nenhum") && 
                        jComboBoxProfessores.getSelectedItem().equals("Nenhum")){
                    JOptionPane.showMessageDialog(null, "É preciso ter um responsável", "", JOptionPane.ERROR_MESSAGE);
                }
                else if(jComboBoxAlunos.getSelectedItem().equals("Nenhum") &&
                        !jComboBoxProfessores.getSelectedItem().equals("Nenhum")){
                    
                    Chave chave = (Chave)jComboBoxChaves.getSelectedItem();
                    Professor professor = (Professor)jComboBoxProfessores.getSelectedItem();
                    Porteiro pt = (Porteiro)jComboBoxPorteiros.getSelectedItem();
                    if(aulacon.iniciarAula(chave.getId(), professor.getId(), 0, pt.getId(), txtdata.getText())){
                        if(chcon.updateSituacao(chave.getId(), "Ocupada")){
                            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Não foi possível salvar", "", JOptionPane.ERROR_MESSAGE);
                    }
                }else if(!jComboBoxAlunos.getSelectedItem().equals("Nenhum") &&
                        jComboBoxProfessores.getSelectedItem().equals("Nenhum")){
                    Chave chave = (Chave)jComboBoxChaves.getSelectedItem();
                    Aluno aluno = (Aluno)jComboBoxAlunos.getSelectedItem();
                    Porteiro pt = (Porteiro)jComboBoxPorteiros.getSelectedItem();
                    if(aulacon.iniciarAula(chave.getId(), 0, aluno.getId(), pt.getId(), txtdata.getText())){
                        if(chcon.updateSituacao(chave.getId(), "Ocupada")){
                            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Não foi possível salvar", "", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    Professor professor = (Professor)jComboBoxProfessores.getSelectedItem();
                    Chave chave = (Chave)jComboBoxChaves.getSelectedItem();
                    Aluno aluno = (Aluno)jComboBoxAlunos.getSelectedItem();
                    Porteiro pt = (Porteiro)jComboBoxPorteiros.getSelectedItem();
                    if(aulacon.iniciarAula(chave.getId(), professor.getId(), aluno.getId(), pt.getId(), txtdata.getText())){
                        if(chcon.updateSituacao(chave.getId(), "Ocupada")){
                            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Não foi possível salvar", "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
    }//GEN-LAST:event_btniniciaraulaActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewIniciarAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIniciarAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIniciarAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIniciarAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIniciarAula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btniniciaraula;
    private javax.swing.JComboBox<Object> jComboBoxAlunos;
    private javax.swing.JComboBox<Object> jComboBoxChaves;
    private javax.swing.JComboBox<Object> jComboBoxPorteiros;
    private javax.swing.JComboBox<Object> jComboBoxProfessores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JFormattedTextField txtdata;
    // End of variables declaration//GEN-END:variables
}

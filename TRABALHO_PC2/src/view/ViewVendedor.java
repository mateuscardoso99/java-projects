package view;

import conexao.ConnectionFactory;
import controller.VendedorController;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.bean.Vendedor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.validacao;
import tablemodel.VendedorTableModel;

public class ViewVendedor extends javax.swing.JFrame {

    VendedorController vc = new VendedorController();
    MaskFormatter a;
    VendedorTableModel vt;
            
    public ViewVendedor() {
        try{
            a = new MaskFormatter("###.###.###-##");
        }catch(Exception e){
            e.getMessage();
        }
        
        initComponents();
        
        btnatualizar.setEnabled(false);
        btnexcluir.setEnabled(false);
        
        populaTabela();
    }

    public void populaTabela(){
        tabelaVendedores.removeAll();
        vt = new VendedorTableModel(vc.select());
        tabelaVendedores.setModel(vt);
    }
    
    public void limpar(){
        txtnomevendedor.setText("");
        txtcpfvendedor.setText("");
        txtenderecovendedor.setText("");
        txtsalariovendedor.setText("");
        txtpercentualvendedor.setText("");
    }
    
    public void buscaNome(){
        tabelaVendedores.removeAll();
        vt = new VendedorTableModel(vc.buscaNome(txtbusca.getText()));
        tabelaVendedores.setModel(vt);
    }
    
    public void buscaCpf(){
        tabelaVendedores.removeAll();
        vt = new VendedorTableModel(vc.buscacpf(txtbusca.getText()));
        tabelaVendedores.setModel(vt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendedores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnomevendedor = new javax.swing.JTextField();
        txtsalariovendedor = new javax.swing.JTextField();
        txtcpfvendedor = new javax.swing.JFormattedTextField(a);
        txtpercentualvendedor = new javax.swing.JTextField();
        txtenderecovendedor = new javax.swing.JTextField();
        btncadastrar = new javax.swing.JButton();
        btnatualizar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jRadioButtonCPF = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnrestaurar = new javax.swing.JButton();
        btnrelatoriovendedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaVendedores.setSelectionBackground(new java.awt.Color(204, 0, 51));
        tabelaVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVendedores);

        jLabel2.setText("NOME:");

        jLabel3.setText("SALÁRIO:");

        jLabel4.setText("CPF:");

        jLabel5.setText("ENDEREÇO:");

        jLabel6.setText("PERCENTUAL: %");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("CADASTRO DE VENDEDORES");

        jLabel7.setText("BUSCAR:");

        buttonGroup1.add(jRadioButtonNome);
        jRadioButtonNome.setText("Nome");

        buttonGroup1.add(jRadioButtonCPF);
        jRadioButtonCPF.setText("CPF");

        jLabel8.setText("Buscar por:");

        btnbuscar.setBackground(new java.awt.Color(0, 102, 102));
        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnrestaurar.setBackground(new java.awt.Color(204, 0, 0));
        btnrestaurar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnrestaurar.setForeground(new java.awt.Color(255, 255, 255));
        btnrestaurar.setText("RESTAURAR");
        btnrestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestaurarActionPerformed(evt);
            }
        });

        btnrelatoriovendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Office-Client-Male-Dark-icon.png"))); // NOI18N
        btnrelatoriovendedor.setText("VENDEDORES CADASTRADOS");
        btnrelatoriovendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrelatoriovendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtsalariovendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcpfvendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)
                                .addComponent(txtpercentualvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtnomevendedor)
                            .addComponent(txtenderecovendedor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(16, 16, 16)
                                .addComponent(jRadioButtonNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonCPF))
                            .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnrestaurar))
                            .addComponent(btnrelatoriovendedor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnomevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsalariovendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtpercentualvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcpfvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtenderecovendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonNome)
                            .addComponent(jRadioButtonCPF)
                            .addComponent(jLabel8)
                            .addComponent(btnbuscar)
                            .addComponent(btnrestaurar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnexcluir)
                            .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncadastrar)
                            .addComponent(btnrelatoriovendedor)))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        if (validaCamposVendedor()) {
            if (!txtnomevendedor.getText().isEmpty() || !txtsalariovendedor.getText().isEmpty()) {
                if (vc.insert(txtnomevendedor.getText(), Double.parseDouble(txtsalariovendedor.getText()),
                        txtcpfvendedor.getText(), Double.parseDouble(txtpercentualvendedor.getText()), txtenderecovendedor.getText())) {
                    populaTabela();
                    limpar();
                }
            } else {
                JOptionPane.showMessageDialog(this, "nome e salário são obrigatórios", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void tabelaVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendedoresMouseClicked
        if(tabelaVendedores.getSelectedRow()>=0){
            
            txtnomevendedor.setText(tabelaVendedores.getValueAt(tabelaVendedores.getSelectedRow(), 0).toString());
            txtsalariovendedor.setText(tabelaVendedores.getValueAt(tabelaVendedores.getSelectedRow(), 1).toString());
            txtcpfvendedor.setText(tabelaVendedores.getValueAt(tabelaVendedores.getSelectedRow(), 2).toString());
            txtenderecovendedor.setText(tabelaVendedores.getValueAt(tabelaVendedores.getSelectedRow(), 3).toString());
            txtpercentualvendedor.setText(tabelaVendedores.getValueAt(tabelaVendedores.getSelectedRow(), 4).toString());
                        
            btnatualizar.setEnabled(true);
            btnexcluir.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaVendedoresMouseClicked

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        if(tabelaVendedores.getSelectedRow()>=0){
            
            Vendedor vendedor = vt.getVendedor(tabelaVendedores.getSelectedRow());
            
            if(vc.apagar(vendedor)){
                populaTabela();
                limpar();
                
                btnatualizar.setEnabled(false);
                btnexcluir.setEnabled(false);
            }         
        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        if (validaCamposVendedor()) {
            if (tabelaVendedores.getSelectedRow() >= 0) {
                
                Vendedor vendedor = vt.getVendedor(tabelaVendedores.getSelectedRow());
                
                if (vc.update(vendedor.getId(), txtnomevendedor.getText(),
                        Double.parseDouble(txtsalariovendedor.getText()), txtcpfvendedor.getText(),
                        Double.parseDouble(txtpercentualvendedor.getText()), txtenderecovendedor.getText())) {
                    populaTabela();
                    limpar();

                    btnatualizar.setEnabled(false);
                    btnexcluir.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal p = new ViewPrincipal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnrestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarActionPerformed
        populaTabela();
        txtbusca.setText("");
        jRadioButtonNome.setSelected(false);
        jRadioButtonCPF.setSelected(false);
    }//GEN-LAST:event_btnrestaurarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        if(txtbusca.getText().isEmpty()){
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

    private void btnrelatoriovendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrelatoriovendedorActionPerformed
        Connection con = ConnectionFactory.getConnection();
        String src = "src/reports/relatorioVendedores.jasper";
        
        JasperPrint jp = null;
        
        try{
            jp = JasperFillManager.fillReport(src, null, con);
            
        }catch(JRException ex){
            System.out.println("erro ao gerar relatório dos vendedores"+ex);
        }
        
        JasperViewer view = new JasperViewer(jp, false);
        view.setVisible(true);
    }//GEN-LAST:event_btnrelatoriovendedorActionPerformed

    private boolean validaCamposVendedor(){
        if(!validacao.validaNome(txtnomevendedor.getText())){
            JOptionPane.showMessageDialog(this, "nome inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaSalario(txtsalariovendedor.getText())){
            JOptionPane.showMessageDialog(this, "salário inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaPercentual(txtpercentualvendedor.getText())){
            JOptionPane.showMessageDialog(this, "percentual inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaCpf(txtcpfvendedor.getText())){
            JOptionPane.showMessageDialog(this, "cpf inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaEndereco(txtenderecovendedor.getText())){
            JOptionPane.showMessageDialog(this, "endereço inválido","",JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JButton btnrelatoriovendedor;
    private javax.swing.JButton btnrestaurar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButtonCPF;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVendedores;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JFormattedTextField txtcpfvendedor;
    private javax.swing.JTextField txtenderecovendedor;
    private javax.swing.JTextField txtnomevendedor;
    private javax.swing.JTextField txtpercentualvendedor;
    private javax.swing.JTextField txtsalariovendedor;
    // End of variables declaration//GEN-END:variables
}

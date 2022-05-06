package view;

import conexao.ConnectionFactory;
import controller.ClienteController;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.bean.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.validacao;
import tablemodel.ClienteTableModel;

public class ViewCliente extends javax.swing.JFrame {

    ClienteController cc = new ClienteController();
    MaskFormatter a,b,c;
    ClienteTableModel ct;
    
    public ViewCliente() {
        try{
            a = new MaskFormatter("##/##/####");
            b = new MaskFormatter("(##) #####-####");
            c = new MaskFormatter("###.###.###-##");
        }catch(Exception e){
            e.getMessage();
        }
        initComponents();
        
        btnatualizar.setEnabled(false);
        btnapagar.setEnabled(false);
        populaTabela();
        
    }
    
    public void limpar(){
        txtnomecliente.setText("");
        txttelefonecliente.setText("");
        txtcpfcliente.setText("");
        txtenderecocliente.setText("");
        txtaniversariocliente.setText("");
    }
    
    public void populaTabela(){
        tabelaCliente.removeAll();
        ct = new ClienteTableModel(cc.read());
        tabelaCliente.setModel(ct);
    }
    
    public void buscaNome(){
        tabelaCliente.removeAll();
        ct = new ClienteTableModel(cc.buscaNome(txtbusca.getText()));
        tabelaCliente.setModel(ct);
    }
    
    public void buscaCpf(){
        tabelaCliente.removeAll();
        ct = new ClienteTableModel(cc.buscacpf(txtbusca.getText()));
        tabelaCliente.setModel(ct);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnomecliente = new javax.swing.JTextField();
        txtenderecocliente = new javax.swing.JTextField();
        txtaniversariocliente = new javax.swing.JFormattedTextField(a);
        txttelefonecliente = new javax.swing.JFormattedTextField(b);
        txtcpfcliente = new javax.swing.JFormattedTextField(c);
        btnCadastro = new javax.swing.JButton();
        btnatualizar = new javax.swing.JButton();
        btnapagar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jRadioButtonCPF = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnrestaurar = new javax.swing.JButton();
        btnrelatorioclientes = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaCliente.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        jLabel1.setText("NOME:");

        jLabel2.setText("ENDEREÇO:");

        jLabel3.setText("DATA DE ANIVERSÁRIO:");

        jLabel4.setText("TELEFONE:");

        jLabel5.setText("CPF:");

        btnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save-icon.png"))); // NOI18N
        btnCadastro.setText("CADASTRAR");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-validated-icon.png"))); // NOI18N
        btnatualizar.setText("ATUALIZAR");
        btnatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatualizarActionPerformed(evt);
            }
        });

        btnapagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close-icon.png"))); // NOI18N
        btnapagar.setText("EXCLUIR");
        btnapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("CADASTRO DE CLIENTES");

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

        btnrelatorioclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/User-Clients-icon.png"))); // NOI18N
        btnrelatorioclientes.setText("CLIENTES CADASTRADOS");
        btnrelatorioclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrelatorioclientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefonecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcpfcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonNome)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCPF))
                    .addComponent(btnapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnrestaurar))
                    .addComponent(btnrelatorioclientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtaniversariocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnomecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtenderecocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(355, 355, 355))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtnomecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtenderecocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaniversariocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txttelefonecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastro)
                            .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnapagar)
                            .addComponent(btnrelatorioclientes))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnrestaurar)
                            .addComponent(btnbuscar)
                            .addComponent(jRadioButtonCPF)
                            .addComponent(jRadioButtonNome)
                            .addComponent(jLabel8)
                            .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcpfcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        if (validaCamposCliente()) {
            if (!txtnomecliente.getText().isEmpty()) {
                cc.insert(txtnomecliente.getText(), txtenderecocliente.getText(), txtaniversariocliente.getText(), txttelefonecliente.getText(), txtcpfcliente.getText());
                populaTabela();
                limpar();
            } else {
                JOptionPane.showMessageDialog(this, "nome é obrigatório", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        if(tabelaCliente.getSelectedRow() >= 0){
            txtnomecliente.setText(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 0).toString());
            txtenderecocliente.setText(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 1).toString());
            txtaniversariocliente.setText(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 2).toString());
            txttelefonecliente.setText(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 3).toString());
            txtcpfcliente.setText(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 4).toString());
            
            btnatualizar.setEnabled(true);
            btnapagar.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        if (validaCamposCliente()) {
            if (!txtnomecliente.getText().isEmpty()) {
                
                Cliente cliente = ct.getCliente(tabelaCliente.getSelectedRow());
                
                if (cc.update(cliente.getId(), txtnomecliente.getText(), txtenderecocliente.getText(),
                        txtaniversariocliente.getText(), txttelefonecliente.getText(), txtcpfcliente.getText())) {
                    populaTabela();
                    limpar();
                    btnatualizar.setEnabled(false);
                    btnapagar.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "nome é obrigatório", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void btnapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarActionPerformed
        if(tabelaCliente.getSelectedRow() >= 0){
            
            Cliente cliente = ct.getCliente(tabelaCliente.getSelectedRow());
            
            if(cc.delete(cliente)){
                populaTabela();
                limpar();
                btnapagar.setEnabled(false);
                btnatualizar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnapagarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewPrincipal p = new ViewPrincipal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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

    private void btnrestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarActionPerformed
        populaTabela();
        txtbusca.setText("");
        jRadioButtonNome.setSelected(false);
        jRadioButtonCPF.setSelected(false);
    }//GEN-LAST:event_btnrestaurarActionPerformed

    private void btnrelatorioclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrelatorioclientesActionPerformed
        Connection con = ConnectionFactory.getConnection();
        String src = "src/reports/relatorioCliente.jasper";
        
        JasperPrint jp = null;
        
        try{
            jp = JasperFillManager.fillReport(src, null, con);
            
        }catch(JRException ex){
            System.out.println("erro ao gerar relatório dos clientes"+ex);
        }
        
        JasperViewer view = new JasperViewer(jp, false);
        view.setVisible(true);
    }//GEN-LAST:event_btnrelatorioclientesActionPerformed

    private boolean validaCamposCliente(){
        if(!validacao.validaNome(txtnomecliente.getText())){
            JOptionPane.showMessageDialog(this, "nome inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaEndereco(txtenderecocliente.getText())){
            JOptionPane.showMessageDialog(this, "endereço inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaFone(txttelefonecliente.getText())){
            JOptionPane.showMessageDialog(this, "telefone inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaData(txtaniversariocliente.getText())){
            JOptionPane.showMessageDialog(this, "data inválida","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        if(!validacao.validaCpf(txtcpfcliente.getText())){
            JOptionPane.showMessageDialog(this, "cpf inválido","",JOptionPane.ERROR_MESSAGE);
            limpar();
            return false;
        }
        
        return true;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnapagar;
    private javax.swing.JButton btnatualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnrelatorioclientes;
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JRadioButton jRadioButtonCPF;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JFormattedTextField txtaniversariocliente;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JFormattedTextField txtcpfcliente;
    private javax.swing.JTextField txtenderecocliente;
    private javax.swing.JTextField txtnomecliente;
    private javax.swing.JFormattedTextField txttelefonecliente;
    // End of variables declaration//GEN-END:variables
}

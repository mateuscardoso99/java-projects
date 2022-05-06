
package newpackage;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class intRegistroVenda extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel <String> comboLivros = new DefaultComboBoxModel();
    private MaskFormatter f1,f2;
    private DefaultTableModel listaRegistroVenda;
    private Livro liverpool;
    private ArrayList <Livro> comboArray =new ArrayList<>();
    
    public intRegistroVenda() {
        try{
            f1=new MaskFormatter("##/##/####");
            f2=new MaskFormatter("###.###.###-##");
        }catch(Exception e){
            e.getMessage();
        }
        
        initComponents();
        
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        txtDataRegistroVenda.setText(formatarDate.format(data));
        
        File arq=new File("Livros.txt");
        if(arq.exists()){
            this.lerLivros();
        }
        
        listaRegistroVenda = (DefaultTableModel) tabelaRegistroVenda.getModel();
        
         for(int i=0;i<comboArray.size();i++){
        if(jComboBox1.getSelectedItem().toString().equals(comboArray.get(i).getNomeLivro())){
           txtPrecoRegistroVenda.setText(String.valueOf(comboArray.get(i).getPreco()));
            }  //ao abrir a tela o preço do primeiro item do combobox é inserido no campo preço
        }
        
    }

    public void posicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) /2, (d.height - this.getSize().height) /2);
    }
    
    public void lerLivros(){
        String conteudo="";
        try{
            FileReader fr=new FileReader("Livros.txt");
            BufferedReader bufalo=new BufferedReader(fr);
            while((conteudo=bufalo.readLine())!=null){
               String positions[]=conteudo.split(";");
                comboLivros.addElement(positions[0]);//adicionando no comboboxmodel o primeiro campo que corresponde ao nome
                liverpool=new Livro((String) positions[0], (String) positions[1], (String) positions[2], Double.parseDouble(positions[3]));
                comboArray.add(liverpool);                
            }
            jComboBox1.setModel(comboLivros);
         //  
            
            bufalo.close();
            fr.close();
            
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRegistroVenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnomeRegistroVenda = new javax.swing.JTextField();
        txtCpfRegistroVenda = new javax.swing.JFormattedTextField(f2);
        txtDataRegistroVenda = new javax.swing.JFormattedTextField(f1);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoRegistroVenda = new javax.swing.JTextField();
        btnsalvar = new javax.swing.JButton();
        btnremover = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTotalRegistroVenda = new javax.swing.JTextField();
        btnFinalizarVenda = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registro de Vendas de Livros");

        tabelaRegistroVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor Unitário", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaRegistroVenda);

        jLabel1.setText("NOME:");

        jLabel2.setText("CPF:");

        jLabel3.setText("DATA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DADOS DA VENDA");

        jLabel5.setText("SELECIONAR LIVROS:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("QUANTIDADE:");

        jLabel8.setText("PREÇO UNITÁRIO:");

        txtPrecoRegistroVenda.setEditable(false);

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Floppy-Small-icon.png"))); // NOI18N
        btnsalvar.setText("Cadastrar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btnremover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Button-Delete-icon.png"))); // NOI18N
        btnremover.setText("Remover");
        btnremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoverActionPerformed(evt);
            }
        });

        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Actions-application-exit-icon.png"))); // NOI18N
        btnsair.setText("Sair");
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("VALOR TOTAL DA VENDA:");

        txtTotalRegistroVenda.setEditable(false);

        btnFinalizarVenda.setBackground(new java.awt.Color(0, 0, 0));
        btnFinalizarVenda.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnomeRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCpfRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel6)
                                        .addGap(38, 38, 38)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(51, 51, 51)
                                                    .addComponent(jLabel7))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(33, 33, 33)
                                                    .addComponent(jLabel8)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtPrecoRegistroVenda)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(280, 280, 280)
                                        .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnFinalizarVenda)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnomeRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecoRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalRegistroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsairActionPerformed

    private void btnremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverActionPerformed
        if(tabelaRegistroVenda.getSelectedRow()>=0){   
        double valorExcluido = Double.parseDouble((String) listaRegistroVenda.getValueAt(tabelaRegistroVenda.getSelectedRow(), 3)); 
        listaRegistroVenda.removeRow(tabelaRegistroVenda.getSelectedRow());
        
        double diminui=Double.parseDouble(txtTotalRegistroVenda.getText());
        diminui=diminui-valorExcluido;
        txtTotalRegistroVenda.setText(String.valueOf(diminui));
        }
    }//GEN-LAST:event_btnremoverActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        if(txtQuant.getText().equals("")||Integer.parseInt(txtQuant.getText())<=0){
            JOptionPane.showMessageDialog(this, "quantidade deve ser preenchida corretamente", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        else{
        
        double z=Double.parseDouble(txtQuant.getText());
        double y=Double.parseDouble(txtPrecoRegistroVenda.getText());
        double t=z*y;
        
        String informacoes[] = {(String)jComboBox1.getSelectedItem(), txtPrecoRegistroVenda.getText(), txtQuant.getText(), String.valueOf(t)};
        
        listaRegistroVenda.addRow(informacoes);
        tabelaRegistroVenda.setModel(listaRegistroVenda);
        
        txtQuant.setText("");
        
         double valorTotal = 0;
        if (!txtTotalRegistroVenda.getText().equals("")) {
            valorTotal = Double.parseDouble(txtTotalRegistroVenda.getText());
        }
        valorTotal += z*y;
        
        txtTotalRegistroVenda.setText(String.valueOf(valorTotal));
        }
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        if(tabelaRegistroVenda.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "não há dados para salvar", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        else if(jComboBox1.getItemCount()<0){
            JOptionPane.showMessageDialog(this, "não existem livros cadastrados", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            
                Cliente c=new Cliente();
                c.setNomeCliente(txtnomeRegistroVenda.getText());
                c.setCpf(txtCpfRegistroVenda.getText());
           
                Venda v=new Venda(txtDataRegistroVenda.getText(),Double.parseDouble(txtTotalRegistroVenda.getText()),liverpool,c);
            
            try{
                
                FileWriter arq=new FileWriter(txtCpfRegistroVenda.getText()+".txt",false);
                PrintWriter dados=new PrintWriter(arq);
                
                dados.println("--------------------RECIBO--------------------");
                dados.println("Nome do Cliente: "+v.getCliente().getNomeCliente());
                dados.println("CPF: "+v.getCliente().getCpf());
                dados.println("Data da Venda: "+v.getDataVenda());
                dados.println("");//linha vazia pra ficar melhor de ler o arquivo
                
                 for(int i=0;i<listaRegistroVenda.getRowCount();i++){
                   dados.println("Produto: "+listaRegistroVenda.getValueAt(i, 0));
                   dados.println("Preço: "+listaRegistroVenda.getValueAt(i, 1));
                   dados.println("Quantidade: "+listaRegistroVenda.getValueAt(i, 2));
                   dados.println("Total: "+listaRegistroVenda.getValueAt(i, 3));
                   dados.println("");//linha vazia pra ficar melhor de ler o arquivo
                }
                
                dados.println("Total a pagar: R$ "+v.getValorTotal());
                 
                arq.close();
                dados.close();
                  
                 JOptionPane.showMessageDialog(this, "venda registrada com sucesso");
                 
                 txtQuant.setText("");
                 
                 listaRegistroVenda.setRowCount(0);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "não foi possível salvar", "", JOptionPane.ERROR_MESSAGE);
            }
                       
            
        }
        
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       for(int i=0;i<comboArray.size();i++){
        if(jComboBox1.getSelectedItem().toString().equals(comboArray.get(i).getNomeLivro())){
           txtPrecoRegistroVenda.setText(String.valueOf(comboArray.get(i).getPreco()));
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnremover;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRegistroVenda;
    public javax.swing.JFormattedTextField txtCpfRegistroVenda;
    private javax.swing.JFormattedTextField txtDataRegistroVenda;
    private javax.swing.JTextField txtPrecoRegistroVenda;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtTotalRegistroVenda;
    public javax.swing.JTextField txtnomeRegistroVenda;
    // End of variables declaration//GEN-END:variables
}

package newpackage;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class intCadLivros extends javax.swing.JInternalFrame {

    private DefaultTableModel listaLivros;
    private ArrayList <Livro> arrayLivros=new ArrayList<>();
    private boolean alterar=false;
    private String nomeSelecionado;
    
    public intCadLivros() {
        initComponents();
        
        listaLivros=(DefaultTableModel) tabelaLivros.getModel();
     
        btnremover.setEnabled(false);
        btnCadastrar.setEnabled(false);
    }

    public void posicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) /2, (d.height - this.getSize().height) /2);
    }
    
    public void limpar(){
        txtnomeLivro.setText("");
        txtautor.setText("");
        txteditora.setText("");
        txtprecoLivro.setText("");
        
        txtnomeLivro.requestFocus();
    }
    
    public void lerLivros(){
        listaLivros.setRowCount(0);
        arrayLivros=new ArrayList<>();
        listaLivros=(DefaultTableModel) tabelaLivros.getModel();
        
        String l;
        try{
            FileReader fr=new FileReader("Livros.txt");
            BufferedReader bufalo=new BufferedReader(fr);
            while((l=bufalo.readLine())!=null){
                String[] vetorLivros=l.split(";");
                listaLivros.addRow(vetorLivros);//populando o tablemodel com os dados do vetor que pega os dados do arquivo
                
                Livro liv=new Livro
        (vetorLivros[0],vetorLivros[1],vetorLivros[2],Double.parseDouble(vetorLivros[3]));
                
                arrayLivros.add(liv);
                
            }
            tabelaLivros.setModel(listaLivros);
            
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
        tabelaLivros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnomeLivro = new javax.swing.JTextField();
        txtautor = new javax.swing.JTextField();
        txteditora = new javax.swing.JTextField();
        txtprecoLivro = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnremover = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Livros");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Autor", "Editora", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLivros);

        jLabel1.setText("NOME:");

        jLabel2.setText("AUTOR:");

        jLabel3.setText("EDITORA:");

        jLabel4.setText("PREÇO UNITÁRIO:");

        txtnomeLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomeLivroKeyTyped(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Floppy-Small-icon.png"))); // NOI18N
        btnCadastrar.setText("Salvar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnomeLivro)
                        .addComponent(txtautor)
                        .addComponent(txteditora, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                    .addComponent(txtprecoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txteditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtprecoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Livro liv;
        
        if(txtnomeLivro.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "o nome do livro é obrigatório", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        
        else{
        
        
        if(alterar==false){
            
             String campos[]={txtnomeLivro.getText(),txtautor.getText(),txteditora.getText(),txtprecoLivro.getText()};
        
        listaLivros.addRow(campos);
        tabelaLivros.setModel(listaLivros);
            
            liv=new Livro(txtnomeLivro.getText(),txtautor.getText(),txteditora.getText(),Double.parseDouble(txtprecoLivro.getText()));
          //      arrayLivros.add(liv);
                        
       //     btnCadastrar.setEnabled(false);
       //     btnremover.setEnabled(false);
            
      /*      try{
                FileWriter arq=new FileWriter("Livros.txt", true);
                PrintWriter dados=new PrintWriter(arq);
                
            //    for(int i=0;i<arrayLivros.size();i++){
                    dados.println(liv.getNomeLivro()+
                    ";"+ liv.getAutor()+
                    ";"+ liv.getEditora()+
                    ";"+ liv.getPreco());
            //    }
                
                arq.close();
                dados.close();
                
                JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }*/
      arrayLivros.add(liv);
      limpar();
        
        } else if(alterar==true){
       /*     File file=new File("Livros.txt");
            if(file.exists()){
            file.delete();
            }*/
            int indiceLivroAlterar = 0;
            
            for(int i=0;i<arrayLivros.size();i++){
                if(arrayLivros.get(i).getNomeLivro()==this.nomeSelecionado){
                    indiceLivroAlterar=i;
                }
            }
            
            this.arrayLivros.get(indiceLivroAlterar).setNomeLivro(txtnomeLivro.getText());
            this.arrayLivros.get(indiceLivroAlterar).setAutor(txtautor.getText());
            this.arrayLivros.get(indiceLivroAlterar).setEditora(txteditora.getText());
            this.arrayLivros.get(indiceLivroAlterar).setPreco(Double.parseDouble(txtprecoLivro.getText()));
            
            this.listaLivros.setValueAt(txtnomeLivro.getText(), tabelaLivros.getSelectedRow(), 0);
            this.listaLivros.setValueAt(txtautor.getText(), tabelaLivros.getSelectedRow(), 1);
            this.listaLivros.setValueAt(txteditora.getText(), tabelaLivros.getSelectedRow(), 2);
            this.listaLivros.setValueAt(txtprecoLivro.getText(), tabelaLivros.getSelectedRow(), 3);
            
           /*  try{           
                FileWriter arq=new FileWriter("Livros.txt", true);
                PrintWriter dados=new PrintWriter(arq);
                
                for(int i=0;i<this.arrayLivros.size();i++){
                    dados.println(arrayLivros.get(i).getNomeLivro()+
                    ";"+ arrayLivros.get(i).getAutor()+
                    ";"+ arrayLivros.get(i).getEditora()+
                    ";"+ arrayLivros.get(i).getPreco());
                }
                
                arq.close();
                dados.close();
                this.nomeSelecionado=null;
                
                JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }*/
            
             
        }
        
        this.alterar=false;
        this.nomeSelecionado=null;
        limpar();
      //  lerLivros();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverActionPerformed
        if(tabelaLivros.getSelectedRow()<0||tabelaLivros.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "selecione uma linha pra poder apagar", "Atenção!", JOptionPane.WARNING_MESSAGE);          
        }
        else{      
        //    int linha=tabelaLivros.getSelectedRow();
            
            
            for(int i=0;i<arrayLivros.size();i++){
                   if(arrayLivros.get(i).getNomeLivro().equals(tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0))){
                       arrayLivros.remove(i);
                   }
            } 
            
            listaLivros.removeRow(tabelaLivros.getSelectedRow());
         //   tabelaLivros.setModel(listaLivros);
         this.alterar=false; //ao clicar em remover o usuario não está editando e sim apagando, portanto alterar fica falso
            limpar();
           
            
       /*     try{
                File file=new File("Livros.txt");
                file.delete();
                
                FileWriter arq=new FileWriter("Livros.txt",true);
                PrintWriter dados=new PrintWriter(arq);
                
                for(int i=0;i<arrayLivros.size();i++){
                dados.println(arrayLivros.get(i).getNomeLivro()+
                             ";"+arrayLivros.get(i).getAutor()+
                             ";"+arrayLivros.get(i).getEditora()+
                             ";"+arrayLivros.get(i).getPreco());
                }
                
                dados.close();
                arq.close();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }*/
      //  lerLivros();
           
        }
    }//GEN-LAST:event_btnremoverActionPerformed

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
     /*   if(tabelaLivros.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "não há clientes pra salvar", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        
        else if(alterar==false){
            for(int i=0;i<listaLivros.getRowCount();i++){
            Livro liv=new Livro((String) listaLivros.getValueAt(i, 0),
                              (String) listaLivros.getValueAt(i, 1),
                              (String) listaLivros.getValueAt(i, 2),
                              Double.parseDouble((String)listaLivros.getValueAt(i, 3)));
                        arrayLivros.add(liv);
            
            }
            
           
            
        }
        
        else if(alterar==true){
            File file=new File("Livros.txt");
            if(file.exists()){
            file.delete();
            }
            int indiceLivroAlterar = 0;
            
            for(int i=0;i<arrayLivros.size();i++){
                if(arrayLivros.get(i).getNomeLivro()==this.nomeSelecionado){
                    indiceLivroAlterar=i;
                }
            }
            
            this.arrayLivros.get(indiceLivroAlterar).setNomeLivro(txtnomeLivro.getText());
            this.arrayLivros.get(indiceLivroAlterar).setAutor(txtautor.getText());
            this.arrayLivros.get(indiceLivroAlterar).setEditora(txteditora.getText());
            this.arrayLivros.get(indiceLivroAlterar).setPreco(Double.parseDouble(txtprecoLivro.getText()));
            
             try{
                FileWriter arq=new FileWriter("Livros.txt", true);
                PrintWriter dados=new PrintWriter(arq);
                
                for(int i=0;i<this.arrayLivros.size();i++){
                    dados.println(arrayLivros.get(i).getNomeLivro()+
                    ";"+ arrayLivros.get(i).getAutor()+
                    ";"+ arrayLivros.get(i).getEditora()+
                    ";"+ arrayLivros.get(i).getPreco());
                }
                
                arq.close();
                dados.close();
              //  this.nomeSelecionado=null;
                
                JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }
            
             
        }
        
        this.alterar=false;
        this.nomeSelecionado=null;
        limpar();
        lerLivros();
        */
     this.dispose();
        
        
    }//GEN-LAST:event_btnsairActionPerformed

    private void tabelaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivrosMouseClicked
        String aux=String.valueOf(tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0));
        Livro liv=new Livro();
        
        for(int i=0;i<arrayLivros.size();i++){
            if(arrayLivros.get(i).getNomeLivro()==aux){
                liv = (Livro) arrayLivros.get(i);
            }
        }
        
        txtnomeLivro.setText(liv.getNomeLivro());
        txtautor.setText(liv.getAutor());
        txteditora.setText(liv.getEditora());
        txtprecoLivro.setText(String.valueOf(liv.getPreco()));
        
        this.alterar=true;
        this.nomeSelecionado=liv.getNomeLivro();
        
        btnremover.setEnabled(true);
    }//GEN-LAST:event_tabelaLivrosMouseClicked

    private void txtnomeLivroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomeLivroKeyTyped
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_txtnomeLivroKeyTyped

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
         try{
                FileWriter arq=new FileWriter("Livros.txt", false);
                PrintWriter dados=new PrintWriter(arq);
                
                for(int i=0;i<arrayLivros.size();i++){
                    dados.println(arrayLivros.get(i).getNomeLivro()+
                    ";"+ arrayLivros.get(i).getAutor()+
                    ";"+ arrayLivros.get(i).getEditora()+
                    ";"+ arrayLivros.get(i).getPreco());
                }
                
                arq.close();
                dados.close();
                
                JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                
              //  this.dispose();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        File file=new File("Livros.txt");
        if(file.exists()){
            lerLivros();
        }
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnremover;
    private javax.swing.JButton btnsair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextField txtautor;
    private javax.swing.JTextField txteditora;
    private javax.swing.JTextField txtnomeLivro;
    private javax.swing.JTextField txtprecoLivro;
    // End of variables declaration//GEN-END:variables
}

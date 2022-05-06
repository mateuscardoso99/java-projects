/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class intCadClientes extends javax.swing.JInternalFrame {

    private DefaultTableModel listaClientes;
    private ArrayList<Cliente> arrayClientes = new ArrayList<>();
    private MaskFormatter f1, f2, f3;
    private boolean alterar = false;
    private String cpfSelecionado;

    public intCadClientes() {
        try {
            f1 = new MaskFormatter("###.###.###-##");
            f2 = new MaskFormatter("(##) # ####-####");
            f3 = new MaskFormatter("##/##/####");

        } catch (Exception e) {
            e.getMessage();
        }

        initComponents();
        btnremover.setEnabled(false);
        // btnsalvar.setEnabled(false);
        listaClientes = (DefaultTableModel) tabelaClientes.getModel();
    }

    public void posicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void lerClientes() {
        listaClientes.setRowCount(0);
        arrayClientes = new ArrayList<>();
        listaClientes = (DefaultTableModel) tabelaClientes.getModel();

        String p;
        try {
            FileReader fr = new FileReader("Clientes.txt");
            BufferedReader bufalo = new BufferedReader(fr);
            while ((p = bufalo.readLine()) != null) {
                String vetorClientes[] = p.split(";");
                listaClientes.addRow(vetorClientes);

                Cliente c = new Cliente(vetorClientes[0], vetorClientes[1], vetorClientes[2], vetorClientes[3], vetorClientes[4]);

                arrayClientes.add(c);

            }
          //  tabelaClientes.setModel(listaClientes);

            bufalo.close();
            fr.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void limpar() {
        txtnomeCliente.setText("");
        txtemail.setText("");
        txtcpf.setText("");
        txtfone.setText("");
        txtdataAniversario.setText("");

        txtnomeCliente.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnomeCliente = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcpf = new javax.swing.JFormattedTextField(f1);
        txtfone = new javax.swing.JFormattedTextField(f2);
        txtdataAniversario = new javax.swing.JFormattedTextField(f3);
        btnsalvar = new javax.swing.JButton();
        btnremover = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Clientes");
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

        jLabel1.setText("NOME:");

        jLabel2.setText("E-MAIL:");

        jLabel3.setText("CPF:");

        jLabel4.setText("TELEFONE:");

        jLabel5.setText("DATA DE ANIVERSÁRIO:");

        txtnomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomeClienteKeyTyped(evt);
            }
        });

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Floppy-Small-icon.png"))); // NOI18N
        btnsalvar.setText("Salvar");
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

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "E-mail", "CPF", "Telefone", "Aniversário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(txtdataAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtemail)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnomeCliente))))
                        .addGap(11, 11, 11)))
                .addGap(51, 51, 51))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdataAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnremover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        //Cliente c;

        if (txtnomeCliente.getText().isEmpty()/*||!txtcpf.getText().equals("   .   .   -  ")*/) {
            JOptionPane.showMessageDialog(this, "campo nome é obrigatórios", "Atenção!", JOptionPane.WARNING_MESSAGE);
        } else {

            if (alterar == false) {

                String campos[] = {txtnomeCliente.getText(), txtemail.getText(), txtcpf.getText(), txtfone.getText(), txtdataAniversario.getText()};

                listaClientes.addRow(campos);
                tabelaClientes.setModel(listaClientes);

                Cliente c = new Cliente(txtnomeCliente.getText(), txtemail.getText(), txtcpf.getText(), txtfone.getText(), txtdataAniversario.getText());

                arrayClientes.add(c);

                limpar();
                /*c=new Cliente((String)listaClientes.getValueAt(i, 0),
                        (String)listaClientes.getValueAt(i, 1),
                        (String)listaClientes.getValueAt(i, 2),
                        (String)listaClientes.getValueAt(i, 3),
                        (String)listaClientes.getValueAt(i, 4));*/
                //    c=new Cliente(txtnomeCliente.getText(),txtemail.getText(),txtcpf.getText(),txtfone.getText(),txtdataAniversario.getText());
                // for(i=0;i<listaClientes.getRowCount();i++){
                //  arrayClientes.add(c);
                //   }
                /*    btnsalvar.setEnabled(false);
         btnremover.setEnabled(false);
         
            try{
                FileWriter arq=new FileWriter("Clientes.txt", true);
                PrintWriter dados=new PrintWriter(arq);
                
             //   for(i=0;i<arrayClientes.size();i++){
                    dados.println(c.getNomeCliente()+";"
                            +c.getEmail()+";"
                            +c.getCpf()+";"
                            +c.getTelefone()+";"
                            +c.getDataAniversario());
             //   }
                dados.close();
                arq.close();
                
              JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
              
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }            
            
        }
        
        else if(alterar==true){
                File file = new File("Clientes.txt");
                file.delete();
                
                int indicePessoaAlterar = 0;

                for (i = 0; i < arrayClientes.size(); i++) {
                    if (arrayClientes.get(i).getCpf() == this.cpfSelecionado) {
                        indicePessoaAlterar = i;
                    }

                }

                this.arrayClientes.get(indicePessoaAlterar).setNomeCliente(txtnomeCliente.getText());
                this.arrayClientes.get(indicePessoaAlterar).setEmail(txtemail.getText());
                this.arrayClientes.get(indicePessoaAlterar).setCpf(txtcpf.getText());
                this.arrayClientes.get(indicePessoaAlterar).setTelefone(txtfone.getText());
                this.arrayClientes.get(indicePessoaAlterar).setDataAniversario(txtdataAniversario.getText());

                try {
                    FileWriter f = new FileWriter("Clientes.txt", true);
                    PrintWriter p = new PrintWriter(f);

                    for (i = 0; i < this.arrayClientes.size(); i++) {
                        p.println(arrayClientes.get(i).getNomeCliente() + ";"
                                + arrayClientes.get(i).getEmail() + ";"
                                + arrayClientes.get(i).getCpf() + ";"
                                + arrayClientes.get(i).getTelefone() + ";"
                                +arrayClientes.get(i).getDataAniversario());

                    }

                    f.close();
                    p.close();
                    this.cpfSelecionado = null;

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "não foi possível salvar", "erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        
            this.alterar = false;
            this.cpfSelecionado = null;
            limpar();
            lerClientes();
        }*/

                //  Cliente c;
                //    if (txtnomeCliente.getText().isEmpty()/*||!txtcpf.getText().equals("   .   .   -  ")*/) {
                //       JOptionPane.showMessageDialog(this, "campos nome é obrigatório", "Atenção!", JOptionPane.WARNING_MESSAGE);
                //   } 
                //  else {
                //     int i=0;
                /*  if (tabelaClientes.getRowCount() == 0/*||!txtcpf.getText().equals("   .   .   -  ")*/  //) {
                //        JOptionPane.showMessageDialog(this, "não há dados para gravar", "Atenção!", JOptionPane.WARNING_MESSAGE);
                //       this.dispose();
                //   } else {
                /* String campos[]={txtnomeCliente.getText(),txtemail.getText(),txtcpf.getText(),txtfone.getText(),txtdataAniversario.getText()};
    
    listaClientes.addRow(campos);
    tabelaClientes.setModel(listaClientes);*/
 /* if (alterar == false) {
                /*c=new Cliente((String)listaClientes.getValueAt(i, 0),
                        (String)listaClientes.getValueAt(i, 1),
                        (String)listaClientes.getValueAt(i, 2),
                        (String)listaClientes.getValueAt(i, 3),
                        (String)listaClientes.getValueAt(i, 4));*/
                //   c=new Cliente(txtnomeCliente.getText(),txtemail.getText(),txtcpf.getText(),txtfone.getText(),txtdataAniversario.getText());
                //   String campos[] = {txtnomeCliente.getText(), txtemail.getText(), txtcpf.getText(), txtfone.getText(), txtdataAniversario.getText()};
                //  listaClientes.addRow(campos);
                //  tabelaClientes.setModel(listaClientes);
                // for(i=0;i<listaClientes.getRowCount();i++){
                //  arrayClientes.add(c);
                //   }
                //   btnsalvar.setEnabled(false);
                //   btnremover.setEnabled(false);

                /*try {
                    FileWriter arq = new FileWriter("Clientes.txt", true);
                    PrintWriter dados = new PrintWriter(arq);

                    for (i = 0; i < arrayClientes.size(); i++) {
                        dados.println(arrayClientes.get(i).getNomeCliente() + ";"
                                + arrayClientes.get(i).getEmail() + ";"
                                + arrayClientes.get(i).getCpf() + ";"
                                + arrayClientes.get(i).getTelefone() + ";"
                                + arrayClientes.get(i).getDataAniversario());
                    }
                    dados.close();
                    arq.close();

                    JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
                }

                 */
            } else if (alterar == true) {
                /*         File file = new File("Clientes.txt");
                file.delete();*/
                //listaClientes.removeRow(tabelaClientes.getSelectedRow());
            //    tabelaClientes.setModel(listaClientes);

                int indicePessoaAlterar = 0;

                for (int i = 0; i < arrayClientes.size(); i++) {
                    if (arrayClientes.get(i).getCpf() == this.cpfSelecionado) {
                        indicePessoaAlterar = i;

                    }
                    //   this.arrayClientes.remove(indicePessoaAlterar);
                }

                this.arrayClientes.get(indicePessoaAlterar).setNomeCliente(txtnomeCliente.getText());
                this.arrayClientes.get(indicePessoaAlterar).setEmail(txtemail.getText());
                this.arrayClientes.get(indicePessoaAlterar).setCpf(txtcpf.getText());
                this.arrayClientes.get(indicePessoaAlterar).setTelefone(txtfone.getText());
                this.arrayClientes.get(indicePessoaAlterar).setDataAniversario(txtdataAniversario.getText());

                this.listaClientes.setValueAt(txtnomeCliente.getText(), tabelaClientes.getSelectedRow(), 0);
                this.listaClientes.setValueAt(txtemail.getText(), tabelaClientes.getSelectedRow(), 1);
                this.listaClientes.setValueAt(txtcpf.getText(), tabelaClientes.getSelectedRow(), 2);
                this.listaClientes.setValueAt(txtfone.getText(), tabelaClientes.getSelectedRow(), 3);
                this.listaClientes.setValueAt(txtdataAniversario.getText(), tabelaClientes.getSelectedRow(), 4);

            }

            this.alterar = false;
            this.cpfSelecionado = null;
            limpar();
            //  lerClientes();
        }

        //    limpar();
        //  }

    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btnremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverActionPerformed
        /* if(tabelaClientes.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "selecione uma linha pra poder apagar", "Atenção!", JOptionPane.WARNING_MESSAGE);          
        }
        else{
            
            int indiceCliente=0;
       //     int linha=tabelaClientes.getSelectedRow();
            
            for(int i=0;i<arrayClientes.size();i++){
               if(arrayClientes.get(i).getCpf().equals(txtcpf.getText())){
                   indiceCliente=i;
            }
            }    
            
            this.arrayClientes.remove(indiceCliente);
            //listaClientes.removeRow(tabelaClientes.getSelectedRow());
            
            try{
                File file = new File("Clientes.txt");
                file.delete();
                
                FileWriter arq=new FileWriter("Clientes.txt",true);
                PrintWriter dados=new PrintWriter(arq);
                
                for(int i=0;i<this.arrayClientes.size();i++){
                    dados.println(arrayClientes.get(i).getNomeCliente()+";"
                    +arrayClientes.get(i).getEmail()+";"
                    +arrayClientes.get(i).getCpf()+";"
                    +arrayClientes.get(i).getTelefone()+";"
                    +arrayClientes.get(i).getDataAniversario());
                }
                
                dados.close();
                arq.close();
                
            }catch(Exception e){
               JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }
         
        limpar();
        lerClientes();
       }*/
        if (tabelaClientes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "selecione uma linha pra poder apagar", "Atenção!", JOptionPane.WARNING_MESSAGE);
        } else {           

            for (int i = 0; i<arrayClientes.size(); i++) {
                if (arrayClientes.get(i).getCpf().equals(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 2))) {
                    arrayClientes.remove(i);
                }
            }
            
            listaClientes.removeRow(tabelaClientes.getSelectedRow());
          //  tabelaClientes.setModel(listaClientes);
            this.alterar=false;
            limpar();

        }


    }//GEN-LAST:event_btnremoverActionPerformed

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
        /*int i=0;
        Cliente c;
        
        if(tabelaClientes.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "não há clientes pra salvar", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtnomeCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "nome obrigatório", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            
        if(alterar==false){
            c=new Cliente((String)listaClientes.getValueAt(i, 0),
                        (String)listaClientes.getValueAt(i, 1),
                        (String)listaClientes.getValueAt(i, 2),
                        (String)listaClientes.getValueAt(i, 3),
                        (String)listaClientes.getValueAt(i, 4));
           // for(i=0;i<listaClientes.getRowCount();i++){
                
              //  arrayClientes.add(c);
         //   }
         btnsalvar.setEnabled(false);
         btnremover.setEnabled(false);
         
            try{
                FileWriter arq=new FileWriter("Clientes.txt", true);
                PrintWriter dados=new PrintWriter(arq);
                
             //   for(i=0;i<arrayClientes.size();i++){
                    dados.println(c.getNomeCliente()+";"
                            +c.getEmail()+";"
                            +c.getCpf()+";"
                            +c.getTelefone()+";"
                            +c.getDataAniversario());
             //   }
                dados.close();
                arq.close();
                
              JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                
              this.dispose();
              
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
            }            
            
        }
        
        else if(alterar==true){
                File file = new File("Clientes.txt");
                file.delete();
                
                int indicePessoaAlterar = 0;

                for (i = 0; i < arrayClientes.size(); i++) {
                    if (arrayClientes.get(i).getCpf() == this.cpfSelecionado) {
                        indicePessoaAlterar = i;
                    }

                }

                this.arrayClientes.get(indicePessoaAlterar).setNomeCliente(txtnomeCliente.getText());
                this.arrayClientes.get(indicePessoaAlterar).setEmail(txtemail.getText());
                this.arrayClientes.get(indicePessoaAlterar).setCpf(txtcpf.getText());
                this.arrayClientes.get(indicePessoaAlterar).setTelefone(txtfone.getText());
                this.arrayClientes.get(indicePessoaAlterar).setDataAniversario(txtdataAniversario.getText());

                try {
                    FileWriter f = new FileWriter("Clientes.txt", true);
                    PrintWriter p = new PrintWriter(f);

                    for (i = 0; i < this.arrayClientes.size(); i++) {
                        p.println(arrayClientes.get(i).getNomeCliente() + ";"
                                + arrayClientes.get(i).getEmail() + ";"
                                + arrayClientes.get(i).getCpf() + ";"
                                + arrayClientes.get(i).getTelefone() + ";"
                                +arrayClientes.get(i).getDataAniversario());

                    }

                    f.close();
                    p.close();
                    this.cpfSelecionado = null;

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "não foi possível salvar", "erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        
            this.alterar = false;
            this.cpfSelecionado = null;
            limpar();
            lerClientes();
        }*/

 /*   Cliente c;

  //     if (tabelaClientes.getRowCount() == 0/*||!txtcpf.getText().equals("   .   .   -  ")*///) {
        //   JOptionPane.showMessageDialog(this, "não há dados para gravar", "Atenção!", JOptionPane.WARNING_MESSAGE);
        //      this.dispose();
        // } else {
        /* String campos[]={txtnomeCliente.getText(),txtemail.getText(),txtcpf.getText(),txtfone.getText(),txtdataAniversario.getText()};
    
    listaClientes.addRow(campos);
    tabelaClientes.setModel(listaClientes);*/
 /*        if (alterar == false) {
                /*c=new Cliente((String)listaClientes.getValueAt(i, 0),
                        (String)listaClientes.getValueAt(i, 1),
                        (String)listaClientes.getValueAt(i, 2),
                        (String)listaClientes.getValueAt(i, 3),
                        (String)listaClientes.getValueAt(i, 4));*/
        //   c=new Cliente(txtnomeCliente.getText(),txtemail.getText(),txtcpf.getText(),txtfone.getText(),txtdataAniversario.getText());
        //        c = new Cliente((String) listaClientes.getValueAt(i, 0), (String) listaClientes.getValueAt(i, 1),
        //               (String) listaClientes.getValueAt(i, 2), (String) listaClientes.getValueAt(i, 3), (String) listaClientes.getValueAt(i, 4));
        //       arrayClientes.add(c);
        // for(i=0;i<listaClientes.getRowCount();i++){
        //  arrayClientes.add(c);
        //   }
        /*          btnsalvar.setEnabled(false);
                btnremover.setEnabled(false);

                try {
                    FileWriter arq = new FileWriter("Clientes.txt", true);
                    PrintWriter dados = new PrintWriter(arq);

                    for (i = 0; i < arrayClientes.size(); i++) {
                        dados.println(arrayClientes.get(i).getNomeCliente() + ";"
                                + arrayClientes.get(i).getEmail() + ";"
                                + arrayClientes.get(i).getCpf() + ";"
                                + arrayClientes.get(i).getTelefone() + ";"
                                + arrayClientes.get(i).getDataAniversario());
                    }
                    dados.close();
                    arq.close();

                    JOptionPane.showMessageDialog(this, "salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "erro ao gravar", "erro", JOptionPane.ERROR_MESSAGE);
                }

            } else if (alterar == true) {
                File file = new File("Clientes.txt");
                file.delete();

                int indicePessoaAlterar = 0;

                for (i = 0; i < arrayClientes.size(); i++) {
                    if (arrayClientes.get(i).getCpf() == this.cpfSelecionado) {
                        indicePessoaAlterar = i;
                    }

                }

                this.arrayClientes.get(indicePessoaAlterar).setNomeCliente(txtnomeCliente.getText());
                this.arrayClientes.get(indicePessoaAlterar).setEmail(txtemail.getText());
                this.arrayClientes.get(indicePessoaAlterar).setCpf(txtcpf.getText());
                this.arrayClientes.get(indicePessoaAlterar).setTelefone(txtfone.getText());
                this.arrayClientes.get(indicePessoaAlterar).setDataAniversario(txtdataAniversario.getText());

            }

            this.alterar = false;
            this.cpfSelecionado = null;
            limpar();
            lerClientes();
        }
         */
        this.dispose();


    }//GEN-LAST:event_btnsairActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        String aux = String.valueOf(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 2));
        Cliente c = new Cliente();

        for (int i = 0; i < arrayClientes.size(); i++) {
            if (arrayClientes.get(i).getCpf() == aux) {
                c = (Cliente) arrayClientes.get(i);
            }
        }

        txtnomeCliente.setText(c.getNomeCliente());
        txtemail.setText(c.getEmail());
        txtcpf.setText(c.getCpf());
        txtfone.setText(c.getTelefone());
        txtdataAniversario.setText(c.getDataAniversario());

        btnremover.setEnabled(true);
        this.alterar = true;
        this.cpfSelecionado = c.getCpf();


    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void txtnomeClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomeClienteKeyTyped
        btnsalvar.setEnabled(true);
    }//GEN-LAST:event_txtnomeClienteKeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        File file = new File("Clientes.txt");
        if (file.exists()) {
            lerClientes();
        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        try {
            FileWriter f = new FileWriter("Clientes.txt", false);
            PrintWriter p = new PrintWriter(f);

            for (int i = 0; i < this.arrayClientes.size(); i++) {
                p.println(arrayClientes.get(i).getNomeCliente() + ";"
                        + arrayClientes.get(i).getEmail() + ";"
                        + arrayClientes.get(i).getCpf() + ";"
                        + arrayClientes.get(i).getTelefone() + ";"
                        + arrayClientes.get(i).getDataAniversario());

            }

            f.close();
            p.close();
            this.cpfSelecionado = null;

            JOptionPane.showMessageDialog(this, "gravado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "não foi possível salvar", "erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnremover;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    public javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JFormattedTextField txtdataAniversario;
    private javax.swing.JTextField txtemail;
    private javax.swing.JFormattedTextField txtfone;
    private javax.swing.JTextField txtnomeCliente;
    // End of variables declaration//GEN-END:variables
}

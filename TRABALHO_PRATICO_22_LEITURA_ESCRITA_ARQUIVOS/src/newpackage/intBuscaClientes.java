
package newpackage;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class intBuscaClientes extends javax.swing.JInternalFrame {

    private MaskFormatter f1;
   // private Cliente cliente; //fazendo a composição aqui deu null pointer quando lê os dados na tabela
    private DefaultTableModel listaAux;
    
    public intBuscaClientes() {
          try{
            f1=new MaskFormatter("###.###.###-##");
            
        }catch(Exception e){
            e.getMessage();
        }
        
        initComponents();
        
        listaAux=(DefaultTableModel) tabelaBusca.getModel();
    }

     public void posicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) /2, (d.height - this.getSize().height) /2);
    }
        
        public void lerClientes(){
      /*  listaClientes.setRowCount(0);
        arrayClientes=new ArrayList<>();
        listaClientes=(DefaultTableModel) tabelaClientes.getModel();*/
        
        String p;
        try{
            FileReader fr=new FileReader("Clientes.txt");
            BufferedReader bufalo=new BufferedReader(fr);
            while((p=bufalo.readLine())!=null){
                String[] vetorClientes=p.split(";");
                listaAux.addRow(vetorClientes);
            }
            
            bufalo.close();
            fr.close();
            
        }catch(Exception e){
            e.getMessage();
        }
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtbuscaCpf = new javax.swing.JFormattedTextField(f1);
        btnbuscar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaBusca = new javax.swing.JTable();

        setClosable(true);
        setTitle("Identificação do Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Insira o CPF do Cliente:");

        btnbuscar.setText("Buscar Cliente");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        tabelaBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "E-mail", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaBusca);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtbuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addComponent(btncancelar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
    lerClientes();
        String procura=txtbuscaCpf.getText();
        ArrayList <Cliente> aux=new ArrayList<>();
        
         for (int i = 0; i < listaAux.getRowCount(); i++) {
                String nome = (String) listaAux.getValueAt(i, 2);

                if (nome.toLowerCase().contains(procura.toLowerCase())){
                Cliente neymar=new Cliente();// criando o objeto aqui funcionou corretamente
                neymar.setNomeCliente((String) listaAux.getValueAt(i, 0));
                neymar.setEmail((String) listaAux.getValueAt(i, 1));
                neymar.setCpf((String) listaAux.getValueAt(i, 2));

                aux.add(neymar);
                }
            }
         DefaultTableModel listaAux = (DefaultTableModel) tabelaBusca.getModel();
         listaAux.setRowCount(0);
         String campos[] = new String[3];

            for (int i = 0; i < aux.size(); i++) {
                campos[0] = String.valueOf(aux.get(i).getNomeCliente());
                campos[1] = aux.get(i).getEmail();
                campos[2] = aux.get(i).getCpf();
                listaAux.addRow(campos);
            }
    
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        intRegistroVenda iv=new intRegistroVenda();
        getParent().add(iv);
        iv.setVisible(true);
        iv.posicao();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tabelaBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaBuscaMouseClicked
        intRegistroVenda iv=new intRegistroVenda();
        getParent().add(iv);
        iv.txtnomeRegistroVenda.setText((String) tabelaBusca.getValueAt(0,0));
        iv.txtCpfRegistroVenda.setText((String) tabelaBusca.getValueAt(0, 2));
        iv.txtnomeRegistroVenda.setEditable(false);
        iv.txtCpfRegistroVenda.setEditable(false);
        iv.setVisible(true);
        iv.posicao();
    }//GEN-LAST:event_tabelaBuscaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaBusca;
    private javax.swing.JFormattedTextField txtbuscaCpf;
    // End of variables declaration//GEN-END:variables
}

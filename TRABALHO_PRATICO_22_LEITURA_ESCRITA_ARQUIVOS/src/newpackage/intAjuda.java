package newpackage;

import java.awt.Dimension;


public class intAjuda extends javax.swing.JInternalFrame {

    public intAjuda() {
        initComponents();
    }

    public void posicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setClosable(true);
        setTitle("Ajuda");

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(51, 102, 255));
        jTextPane1.setText("\t                      Como usar o Sistema?\n\n          Na tela cadastro de clientes, você pode cadastrar clientes, remover, e ao clicar em sair um  arquivo texto será gerado com os dados dos seus clientes.\n          Na tela cadastro de livros, você pode cadastrar livros, remover, e ao clicar em sair um arquivo texto será gerado com os dados dos livros.\n          Na tela busca você pode procurar os clientes cadastrados pelo CPF, o sistema irá procurar pelo cliente, e ele vai aparecer na tabela junto com seus dados, depois é só clicar no cliente para ir para a tela de registro de vendas, também é possível registrar uma venda clicando no botão cancelar, dessa forma você pode inserir um cliente no momento do registro da venda.");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}

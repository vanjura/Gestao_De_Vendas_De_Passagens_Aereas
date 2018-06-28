/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import passagens_aereas.Passagem;

/**
 *
 * @author lucas
 */
public final class Impressao extends javax.swing.JDialog {

    /**
     * Creates new form Impressao
     * @param parent
     * @param modal
     * @param passagem
     */
    public Impressao(java.awt.Frame parent, boolean modal, Passagem passagem) {
        super(parent, modal);
        initComponents();
        setaValores(passagem);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void setaValores(Passagem passagem){
        this.lbl_Aviao.setText(passagem.getPlataforma().substring(1, 7));
        this.lbl_Destino.setText(passagem.getDestino());
        this.lbl_Dia.setText(passagem.getData().toString());
        this.lbl_Hora.setText(passagem.getHora());
        this.lbl_Nome.setText(passagem.getNome());
        this.lbl_Origem.setText(passagem.getOrigem());
        this.lbl_Portao.setText(passagem.getPlataforma());
        this.lbl_Tipo.setText(passagem.getTipo());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbl_Tipo = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lbl_Dia = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        lbl_Portao = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        lbl_Hora = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        lbl_Origem = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        lbl_Destino = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        lbl_Nome = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        lbl_Aviao = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);
        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.add(jPanel13);

        lbl_Tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Tipo.setText("jLabel2");
        jPanel10.add(lbl_Tipo);
        jPanel10.add(jPanel11);

        jPanel8.add(jPanel10);

        jPanel6.add(jPanel8);

        jPanel5.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jPanel15.add(jPanel16);

        lbl_Dia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Dia.setText("jLabel2");
        jPanel15.add(lbl_Dia);
        jPanel15.add(jPanel17);

        jPanel12.add(jPanel15);

        jPanel7.add(jPanel12);

        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.Y_AXIS));

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Portão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel20.add(jPanel21);

        lbl_Portao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Portao.setText("jLabel2");
        jPanel20.add(lbl_Portao);
        jPanel20.add(jPanel22);

        jPanel18.add(jPanel20);

        jPanel7.add(jPanel18);

        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.Y_AXIS));

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel31.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel31.add(jPanel32);

        lbl_Hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Hora.setText("jLabel2");
        jPanel31.add(lbl_Hora);
        jPanel31.add(jPanel33);

        jPanel29.add(jPanel31);

        jPanel7.add(jPanel29);

        jPanel5.add(jPanel7);

        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.Y_AXIS));

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel26.add(jPanel27);

        lbl_Origem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Origem.setText("jLabel2");
        jPanel26.add(lbl_Origem);
        jPanel26.add(jPanel28);

        jPanel24.add(jPanel26);

        jPanel23.add(jPanel24);

        jPanel34.setLayout(new javax.swing.BoxLayout(jPanel34, javax.swing.BoxLayout.Y_AXIS));

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel36.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel36.add(jPanel37);

        lbl_Destino.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Destino.setText("jLabel2");
        jPanel36.add(lbl_Destino);
        jPanel36.add(jPanel38);

        jPanel34.add(jPanel36);

        jPanel23.add(jPanel34);

        jPanel5.add(jPanel23);

        jPanel39.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.Y_AXIS));

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel42.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel42.add(jPanel43);

        lbl_Nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Nome.setText("jLabel2");
        jPanel42.add(lbl_Nome);
        jPanel42.add(jPanel44);

        jPanel40.add(jPanel42);

        jPanel39.add(jPanel40);

        jPanel45.setLayout(new javax.swing.BoxLayout(jPanel45, javax.swing.BoxLayout.Y_AXIS));

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aviao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel47.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel47.add(jPanel48);

        lbl_Aviao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Aviao.setText("jLabel2");
        jPanel47.add(lbl_Aviao);
        jPanel47.add(jPanel49);

        jPanel45.add(jPanel47);

        jPanel39.add(jPanel45);

        jPanel5.add(jPanel39);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_Aviao;
    private javax.swing.JLabel lbl_Destino;
    private javax.swing.JLabel lbl_Dia;
    private javax.swing.JLabel lbl_Hora;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JLabel lbl_Origem;
    private javax.swing.JLabel lbl_Portao;
    private javax.swing.JLabel lbl_Tipo;
    // End of variables declaration//GEN-END:variables
}

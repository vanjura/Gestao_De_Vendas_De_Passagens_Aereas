/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas_nuze0yo
 */
public final class CadastroVoo extends java.awt.Dialog {

    private int rota_selecionada;
    private Time duracao_selecionada;
    private Date data_selecionada;

    public Time getDuracao_selecionada() {
        return duracao_selecionada;
    }

    public void setDuracao_selecionada(Time duracao_selecionada) {
        this.duracao_selecionada = duracao_selecionada;
    }

    public Date getData_selecionada() {
        return data_selecionada;
    }

    public void setData_selecionada(Date data_selecionada) {
        this.data_selecionada = data_selecionada;
    }

    public int getRota_selecionada() {
        return rota_selecionada;
    }

    public void setRota_selecionada(int rota_selecionada) {
        this.rota_selecionada = rota_selecionada;
    }

    /**
     * Creates new form CadastroVoo
     *
     * @param parent
     * @param modal
     */
    public CadastroVoo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

//            this.setData_selecionada(format.format(this.jDateChooser1.getDate()));
    private void setVariaveisRota() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (this.jDateChooser1.getDate() != null) {
            System.out.println(format.format(this.jDateChooser1.getDate()));
            TelaSelecRota telaSelecRota = new TelaSelecRota(null, true);
            this.setData_selecionada(this.jDateChooser1.getDate());
            if (telaSelecRota.getRota_int() != 0) {
                int i = telaSelecRota.getRota_int();
                String x = telaSelecRota.getRota_Origem();
                String y = telaSelecRota.getRota_Destino();
                telaSelecRota.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma data de saida primeiramente.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel8.setText("Campos com");
        jPanel6.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jPanel6.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel10.setText("são obrigatórios.");
        jPanel6.add(jLabel10);

        add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jPanel4.add(jLabel5);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Data de Saída:");
        jPanel4.add(jLabel4);

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDateChooser1.setMaximumSize(new java.awt.Dimension(100, 20));
        jDateChooser1.setMinimumSize(new java.awt.Dimension(100, 20));
        jDateChooser1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jDateChooser1);

        jPanel2.add(jPanel4);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");
        jPanel3.add(jLabel6);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Rota:");
        jPanel3.add(jLabel1);

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton3.setText("Selecionar Rota");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Escolha uma viagem clicando no botão ao lado");
        jPanel3.add(jLabel2);

        jPanel2.add(jPanel3);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jPanel5.add(jLabel11);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Avião:");
        jPanel5.add(jLabel7);

        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton4.setText("Selecionar Avião");
        jPanel5.add(jButton4);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Escolha um avião clicando no botão ao lado");
        jPanel5.add(jLabel3);

        jPanel2.add(jPanel5);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setText("Salvar");
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
        add(jPanel7, java.awt.BorderLayout.EAST);
        add(jPanel8, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVariaveisRota();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        CadastroVoo cadastroVoo = new CadastroVoo(null, true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}

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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel4.add(jLabel3);

        jLabel4.setText("Data de Saída: ");
        jPanel4.add(jLabel4);

        jDateChooser1.setMaximumSize(new java.awt.Dimension(100, 20));
        jDateChooser1.setMinimumSize(new java.awt.Dimension(100, 20));
        jDateChooser1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jDateChooser1);

        jLabel5.setText("Data Prevista de chegada: ");
        jPanel4.add(jLabel5);

        jLabel6.setText("00/00/000");
        jPanel4.add(jLabel6);

        jPanel2.add(jPanel4);

        jLabel1.setText("Rota:");
        jPanel3.add(jLabel1);

        jButton3.setText("Selecionar Rota");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jLabel2.setText("Escolha uma viagem clicando no botão ao lado");
        jPanel3.add(jLabel2);

        jPanel2.add(jPanel3);
        jPanel2.add(jPanel5);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Salvar");
        jPanel1.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

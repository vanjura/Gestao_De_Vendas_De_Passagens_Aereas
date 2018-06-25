/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.RotaCRUD;
import javax.swing.table.DefaultTableModel;
import passagens_aereas.Rota;

/**
 *
 * @author lucas_nuze0yo
 */
public final class TelaSelecRota extends java.awt.Dialog {

    private int rota_cod = 0;
    private String rota_Origem;
    private String rota_Destino;

    public String getRota_Destino() {
        return rota_Destino;
    }

    public void setRota_Destino(String rota_Destino) {
        this.rota_Destino = rota_Destino;
    }

    public String getRota_Origem() {
        return rota_Origem;
    }

    public void setRota_Origem(String rota_Origem) {
        this.rota_Origem = rota_Origem;
    }

    public int getRota_cod() {
        return rota_cod;
    }

    public void setRota_cod(int rota_cod) {
        this.rota_cod = rota_cod;
    }

    /**
     * Creates new form TabelaViagem
     *
     * @param parent
     * @param modal
     */
    public TelaSelecRota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populaTabela();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public int pegaId() {
        int coluna = 0;
        int linha = jTable1.getSelectedRow();
        return (int) jTable1.getValueAt(linha, coluna);
    }

    public String pegaOrigem() {
        int coluna = 1;
        int linha = jTable1.getSelectedRow();
        return (String) jTable1.getValueAt(linha, coluna);
    }

    public String pegaDestino() {
        int coluna = 2;
        int linha = jTable1.getSelectedRow();
        return (String) jTable1.getValueAt(linha, coluna);
    }

    public void populaTabela() {
        RotaCRUD rotaCRUD = new RotaCRUD();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        for (Rota r : rotaCRUD.buscaTudo()) {
            modelo.addRow(new Object[]{
                r.getId(),
                r.getOrigem(),
                r.getDestino(),
                r.getPreco_c(),
                r.getPreco_e()
            });
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Cancelar");
        jPanel1.add(jButton2);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 275));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origem", "Destino", "Preço", "Preco Ass. Especial "
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel3.add(jScrollPane1);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Clique em um item na tabela e após isso clique em selecionar.");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.setRota_cod(pegaId());
            this.setRota_Origem(pegaOrigem());
            this.setRota_Destino(pegaDestino());
            this.setVisible(false);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        TelaSelecRota telaSelecRota = new TelaSelecRota(null, true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

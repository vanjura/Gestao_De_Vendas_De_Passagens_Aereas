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
 * @author lucas
 */
public class TabelaRota extends DefaultTabelas {

    /**
     * Creates new form TabelaRota
     */
    public TabelaRota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        escreveTabela();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void escreveTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        RotaCRUD rotaCRUD = new RotaCRUD();
        System.out.println("entrou1");
        for (Rota r : rotaCRUD.buscaTudo()) {
            System.out.println("entrou2");
            modelo.addRow(new Object[]{
                r.getId(),
                r.getOrigem(),
                r.getDestino(),
                r.getPreco_c(),
                r.getPreco_e()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origem", "Destino", "Preco Comum", "Preco Especial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        jButton1.setText("Editar");
        jPanel4.add(jButton1);

        jButton2.setText("Sair");
        jPanel4.add(jButton2);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        TabelaRota tabelaRota = new TabelaRota(null, true);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
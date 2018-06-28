/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.VooCRUD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import passagens_aereas.Voo;

/**
 *
 * @author lucas
 */
public class Voo_Tabela extends DefaultTabelas {

    /**
     * Creates new form TabelaVoo
     * @param parent
     * @param modal
     */
    public Voo_Tabela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        escreveTabela();
    }
    
    private int pegaId() {
        int coluna = 0;
        int linha = this.jTbVoo.getSelectedRow();
        return (int) this.jTbVoo.getValueAt(linha, coluna);
    }
    
    private void escreveTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTbVoo.getModel();
        VooCRUD vooCRUD = new VooCRUD();
        for (Voo v : vooCRUD.buscaTudo()) {
            modelo.addRow(new Object[]{
                v.getId(),
                v.getRota(),
                v.getOrigem(),
                v.getDestino(),
                v.getPreco_c(),
                v.getPreco_e(),
                v.getData(),
                v.getHora(),
                v.getAviao(),
                v.getAss_c(),
                v.getAss_e()
            });
        }
    }
    
    protected void exclui() {
        VooCRUD vooCRUD = new VooCRUD();
        String texto = "Deseja realmente excluir esse item?";
        String titulo = "Exclusão";
        this.dispose();
        int op = JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            vooCRUD.exclusao(this.pegaId());
        }
        Voo_Exclusao exclusao = new Voo_Exclusao(null, true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbVoo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 300));

        jTbVoo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Rota", "Origem", "Destino", "Preço Comum", "Preço Especial", "Data", "Hora", "Aviao", "Quantidade de Ass. Comuns ", "Quantidade de Ass. Especiais"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbVoo);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);
        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbVoo;
    // End of variables declaration//GEN-END:variables
}

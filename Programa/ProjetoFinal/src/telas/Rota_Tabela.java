/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.RotaCRUD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import passagens_aereas.Rota;

/**
 *
 * @author lucas
 */
public class Rota_Tabela extends DefaultTabelas {

    /**
     * Creates new form TabelaRota
     *
     * @param parent
     * @param modal
     */
    public Rota_Tabela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        escreveTabela();
    }

    private void escreveTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        RotaCRUD rotaCRUD = new RotaCRUD();
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

    public int pegaId() {
        int coluna = 0;
        int linha = this.jTable1.getSelectedRow();
        return (int) this.jTable1.getValueAt(linha, coluna);
    }
    
    

    public String pegaOrigem() {
        int coluna = 1;
        int linha = this.jTable1.getSelectedRow();
        return (String) this.jTable1.getValueAt(linha, coluna);
    }

    public String pegaDestino() {
        int coluna = 2;
        int linha = this.jTable1.getSelectedRow();
        return (String) this.jTable1.getValueAt(linha, coluna);
    }

    public float pegaPreco_c() {
        int coluna = 3;
        int linha = this.jTable1.getSelectedRow();
        return (float) this.jTable1.getValueAt(linha, coluna);
    }

    public float pegaPreco_e() {
        int coluna = 4;
        int linha = this.jTable1.getSelectedRow();
        return (float) this.jTable1.getValueAt(linha, coluna);
    }

    protected void edita() {
        Rota rota = new Rota();
        rota.setId(this.pegaId());
        rota.setOrigem(this.pegaOrigem());
        rota.setDestino(this.pegaDestino());
        rota.setPreco_c(this.pegaPreco_c());
        rota.setPreco_e(this.pegaPreco_e());
        this.dispose();
        Rota_Cadastro cadastro = new Rota_Cadastro(null, true, rota);
        Rota_Consulta_Atualizacao consulta_Atualizacao = new Rota_Consulta_Atualizacao(null, true);
    }

    protected void exclui() {
        RotaCRUD rotaCRUD = new RotaCRUD();
        String texto = "Deseja realmente excluir esse item?";
        String titulo = "Exclusão";
        this.dispose();
        int op = JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            rotaCRUD.exclusao(pegaId());
        }
        Rota_Exclusao exclusao = new Rota_Exclusao(null, true);
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
        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

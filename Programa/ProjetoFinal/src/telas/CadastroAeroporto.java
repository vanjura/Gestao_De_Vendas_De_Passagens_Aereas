/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.AeroportoCRUD;
import javax.swing.JOptionPane;
import passagens_aereas.Aeroporto;

/**
 *
 * @author lucas_nuze0yo
 */
public class CadastroAeroporto extends java.awt.Dialog {

    /**
     * Creates new form CadastroAeroporto
     *
     * @param parent
     * @param modal
     */
    public CadastroAeroporto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public int perguntaCadastro(Aeroporto aeroporto){

    public boolean validaAeroporto(Aeroporto aeroporto) {
        return true;
    }

    public void perguntaCadastro(Aeroporto aeroporto) {
        int op;
        String titulo = "Cadastro de Aeroporto";
        String texto = "";
        texto = "Informações cadastradas:"
                + "\nNome: " + aeroporto.getNome()
                + "\nCidade: " + aeroporto.getCidade()
                + "\nEstado: " + aeroporto.getEstado()
                + "\nDeseja cadastrar outro?";
        op = JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            cadastraAeroporto(aeroporto);
        } else if (op == JOptionPane.NO_OPTION){
            cadastraAeroporto(aeroporto);
            this.dispose();
        }
    }
        }
        return op;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new javax.swing.JPanel();
        jPanelMid = new javax.swing.JPanel();
        jPanelNome = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelEstado = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0));
        jLabelCidade = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jPanelBottom = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setModal(true);
        setName("Cadastro de Aeroporto"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        add(jPanelTop, java.awt.BorderLayout.NORTH);

        jPanelMid.setLayout(new javax.swing.BoxLayout(jPanelMid, javax.swing.BoxLayout.PAGE_AXIS));

        jPanelNome.setLayout(new java.awt.GridBagLayout());
        jPanelNome.add(jPanel3, new java.awt.GridBagConstraints());

        jLabelNome.setText("Nome: ");
        jPanelNome.add(jLabelNome, new java.awt.GridBagConstraints());

        jTextFieldNome.setMaximumSize(new java.awt.Dimension(300, 20));
        jTextFieldNome.setMinimumSize(new java.awt.Dimension(300, 20));
        jTextFieldNome.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanelNome.add(jTextFieldNome, new java.awt.GridBagConstraints());
        jPanelNome.add(jPanel2, new java.awt.GridBagConstraints());

        jPanelMid.add(jPanelNome);

        jLabelEstado.setText("Estado: ");
        jPanel1.add(jLabelEstado);

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel1.add(jComboBoxEstado);
        jPanel1.add(filler1);

        jLabelCidade.setText("Cidade: ");
        jPanel1.add(jLabelCidade);

        jTextFieldCidade.setMaximumSize(new java.awt.Dimension(150, 20));
        jTextFieldCidade.setMinimumSize(new java.awt.Dimension(150, 20));
        jTextFieldCidade.setName(""); // NOI18N
        jTextFieldCidade.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel1.add(jTextFieldCidade);

        jPanelMid.add(jPanel1);

        add(jPanelMid, java.awt.BorderLayout.CENTER);

        jButtonOK.setText("OK");
        jButtonOK.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonOK.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonOK.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanelBottom.add(jButtonOK);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBottom.add(jButtonCancelar);

        add(jPanelBottom, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroAeroporto dialog = new CadastroAeroporto(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelMid;
    private javax.swing.JPanel jPanelNome;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}

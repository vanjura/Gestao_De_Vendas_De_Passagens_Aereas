/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.AviaoCRUD;
import javax.swing.JOptionPane;
import passagens_aereas.Aviao;

/**
 *
 * @author lucas_nuze0yo
 */
public class Aviao_Cadastro extends DefaultCadastro {

    String registroOld = "";
    boolean atualizacao = false;

    /**
     * Creates new form CadastroAviao
     *
     * @param parent
     * @param modal
     */
    public Aviao_Cadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        iniciaTela();
    }

    public Aviao_Cadastro(java.awt.Frame parent, boolean modal, Aviao aviao) {
        super(parent, modal);
        iniciaTela(aviao);
    }

    private void iniciaTela() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setaCampos(Aviao aviao) {
        this.jFtfRegistro.setText(aviao.getRegistro());
        this.jTfModelo.setText(aviao.getModelo());
        this.jFtfAssC.setValue(aviao.getQtd_assentos());
        this.jFtfAssE.setValue(aviao.getQtd_assentos_esp());
    }

    private void iniciaTela(Aviao aviao) {
        registroOld = aviao.getRegistro();
        atualizacao = true;
        initComponents();
        setaCampos(aviao);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public boolean validacaoAviao(Aviao aviao) {
        if (this.jFtfRegistro.getText().equals("   -  ")
                || this.jTfModelo.getText().isEmpty()
                || this.jFtfAssC.getText().isEmpty()
                || this.jFtfAssE.getText().isEmpty()) {
            System.out.println("Campo em branco");
            return false;
        }
        try {
            if (Integer.valueOf(this.jFtfAssC.getText()) < 0) {
                System.out.println("Valor de assentos menor que 1");
                return false;
            }
            if (Integer.valueOf(this.jFtfAssE.getText()) < 0) {
                System.out.println("Valor de assentos especiais menor que 1");
                return false;
            }
        } catch (NumberFormatException ex) {
            System.out.println("numero inválido de assentos ou assentos especiais");
            return false;
        }
        return true;
    }

    public void iniciaGravacao() {
        Aviao aviao = criaAviao();
        AviaoCRUD aviaocrud = new AviaoCRUD();
        if (!validacaoAviao(aviao)) {
            return;
        }
        if (aviao != null) {
            if (aviaocrud.procuraRegistro(aviao.getRegistro()) && !registroOld.equals(aviao.getRegistro())) {
                JOptionPane.showMessageDialog(null, "Já existe um avião cadastrado com esse registro."
                        + "\nFavor informar um registro diferente.");
            } else {
                if (atualizacao) {
                    mostraDadosAt(aviao);
                    salvaAviao(aviao);
                } else {
                    if (mostraDados(aviao)) {
                        salvaAviao(aviao);
                    }
                }
            }
        }
    }
    
    public void mostraDadosAt(Aviao aviao) {
        JOptionPane.showMessageDialog(null, "Dados Gravados: "
                + "\n" + this.jLblRegistro.getText() + " " + aviao.getRegistro()
                + "\nModelo: " + aviao.getModelo()
                + "\nQuantidade ass. comum: " + aviao.getQtd_assentos()
                + "\nQuantidade ass. espec.: " + aviao.getQtd_assentos_esp());
        this.dispose();
    }

    public boolean mostraDados(Aviao aviao) {
        int op = JOptionPane.showConfirmDialog(null, "Dados Gravados: "
                + "\n" + this.jLblRegistro.getText() + " " + aviao.getRegistro()
                + "\nModelo: " + aviao.getModelo()
                + "\nQuantidade ass. comum: " + aviao.getQtd_assentos()
                + "\nQuantidade ass. espec.: " + aviao.getQtd_assentos_esp()
                + "\n"
                + "\nDeseja cadastrar outro?"
                + "\nClique em cancelar para editar os dados acima.");
        if (op == JOptionPane.OK_OPTION) {
            this.jTfModelo.setText(null);
            this.jFtfAssE.setText(null);
            this.jFtfAssC.setText(null);
            this.jFtfRegistro.setText(null);
            return true;
        } else if (op == JOptionPane.NO_OPTION) {
            this.dispose();
            return true;
        }
        return false;
    }

    public void salvaAviao(Aviao aviao) {
        AviaoCRUD aviaoCRUD = new AviaoCRUD();
        if (atualizacao) {
            aviaoCRUD.atualizar(aviao, registroOld);
        } else {
            aviaoCRUD.inserir(aviao);
        }
    }

    public Aviao criaAviao() {
        try {
            String registro = this.jFtfRegistro.getText();
            String modelo = this.jTfModelo.getText();
            int qtd_ass_esp = Integer.parseInt(this.jFtfAssE.getText());
            int qtd_ass = Integer.parseInt(this.jFtfAssC.getText());
            Aviao aviao = new Aviao(registro, modelo, qtd_ass, qtd_ass_esp);
            return aviao;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Os campos '"
                    + this.jLblAssentosEspeciais.getText()
                    + "' e '"
                    + this.jLblQtdAss.getText()
                    + "' \nsão de preenchimento obrigatório.");
            return null;
        }
    }

    public static void main(String[] args) {
        Aviao_Cadastro cadastroAviao = new Aviao_Cadastro(null, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMed = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLblRegistro1 = new javax.swing.JLabel();
        jLblRegistro = new javax.swing.JLabel();
        jFtfRegistro = new javax.swing.JFormattedTextField();
        jLblRegistro2 = new javax.swing.JLabel();
        jLblModelo = new javax.swing.JLabel();
        jTfModelo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLblRegistro3 = new javax.swing.JLabel();
        jLblQtdAss = new javax.swing.JLabel();
        jFtfAssC = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLblRegistro4 = new javax.swing.JLabel();
        jLblAssentosEspeciais = new javax.swing.JLabel();
        jFtfAssE = new javax.swing.JFormattedTextField();
        jPanelBaixo = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanelMed.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMed.setLayout(new javax.swing.BoxLayout(jPanelMed, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro1.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro1.setText("*");
        jPanel2.add(jLblRegistro1);

        jLblRegistro.setText("Registro:");
        jPanel2.add(jLblRegistro);

        try {
            jFtfRegistro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-UU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFtfRegistro.setMaximumSize(new java.awt.Dimension(50, 20));
        jFtfRegistro.setMinimumSize(new java.awt.Dimension(50, 20));
        jFtfRegistro.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel2.add(jFtfRegistro);

        jLblRegistro2.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro2.setText("*");
        jPanel2.add(jLblRegistro2);

        jLblModelo.setText("Modelo:");
        jPanel2.add(jLblModelo);

        jTfModelo.setMaximumSize(new java.awt.Dimension(150, 20));
        jTfModelo.setMinimumSize(new java.awt.Dimension(150, 20));
        jTfModelo.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel2.add(jTfModelo);

        jPanelMed.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro3.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro3.setText("*");
        jPanel3.add(jLblRegistro3);

        jLblQtdAss.setText("Quantidade de Assentos Comuns:");
        jPanel3.add(jLblQtdAss);

        jFtfAssC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFtfAssC.setMaximumSize(new java.awt.Dimension(50, 20));
        jFtfAssC.setMinimumSize(new java.awt.Dimension(50, 20));
        jFtfAssC.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel3.add(jFtfAssC);

        jPanelMed.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro4.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro4.setText("*");
        jPanel4.add(jLblRegistro4);

        jLblAssentosEspeciais.setText("Quantidade de Assentos Especiais:");
        jPanel4.add(jLblAssentosEspeciais);

        jFtfAssE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFtfAssE.setMaximumSize(new java.awt.Dimension(50, 20));
        jFtfAssE.setMinimumSize(new java.awt.Dimension(50, 20));
        jFtfAssE.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel4.add(jFtfAssE);

        jPanelMed.add(jPanel4);

        getContentPane().add(jPanelMed, java.awt.BorderLayout.CENTER);

        jButtonOK.setText("Salvar");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanelBaixo.add(jButtonOK);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBaixo.add(jButtonCancelar);

        getContentPane().add(jPanelBaixo, java.awt.BorderLayout.SOUTH);
        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_END);
        getContentPane().add(jPanel6, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        iniciaGravacao();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JFormattedTextField jFtfAssC;
    private javax.swing.JFormattedTextField jFtfAssE;
    private javax.swing.JFormattedTextField jFtfRegistro;
    private javax.swing.JLabel jLblAssentosEspeciais;
    private javax.swing.JLabel jLblModelo;
    private javax.swing.JLabel jLblQtdAss;
    private javax.swing.JLabel jLblRegistro;
    private javax.swing.JLabel jLblRegistro1;
    private javax.swing.JLabel jLblRegistro2;
    private javax.swing.JLabel jLblRegistro3;
    private javax.swing.JLabel jLblRegistro4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelBaixo;
    private javax.swing.JPanel jPanelMed;
    private javax.swing.JTextField jTfModelo;
    // End of variables declaration//GEN-END:variables
}

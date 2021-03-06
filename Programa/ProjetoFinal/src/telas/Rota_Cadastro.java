/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.AeroportoCRUD;
import connection.RotaCRUD;
import javax.swing.JOptionPane;
import passagens_aereas.Aeroporto;
import passagens_aereas.Rota;

/**
 *
 * @author lucas_nuze0yo
 */
public final class Rota_Cadastro extends DefaultCadastro {

    int codOld = 0;
    boolean atualizacao = false;
    float valorPassagem = 0;

    /**
     * Creates new form CadastroRota
     *
     * @param parent
     * @param modal
     */
    public Rota_Cadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pesquisaAeroporto();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Rota_Cadastro(java.awt.Frame parent, boolean modal, Rota rota) {
        super(parent, modal);
        initComponents();
        pesquisaAeroporto();
        codOld = rota.getId();
        atualizacao = true;
        setaCampos(rota);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private float pegaPorcentagem(Rota rota) {
        float valor1 = rota.getPreco_c();
        float valor2 = rota.getPreco_e();
        float result1;
        float result2;
        result1 = valor1 - valor2;
        result2 = result1 / valor1;
        return result2 * 100;
    }

    private void setaCampos(Rota rota) {
        this.caixaOrigem.setSelectedItem(rota.getOrigem());
        this.caixaDestino.setSelectedItem(rota.getDestino());
        this.ftextoPrecoPass.setText(Float.toString(rota.getPreco_c()));
        this.ftextoDesconto.setText(Float.toString(pegaPorcentagem(rota)));
    }

    public void pesquisaAeroporto() {
        AeroportoCRUD aeroCRUD = new AeroportoCRUD();
        for (Aeroporto a : aeroCRUD.buscaNome()) {
            this.caixaOrigem.addItem(a.getNome());
            this.caixaDestino.addItem(a.getNome());
        }
    }

    public Rota validaCampos() {
        Rota rota = criaRota();
        if (rota.getPreco_c() <= 0 || rota.getPreco_e() < 0) {
            System.out.println("Os campos Preço e Desconto não podem ser menores ou iguais a zero.");
            return null;
        }
        return rota;
    }

    public int retornaIdAeroporto(String nomeAero) {
        AeroportoCRUD aeroportoCRUD = new AeroportoCRUD();
        return aeroportoCRUD.buscaRegistroComNome(nomeAero);
    }

    public Rota criaRota() {
        Rota rota = new Rota();
        rota.setOrigem(this.caixaOrigem.getSelectedItem().toString());
        rota.setDestino(this.caixaDestino.getSelectedItem().toString());
        rota.setPreco_c(Float.parseFloat(this.ftextoPrecoPass.getText().replace(",", ".")));
        rota.setPreco_e(this.valorPassagem);
        return rota;
    }

    private boolean perguntaAt() {
        String titulo = "Atualização";
        String texto = "Dados atualizados:"
                + "\n"
                + "\nOrigem: " + this.caixaOrigem.getSelectedItem().toString()
                + "\nDestino: " + this.caixaDestino.getSelectedItem().toString()
                + "\nPreço Ass. Comum:" + this.ftextoPrecoPass.getText()
                + "\nPreço Ass. Especial:" + this.valorPassagem
                + "\n"
                + "\nVocê confirma a atualização?";
        int op = JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            this.dispose();
            return true;
        } else {
            return false;
        }
    }

    private boolean pergunta() {
        String titulo = "Cadastro";
        String texto = "Dados cadastrados:"
                + "\n"
                + "\nOrigem: " + this.caixaOrigem.getSelectedItem().toString()
                + "\nDestino: " + this.caixaDestino.getSelectedItem().toString()
                + "\nPreço Ass. Comum:" + this.ftextoPrecoPass.getText()
                + "\nPreço Ass. Especial:" + this.valorPassagem
                + "\n"
                + "\nDeseja cadastrar outro?"
                + "\nClique em cancelar para editar os dados acima.";
        int op = JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        switch (op) {
            case JOptionPane.YES_OPTION:
                return true;
            case JOptionPane.NO_OPTION:
                this.dispose();
                return true;
            default:
                return false;
        }
    }

    public void insereRota(Rota rota) {
        RotaCRUD rotaCRUD = new RotaCRUD();
        if (atualizacao) {
            if (perguntaAt()) {
                rotaCRUD.atualizar(rota, codOld);
            }
        } else {
            if (pergunta()) {
                rotaCRUD.inserir(rota);
            }
        }
    }

    private void calcula() {
        String texto01 = this.ftextoPrecoPass.getText().replace(",", ".");
        String texto02 = this.ftextoDesconto.getText().replace(",", ".");
        float num1, num2, result;
        try {
            num1 = Float.parseFloat(texto01);
            num2 = Float.parseFloat(texto02);
        } catch (NumberFormatException ex) {
            num1 = 0;
            num2 = 0;
        }
        if (num1 != 0 || num2 != 0) {
            result = num1 - (num2 * (num1 / 100));
            this.valorPassagem = result;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLblRegistro1 = new javax.swing.JLabel();
        textoOrigem = new javax.swing.JLabel();
        caixaOrigem = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLblRegistro2 = new javax.swing.JLabel();
        textoDestino = new javax.swing.JLabel();
        caixaDestino = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLblRegistro3 = new javax.swing.JLabel();
        textoPrecoPass = new javax.swing.JLabel();
        ftextoPrecoPass = new javax.swing.JFormattedTextField();
        jLblRegistro4 = new javax.swing.JLabel();
        textoDesconto = new javax.swing.JLabel();
        ftextoDesconto = new javax.swing.JFormattedTextField();
        textoPorcent = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setAutoRequestFocus(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro1.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro1.setText("*");
        jPanel4.add(jLblRegistro1);

        textoOrigem.setText("Origem");
        jPanel4.add(textoOrigem);

        caixaOrigem.setMaximumSize(new java.awt.Dimension(200, 20));
        caixaOrigem.setMinimumSize(new java.awt.Dimension(200, 20));
        caixaOrigem.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel4.add(caixaOrigem);

        jPanel2.add(jPanel4);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro2.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro2.setText("*");
        jPanel3.add(jLblRegistro2);

        textoDestino.setText("Destino");
        jPanel3.add(textoDestino);

        caixaDestino.setMaximumSize(new java.awt.Dimension(200, 20));
        caixaDestino.setMinimumSize(new java.awt.Dimension(200, 20));
        caixaDestino.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel3.add(caixaDestino);

        jPanel2.add(jPanel3);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro3.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro3.setText("*");
        jPanel8.add(jLblRegistro3);

        textoPrecoPass.setText("Preço Passagem:");
        jPanel8.add(textoPrecoPass);

        ftextoPrecoPass.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftextoPrecoPass.setText("00,00");
        ftextoPrecoPass.setMaximumSize(new java.awt.Dimension(100, 20));
        ftextoPrecoPass.setMinimumSize(new java.awt.Dimension(100, 20));
        ftextoPrecoPass.setNextFocusableComponent(ftextoDesconto);
        ftextoPrecoPass.setPreferredSize(new java.awt.Dimension(100, 20));
        ftextoPrecoPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftextoPrecoPassFocusGained(evt);
            }
        });
        jPanel8.add(ftextoPrecoPass);

        jLblRegistro4.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro4.setText("*");
        jPanel8.add(jLblRegistro4);

        textoDesconto.setText("Desconto em Ass. Especial:");
        jPanel8.add(textoDesconto);

        ftextoDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftextoDesconto.setText("00,00");
        ftextoDesconto.setMaximumSize(new java.awt.Dimension(50, 20));
        ftextoDesconto.setMinimumSize(new java.awt.Dimension(50, 20));
        ftextoDesconto.setNextFocusableComponent(ftextoPrecoPass);
        ftextoDesconto.setPreferredSize(new java.awt.Dimension(50, 20));
        ftextoDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftextoDescontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftextoDescontoFocusLost(evt);
            }
        });
        jPanel8.add(ftextoDesconto);

        textoPorcent.setText("%");
        jPanel8.add(textoPorcent);

        jPanel2.add(jPanel8);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoSalvar);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoCancelar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);
        getContentPane().add(jPanel6, java.awt.BorderLayout.EAST);
        getContentPane().add(jPanel9, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void ftextoPrecoPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftextoPrecoPassFocusGained
        this.ftextoPrecoPass.selectAll();
    }//GEN-LAST:event_ftextoPrecoPassFocusGained

    private void ftextoDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftextoDescontoFocusGained
        this.ftextoDesconto.selectAll();
    }//GEN-LAST:event_ftextoDescontoFocusGained

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        Rota rota = validaCampos();
        if (rota != null) {
            insereRota(rota);
            calcula();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void ftextoDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftextoDescontoFocusLost
        calcula();
    }//GEN-LAST:event_ftextoDescontoFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Rota_Cadastro cadastroRota = new Rota_Cadastro(null, true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox<String> caixaDestino;
    private javax.swing.JComboBox<String> caixaOrigem;
    private javax.swing.JFormattedTextField ftextoDesconto;
    private javax.swing.JFormattedTextField ftextoPrecoPass;
    private javax.swing.JLabel jLblRegistro1;
    private javax.swing.JLabel jLblRegistro2;
    private javax.swing.JLabel jLblRegistro3;
    private javax.swing.JLabel jLblRegistro4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel textoDesconto;
    private javax.swing.JLabel textoDestino;
    private javax.swing.JLabel textoOrigem;
    private javax.swing.JLabel textoPorcent;
    private javax.swing.JLabel textoPrecoPass;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.PassagemCRUD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import passagens_aereas.Passagem;

/**
 *
 * @author lucas
 */
public class Passagem_Venda extends javax.swing.JDialog {

    Passagem passagem = new Passagem();
    int idOld;
    boolean atualizacao;

    /**
     * Creates new form CadastroPassagem
     *
     * @param parent
     * @param modal
     */
    public Passagem_Venda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Passagem_Venda(java.awt.Frame parent, boolean modal, Passagem passagem) {
        super(parent, modal);
        initComponents();
        this.idOld = passagem.getId_passagem();
        this.atualizacao = true;
        setaCampos(passagem);
        setaPassagem(passagem);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setaPassagem(Passagem passagem) {
        this.passagem.setId_passagem(passagem.getId_passagem());
        this.passagem.setCpf(passagem.getCpf());
        this.passagem.setData(passagem.getData());
        this.passagem.setDestino(passagem.getDestino());
        this.passagem.setHora(passagem.getHora());
        this.passagem.setNome(passagem.getNome());
        this.passagem.setOrigem(passagem.getOrigem());
        this.passagem.setPlataforma(passagem.getPlataforma());
        this.passagem.setRg(passagem.getRg());
        this.passagem.setTipo(passagem.getTipo());
        this.passagem.setValor(passagem.getValor());
    }

    private void setaCampos(Passagem passagem) {
        this.jTextField1.setText(passagem.getNome());
        this.jFtfCPF.setText(passagem.getCpf());
        this.jFtfRG.setText(passagem.getRg());
        if (passagem.getTipo().equals("Comum")) {
            this.jRBComum.setSelected(true);
        } else {
            this.jRBEspecial.setSelected(true);
        }
    }

    private void escreveTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        if (modelo.getRowCount() == 0) {
            modelo.addRow(new Object[]{
                this.passagem.getData(),
                this.passagem.getHora(),
                this.passagem.getOrigem(),
                this.passagem.getDestino(),
                this.passagem.getPlataforma(),
                this.passagem.getValor(),
                this.passagem.getTipo()
            });
        } else {
            modelo.removeRow(0);
            modelo.addRow(new Object[]{
                this.passagem.getData(),
                this.passagem.getHora(),
                this.passagem.getOrigem(),
                this.passagem.getDestino(),
                this.passagem.getPlataforma(),
                this.passagem.getValor(),
                this.passagem.getTipo()
            });
        }

    }

    private boolean validaRG() {
        return this.jFtfRG.getText().matches("\\d{2}.\\d{3}.\\d{3}-\\d{1}");
    }

    private boolean validaCPF() {
        return this.jFtfCPF.getText().matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
    }

    private boolean validaNome() {
        return !this.jTextField1.getText().equals("");
    }

    private boolean validaVoo() {
        return !this.jLabel6.getText().equals("Selecione um voo clicando no botão ao lado.");
    }

    private boolean validaCampos() {
        if (!validaNome()) {
            return false;
        } else if (!validaRG()) {
            return false;
        } else if (!validaCPF()) {
            return false;
        } else {
            return validaVoo();
        }
    }

    private void setarDadosRestantes() {
        this.passagem.setNome(this.jTextField1.getText());
        this.passagem.setCpf(this.jFtfCPF.getText());
        this.passagem.setRg(this.jFtfRG.getText());
    }

    private void gravaPassagem() {
        setarDadosRestantes();
        PassagemCRUD passagemCRUD = new PassagemCRUD();
        if (atualizacao) {
            perguntaAt();
            passagemCRUD.atualizar(passagem, idOld);
            this.dispose();
        } else {
            if(pergunta()){
                passagemCRUD.inserir(passagem);
            }
        }
    }
    //Pergunta sobre o cadastro
    private boolean pergunta() {
        String texto = "Operação aceita."
                + "\nPassagem no valor de " + this.passagem.getValor()
                + " gerada com sucesso."
                + "\nDeseja imprimir?"
                + "\nPrecione 'Cancelar' para voltar para a tela de vendas"
                + "\ne editar esta passagem.";
        int op = JOptionPane.showConfirmDialog(null, texto);
        if(op == JOptionPane.YES_OPTION){
            this.dispose();
            imprimePassagem();
            return true;
        } else if(op == JOptionPane.NO_OPTION){
            this.dispose();
            return true;
        }
        return false;
    }

    //Pergunta sobre a atualização
    private boolean perguntaAt() {
        String texto = "Operação aceita."
                + "\nPassagem atualizada.";
        JOptionPane.showMessageDialog(null, texto);
        return true;
    }

    private void imprimePassagem() {
        Impressao impressao = new Impressao(null, true, passagem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLblRegistro1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLblRegistro2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFtfCPF = new javax.swing.JFormattedTextField();
        jLblRegistro3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFtfRG = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLblRegistro4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRBComum = new javax.swing.JRadioButton();
        jRBEspecial = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLblRegistro5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnSelecionar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);
        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro1.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro1.setText("*");
        jPanel6.add(jLblRegistro1);

        jLabel1.setText("Nome Completo:");
        jPanel6.add(jLabel1);

        jTextField1.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel6.add(jTextField1);

        jPanel9.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro2.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro2.setText("*");
        jPanel7.add(jLblRegistro2);

        jLabel2.setText("CPF:");
        jPanel7.add(jLabel2);

        try {
            jFtfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFtfCPF.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel7.add(jFtfCPF);

        jLblRegistro3.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro3.setText("*");
        jPanel7.add(jLblRegistro3);

        jLabel3.setText("RG:");
        jPanel7.add(jLabel3);

        try {
            jFtfRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFtfRG.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel7.add(jFtfRG);

        jPanel9.add(jPanel7);

        jPanel5.add(jPanel9);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Viagem"));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro4.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro4.setText("*");
        jPanel13.add(jLblRegistro4);

        jLabel7.setText("Tipo de Assento:");
        jPanel13.add(jLabel7);

        buttonGroup1.add(jRBComum);
        jRBComum.setSelected(true);
        jRBComum.setText("Comum");
        jPanel13.add(jRBComum);

        buttonGroup1.add(jRBEspecial);
        jRBEspecial.setText("Especial");
        jPanel13.add(jRBEspecial);

        jPanel8.add(jPanel13);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLblRegistro5.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro5.setText("*");
        jPanel10.add(jLblRegistro5);

        jLabel4.setText("Selecionar Voo:");
        jPanel10.add(jLabel4);

        jBtnSelecionar.setText("Selecionar");
        jBtnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelecionarActionPerformed(evt);
            }
        });
        jPanel10.add(jBtnSelecionar);

        jLabel6.setText("Selecione um voo clicando no botão ao lado.");
        jPanel10.add(jLabel6);

        jPanel8.add(jPanel10);
        jPanel8.add(jPanel15);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setText("Dados de Voo");
        jPanel12.add(jLabel5);

        jPanel11.add(jPanel12);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Origem", "Destino", "Plataforma", "Valor", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel11.add(jScrollPane1);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Para atualizar a tabela com outro tipo de passagem selecione novamente o voo.");
        jPanel14.add(jLabel8);

        jPanel11.add(jPanel14);

        jPanel8.add(jPanel11);

        jPanel5.add(jPanel8);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionarActionPerformed
        TelaSelecVoo selecVoo = new TelaSelecVoo(null, true);
        this.passagem.setOrigem(selecVoo.getOrigem());
        this.passagem.setDestino(selecVoo.getDestino());
        this.passagem.setPlataforma(selecVoo.getPlataforma());
        this.passagem.setData(selecVoo.getData());
        this.passagem.setHora(selecVoo.getHora());
        if (this.jRBComum.isSelected()) {
            this.passagem.setValor(selecVoo.getPreco_c());
            this.passagem.setTipo("Comum");
        } else {
            this.passagem.setValor(selecVoo.getPreco_e());
            this.passagem.setTipo("Especial");
        }
        this.jLabel6.setText("Voo selecionado: " + selecVoo.getCodigo());
        selecVoo.dispose();
        escreveTabela();
    }//GEN-LAST:event_jBtnSelecionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validaCampos()) {
            gravaPassagem();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Passagem_Venda cadastroPassagem = new Passagem_Venda(null, true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFtfCPF;
    private javax.swing.JFormattedTextField jFtfRG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblRegistro1;
    private javax.swing.JLabel jLblRegistro2;
    private javax.swing.JLabel jLblRegistro3;
    private javax.swing.JLabel jLblRegistro4;
    private javax.swing.JLabel jLblRegistro5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRBComum;
    private javax.swing.JRadioButton jRBEspecial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

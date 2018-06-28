/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.AeroportoCRUD;
import connection.AviaoCRUD;
import connection.RotaCRUD;
import connection.VooCRUD;
import java.sql.Date;
import javax.swing.JOptionPane;
import passagens_aereas.Voo;

/**
 *
 * @author lucas_nuze0yo
 */
public final class Voo_Cadastro extends DefaultCadastro {

    private int rota_selecionada = -1;
    int idOld = 0;
    boolean atualizacao = false;

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
    public Voo_Cadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setAvioesComboBox();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Voo_Cadastro(java.awt.Frame parent, boolean modal, Voo voo) {
        super(parent, modal);
        initComponents();
        setAvioesComboBox();
        this.atualizacao = true;
        this.idOld = voo.getId();
        setacampos(voo);
    }
    
    private void setacampos(Voo voo){
        String hora;
        String teste;
        teste.substring(WIDTH, WIDTH)
        this.jDateChooser1.setDate(voo.getData());
    }

    private void setAvioesComboBox() {
        AviaoCRUD acrud = new AviaoCRUD();
        for (String s : acrud.selecionaRegistro()) {
            this.jComboBox1.addItem(s);
        }

    }

    private void setVariaveisRota() {
        TelaSelecRota telaSelecRota = new TelaSelecRota(null, true);
        if (telaSelecRota.getRota_cod() != 0) {
            this.setRota_selecionada(telaSelecRota.getRota_cod());
            this.jLblRotaSelecionada.setText("Rota selecionada: " + Integer.toString(rota_selecionada));
            telaSelecRota.dispose();
        }
    }

    private boolean validaData() {
        if (this.jDateChooser1.getDate() == null) {
//            frase de aviso de data nula
            System.out.println("data incorreta");
        } else {
            return true;
        }
        return false;
    }

    private boolean validaRota() {
        if (this.getRota_selecionada() == -1) {
            //frase
            System.out.println("Nenhuma rota seleconada");
            return false;
        }
        return true;
    }

    private boolean validaAvião() {
        VooCRUD vooCRUD = new VooCRUD();
        Date data = new Date(this.jDateChooser1.getDate().getTime());
        for (Voo v : vooCRUD.procuraAvioesUtilizados(data)) {
            if (v.getAviao().equals(this.jComboBox1.getSelectedItem().toString())) {
                System.out.println("Avião sendo utilizado");
                return false;
            }
        }
        return true;
    }

    private boolean perguntaVoo(Voo voo) {
        int op = JOptionPane.showConfirmDialog(this, "Dados adicionados:"
                + "\nRota selecionada:  " + voo.getOrigem() + " até " + voo.getDestino()
                + "\nAvião selecionado: " + voo.getAviao()
                + "\nData selecionada:  " + voo.getData()
                + "\n"
                + "\nDeseja adicionar outro?"
                + "\nClique em 'Cancelar' para alterar os dados apresentados.");
        if (op == JOptionPane.OK_OPTION) {
            this.jDateChooser1.setDate(null);
            this.jComboBox1.setSelectedItem(null);
            this.rota_selecionada = -1;
            return true;
        } else if (op == JOptionPane.NO_OPTION) {
            this.dispose();
            return true;
        }
        return false;
    }

    private void quantidadeAss(Voo voo) {
        AviaoCRUD aviaoAssC = new AviaoCRUD();
        AviaoCRUD aviaoAssE = new AviaoCRUD();
        int ass_c = aviaoAssC.retornaAssentosC(voo.getAviao());
        int ass_e = aviaoAssE.retornaAssentosE(voo.getAviao());
        voo.setAss_c(ass_c);
        voo.setAss_e(ass_e);
    }

    private void setaPrecos(Voo voo) {
        RotaCRUD precoC = new RotaCRUD();
        RotaCRUD precoE = new RotaCRUD();
        float pc = precoC.procuraPrecoC(voo.getRota());
        float pe = precoE.procuraPrecoE(voo.getRota());
        voo.setPreco_c(pc);
        voo.setPreco_e(pe);
    }

    private void setaOeD(Voo voo) {
        RotaCRUD origem = new RotaCRUD();
        RotaCRUD destino = new RotaCRUD();
        String or = origem.procuraOrigem(voo.getRota());
        String de = destino.procuraDestino(voo.getRota());
        AeroportoCRUD aeroportoCRUD1 = new AeroportoCRUD();
        AeroportoCRUD aeroportoCRUD2 = new AeroportoCRUD();
        String cidade1 = aeroportoCRUD1.buscaCidade(or);
        String cidade2 = aeroportoCRUD2.buscaCidade(de);
        voo.setOrigem(cidade1);
        voo.setDestino(cidade2);
    }

    private String arrumaHora() {
        String hora = "";
        String minuto = "";
        if (this.jSpinField1.getValue() < 10) {
            hora += "0" + this.jSpinField1.getValue();
        } else {
            hora += this.jSpinField1.getValue();
        }
        if (this.jSpinField2.getValue() < 10) {
            minuto += "0" + this.jSpinField2.getValue();
        } else {
            minuto += this.jSpinField2.getValue();
        }
        return hora + ":" + minuto;
    }

    private void gravaVoo() {
        Voo voo = new Voo();
        Date data = new Date(this.jDateChooser1.getDate().getTime());
        voo.setData(data);
        voo.setRota(rota_selecionada);
        voo.setAviao(this.jComboBox1.getSelectedItem().toString());
        voo.setHora(arrumaHora());
        quantidadeAss(voo);
        setaPrecos(voo);
        setaOeD(voo);
        if (perguntaVoo(voo)) {
            VooCRUD vooCRUD = new VooCRUD();
            vooCRUD.inserir(voo);
        }
    }

    private boolean validaCampos() {
        if (validaData()) {
            if (validaRota()) {
                if (validaAvião()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void cadastraVoo() {
        if (validaCampos()) {
            gravaVoo();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinField1 = new com.toedter.components.JSpinField();
        jSpinField2 = new com.toedter.components.JSpinField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBtnSelecionarRota = new javax.swing.JButton();
        jLblRotaSelecionada = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
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
        getContentPane().add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jPanel4.add(jLabel5);

        jLabel4.setText("Data de Saída:");
        jPanel4.add(jLabel4);

        jDateChooser1.setMaximumSize(new java.awt.Dimension(100, 20));
        jDateChooser1.setMinimumSize(new java.awt.Dimension(100, 20));
        jDateChooser1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jDateChooser1);

        jPanel2.add(jPanel4);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jPanel9.add(jLabel12);

        jLabel2.setText("Hora:");
        jPanel9.add(jLabel2);

        jSpinField1.setMaximum(23);
        jSpinField1.setMinimum(0);
        jSpinField1.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel9.add(jSpinField1);

        jSpinField2.setMaximum(59);
        jSpinField2.setMinimum(0);
        jSpinField2.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel9.add(jSpinField2);

        jPanel2.add(jPanel9);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");
        jPanel3.add(jLabel6);

        jLabel1.setText("Rota:");
        jPanel3.add(jLabel1);

        jBtnSelecionarRota.setText("Selecionar Rota");
        jBtnSelecionarRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelecionarRotaActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnSelecionarRota);

        jLblRotaSelecionada.setText("Escolha uma viagem clicando no botão ao lado");
        jPanel3.add(jLblRotaSelecionada);

        jPanel2.add(jPanel3);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jPanel5.add(jLabel11);

        jLabel7.setText("Avião:");
        jPanel5.add(jLabel7);

        jComboBox1.setMinimumSize(new java.awt.Dimension(200, 20));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel5.add(jComboBox1);

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);
        getContentPane().add(jPanel7, java.awt.BorderLayout.EAST);
        getContentPane().add(jPanel8, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jBtnSelecionarRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionarRotaActionPerformed
        setVariaveisRota();
    }//GEN-LAST:event_jBtnSelecionarRotaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastraVoo();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        Voo_Cadastro cadastroVoo = new Voo_Cadastro(null, true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSelecionarRota;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLblRotaSelecionada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private com.toedter.components.JSpinField jSpinField1;
    private com.toedter.components.JSpinField jSpinField2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import connection.UsuarioCRUD;
import javax.swing.JOptionPane;
import passagens_aereas.Usuario;

/**
 *
 * @author lucas_nuze0yo
 */
public class Usuario_Cadastro extends DefaultCadastro {

    boolean atualizacao = false;
    String nomeOld;

    /**
     * Creates new form CadastroUsuario
     *
     * @param parent
     * @param modal
     */
    public Usuario_Cadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Usuario_Cadastro(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        atualizacao = true;
        nomeOld = usuario.getNome();
        setaCampos(usuario);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setaCampos(Usuario usuario) {
        this.campoNome.setText(usuario.getNome());
        this.campoNivel.setSelectedItem(retornaNivel(usuario));
        this.campoSenha.setText(usuario.getSenha());
        this.campoConfirmaSenha.setText(usuario.getSenha());
    }

    public String retornaNivel(Usuario usuario) {
        switch (usuario.getNivel()) {
            case 1:
                return "Atendente";
            case 5:
                return "Gerente";
            case 10:
                return "Administrador";
            default:
                break;
        }
        return null;
    }

    private boolean perguntaAt() {
        String titulo = "Atualização";
        String texto = "Dados atualizados:"
                + "\n"
                + "\nNome: " + this.campoNome.getText()
                + "\nNível: " + this.campoNivel.getSelectedItem()
                + "\nSenha:" + this.campoSenha.getText()
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
                + "\nNome: " + this.campoNome.getText()
                + "\nNível: " + this.campoNivel.getSelectedItem()
                + "\nSenha:" + this.campoSenha.getText()
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

    public void salvaUsuario(Usuario usuario) {
        System.out.println("Salva");
        if (!validaUsuario()) {
            //mensagem de usuario já cadastrado ou nulo
            System.out.println("Usuário com problema");
            return;
        }
        if (!validaSenha()) {
            System.out.println("Senha com problema");
            //mensagem de senha não confere ou nula
            return;
        }
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        System.out.println("Validado");
        if (atualizacao) {
            if (perguntaAt()) {
                usuarioCRUD.atualizar(usuario, nomeOld);
            }
        } else if (pergunta()) {
            System.out.println("inserção");
            usuarioCRUD.inserir(usuario);
        }
    }

    public Usuario criaUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.campoNome.getText());
        usuario.setSenha(this.campoSenha.getText());
        usuario.setNivel(transformaNivel());
//        System.out.println("Nome: " + usuario.getNome()
//                       + "\nSenha: " + usuario.getSenha()
//                       + "\nNivel: " + usuario.getNivel());
        return usuario;
    }

    public boolean validaSenha() {
        if ("".equals(this.campoSenha.getText())) {
            return false;
        }
        if ("".equals(this.campoConfirmaSenha.getText())) {
            return false;
        }
        String senha = this.campoSenha.getText();
        String confSenha = this.campoConfirmaSenha.getText();
        System.out.println(senha.equals(confSenha));
        return senha.equals(confSenha);
    }

    public boolean validaUsuario() {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        if (!"".equals(this.campoNome.getText())) {
            return true;
        } else if (usuarioCRUD.procurarUsuario(this.campoNome.getText()) && atualizacao) {
            return true;
        }
        return false;
    }

    public int transformaNivel() {
        switch (this.campoNivel.getSelectedItem().toString()) {
            case "Atendente":
                return 1;
            case "Gerente":
                return 5;
            case "Administrador":
                return 10;
            default:
                return 0;
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Usuario_Cadastro teste = new Usuario_Cadastro(null, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLblRegistro1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLblRegistro2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jLblRegistro3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoConfirmaSenha = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLblRegistro4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNivel = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLblRegistro1.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro1.setText("*");
        jPanel3.add(jLblRegistro1);

        jLabel1.setText("Nome:");
        jPanel3.add(jLabel1);

        campoNome.setMaximumSize(new java.awt.Dimension(150, 20));
        campoNome.setMinimumSize(new java.awt.Dimension(150, 20));
        campoNome.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel3.add(campoNome);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLblRegistro2.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro2.setText("*");
        jPanel4.add(jLblRegistro2);

        jLabel2.setText("Senha:");
        jPanel4.add(jLabel2);

        campoSenha.setMaximumSize(new java.awt.Dimension(150, 20));
        campoSenha.setMinimumSize(new java.awt.Dimension(150, 20));
        campoSenha.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel4.add(campoSenha);

        jPanel2.add(jPanel4);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLblRegistro3.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro3.setText("*");
        jPanel6.add(jLblRegistro3);

        jLabel4.setText("Confirmar Senha:");
        jPanel6.add(jLabel4);

        campoConfirmaSenha.setMaximumSize(new java.awt.Dimension(150, 20));
        campoConfirmaSenha.setMinimumSize(new java.awt.Dimension(150, 20));
        campoConfirmaSenha.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel6.add(campoConfirmaSenha);

        jPanel2.add(jPanel6);

        jLblRegistro4.setForeground(new java.awt.Color(255, 0, 0));
        jLblRegistro4.setText("*");
        jPanel5.add(jLblRegistro4);

        jLabel3.setText("Nível:");
        jPanel5.add(jLabel3);

        campoNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendente", "Gerente", "Administrador" }));
        jPanel5.add(campoNivel);

        jPanel2.add(jPanel5);

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
        getContentPane().add(jPanel7, java.awt.BorderLayout.NORTH);
        getContentPane().add(jPanel8, java.awt.BorderLayout.EAST);
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

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        Usuario usuario = criaUsuario();
        salvaUsuario(usuario);
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JPasswordField campoConfirmaSenha;
    private javax.swing.JComboBox<String> campoNivel;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}

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
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TextoUsuario = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        SenhaUsuario = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(200, 200));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(200, 200));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 23));
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 23));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 23));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Usuário");
        jPanel4.add(jLabel1);

        getContentPane().add(jPanel4);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        TextoUsuario.setMaximumSize(new java.awt.Dimension(150, 23));
        TextoUsuario.setMinimumSize(new java.awt.Dimension(150, 23));
        TextoUsuario.setNextFocusableComponent(SenhaUsuario);
        TextoUsuario.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel2.add(TextoUsuario);

        getContentPane().add(jPanel2);

        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel8.setMinimumSize(new java.awt.Dimension(0, 10));
        jPanel8.setName(""); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(429, 10));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel8);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Senha");
        jPanel6.add(jLabel2);

        getContentPane().add(jPanel6);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        SenhaUsuario.setMaximumSize(new java.awt.Dimension(150, 23));
        SenhaUsuario.setMinimumSize(new java.awt.Dimension(150, 23));
        SenhaUsuario.setPreferredSize(new java.awt.Dimension(150, 23));
        SenhaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaUsuarioActionPerformed(evt);
            }
        });
        jPanel7.add(SenhaUsuario);

        getContentPane().add(jPanel7);

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(429, 50));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(filler1);

        jButton1.setText("Login");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton4.setText("Sair");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jPanel3.add(filler2);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Código de validação de login
        validaUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SenhaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaUsuarioActionPerformed
        
    }//GEN-LAST:event_SenhaUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //criação da tela de login
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void validaUsuario() {
        Usuario usuario = new Usuario(this.TextoUsuario, this.SenhaUsuario);
        UsuarioCRUD usuarioCrud = new UsuarioCRUD();
        //uso de booleans para um controle maior em caso de novas opções de login surgirem futuramente
        boolean U = false;
        boolean S = false;

        //codigo que percorre o array criado com os dados do banco e detecta qual dos dados está errado
        for (Usuario u : usuarioCrud.buscaTodos()) {
            if (u.getNome().equals(usuario.getNome())) {
                U = true;
                if (u.getSenha().equals(usuario.getSenha())) {
                    S = true;
                    usuario.setNivel(u.getNivel());
                }
            }
        }
        //inicia o sistema somente se usuario e senha conferem
        if (U == true && S == true) {
            iniciaSistema(usuario);
        //se somente o usuário for encontrado, avisa que a senha está incorreta
        } else if (U == true) {
            JOptionPane.showMessageDialog(null, "Senha incorreta.");
        //se o usuario não for encontrado também informa este fato
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        }
    }

    //inicia o sistema utilizando o usuário encontrado no banco e previne a entrada de usuários com nível zerado.
    public void iniciaSistema(Usuario usuario) {
        if(usuario.getNivel() == 0){
            JOptionPane.showMessageDialog(null, "Usuário banido, impossível logar.");
            System.exit(0);
        }
        Inicio inicio = new Inicio(usuario);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        this.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField SenhaUsuario;
    private javax.swing.JTextField TextoUsuario;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}

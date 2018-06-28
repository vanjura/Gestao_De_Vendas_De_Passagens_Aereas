/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Image;
import javax.swing.ImageIcon;
import passagens_aereas.Usuario;

/**
 *
 * @author lucas_nuze0yo
 */
public class Inicio extends javax.swing.JFrame {

    Usuario usu;

    /**
     * Creates new form Inicio
     *
     * @param usuario
     */
    public Inicio(Usuario usuario) {
        usu = usuario;
        initComponents();
        //comando para deixar a janela em fullscreen
        this.setExtendedState(Inicio.MAXIMIZED_BOTH);
        //se o nível do usuário for menor que 10 a opção 2 e 3 do menu estarão inacessiveis
        if (usuario.getNivel() <= 5) {
            this.menuCadastroDeUsuario.setEnabled(false);
        }
        if (usuario.getNivel() <= 1) {
            this.menuFrota.setEnabled(false);
            this.menuAero.setEnabled(false);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuVoo = new javax.swing.JMenu();
        menuVoos_CadVoo = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        menuUsuar = new javax.swing.JMenu();
        menuCadastroDeUsuario = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        menuFrota = new javax.swing.JMenu();
        menuFrota_CadAviao = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuFrota_CadRotas = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuAero = new javax.swing.JMenu();
        menuAero_CadAero = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 100));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/UnicornAirlinesAzul.png"))); // NOI18N
        jPanel4.add(jLabel1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        menuVoo.setText("Voos");

        menuVoos_CadVoo.setText("Cadastro de Voo");
        menuVoos_CadVoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVoos_CadVooActionPerformed(evt);
            }
        });
        menuVoo.add(menuVoos_CadVoo);

        jMenuItem10.setText("Consulta/Atualização de Aviao");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menuVoo.add(jMenuItem10);

        jMenuItem11.setText("Exclusao de Aviao");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menuVoo.add(jMenuItem11);

        jMenuItem2.setText("Venda de Passagens");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuVoo.add(jMenuItem2);

        jMenuItem12.setText("Consulta/Atualização de Aviao");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        menuVoo.add(jMenuItem12);

        jMenuItem13.setText("Exclusao de Aviao");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        menuVoo.add(jMenuItem13);

        barraMenu.add(menuVoo);

        menuUsuar.setText("Usuários");

        menuCadastroDeUsuario.setText("Cadastro de Usuários");
        menuCadastroDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroDeUsuarioActionPerformed(evt);
            }
        });
        menuUsuar.add(menuCadastroDeUsuario);

        jMenuItem8.setText("Consulta/Atualização de Usuários");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuUsuar.add(jMenuItem8);

        jMenuItem9.setText("Exclusao de Usuários");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuUsuar.add(jMenuItem9);

        barraMenu.add(menuUsuar);

        menuFrota.setText("Frota");

        menuFrota_CadAviao.setText("Cadastro de Aviões");
        menuFrota_CadAviao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFrota_CadAviaoActionPerformed(evt);
            }
        });
        menuFrota.add(menuFrota_CadAviao);

        jMenuItem4.setText("Consulta/Atualização de Aviao");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuFrota.add(jMenuItem4);

        jMenuItem5.setText("Exclusao de Aviao");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuFrota.add(jMenuItem5);

        menuFrota_CadRotas.setText("Cadastro de Rotas");
        menuFrota_CadRotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFrota_CadRotasActionPerformed(evt);
            }
        });
        menuFrota.add(menuFrota_CadRotas);

        jMenuItem6.setText("Consulta/Atualização de Rota");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuFrota.add(jMenuItem6);

        jMenuItem7.setText("Exclusao de Rota");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuFrota.add(jMenuItem7);

        barraMenu.add(menuFrota);

        menuAero.setText("Aeroportos");

        menuAero_CadAero.setText("Cadastro de Aeroportos");
        menuAero_CadAero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAero_CadAeroActionPerformed(evt);
            }
        });
        menuAero.add(menuAero_CadAero);

        jMenuItem1.setText("Consulta/Atualização de Aeroporto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAero.add(jMenuItem1);

        jMenuItem3.setText("Exclusao de Aeroportos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuAero.add(jMenuItem3);

        barraMenu.add(menuAero);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAero_CadAeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAero_CadAeroActionPerformed
        Aeroporto_Cadastro cadAero = new Aeroporto_Cadastro(this, true);
    }//GEN-LAST:event_menuAero_CadAeroActionPerformed

    private void menuFrota_CadAviaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFrota_CadAviaoActionPerformed
        Aviao_Cadastro cadastroAviao = new Aviao_Cadastro(null, true);
    }//GEN-LAST:event_menuFrota_CadAviaoActionPerformed

    private void menuCadastroDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroDeUsuarioActionPerformed
        Usuario_Cadastro cadastroUsuario = new Usuario_Cadastro(null, true);
    }//GEN-LAST:event_menuCadastroDeUsuarioActionPerformed

    private void menuFrota_CadRotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFrota_CadRotasActionPerformed
        Rota_Cadastro cadastroRota = new Rota_Cadastro(null, true);
    }//GEN-LAST:event_menuFrota_CadRotasActionPerformed

    private void menuVoos_CadVooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoos_CadVooActionPerformed
        Voo_Cadastro cadastroVoo = new Voo_Cadastro(null, true);
    }//GEN-LAST:event_menuVoos_CadVooActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Passagem_Venda vendaPassagem = new Passagem_Venda(null, true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Aeroporto_Consulta_Atualizacao consulta_Atualizacao = new Aeroporto_Consulta_Atualizacao(null, true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Aeroporto_Exclusao exclusao = new Aeroporto_Exclusao(null, true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Aviao_Consulta_Atualizacao aviao_Consulta_Atualizacao = new Aviao_Consulta_Atualizacao(null, true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Aviao_Exclusao aviao_Exclusao = new Aviao_Exclusao(null, true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Rota_Consulta_Atualizacao consulta_Atualizacao = new Rota_Consulta_Atualizacao(null, true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Rota_Exclusao exclusao = new Rota_Exclusao(null, true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Usuario_Consulta_Atualizacao consulta_Atualizacao = new Usuario_Consulta_Atualizacao(null, true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Usuario_Exclusao exclusao = new Usuario_Exclusao(null, true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Passagem_Consulta_Atualizacao consulta_Atualizacao = new Passagem_Consulta_Atualizacao(null, true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Voo_Consulta_Atualizacao consulta_Atualizacao = new Voo_Consulta_Atualizacao(null, true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Voo_Exclusao exclusao = new Voo_Exclusao(null, true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Passagem_Exclusao exclusao = new Passagem_Exclusao(null, true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JMenu menuAero;
    private javax.swing.JMenuItem menuAero_CadAero;
    private javax.swing.JMenuItem menuCadastroDeUsuario;
    private javax.swing.JMenu menuFrota;
    private javax.swing.JMenuItem menuFrota_CadAviao;
    private javax.swing.JMenuItem menuFrota_CadRotas;
    private javax.swing.JMenu menuUsuar;
    private javax.swing.JMenu menuVoo;
    private javax.swing.JMenuItem menuVoos_CadVoo;
    // End of variables declaration//GEN-END:variables
}

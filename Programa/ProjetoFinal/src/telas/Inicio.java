/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import passagens_aereas.Usuario;
/**
 *
 * @author lucas_nuze0yo
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio(Usuario usuario) {
        initComponents();
        //comando para deixar a janela em fullscreen
        this.setExtendedState(Inicio.MAXIMIZED_BOTH);
        //se o nível do usuário for menor que 10 a opção 2 e 3 do menu estarão inacessiveis
        if (usuario.getNivel() < 10) {
            menuOp2.setEnabled(false);
            menuOp3.setEnabled(false);
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

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        menuOp1 = new javax.swing.JMenu();
        menuOp5 = new javax.swing.JMenu();
        menuOp6 = new javax.swing.JMenu();
        menuOp2 = new javax.swing.JMenu();
        menuOp3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        menuOp1.setText("Controle de Voos");

        menuOp5.setText("Passagens");
        menuOp1.add(menuOp5);

        menuOp6.setText("Voos");
        menuOp1.add(menuOp6);

        barraMenu.add(menuOp1);

        menuOp2.setText("Controle de Funcionarios");
        barraMenu.add(menuOp2);

        menuOp3.setText("Controle de Frota");
        barraMenu.add(menuOp3);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JMenu menuOp1;
    private javax.swing.JMenu menuOp2;
    private javax.swing.JMenu menuOp3;
    private javax.swing.JMenu menuOp5;
    private javax.swing.JMenu menuOp6;
    // End of variables declaration//GEN-END:variables
}

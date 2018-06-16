/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JVict
 */
public class Usuario {

    private int id_usuario;
    private String nome;
    private String senha;
    private int nivel = 0;

    //construtor utilizado para setar os dados através do banco
    public Usuario() {
    }

    //construtor utilizado para conseguir os dados do usuário através da tela de login
    public Usuario(JTextField TextUsuario, JPasswordField PassUsuario) {
        this.nome = TextUsuario.getText();
        this.senha = PassUsuario.getText();
        this.nivel = 0;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

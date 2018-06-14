/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

/**
 *
 * @author JVict
 */
public class Passagem {
    private int id_passagem;
    private int id_voo;
    private float valor;
    private String cpf_passageiro;

    public int getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }

    public int getId_voo() {
        return id_voo;
    }

    public void setId_voo(int id_voo) {
        this.id_voo = id_voo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCpf_passageiro() {
        return cpf_passageiro;
    }

    public void setCpf_passageiro(String cpf_passageiro) {
        this.cpf_passageiro = cpf_passageiro;
    }
}

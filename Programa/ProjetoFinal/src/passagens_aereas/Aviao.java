/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

/**
 *
 * @author lucas_nuze0yo
 */
public class Aviao {

    private String registro;
    private String modelo;
    private int qtd_assentos;
    private int qtd_assentos_esp;

    public Aviao() {
    }

    public Aviao(String registro, String modelo, int qtd_assentos, int qtd_assentos_esp) {
        this.registro = registro;
        this.modelo = modelo;
        this.qtd_assentos = qtd_assentos;
        this.qtd_assentos_esp = qtd_assentos_esp;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQtd_assentos() {
        return qtd_assentos;
    }

    public void setQtd_assentos(int qtd_assentos) {
        this.qtd_assentos = qtd_assentos;
    }

    public int getQtd_assentos_esp() {
        return qtd_assentos_esp;
    }

    public void setQtd_assentos_esp(int qtd_assentos_esp) {
        this.qtd_assentos_esp = qtd_assentos_esp;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author lucas
 */
public class Aviao {
    private int cod;
    private String nome;
    private double velocidadeMedia;
    private double gastoPorHora;
    private String descricao;

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the velocidadeMedia
     */
    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    /**
     * @param velocidadeMedia the velocidadeMedia to set
     */
    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    /**
     * @return the gastoPorHora
     */
    public double getGastoPorHora() {
        return gastoPorHora;
    }

    /**
     * @param gastoPorHora the gastoPorHora to set
     */
    public void setGastoPorHora(double gastoPorHora) {
        this.gastoPorHora = gastoPorHora;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

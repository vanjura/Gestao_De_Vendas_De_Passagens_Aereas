/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

import java.sql.Time;

/**
 *
 * @author lucas_nuze0yo
 */
public class Rota {
    private int id;
    private int origem;
    private int destino;
    private String duracao;
    private float preco_c;
    private float preco_e;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the origem
     */
    public int getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(int origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * @return the duracao
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the preco_c
     */
    public float getPreco_c() {
        return preco_c;
    }

    /**
     * @param preco_c the preco_c to set
     */
    public void setPreco_c(float preco_c) {
        this.preco_c = preco_c;
    }

    /**
     * @return the preco_e
     */
    public float getPreco_e() {
        return preco_e;
    }

    /**
     * @param preco_e the preco_e to set
     */
    public void setPreco_e(float preco_e) {
        this.preco_e = preco_e;
    }
}

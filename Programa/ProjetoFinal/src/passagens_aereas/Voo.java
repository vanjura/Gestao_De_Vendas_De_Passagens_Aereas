/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

import java.sql.Date;

/**
 *
 * @author lucas_nuze0yo
 */
public class Voo {

    private int id;
    private int rota;
    private String origem;
    private String destino;
    private String aviao;
    private Date data;
    private String hora;
    private int ass_c;
    private int ass_e;
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
     * @return the rota
     */
    public int getRota() {
        return rota;
    }

    /**
     * @param rota the rota to set
     */
    public void setRota(int rota) {
        this.rota = rota;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the aviao
     */
    public String getAviao() {
        return aviao;
    }

    /**
     * @param aviao the aviao to set
     */
    public void setAviao(String aviao) {
        this.aviao = aviao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the ass_c
     */
    public int getAss_c() {
        return ass_c;
    }

    /**
     * @param ass_c the ass_c to set
     */
    public void setAss_c(int ass_c) {
        this.ass_c = ass_c;
    }

    /**
     * @return the ass_e
     */
    public int getAss_e() {
        return ass_e;
    }

    /**
     * @param ass_e the ass_e to set
     */
    public void setAss_e(int ass_e) {
        this.ass_e = ass_e;
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

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    
}

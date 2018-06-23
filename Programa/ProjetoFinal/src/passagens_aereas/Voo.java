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
    private String aviao;
    private Date data;

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
}

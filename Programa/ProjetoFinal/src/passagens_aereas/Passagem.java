/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author lucas
 */
public class Passagem {

    private int id_passagem;
    private String tipo;
    private String origem;
    private String destino;
    private Date data;
    private String plataforma;
    private float valor;
    private String rg;
    private String cpf;
    private String nome;
    private String hora;

    public Passagem() {
    }
    
    public Passagem(int id_passagem, String tipo, String origem, String destino, Date data, String plataforma, float valor, String rg, String cpf, String nome, String hora) {
        this.id_passagem = id_passagem;
        this.tipo = tipo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.plataforma = plataforma;
        this.valor = valor;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.hora = hora;
    }


    
    /**
     * @return the id_passagem
     */
    public int getId_passagem() {
        return id_passagem;
    }

    /**
     * @param id_passagem the id_passagem to set
     */
    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the plataforma
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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

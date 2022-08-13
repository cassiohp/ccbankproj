/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unifor.ccbankapi.domain;

import java.time.LocalDateTime;

/**
 *
 * @author wander
 */
public class ErroResponse {
    
    private String mensagem;
    private int status;
    private LocalDateTime dataHora;

    public ErroResponse(String mensagem, int status, LocalDateTime dataHora) {
        this.mensagem = mensagem;
        this.status = status;
        this.dataHora = dataHora;
    }
    
        public ErroResponse(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
        this.dataHora = LocalDateTime.now();
    }

    public ErroResponse() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
}

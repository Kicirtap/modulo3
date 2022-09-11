package br.com.viagem.model;

import java.util.Date;

public class Cotacao {
    
	 private int cotacao_id;  
	 private String destino;
	 private String valor;
	 private Date dataCotacao;
	public int getCotacao_id() {
		return cotacao_id;
	}
	public void setCotacao_id(int cotacao_id) {
		this.cotacao_id = cotacao_id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Date getDataCotacao() {
		return dataCotacao;
	}
	public void setDataCotacao(Date dataCotacao) {
		this.dataCotacao = dataCotacao;
	}
	 
	 
}

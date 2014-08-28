package br.com.rpg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class _Ficha {

	@XmlElement(name="nome-aventura")
	private String nomeCampanha;
	
	@XmlElement
	private Jogador jogador;
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getCampanha() {
		return nomeCampanha;
	}

	public void setCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}
}

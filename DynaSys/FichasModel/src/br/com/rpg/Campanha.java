package br.com.rpg;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;

import br.com.rpg.sistema.Sistema;

@XmlAccessorType(XmlAccessType.FIELD)
public class Campanha {

	@XmlAttribute
	private String nome;
	private Sistema sistema;
	
	@XmlElementWrapper(name="jogador")
	private List<Jogador> jogadores;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
}
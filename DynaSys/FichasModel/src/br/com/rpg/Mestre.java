package br.com.rpg;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Mestre {

	@XmlAttribute
	private String nome;
	
	@XmlElementWrapper(name="campanha")
	private Set<Campanha> campanhas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Campanha> getCampanhas() {
		return campanhas;
	}
	public void setCampanhas(Set<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
}

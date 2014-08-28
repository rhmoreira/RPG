package br.com.rpg.pontuacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.rpg.XmlReference;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Calculavel extends XmlReference {
	
	public Calculavel() {
		this(null);
		setId(Integer.toHexString(hashCode()));
	}
	
	public Calculavel(String id) {
		super(id);
	}

	public abstract String getDescricao();
	public abstract double getValor();
	
}

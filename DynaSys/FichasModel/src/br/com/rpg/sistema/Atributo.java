package br.com.rpg.sistema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.rpg.pontuacao.ParCalculavel;

@XmlAccessorType(XmlAccessType.FIELD)
public class Atributo extends Elemento{

	public Atributo() {
	}
	
	public Atributo(double minPontos, double maxPontos) {
		setMinPontos(minPontos);
		setMaxPontos(maxPontos);
	}
	
	public Atributo(ParCalculavel regra){
		super(regra);
	}
	
	@Override
	public String getDescricao() {
		return "Atributo [" + getNome() + "]: " + getPontos();
	}
}
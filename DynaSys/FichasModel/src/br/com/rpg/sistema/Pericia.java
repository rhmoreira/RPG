package br.com.rpg.sistema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.rpg.pontuacao.ParCalculavel;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pericia extends Elemento{

	public Pericia(){
	}
	
	public Pericia(ParCalculavel regra){
		super(regra);
	}
	@Override
	public String getDescricao() {
		return "Pericia [" + getNome() + "]: " + getPontos();
	}
}
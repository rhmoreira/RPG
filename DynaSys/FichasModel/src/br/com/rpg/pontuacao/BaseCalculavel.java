package br.com.rpg.pontuacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseCalculavel extends Calculavel{

	private double valor;
	
	public BaseCalculavel(){}
	
	public BaseCalculavel(double valor){
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return "Valor inteiro: " + valor;
	}
	
	/*@Override
	public boolean isParteDoCalculo(Calculavel calculavel) {
		return false;
	}
	
	@Override
	public boolean isParteDoCalculo(Calculavel calculavel, boolean useIfTrue) {
		return false;
	};*/
}
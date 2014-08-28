package br.com.rpg.pontuacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class ParCalculavel extends Calculavel{

	@XmlAttribute
	@XmlIDREF
	private Calculavel valor1;
	
	@XmlAttribute
	@XmlIDREF
	private Calculavel valor2;
	
	private Operacao operacao;
	
	public ParCalculavel() {
	}
	
	public ParCalculavel(Calculavel valor1, Calculavel valor2, Operacao operacao){
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.operacao = operacao;
	}

	public Calculavel getValor1() {
		return valor1;
	}

	public void setValor1(Calculavel valor1) {
		this.valor1 = valor1;
	}

	public Calculavel getValor2() {
		return valor2;
	}

	public void setValor2(Calculavel valor2) {
		this.valor2 = valor2;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public String getDescricao() {
		return "(" + valor1.getDescricao() + operacao.getSimbolo() + valor2.getDescricao() + ")";
	}

	public double getValor() {
		switch (operacao) {
		case SOMA:
			return valor1.getValor() + valor2.getValor();
		case SUBTRACAO:
			return valor1.getValor() - valor2.getValor();
		case DIVISAO:
			return valor1.getValor() / valor2.getValor();
		case MULTIPLICACAO:
			return valor1.getValor() * valor2.getValor();
		}
		return 0;
	}

	/*public boolean isParteDoCalculo(Calculavel calculavel) {
		return isParteDoCalculo(calculavel, false);
	}

	public boolean isParteDoCalculo(Calculavel calculavel, boolean useIfTrue) {
		boolean isPart = valor1.isParteDoCalculo(calculavel, useIfTrue);
		if (isPart && useIfTrue && (valor1 instanceof Elemento && calculavel instanceof Elemento))
			valor1 = calculavel;
		
		isPart = valor2.isParteDoCalculo(calculavel, useIfTrue);
		if (isPart && useIfTrue && (valor2 instanceof Elemento && calculavel instanceof Elemento))
			valor2 = calculavel;
		
		return  isPart;
	}*/
	
	
}
package br.com.rpg.sistema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlTransient;

import br.com.rpg.pontuacao.Calculavel;
import br.com.rpg.pontuacao.ParCalculavel;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Elemento extends Calculavel {

	private String nome;
	private double minPontos;
	private double maxPontos;
	
	@XmlTransient
	private double pontos;
	private String grupo;
	private boolean calculado;
	
	@XmlElement(name="regra-calculo")
	@XmlIDREF
	private ParCalculavel regraCalculo;
	
	public Elemento() {
	}
	
	public Elemento(ParCalculavel regra){
		this();
		setCalculado(true);
		this.regraCalculo = regra;
	}
	
	@Override
	public double getValor() {
		if (isCalculado())
			pontos = regraCalculo.getValor();
		return pontos;
	}

	public double getPontos() {
		return getValor();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? super.hashCode() : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public ParCalculavel getRegraCalculo() {
		return regraCalculo;
	}
	
	/*@Override
	public boolean isParteDoCalculo(Calculavel calculavel) {
		return isParteDoCalculo(calculavel, false);
	}

	@Override
	public boolean isParteDoCalculo(Calculavel calculavel, boolean useIfTrue) {
		return this.equals(calculavel);
	}*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMinPontos() {
		return minPontos;
	}

	public void setMinPontos(double minPontos) {
		this.minPontos = minPontos;
	}

	public double getMaxPontos() {
		return maxPontos;
	}

	public void setMaxPontos(double maxPontos) {
		this.maxPontos = maxPontos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isCalculado() {
		return calculado;
	}

	public void setCalculado(boolean calculado) {
		this.calculado = calculado;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}
}
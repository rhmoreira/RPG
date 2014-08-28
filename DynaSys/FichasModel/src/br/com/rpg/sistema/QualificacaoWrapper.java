package br.com.rpg.sistema;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class QualificacaoWrapper {

	@XmlElement(name="vantagem")
	private List<Qualificacao> vantagens;
	
	@XmlElement(name="desvantagem")
	private List<Qualificacao> desvantagens;

	public List<Qualificacao> getVantagens() {
		return vantagens;
	}

	public void setVantagens(List<Qualificacao> vantagens) {
		this.vantagens = vantagens;
	}

	public List<Qualificacao> getDesvantagens() {
		return desvantagens;
	}

	public void setDesvantagens(List<Qualificacao> desvantagens) {
		this.desvantagens = desvantagens;
	}
}

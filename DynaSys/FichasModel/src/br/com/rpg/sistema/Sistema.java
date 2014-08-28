package br.com.rpg.sistema;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.rpg.pontuacao.Calculavel;
import br.com.rpg.pontuacao.ParCalculavel;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sistema {
	
	@XmlElementWrapper(name="atributos")
	@XmlElement(name="atributo")
	private Set<Atributo> atributos;
	
	@XmlElementWrapper(name="pericias")
	@XmlElement(name="pericia")
	private Set<Pericia> pericias;

	@XmlElementWrapper(name="vantagens")
	@XmlElement(name="vantagen")
	private Set<Qualificacao> vantagens;
	
	@XmlElementWrapper(name="desvantagens")
	@XmlElement(name="desvantagen")
	private Set<Qualificacao> desvantagens;
	
	@XmlElementWrapper(name="calculaveis")
	@XmlElement(name="calculavei")
	private Set<Calculavel> calculaveis = new LinkedHashSet<>();

	public Set<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(Set<Atributo> atributos) {
		setRegraCalculo(atributos);
		this.atributos = atributos;
	}

	public Set<Pericia> getPericias() {
		return pericias;
	}

	public void setPericias(Set<Pericia> pericias) {
		setRegraCalculo(pericias);
		this.pericias = pericias;
	}

	public Set<Qualificacao> getVantagens() {
		return vantagens;
	}

	public void setVantagens(Set<Qualificacao> vantagens) {
		setRegraCalculo(vantagens);
		this.vantagens = vantagens;
	}

	public Set<Qualificacao> getDesvantagens() {
		return desvantagens;
	}

	public void setDesvantagens(Set<Qualificacao> desvantagens) {
		setRegraCalculo(desvantagens);
		this.desvantagens = desvantagens;
	}

	private void setRegraCalculo(Set<? extends Elemento> elementos) {
		for (Elemento elem: elementos)
			if (elem.isCalculado())
				setCalculavel(elem.getRegraCalculo());
	}
	
	private void setCalculavel(Calculavel calculavel){
		if (calculavel instanceof ParCalculavel){
			ParCalculavel parCalc = (ParCalculavel) calculavel;
			calculaveis.add(parCalc);
			
			setCalculavel(parCalc.getValor1());
			setCalculavel(parCalc.getValor2());
			
		}else if (!(calculavel instanceof Elemento))
			calculaveis.add(calculavel);
	}
}
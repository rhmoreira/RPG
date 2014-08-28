package br.com.rpg.sistema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.rpg.pontuacao.ParCalculavel;

@XmlAccessorType(XmlAccessType.FIELD)
public class Qualificacao extends Elemento{

	public Qualificacao() {
	}
	
	public Qualificacao(ParCalculavel regra){
		super(regra);
	}
	
	public String getDescricao() {
		double pontos = getValor();
		String tipoQualificacao;
		if (pontos < 0)
			tipoQualificacao = "Vantagem: ";
		else
			tipoQualificacao = "Desvantagem: ";
		return tipoQualificacao + pontos ;
	}

}

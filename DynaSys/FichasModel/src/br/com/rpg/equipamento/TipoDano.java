package br.com.rpg.equipamento;

import java.math.BigDecimal;

public enum TipoDano {

	CORTANTE(new BigDecimal(1.5)),
	PERFURANTE(new BigDecimal(2.0)),
	CONTUNDENTE(new BigDecimal(1)),
	EXPLOSIVO(new BigDecimal(1)),
	
	;
	private BigDecimal adicional;
	
	private TipoDano(BigDecimal adicional) {
		this.adicional = adicional;
	}
	
	public BigDecimal getAdicional() {
		return adicional;
	}
}

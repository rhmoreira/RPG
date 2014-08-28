package br.com.rpg.equipamento;

public class Arma extends Equipamento {
	
	private Dano dano;

	public Dano getDano() {
		return dano;
	}
	public void setDano(Dano dano) {
		this.dano = dano;
	}
}
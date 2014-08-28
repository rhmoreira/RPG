package br.com.rpg.pontuacao;


public enum Operacao {

	SOMA("+"),
	SUBTRACAO("-"),
	MULTIPLICACAO("*"),
	DIVISAO("/");
	
	private String simbolo;
	
	private Operacao(String simbolo){
		this.simbolo = simbolo;
	}
	
	public String getSimbolo(){
		return simbolo;
	}
}

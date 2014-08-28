package br.com.rpg.equipamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dano {

	private Integer totalDados = 1;
	private Integer qtdFacesDado = 6;
	private Integer modificador;
	private String sinalAritimetico;
	private TipoDano[] tipos;
	
	@XmlTransient
	private String[] sinais = new String[]{"+", "-", "*", "/"};
	
	public Dano(){
	}
	
	public Dano(String danoFormatado){
		danoFormatado = danoFormatado.replaceAll("[(|)]|[\\s]", "").toUpperCase();
		
		int index = -1;
		for (String s: sinais)
			if ((index = danoFormatado.indexOf(s)) != -1){
				sinalAritimetico = s;
				break;
			}
		index = index != -1 ? index : danoFormatado.length();
		String[] danoSplit = danoFormatado.split("D");
		
		if (!danoSplit[0].equals(""))
			this.totalDados = Integer.valueOf(danoSplit[0]);
		
		if (!danoSplit[1].equals("")){
			if (index != -1){
				danoSplit = danoSplit[1].split("\\" + sinalAritimetico);
				if (!danoSplit[0].equals(""))
					qtdFacesDado = Integer.valueOf(danoSplit[0]);
				
				modificador = Integer.valueOf(danoSplit[1]);
			}else
				qtdFacesDado = Integer.valueOf(danoSplit[1]);
		}
	}

	public Integer getTotalDados() {
		return totalDados;
	}

	public void setTotalDados(Integer totalDados) {
		this.totalDados = totalDados;
	}

	public Integer getQtdFacesDado() {
		return qtdFacesDado;
	}

	public void setQtdFacesDado(Integer qtdFacesDado) {
		this.qtdFacesDado = qtdFacesDado;
	}
	
	public Integer getModificador() {
		return modificador;
	}

	public void setModificador(Integer modificador) {
		this.modificador = modificador;
	}

	public String getSinalAritimetico() {
		return sinalAritimetico;
	}

	public void setSinalAritimetico(String sinalAritimetico) {
		this.sinalAritimetico = sinalAritimetico;
	}

	public String getDanoFormatado(){
		return 	(totalDados == null ? "1" : totalDados) +
		  		 "D" +
				(qtdFacesDado == null ? "6" : qtdFacesDado) +
				(modificador == null ? "" : ("" + sinalAritimetico) + modificador);
	}
	
	public static void main(String[] args) {
		Dano dano = new Dano("D12/3");
		System.out.println(dano.getTotalDados());
		System.out.println(dano.getQtdFacesDado());
		System.out.println(dano.getSinalAritimetico());
		System.out.println(dano.getModificador());
		System.out.println(dano.getDanoFormatado());
		/*Dano dano = new Dano();
		dano.setTotalDados(2);
		dano.setQtdFacesDado(8);
		dano.setAdicional(3);
		dano.setBonus(5);
		
		System.out.println(dano.getDanoFormatado());*/
	}

	public TipoDano[] getTipos() {
		return tipos;
	}

	public void setTipos(TipoDano[] tipos) {
		this.tipos = tipos;
	}
}
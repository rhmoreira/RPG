import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.rpg.pontuacao.BaseCalculavel;
import br.com.rpg.pontuacao.Operacao;
import br.com.rpg.pontuacao.ParCalculavel;
import br.com.rpg.sistema.Atributo;
import br.com.rpg.sistema.Pericia;
import br.com.rpg.sistema.Sistema;


public class Main {

	public static void main(String[] args) throws Exception {
		/*
		RoundingMode roundingMode = RoundingMode.HALF_DOWN;
		
		Arma arma = new Arma();
		arma.setNome("AK-47");
		arma.setDano(new Dano("6D+4"));
		arma.setPeso(7500);
		arma.setPreco(new BigDecimal(4000.5d).setScale(2, roundingMode));
		arma.setQuantidade(1);
		
		Equipamento municao = new Equipamento();
		municao.setNome("(Carregador) Munição 7.62 x30");
		municao.setPeso(400);
		municao.setPreco(new BigDecimal(80.d).setScale(2, roundingMode));
		municao.setQuantidade(3);
		
		Jogador jogador = new Jogador();
		jogador.setNome("Renato");
		jogador.setNomePersonagem("Jatobá");
		jogador.addEquipamento(arma);
		jogador.addEquipamento(municao);
		
		_Ficha _Ficha = new _Ficha();
		_Ficha.setJogador(jogador);
		_Ficha.setCampanha("Sequestro");
		
		JAXBContext ctx = JAXBContext.newInstance("br.com.rpg.equipamento");
		ctx.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName)
					throws IOException {
				return new StreamResult(new File("equipamento.xsd"));
			}
		});
		
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(ficha, new File("ficha.xml"));
		
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		ficha = (_Ficha) unmarshaller.unmarshal(new File("ficha.xml"));*/
		
		
		
		Set<Atributo> atributos = getAtributos();
		Set<Pericia> pericias = getPericias();
		
		Sistema sistema = new Sistema();
		sistema.setAtributos(atributos);
		sistema.setPericias(pericias);
		
		
		JAXBContext ctx = JAXBContext.newInstance("br.com.rpg.pontuacao:br.com.rpg.sistema");
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(sistema, new File("sistema.xml"));
		
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		unmarshaller.setListener(createUnmarshallerListener());
		sistema = (Sistema) unmarshaller.unmarshal(new File("sistema.xml"));
		
		System.out.println(sistema);
		
	}
	
	public static Unmarshaller.Listener createUnmarshallerListener(){
		return new Unmarshaller.Listener() {
			@Override
			public void afterUnmarshal(Object target, Object parent) {
				System.out.println("Target: " + target);
				System.out.println("Parent: " + parent);
			}
		};
	}
	
	private static Set<Atributo> getAtributos(){
		Set<Atributo> atributos = new LinkedHashSet<>();
		
		Atributo bt = new Atributo(1, 10);
		bt.setNome("Tipo Corporal");
		atributos.add(bt);
		
		Atributo intel = new Atributo(1, 10);
		intel.setNome("Inteligência");
		atributos.add(intel);
		
		Atributo ref = new Atributo(1, 10);
		ref.setNome("Reflexos");
		atributos.add(ref);
		
		Atributo cool = new Atributo(1, 10);
		cool.setNome("Auto Controle");
		atributos.add(cool);
		
		Atributo tech = new Atributo(1, 10);
		tech.setNome("Técnica");
		atributos.add(tech);
		
		Atributo luck = new Atributo(1, 10);
		luck.setNome("Sorte");
		atributos.add(luck);
		
		Atributo attr = new Atributo(1, 10);
		attr.setNome("Atratividade");
		atributos.add(attr);
		
		Atributo mov = new Atributo(1, 10);
		mov.setNome("Movimentação");
		atributos.add(mov);
		
		Atributo emp = new Atributo(1, 10);
		emp.setNome("Empatia");
		atributos.add(emp);


		//############################# HUMANIDADE #############################
		ParCalculavel regraHumanidade = 
				new ParCalculavel(emp, new BaseCalculavel(10d), Operacao.MULTIPLICACAO);
		Atributo hum = new Atributo(regraHumanidade);
		hum.setNome("Humanidade");
		atributos.add(hum);
		
		//############################# CORRER #############################
		ParCalculavel regraCorrer1 = 
				new ParCalculavel(mov, new BaseCalculavel(3d), Operacao.MULTIPLICACAO);
		ParCalculavel regraCorrer2 = 
				new ParCalculavel(regraCorrer1, new BaseCalculavel(1.0936), Operacao.DIVISAO);
		Atributo run = new Atributo(regraCorrer2);
		run.setNome("Correr");
		atributos.add(run);
		
		//############################# SALTAR #############################
		ParCalculavel regraSaltar1 = 
				new ParCalculavel(run, new BaseCalculavel(4d), Operacao.DIVISAO);
		ParCalculavel regraSaltar2 = 
				new ParCalculavel(regraSaltar1, new BaseCalculavel(3.2808), Operacao.DIVISAO);
		Atributo jump = new Atributo(regraSaltar2);
		jump.setNome("Saltar");
		atributos.add(jump);
		
		//############################# LEVANTAR #############################
		ParCalculavel regraLevantar = 
				new ParCalculavel(bt, new BaseCalculavel(40d), Operacao.MULTIPLICACAO);
		Atributo lift = new Atributo(regraLevantar);
		lift.setNome("Levantar");
		atributos.add(lift);
		
		return atributos;
	}
	
	private static Set<Pericia> getPericias(){
		Set<Pericia> pericias = new LinkedHashSet<>();
		
		Pericia perc1 = new Pericia();
		perc1.setNome("Armas Curtas");
		pericias.add(perc1);

		Pericia perc2 = new Pericia();
		perc2.setNome("Eletrônica");
		pericias.add(perc2);
		
		Pericia perc3 = new Pericia();
		perc3.setNome("Arrombamento");
		pericias.add(perc3);
		
		return pericias;
	}

}

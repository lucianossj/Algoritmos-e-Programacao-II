package projetos;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import principal.CSVFile;
import principal.Main;
import principal.Parser;
import principal.Vetores;

public class Projetos {

	static Scanner 			scan = new Scanner(System.in);
	static int 				opcao = 0;
	private static Projeto	projeto;
	static Vetores vetores = new Vetores();
	
	public static void menu() throws IOException{
		
		boolean op = true;
		
		while (op == true){
			
			mensagem("\nO que deseja realizar? \n\n"
					+ " 1 - Cadastrar novo projeto\n"
					+ " 2 - Excluir projeto\n"
					+ " 3 - Consultar projetos ativos\n"
					+ " 4 - Consultar todos os projetos\n"
					+ " 0 - Voltar\n");
			
			opcao();
			escolheOpcao();
			
			op = false;
			
		}
	
	}
	
	static int opcao(){
		
		mensagem("\nEscolha um opção: ");
		
		opcao = scan.nextInt();
		
		return opcao;
		
	}
	
	static void escolheOpcao() throws IOException{
		
		//COLOCAR IF!!!
		
		switch(opcao){
		
			case 1: cadastrarProjeto();
			break;
		
			//case 2: excluirProjeto();
			//break;
			
			case 3: projetosAtivos();
			break;
			
			case 4: listaProjetos();
			break;
			
			case 0: Main.menuInicial();
			break;
		
		}
		
	}
	
	public static void listaProjetos() throws IOException{
		
		mensagem("\n .:: Projetos ::.\n\n"
				+ "Projeto | Data de Início | Data Final | Nº. de Competências | Competências\n");
				
		for(int i = 0; i < vetores.projetos.length; i++){
			
			mensagem("\n"+vetores.projetos[i]);
			
		}
		
		menu();
		opcao();
		escolheOpcao();
		
	}
	
	static void cadastrarProjeto() throws IOException{
		
		projeto = new Projeto();
		
		mensagem("\n .:: Cadastro de Projeto\n");
		
		projeto.setNome(recebeDadosString("\nNome do Projeto: "));
		projeto.setDataInicio(recebeDadosDate("Data de início: "));
		projeto.setDataFim(recebeDadosDate("Data final: "));
		projeto.setNumeroCompetencias(recebeDadosInt("Quantidade de competências necessárias: "));
		
		String[] vCompetencias = new String[projeto.getNumeroCompetencias()];
		
		for(int i = 0; i < projeto.getNumeroCompetencias(); i++){
			
			vCompetencias[i] = recebeDadosString("Competência: ");
			
		}
		
		projeto.setCompetencias(vCompetencias);
		
		String competencias = "";
		
		for(int i = 0; i < projeto.getNumeroCompetencias(); i++){
			
			competencias = competencias+";"+vCompetencias[i];
			
		}
		
		Vetores vetores = new Vetores();
		
		vetores.projetos[vetores.projetos.length] = projeto;
		
		mensagem("\nProjeto cadastrado sucesso!!!\n");
		
		Main.menuInicial();
		
	}
	/*
	static void excluirProjeto() throws IOException{
		
		mensagem("\n .:: Exclusão de Projetos\n\n");
		
		String 		nomeProjeto = recebeDadosString("Digite o nome do projeto: ");
		
		int 		numeroComp = 0;
		String[] 	vComp = new String[numeroComp];
		
		Parser<Projeto> parser = new ParserProjeto();
		
		CSVFile<Projeto> csvProjeto;	
		
		csvProjeto = new CSVFile<>("src/projetos/projetos.csv", parser);
		
		Projeto projeto = null;
		
		do {
			
			projeto = csvProjeto.readObject();
		
			if(projeto != null)
				
				if(!projeto.getNome().equals(nomeProjeto))
				
					numeroComp = numeroComp + 1;
			
		} while (projeto != null);
		
		Projeto[] vProjeto = new Projeto[numeroComp];
		
		do {
			
			projeto = csvProjeto.readObject();
		
			if(projeto != null)
					
					vProjeto[numeroComp] = projeto;
			
		} while (projeto != null);
		
		fileW.write("");
		
		for(int i = 0; i < numeroComp; i++){
			
			fileW.append((CharSequence) vProjeto[i]);
			
		}
		
/*
		Parser<Projeto> parser = new ParserProjeto();
		
		CSVFile<Projeto> csvProjeto;	
		
		csvProjeto = new CSVFile<>("src/projetos/projetos.csv", parser);
		
		Projeto projeto = null;
		
		int cont = 0;
		int line;
		
		do {
			
			projeto = csvProjeto.readObject();
		
			if(projeto != null)
				
				if(!projeto.getNome().equals(nomeProjeto)){
					
					line = cont;
					
				}
				
					cont = cont + 1;
			
		} while (projeto != null);
		
	}*/
	
	static void projetosAtivos() throws IOException{
		
		mensagem("\n .:: Projetos Ativos\n");
		mensagem("\nProjeto | Competências\n\n");
		
		Parser<Projeto> parser = new ParserProjeto();
		
		CSVFile<Projeto> csvProjeto;
		
		csvProjeto = new CSVFile<>("src/projetos/projetos.csv", parser);
		
		Projeto projeto = null;
		
		Date data = new Date(System.currentTimeMillis());
		Instant instant = data.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate dataAtual = zdt.toLocalDate();
		
		do {
			
			projeto = csvProjeto.readObject();
			
			if(projeto != null)
				
				if(projeto.getDataFim().isAfter(dataAtual)){
					
					mensagem(projeto.getNome() + " | " + projeto.getDataInicio() + " | " + projeto.getDataFim()+"\n");
					
				}
			
		} while (projeto != null);
		
		Projetos.menu();
		
	}
	
	static void mensagem(String mensagem){
		
		System.out.print(mensagem);
		
	}
	
	static String recebeDadosString(String mensagem){
		
		mensagem(mensagem);
		
		String dado;
		
		dado = scan.next();
		
		return dado;
		
	}
	
	static LocalDate recebeDadosDate(String mensagem){
		
		mensagem(mensagem);
		
		LocalDate data;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.US);
		data 	= LocalDate.parse(scan.next(), formatter);
		
		return data;
		
	}
	
	static int recebeDadosInt(String mensagem){
		
		mensagem(mensagem);
		
		int dado;
		
		dado = scan.nextInt();
		
		return dado;
		
	}
	
}

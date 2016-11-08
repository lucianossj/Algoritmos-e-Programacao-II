package funcionarios;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import principal.CSVFile;
import principal.Main;
import principal.Parser;
import projetos.ParserProjeto;
import projetos.Projeto;

public class Funcionarios {

	static Scanner 				scan = new Scanner(System.in);
	static int 					opcao = 0;
	private static Funcionario 	funcionario;
	static FileWriter 			fileW;
	
	public static void listaColaboradores() throws IOException{
		
		System.out.println("\n .:: Funcionários ::.\n"
				+ "\nNome | Salário | Competências\n");
		
		try {
			
			(new Funcionarios()).run();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Arquivo não encontrado!!!");
			System.err.println(e.getMessage());
			
		}
		
		menu();
		
	}
		
	public void run() throws FileNotFoundException{
		
		Parser<Funcionario> parser = new ParserFuncionario();
		
		CSVFile<Funcionario> csvFuncionario;
		
		csvFuncionario = new CSVFile<>("src/funcionarios/funcionarios.csv", parser);
		
		Funcionario funcionario = null;
		
		do {
			
			funcionario = csvFuncionario.readObject();
			
			if(funcionario != null)
				
				System.out.println(funcionario);
			
		} while (funcionario != null);
		
	}
	
	static void menu() throws IOException{
		
		boolean op = true;
		
		while (op == true){
			
			mensagem("\nO que deseja realizar? \n\n"
					+ " 1 - Cadastrar novo funcionário\n"
					+ " 2 - Excluir funcionário\n"
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
		
			case 1: cadastrarFuncionario();
			break;
		
			case 2: excluirFuncionario();
			break;
			
			case 0: Main.menuInicial();
			break;
		
		}
		
	}
	
	static void cadastrarFuncionario() throws IOException{
		
		funcionario = new Funcionario();
		
		mensagem("\n .:: Cadastro de Funcionario\n");
		
		funcionario.setNome(recebeDadosString("\nNome do funcionário: "));
		funcionario.setSalario(recebeDadosDouble("Salário: "));
		funcionario.setNumeroCompetencias(recebeDadosInt("Número de Competências: "));
		
		String[] vCompetencias = new String[funcionario.getNumeroCompetencias()];
		
		for(int i = 0; i < funcionario.getNumeroCompetencias(); i++){
			
			vCompetencias[i] = recebeDadosString("Competência: ");
			
		}
		
		funcionario.setCompetencia(vCompetencias);
		
		String competencias = "";
		
		for(int i = 0; i < funcionario.getNumeroCompetencias(); i++){
			
			competencias = competencias+";"+vCompetencias[i];
			
		}
		
		fileW = new FileWriter("src/funcionarios/funcionarios.csv", true);
		
		fileW.append("\n"+funcionario.getNome()+";"+funcionario.getSalario()+";"+funcionario.getNumeroCompetencias()+competencias);
		
		fileW.flush();
	
		mensagem("\nFuncionário cadastrado sucesso!!!\n");
		
		Main.menuInicial();
		
	}
	
	static void excluirFuncionario(){
		
		
		
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
	
	static Double recebeDadosDouble(String mensagem){
		
		mensagem(mensagem);
		
		Double dado;
		
		String dadoS = scan.next();
		
		dado = Double.parseDouble(dadoS);
		
		return dado;
		
	}
	
	static int recebeDadosInt(String mensagem){
		
		mensagem(mensagem);
		
		int dado;
		
		dado = scan.nextInt();
		
		return dado;
		
	}
	
}
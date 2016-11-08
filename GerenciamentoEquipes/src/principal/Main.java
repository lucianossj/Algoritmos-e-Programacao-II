package principal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import funcionarios.Funcionario;
import funcionarios.Funcionarios;
import funcionarios.ParserFuncionario;
import projetos.ParserProjeto;
import projetos.Projeto;
import projetos.Projetos;

/*
 * Trabalho II - Gerenciamento de Equipes - Algoritmos de Porgramação II
 * 
 * Luciano da Silva Santos Junior
 * 25/10/2016
 * 
 * GitHub:
 * https://github.com/lucianossj/Algoritmos-e-Programacao-II
 * 
 * */

/*• Permitir ao usuário criar novos projetos, definindo para cada projeto, o seu nome, datas de inicio e fim, e as
competências necessárias ao projeto.
• Permitir ao usuário cadastrar novos funcionário, incluindo seu nome, salário e competências.
• Permitir que se exclua projetos.
• Permitir que se exclua funcionários.
• Permitir ao usuário cadastrar novas competências.
• Permitir ao usuário consultar os projetos ativos.
• Permitir ao usuário associar funcionários aos projetos.
• Permitir ao usuário consultar os projetos criados que tem pendências com relação às competências necessárias.
• Fornecer ao usuário uma sugestão de funcionários para preencher as competências de um projeto com os
funcionários disponíveis.
• Garantir que nenhum funcionário trabalhe em mais de dois projetos ao mesmo tempo
*/


public class Main {

	static Scanner scan = new Scanner(System.in);
	
	static int opcao = 0;
	
	static VetorProjeto projetos = new VetorProjeto();
	
	public static void main(String[] args) throws IOException {

		leituraArquivo();
		menuInicial();
		
	}

	static void leituraArquivo() throws IOException{
		
		mensagem("\n .:: Gerenciamento de Equipes ::.\n\n"
				+ ".:: Funcionários\n\n"
				+ "Funcionário | Salário | Quant. Competências | Competências\n");
		
		try {
			
			(new Main()).runFuncionario();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Arquivo não encontrado!!!");
			System.err.println(e.getMessage());
			
		}
		
		mensagem("\n\n .:: Projetos\n\n"
				+ "Projeto | Data de Início | Data Final | Quant. Competências | Competências\n\n");
		
		try {
			
			(new Main()).runProjeto();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Arquivo não encontrado!!!");
			System.err.println(e.getMessage());
			
		}
		
	}
	
	public static void menuInicial() throws IOException{
		
		mensagem("\n\n .:: Gerenciamento de Equipes ::. \n\n"
				+ " 1 - Projetos\n"
				+ " 2 - Funcionários\n"
				+ " 3 - Projetos\n");
		
		opcao();
		escolheOpcao();
		
	}
	
	public void runFuncionario() throws FileNotFoundException{
		
		Parser<Funcionario> parser = new ParserFuncionario();
		
		CSVFile<Funcionario> csvFuncionario;
		
		csvFuncionario = new CSVFile<>("src/funcionarios/funcionarios.csv", parser);
		
		Funcionario funcionario = null;
				
		do {
			
			funcionario = csvFuncionario.readObject();
			
			if(funcionario != null){

				projetos.append(projeto);
				
			}
			
		} while (funcionario != null);
		
		for(int i = 0; i < vetores.funcionarios.length; i++){
			
			mensagem("\n"+vetores.funcionarios[i].toString());
			
		}
		
	}
	
	public void runProjeto() throws IOException{
		
		Parser<Projeto> parser = new ParserProjeto();
		
		CSVFile<Projeto> csvProjeto;
		
		csvProjeto = new CSVFile<>("src/projetos/projetos.csv", parser);
		
		Projeto projeto = null;
		
		int cont = 0;
		
		do {
			
			projeto = csvProjeto.readObject();
			
			if(projeto != null){
				
				vetores.projetos = vetores.aumentaVetorProjetos(vetores.projetos);
				vetores.projetos[cont] = projeto;
				
				cont = cont + 1;
				
			}
			
		} while (projeto != null);
		
		for(int i = 0; i < vetores.projetos.length; i++){
			
			mensagem("\n"+vetores.projetos[i].toString());
			
		}
		
	}
		static int opcao(){
		
		System.out.print("Escolha um opção: ");
		
		opcao = scan.nextInt();
		
		return opcao;
		
	}
	
	static void escolheOpcao() throws IOException{
		
		//COLOCAR IF!!!
		
		switch(opcao){
		
			case 1: projetos.Projetos.menu();
			break;
			
			case 2: funcionarios.Funcionarios.listaColaboradores();
			break;
			
			case 3: funcionarios.Funcionarios.listaColaboradores();
			break;
		
		}
		
	}
	
	static void mensagem(String mensagem){
		
		System.out.print(mensagem);
		
	}
	
}

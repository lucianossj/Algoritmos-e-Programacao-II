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
 * Trabalho II - Gerenciamento de Equipes - Algoritmos de Porgrama��o II
 * 
 * Luciano da Silva Santos Junior
 * 25/10/2016
 * 
 * GitHub:
 * https://github.com/lucianossj/Algoritmos-e-Programacao-II
 * 
 * */

/*� Permitir ao usu�rio criar novos projetos, definindo para cada projeto, o seu nome, datas de inicio e fim, e as
compet�ncias necess�rias ao projeto.
� Permitir ao usu�rio cadastrar novos funcion�rio, incluindo seu nome, sal�rio e compet�ncias.
� Permitir que se exclua projetos.
� Permitir que se exclua funcion�rios.
� Permitir ao usu�rio cadastrar novas compet�ncias.
� Permitir ao usu�rio consultar os projetos ativos.
� Permitir ao usu�rio associar funcion�rios aos projetos.
� Permitir ao usu�rio consultar os projetos criados que tem pend�ncias com rela��o �s compet�ncias necess�rias.
� Fornecer ao usu�rio uma sugest�o de funcion�rios para preencher as compet�ncias de um projeto com os
funcion�rios dispon�veis.
� Garantir que nenhum funcion�rio trabalhe em mais de dois projetos ao mesmo tempo
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
				+ ".:: Funcion�rios\n\n"
				+ "Funcion�rio | Sal�rio | Quant. Compet�ncias | Compet�ncias\n");
		
		try {
			
			(new Main()).runFuncionario();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Arquivo n�o encontrado!!!");
			System.err.println(e.getMessage());
			
		}
		
		mensagem("\n\n .:: Projetos\n\n"
				+ "Projeto | Data de In�cio | Data Final | Quant. Compet�ncias | Compet�ncias\n\n");
		
		try {
			
			(new Main()).runProjeto();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Arquivo n�o encontrado!!!");
			System.err.println(e.getMessage());
			
		}
		
	}
	
	public static void menuInicial() throws IOException{
		
		mensagem("\n\n .:: Gerenciamento de Equipes ::. \n\n"
				+ " 1 - Projetos\n"
				+ " 2 - Funcion�rios\n"
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
		
		System.out.print("Escolha um op��o: ");
		
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

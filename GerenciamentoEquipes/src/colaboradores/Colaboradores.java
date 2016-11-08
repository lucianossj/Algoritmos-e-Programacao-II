package colaboradores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import principal.CSVFile;
import principal.Main;
import principal.Parser;

public class Colaboradores {

	static int opcao;
	static Scanner scan = new Scanner(System.in);
	
	public static void listaColaboradores() throws IOException{
		
		System.out.println("\n .:: Colaboradores ::.\n"
				+ "\nProjeto | Funcionário | Competência\n");
		
		try {
			
			(new Colaboradores()).run();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Arquivo não encontrado!!!");
			System.err.println(e.getMessage());
			
		}

		mensagem("1 - Associar ");
		
	}
		
	static int opcao(){
		
		System.out.print("Escolha um opção: ");
		
		opcao = scan.nextInt();
		
		return opcao;
		
	}
	
	static void escolheOpcao() throws IOException{
		
		//COLOCAR IF!!!
		
			switch(opcao){
		
				case 1: 
				
			}
		
		}
	
	public void run() throws FileNotFoundException{
		
		Parser<Colaborador> parser = new ParserColaborador();
		
		CSVFile<Colaborador> csvColaborador;
		
		csvColaborador = new CSVFile<>("src/colaboradores/colaboradores.csv", parser);
		
		Colaborador colaborador = null;
		
		do {
			
			colaborador = csvColaborador.readObject();
			
			if(colaborador != null)
				
				System.out.println(colaborador);
			
		} while (colaborador != null);
		
	}
	
	public static void mensagem(String mensagem){
		
		System.out.print(mensagem);
		
	}
	
}
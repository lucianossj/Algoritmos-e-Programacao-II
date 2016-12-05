
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		menu();

	}

	static void menu(){
		
		String menu = "\n .:: Trabalho Final - Algoritmos 2 - Lista Duplamente Encadeada Indexada ::.\n\n"
				+ "1 - Carregar lista\n"
				+ "2 - Mostrar dados da lista\n"
				+ "3 - Pesquisar dado\n"
				+ "4 - Sair\n\n";
		
		escolheOpcao(opcao("Escolha uma opção: "));
		
	}
	
	static void carregaLista(){}
	static void mostraLista(){}
	static void pesquisa(){}
	
	static void escolheOpcao(int opcao){
		
		if(opcao == 1){
			
			carregaLista();
			
		}else if(opcao == 2){
			
			mostraLista();
			
		}else if(opcao == 3){
			
			pesquisa();
			
		}else if(opcao == 4){
			
			System.exit(0);
			
		}else{
			
			mensagem("\n\nOpção inválida!! Por favor, tente novamente!!\n\n");
			
		}
		
	}
	
	static int opcao(String mensagem){
		
		System.out.print(mensagem);
		
		int opcao = scan.nextInt();
		
		return opcao;
		
	}
	
	static void mensagem(String mensagem){
			
		System.out.print(mensagem);
		
	}
	
}

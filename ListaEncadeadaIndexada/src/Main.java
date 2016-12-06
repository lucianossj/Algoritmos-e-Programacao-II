/*
 * Trabalho Final - Lista Duplamente Encadeada e Indexada - Algoritmos de Programação II
 * 
 * Luciano da Silva Santos Junior
 * 06/12/2016 
 * 
 * GitHub:
 * https://github.com/lucianossj/Algoritmos-e-Programacao-II
 * 
 * */

/*Lista Indexada
==============

O objetivo desta aplicação é acelerar o processo de procura de um elemento em uma lista encadeada. Para isso, você deve modificar a lista duplamente encadeada de forma que seja possível inserir os dados de forma ordenada na estrutura, e que seja possível criar "pulos" entre os elementos da lista.

A implementação desta lista pode ser realizada com o uso de várias listas encadeadas (uma para cada nível), ou modificando os nós da lista, armazenando apontadores extras nesses nós.*/


import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	
	static ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
	
	public static void main(String[] args) {

		menu();

	}

	static void menu(){
		
		String menu = "\n .:: Trabalho Final - Algoritmos 2 - Lista Duplamente Encadeada Indexada ::.\n\n"
				+ "1 - Carregar lista\n"
				+ "2 - Mostrar dados da lista\n"
				+ "3 - Pesquisar dado\n"
				+ "4 - Sair\n\n";
		
		mensagem(menu);
		
		escolheOpcao(capturaInteiro("Escolha uma opção: "));
		
		menu();
		
	}
	
	static void escolheOpcao(int opcao){
		
		if(opcao == 1){
			
			carregaLista();
			
		}else if(opcao == 2){
			
			mostraLista();
			
		}else if(opcao == 3){
			
			pesquisa();
			
		}else if(opcao == 4){
			
			System.exit(0);
			
		} else {
			
			mensagem("\n\nOpção inválida!! Por favor, tente novamente!!\n\n");
			
		}
		
	}
	
	static void carregaLista(){
		
		for (int i = 0; i <= 15000; i++) {
			lista.append(i);
		}
		
		lista.lista2();
		
	}
	
	static void mostraLista(){
		
		lista.mostraLista();
		
	}
	
	static void pesquisa(){
		
		int elementoPesquisa = capturaInteiro("\nQue elemento deseja procurar? ");
		
		lista.pesquisa(elementoPesquisa);
		
	}
	
	static int capturaInteiro(String mensagem){
		
		System.out.print(mensagem);
		
		int numero = scan.nextInt();
		
		return numero;
		
	}
	
	static void mensagem(String mensagem){
			
		System.out.print(mensagem);
		
	}
	
}

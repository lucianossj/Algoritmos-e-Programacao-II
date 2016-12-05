
public class Main {

	static ListaEncadeada lista = new ListaEncadeada();
	
	public static void main(String args[]){
		
		salvaDados();
		
		pesquisaDados();
		
	}

	static void salvaDados(){
		
		for(int i = 0; i < 2000; i++){
		
			lista.append("Dado "+i);
			
		}
		
	}
	
	static void pesquisaDados(){
		
		System.out.println(lista.popFront());
		
	}
	
	static void imprimeDado(String dado){
		
		System.out.print(dado);
		
	}
	
}

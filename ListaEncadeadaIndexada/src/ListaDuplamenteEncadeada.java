
public class ListaDuplamenteEncadeada<T> {

	private class Node {
		
		private T data;
		private Node proximo;
		private Node anterior;
		
		//Nodes para pular e/ou voltar 50 elementos
		private Node pulaProximo50;
		private Node pulaAnterior50;
		
		//Nodes para pular e/ou voltar 100 elementos
		private Node pulaProximo100;
		private Node pulaAnterior100;
		
		//Nodes para pular e/ou voltar 1000 elementos
		private Node pulaProximo1000;
		private Node pulaAnterior1000;
		
		public Node(T value) {
			
			data = value;
			
		}	
		
		public T getData(){
			
			return data;
			
		}
		
	}
	
	private Node 	head;
	private Node 	tail;
	private int 	size = 0;
	
	//Método que insere os dados na lista
	void append(T value) {
		
		Node novo = new Node(value);
		
		size++;
		
		if (tail != null){
			
			if(head.proximo == null){
				
				head.proximo = novo;
				tail = novo;
				tail.anterior=head;
				
			} else {
				
				novo.anterior=tail;
				tail.proximo = novo;
				tail = novo;
				
			}
			
		} else {
			
			head = novo;
			tail = novo;
			
		}	
		
	}
	
	public void lista2(){
		
		Node node50 	= head;
		Node node100 	= head;
		Node node1000 	= head;
		
		Node atual 		= head;
		
		node50.pulaProximo50 		= tail;
		node100.pulaProximo100 		= tail;
		node1000.pulaProximo1000 	= tail;
		
		int cont = 1;
		
		while(atual != null){
			
			//Se o resto da divisão (valor de cont / 50) for igual a 0 é realizado um pulo de 50 elementos.
			if((cont % 50) == 0){ 
				
				node50.pulaProximo50 	= atual;
				atual.pulaAnterior50 	= node50;
				atual.pulaProximo50 	= tail;
				
				node50 = atual;
				
			}
			
			//Se o resto da divisão (valor de cont / 100) for igual a 0 é realizado um pulo de 100 elementos.
			if((cont % 100) == 0){
				
				node100.pulaProximo100 	= atual;
				atual.pulaAnterior100 	= node100;
				atual.pulaProximo100 	= tail;
				
				node100 = atual;
				
			}
			
			//Se o resto da divisão (valor de cont / 1000) for igual a 0 é realizado um pulo de 1000 elementos.
			if((cont % 1000) == 0){
				
				node1000.pulaProximo1000	= atual;
				atual.pulaAnterior1000		= node1000;
				atual.pulaProximo1000 		= tail;
				
				node1000 = atual;
				
			}
			
			atual = atual.proximo;
			cont++;
			
		}
		
		//Se o tail é nulo, pula 50 elementos antes
		if(tail.pulaAnterior50 == null)
			
			tail.pulaAnterior50 = node50;
		
		//Se o tail é nulo, pula 100 elementos antes
		if(tail.pulaAnterior100 == null)
			
			tail.pulaAnterior100 = node100;
		
		//Se o tail é nulo, pula 1000 elementos antes
		if(tail.pulaAnterior1000 == null)
			
			tail.pulaAnterior1000 = node1000;
		
	}
	
	public void mostraLista(){
		
        Node atual = head;
        
        //Enquanto o node atual for diferente de nulo (final da lista), vai imprimindo os elementos na tela.
        while (atual != null) {
        	
            System.out.println(" | "+(atual.getData()+ " | "));
            atual = atual.proximo;
            
        }
        
    }
	
	//Método que faz a pesquisa de elementos de forma acelerada recebendo como parâmetro o número do elemento solicitado pelo usuário 
	public void pesquisa(int elemento) {
		
		Node atual = head;
        boolean encontrado = false;
        int quantNodes = 0;      

      //Enquanto o node atual for diferente de nulo (final da lista), vai pesquisando o elemento solicitado
		while (atual != null) {
            
			//Se o elemento do node atual for diferente do elemento solicitado, é realizado alguns testes.
            if ((Integer) atual.getData() != elemento) {
            	
            	quantNodes++;
            	
            	//Se um pulo de 1000 elementos do node atual for diferente de nulo e se for menor ou igual ao elemento solicitado, o node atual realiza o pulo.
            	if ((atual.pulaProximo1000 != null) && ((Integer)atual.pulaProximo1000.data <= elemento)) {
            		
                	atual = atual.pulaProximo1000;
                	
                //Se um pulo de 100 elementos do node atual for diferente de nulo e se for menor ou igual ao elemento solicitado, o node atual realiza o pulo.	
            	} else if ((atual.pulaProximo100 != null) && ((Integer)atual.pulaProximo100.data <= elemento)) {
            		
                	atual = atual.pulaProximo100;

                //Se um pulo de 50 elementos do node atual for diferente de nulo e se for menor ou igual ao elemento solicitado, o node atual realiza o pulo.
            	} else if ((atual.pulaProximo50 != null) && ((Integer)atual.pulaProximo50.data <= elemento)) {
            		
            		atual = atual.pulaProximo50;

            	//Senão o node atual pula somente um elemento.
        		} else {
        			
                	atual = atual.proximo;
                	
            	}

            //Senão o elemento foi encontrado.
            } else {
            	
            	encontrado = true;
                break;
                
            }   
            
        }		                 
		
		//Se o elemento for encontrado a pesquisa para e é mostrado na tela a quantidade de pulos realizados pelo sistema.
        if (encontrado) {
        	
        	Main.mensagem("\nQuantidade de nodes percorridos: "+ quantNodes +"\n");
        	
    	}   
        
    }
	
}

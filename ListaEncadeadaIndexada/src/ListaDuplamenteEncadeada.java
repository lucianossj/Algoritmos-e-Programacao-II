
public class ListaDuplamenteEncadeada<T> {

	private class Node {
		
		private T data;
		private Node proximo;
		private Node anterior;
		
		private Node pulaProximo50;
		private Node pulaAnterior50;
		
		private Node pulaProximo100;
		private Node pulaAnterior100;
		
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
	
	void append(T value) {
		
		Node novo = new Node(value);
		
		size++;
		
		if (tail != null){
			
			if(head.proximo==null){
				
				head.proximo = novo;
				tail = novo;
				tail.anterior=head;
				
			}else{
				
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
		
		Node node50 = head;
		Node node100 = head;
		Node node1000 = head;
		
		Node current = head;
		
		node50.pulaProximo50 = tail;
		node100.pulaProximo100 = tail;
		node1000.pulaProximo1000 = tail;
		
		int cont = 1;
		
		while(current != null){
			
			if((cont % 25) == 0){
				
				node50.pulaProximo50 = current;
				current.pulaAnterior50 = node50;
				current.pulaProximo50 = tail;
				
				node50 = current;
				
			}
			
			if((cont % 100) == 0){
				
				node100.pulaProximo100 = current;
				current.pulaAnterior100 = node100;
				current.pulaProximo100 = tail;
				
				node100 = current;
				
			}
			
			if((cont % 1000) == 0){
				
				node1000.pulaProximo1000 = current;
				current.pulaAnterior1000 = node1000;
				current.pulaProximo1000 = tail;
				
				node1000 = current;
				
			}
			
			current = current.proximo;
			cont++;
			
		}
		
		if(tail.pulaAnterior50 == null)
			
			tail.pulaAnterior50 = node50;
		
		if(tail.pulaAnterior100 == null)
			
			tail.pulaAnterior100 = node100;
		
		if(tail.pulaAnterior1000 == null)
			
			tail.pulaAnterior1000 = node1000;
		
	}
	
	public void mostraLista(){
		
        Node current = head;
        
        while (current != null) {
        	
            System.out.println((current.getData()));
            current = current.proximo;
            
        }
        
    }
	
	public void pesquisa(int elemento) {
		
		Node current = head;
        boolean found = false;
        int quantNodes = 0;      

		while (current != null) {
            
            if ((Integer) current.getData() != elemento) {
            	
            	quantNodes++;
            	
            	if ((current.pulaProximo1000 != null) && ((Integer)current.pulaProximo1000.data <= elemento)) {
            		
                	current = current.pulaProximo1000;
                	
            	} else if ((current.pulaProximo100 != null) && ((Integer)current.pulaProximo100.data <= elemento)) {
            		
                	current = current.pulaProximo100;
                	
            	} else if ((current.pulaProximo50 != null) && ((Integer)current.pulaProximo50.data <= elemento)) {
            		
            		current = current.pulaProximo50;
            		
        		} else {
        			
                	current = current.proximo;
                	
            	}
            	
            } else {
            	
            	found = true;
                break;
                
            }   
            
        }		                 
		
        if (found) {
        	
        	Main.mensagem("\nQuantidade de nodes percorridos: "+ quantNodes +"\n");
        	
    	}   
        
    }
	
}

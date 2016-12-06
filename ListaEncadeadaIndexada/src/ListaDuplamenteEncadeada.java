
public class ListaDuplamenteEncadeada<T> {

	private class Node {
		private T data;
		private Node next;
		private Node previous;
		
		private Node next50;
		private Node previous50;
		
		private Node next100;
		private Node previous100;
		
		private Node next1000;
		private Node previous1000;
		
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
			if(head.next==null){
				head.next = novo;
				tail = novo;
				tail.previous=head;
			}else{
				novo.previous=tail;
				tail.next = novo;
				tail = novo;
			}	
		}
		else{
			head = novo;
			tail = novo;
		}				
	}
	
	public void listaCreateSkips(){
		Node node50 = head;
		Node node100 = head;
		Node node1000 = head;
		
		Node current = head;
		
		node50.next50 = tail;
		node100.next100 = tail;
		node1000.next1000 = tail;
		
		int cont = 1;
		while(current != null){
			if((cont % 25) == 0){
				node50.next50 = current;
				current.previous50 = node50;
				current.next50 = tail;
				
				node50 = current;
			}
			if((cont % 100) == 0){
				node100.next100 = current;
				current.previous100 = node100;
				current.next100 = tail;
				
				node100 = current;
			}
			if((cont % 1000) == 0){
				node1000.next1000 = current;
				current.previous1000 = node1000;
				current.next1000 = tail;
				
				node1000 = current;
			}
			current = current.next;
			cont++;
		}
		if(tail.previous50 == null)
			tail.previous50 = node50;
		if(tail.previous100 == null)
			tail.previous100 = node100;
		if(tail.previous1000 == null)
			tail.previous1000 = node1000;
	}
	
}

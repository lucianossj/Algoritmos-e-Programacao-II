public class ListaEncadeada implements Iterable<String> {
	
	private class Node {
		public final String dado;
		private Node next;
		
		public Node(String dado) {
			this.dado = dado;
			this.next = null;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	private class ListaIterator implements Iterador {
		private Node current = null;
		private Node previous = null;

		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}

		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				previous = current;
				current = current.getNext();
			}
			return current.dado;
		}

		@Override
		public void remove() {
			if (current == null) {
				throw new IllegalStateException("Call next() first.");
			}
			if (previous == null) {
				head = current.getNext();
			}
			previous.setNext(current.getNext());
			current = previous.getNext();
		}

		@Override
		public void insertAfter(String dado) {
			if (current == null) {
				throw new IllegalStateException("Call next()!");
			}
				
			Node node = new Node(dado);
			Node next = current.next;
			node.setNext(next);
			current.setNext(node);
			if (next == null) {
				tail = node;
			}
		}

		@Override
		public void insertBefore(String dado) {
			if (current == null) {
				throw new IllegalStateException("Call next()!");
			}
				
			Node node = new Node(dado);
			node.setNext(current);
			if (previous == null) {
				head = node;
			} else {
				previous.setNext(node);
			}
			previous = node;
		}
	}
	
	private Node head;
	private Node tail;
	
	public void append(String dado) {
		Node node = new Node(dado);
		if (tail != null) {
			tail.setNext(node);
		} else {
			head = node;
		}
		tail = node;
	}

	public void pushFront(String dado) {
		Node node = new Node(dado);
		if (head != null) {
			node.setNext(head);
		} else {
			tail = node;
		}
		head = node;
	}
	
	public String popFront() {
		if (head == null) {
			throw new RuntimeException("Lista vazia!");
		}
		String dado = head.dado;
		head = head.next;
		return dado;
	}
	
	@Override
	public Iterador iterator() {
		return new ListaIterator();
	}
}
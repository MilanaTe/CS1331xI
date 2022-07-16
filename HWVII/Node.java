public class Node <T> {

	private  T data;
	private  Node <T> next;
	
//Constructors
	 Node(T data, Node <T> next) {
		this.data=data;
		this.next=next;
	}


	 public Node(T data) {
		  this(data, null);
		
	}


	/**
	 * @return the data
	 */
	public T getData() {
		return this.data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}


	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return this.next;
	}


	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}

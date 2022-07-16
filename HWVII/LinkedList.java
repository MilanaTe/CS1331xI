import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public Node<T> getHead() {
		return this.head;
	}
 

	public Node<T> getTail() {
		return this.tail;
	}

 


 	public T getAtIndex(int index) {
		if (index < 0 || index > size-1) {
			throw new IllegalArgumentException("Your Index ist out of the list bounds");

		}
		else {
			   T returnData;
	            if (index == 0) {
	                returnData = this.head.getData();
	            } else if (index == (this.size - 1)) {
	                returnData = this.tail.getData();
	            } else {

	                int currPosition = 0;
	                Node<T> currNode = this.head;
	                while (currPosition < index) {
	                	currNode = currNode.getNext();
	                    currPosition++;
	                }

	                returnData = currNode.getData();
	            }

	            return returnData;
	        }
	    }

 	public T removeAtIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Your Index is out of bounds");
		}
		else {
			Node<T> nodeToRemove;
			Node<T> previousNode = null;
        if (index == 0) {
            previousNode = null;
            nodeToRemove = this.head;
            this.head = nodeToRemove.getNext();
        } else {
            int currentPosition = 0;
            Node<T> currentNode = this.head;
            while (currentPosition < index) {
                previousNode = currentNode;
                currentNode = previousNode.getNext();
                currentPosition++;
            }
            nodeToRemove = currentNode;
            previousNode.setNext(nodeToRemove.getNext());
            nodeToRemove.setNext(null);
        }

        if (index == (this.size - 1)) {
            this.tail = previousNode;
        }

        this.size--;
        return nodeToRemove.getData();
    }
}

 	public T remove(T data) {
		if (data == null) {
			throw new IllegalArgumentException("You cannot remove null data from the list");
		}
 
        int currPosition = 0;
        T returnData = null;
        Node<T> currNode = this.head;
        while (currNode != null) {
            if (currNode.getData().equals(data)) {
                returnData = currNode.getData();
                break;
            }

            currNode = currNode.getNext();
            currPosition++;
        }
 
        if (returnData == null) {
            throw new NoSuchElementException("The data is not present in the list.");
        }

        return this.removeAtIndex(currPosition);
    }
 	
 	public void addAtIndex(T data, int index) {
		int currPosition=0;

		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Your Index is out of the list bounds");
		} else if (data == null) {
           throw new IllegalArgumentException("You cannot add null data to the list");
		}
		// Check List empty
		else {
			Node<T> MyNewNode = new Node(data,null);
			if (index==0) {
				MyNewNode.setNext(this.head);
				this.head=MyNewNode;
			}else {
				Node<T> currNode=this.head;
			while(currPosition < (index-1)) {
				currNode=currNode.getNext();
				currPosition=currPosition+1;
				}
			Node<T> OldNode =currNode.getNext();

			currNode.setNext(MyNewNode);
			MyNewNode.setNext(OldNode);
			}
			if (index==this.size);
			this.tail=MyNewNode;
		}
			size++;

	}


    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.size <= 0);
    }

    public int size() {
        return this.size;
    }
}
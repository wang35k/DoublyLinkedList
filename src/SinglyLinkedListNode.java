

/**
 * 
 * This is the node class for SinglyLinkedList
 * 
 * @author Eitan Mendelowitz
 *
 * @param <T>
 */
public class SinglyLinkedListNode<T> {
	protected T value;
	protected SinglyLinkedListNode<T> next;
	
	/**
	 * Constructs a SinglyLinkedListNode with the specified value.
	 * @param value
	 */
	public SinglyLinkedListNode(T value) {
		this.value = value;
	}
	
	/**
	 * Returns the value contained in the node.
	 * @return the value contained in the node.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the node's value to the specified value.
	 * @param value - the specified value.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Returns the next node.
	 * @return the next node.
	 */
	public SinglyLinkedListNode<T> getNext() {
		return next;
	}


	/**
	 * Sets next to the specified node.
	 * @param node - the specified node
	 */
	public void setNext(SinglyLinkedListNode<T> node) {
		this.next =  node;
	}

}

/**
 * 
 * This is the node class for DoublyLinkedList
 * 
 * @author Kexin Wang
 *
 * @param <T>
 */
public class DoublyLinkedListNode<T> extends SinglyLinkedListNode<T> {
	private DoublyLinkedListNode<T> next;
	private DoublyLinkedListNode<T> previous;
	
	/**
	 * constructor inherited from super class
	 * 
	 * @param value
	 */
	public DoublyLinkedListNode(T value) {
		super(value);
	}
	
	/**
	 * Returns the next node.
	 * @return the next node.
	 */
	public DoublyLinkedListNode<T> getNext() {
		return next;
	}
	
	/**
	 * Sets next to the specified node.
	 * @param node - the specified node
	 */
	public void setNext(DoublyLinkedListNode<T> node) {
		this.next =  node;
	}
	
	/**
	 * Returns the previous node.
	 * @return the previous node.
	 */
	public DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}
	
	/**
	 * Sets previous to the specified node.
	 * @param node - the specified node
	 */
	public void setprevious(DoublyLinkedListNode<T> node) {
		this.previous =  node;
	}


}

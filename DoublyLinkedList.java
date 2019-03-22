/**
 * Implementation of Doubly Linked Lists.
 * 
 * @author Kexin Wang
 *
 * @param <E>
 */
public class DoublyLinkedList<E> extends SinglyLinkedList<E> implements List<E> {
	DoublyLinkedListNode<E> head = null;
	DoublyLinkedListNode<E> tail = null;

	/**
	 * Appends the specified element to the end of the list
	 * 
	 * @param e  - element to be appended to this list
	 * @return true 
	 */
	@Override
	public boolean add(E e) {
		DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<E>(e);
		if(head == null) {
			head = newNode;
		} else {
			newNode.setprevious(getNode(count-1));
			getNode(count-1).setNext(newNode);
		}
		count++;
		return true;
	}
	/**
	 * Inserts the specified element at the specified position in the list
	 * @param index  - index at which the specified element is to be inserted
	 * @param element - element to be inserted
	 */
	@Override
	public void add(int index, E element) {
		DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<E>(element);

		if(index == 0) {
			newNode.setNext(head);
			head.setprevious(newNode);
			head = newNode;
		} else {
			DoublyLinkedListNode<E> prevNode = getNode(index -1);
			DoublyLinkedListNode<E> nextNode = prevNode.getNext();
			prevNode.setNext(newNode);
			newNode.setprevious(prevNode);
			nextNode.setprevious(newNode);
			newNode.setNext(nextNode);
		}
		count++;
	}	
	/**
	 * Returns the node at the specified index.
	 * @param index -  specified index
	 * @return the node at the specified index.
	 */
	protected DoublyLinkedListNode<E> getNode(int index) {
		DoublyLinkedListNode<E> curNode = head;
		while(index > 0) { 
			curNode = curNode.getNext();
			index--;
		}
		return curNode;
		
	}
	/**
	 * Removes the element at the specified position in this list 
	 * @param index - the index of the element to be removed
	 * @return the element previously at the specified position
	 */
	@Override
	public E remove(int index) {
		DoublyLinkedListNode<E> removedNode = null;
		if (count==1) {
			removedNode=head;
			clear();
			
		}
		else if(index == 0) {
			removedNode = head;
			head.getNext().setprevious(null);
			head = head.getNext();
			
		} 
		else if (index==count-1) {
			DoublyLinkedListNode<E> curNode = head;
			while (curNode.getNext()!=null) {
				curNode=curNode.getNext();
			}
			removedNode=curNode;
			curNode.getPrevious().setNext(null);
			
		}
		else {
			DoublyLinkedListNode<E> prevNode = getNode(index-1);
			//System.out.println(prevNode.getValue());
			removedNode = prevNode.getNext();
			DoublyLinkedListNode<E> nextNode = removedNode.getNext();
			prevNode.setNext(nextNode);
			nextNode.setprevious(prevNode);
		}		
		count--;
		return removedNode.getValue();
	}
	/**
	 * Returns true if this list contains the specified element. 
	 * @param o - element whose presence in this list is to be tested
	 * @return if this list contains the specified element
	 */
	@Override
	public boolean contains(Object o) {
		DoublyLinkedListNode<E> curNode = head;
		while(curNode != null) {
			if(curNode.getValue().equals(o)) {
				return true;
			}
			curNode = curNode.getNext();
		}
		return false;
	}
	/**
	 * Removes all of the elements from this list
	 */
	@Override
	public void clear() {
		head = null;
		count = 0;
		
	}
	/**
	 * return a string with all data in different lines 
	 */
	public String toString() {
		if (head==null) {
			return null;
		}
		DoublyLinkedListNode<E> currentNode = head;
		String str = (String)head.getValue();
		while (currentNode.getNext()!=null) {
			
			str+= "\n"+(String)currentNode.getNext().getValue();
			currentNode=currentNode.getNext();
		}
		return str;	
	}
	/**
	 * get the index of certain node 
	 * @param node the node you want to know the index 
	 * @return the index of the node passed in 
	 */
	public int getIndex(DoublyLinkedListNode<E> node) {
		int index = 0;
		DoublyLinkedListNode<E> curNode = head;
		while (!curNode.getValue().equals(node.getValue())) {
			index ++;
			curNode=curNode.getNext();
		}
		return index;
	}
}

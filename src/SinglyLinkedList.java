

/**
 * Implementation of Singly Linked Lists.
 * 
 * @author Eitan Mendelowitz
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E> {
	SinglyLinkedListNode<E> head = null;
	int count = 0;
	
	/* (non-Javadoc)
	 * @see List#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<E>(e);
		if(head == null) {
			head = newNode;
		} else {
			getNode(size()-1).setNext(newNode);
		}
		count++;	
		return true;
	}

	/* (non-Javadoc)
	 * @see List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E element) {
		SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<E>(element);

		if(index == 0) {
			SinglyLinkedListNode<E> next = head;
			head = newNode;
			head.setNext(next);
		} else {
			SinglyLinkedListNode<E> prevNode = getNode(index -1);
			SinglyLinkedListNode<E> nextNode = prevNode.getNext();
			prevNode.setNext(newNode);
			newNode.setNext(nextNode);
		}
		count++;

	}
	
	/**
	 * Returns the node at the specified index.
	 * @param index -  specified index
	 * @return the node at the specified index.
	 */
	protected SinglyLinkedListNode<E> getNode(int index) {
		
		SinglyLinkedListNode<E> curNode = head;
		while(index > 0) { 
			curNode = curNode.getNext();
			index--;
		}
		return curNode;
		
	}	
	

	/* (non-Javadoc)
	 * @see List#get(int)
	 */
	@Override
	public E get(int index) {
		return getNode(index).getValue();
	}

	/* (non-Javadoc)
	 * @see List#remove(int)
	 */
	@Override
	public E remove(int index) {
		SinglyLinkedListNode<E> removedNode = null;
		if(index == 0) {
				removedNode = head;
				head = head.getNext();
		} else {
			SinglyLinkedListNode<E> prevNode = getNode(index -1);
			removedNode = prevNode.getNext();
			SinglyLinkedListNode<E> nextNode = removedNode.getNext();
			prevNode.setNext(nextNode);
		}		
		count--;
		return removedNode.getValue();
	}

	/* (non-Javadoc)
	 * @see List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	/* (non-Javadoc)
	 * @see List#size()
	 */
	@Override
	public int size() {
		return count;
	}

	/* (non-Javadoc)
	 * @see List#clear()
	 */
	@Override
	public void clear() {
		head = null;
		count = 0;
		
	}

	/* (non-Javadoc)
	 * @see List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		SinglyLinkedListNode<E> curNode = head;
		while(curNode != null) {
			if(curNode.getValue().equals(o)) {
				return true;
			}
			curNode = curNode.getNext();
		}
		return false;
	}

}

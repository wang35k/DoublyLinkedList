

/**
 * This is a common interface for linked lists (both single and doubly linked
 * list). It is based on the Java SE List API.
 * 
 * @author Eitan Mendelowitz
 *
 * @param <E>
 */
public interface List<E> {

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * 
	 * @param e  - element to be appended to this list
	 * @return true (This function should always return true as specified by
	 *         Collection.add(E))
	 */
	public boolean add(E e);

	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation). Shifts the element currently at that position (if any)
	 * and any subsequent elements to the right (adds one to their indices).
	 * 
	 * @param index  - index at which the specified element is to be inserted
	 * @param element - element to be inserted
	 */
	public void add(int index, E element);

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            - index of the element to return
	 * @return the element at the specified position in this list
	 */
	public E get(int index);

	/**
	 * Removes the element at the specified position in this list (optional
	 * operation). Shifts any subsequent elements to the left (subtracts one from
	 * their indices). Returns the element that was removed from the list.
	 * 
	 * @param index
	 *            - the index of the element to be removed
	 * @return the element previously at the specified position
	 */
	public E remove(int index);

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this list contains no elements.
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size();

	/**
	 * Removes all of the elements from this list (optional operation). The list
	 * will be empty after this call returns.
	 */
	public void clear();

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param o  - element whose presence in this list is to be tested
	 * @return if this list contains the specified element
	 */
	public boolean contains(Object o);
}

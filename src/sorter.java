/**
 * Sorter can sort a doubly linked list who hold sting object 
 * it can sort the list to alphabetical order 
 * @author kexin wang 
 * @version 1/30/2019
 */
public class sorter {
	//the list to return 
	static public DoublyLinkedList<String> sortedList = new DoublyLinkedList<>();
	/**
	 * a method to sort a doubly linked list 
	 * @param myList the list need to be sorted 
	 * @return the sorted list 
	 */
	static public DoublyLinkedList<String> sortAlphabetical(DoublyLinkedList<String> myList){
		//creat a new list every time so that the method can be used repeatedly 
		sortedList = new DoublyLinkedList<>();
		//use selection sort algorithm 
		DoublyLinkedListNode<String> currentNode = myList.head;
		DoublyLinkedListNode<String> biggestNode = myList.head;
		//the time the selection sort should happen 
		int sortTime = myList.count;
		for (int i = 0;i<sortTime;i++) {
			//loop through the list to find the string has biggest alphabetical order
			while (currentNode!=null) {				
				String currentFirst = currentNode.getValue().substring(0, 1);
				String biggestFirst = biggestNode.getValue().substring(0, 1);
				if (currentFirst.compareTo(biggestFirst)<=0) {
					biggestNode=currentNode;	
				}
				currentNode=currentNode.getNext();
			}
			//add the string to the end of the sorted list 
			sortedList.add(biggestNode.getValue());
			//remove the one has been added from the original list 
			myList.remove(myList.getIndex(biggestNode));
			//set the cur and biggest back to head 
			currentNode = biggestNode = myList.head;	
		}	
		return sortedList;
	}

}

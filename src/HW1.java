import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author kiki
 * @version 1/30/2019
 */
public class HW1 {
	
	/**
	 * 
	 * @param args the command line argument which is the file name passed in 
	 */
	public static void main(String[] args) {
		//this program can have at most two roster for each class
		DoublyLinkedList<String> roster = new DoublyLinkedList<>();
		DoublyLinkedList<String> roster2 = new DoublyLinkedList<>();
		//wait list for the class 
		DoublyLinkedList<String> waitList = new DoublyLinkedList<>();
		//a boolean to keep track whether the second is created 
		boolean hasSecondRoster = false;
		
	    // create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);
	    //print out the instruction message for user to opreat the program 
	    System.out.print("Enter the maximum size for the class roster" + ": \n");
	    //store the input as an integer
	    int maxNum = Integer.parseInt(scanner.nextLine());
	    //the operations the user can do 
	    System.out.print("Enter the action you want to do" + ": \n"
	    +"type A to add a student to the class\n" + 
	     "type R to remove a student from the class\n" +
	     "type D to display the roster and wait list\n");
		try {
			//create a line scanner so we can read from the file 
		    LineScanner LineScanner = new LineScanner(args[0]);
			 try {
				 //the user should always be able to type in new command 
				 while (true) {
					//store the user's next input as a string 
					String action = scanner.nextLine();
				 		
				 	if (action.equals("A")) {
				 		//get the next name in the name file 
				 		String addname = LineScanner.readNextLine();
				 		//if there are no more names in the name file 
				 		if (addname==null) {
				 			System.out.println("Please add more name to the name file.");
				 		}
				 		//if the name the user wants to add is already in the roster
				 		else if (roster.contains(addname)) {
				 			System.out.println("The name ' "+ addname +
						       " ' you trying to add is already on the roster");
				 		}
				 		//if the roster is not full yet 
				 		else if (roster.count<maxNum) {
				 			
				 			roster.add(addname);
				 		}
				 		else {
				 			//if the waitlist is more than one name away form the max
				 			//or there are already two rosters
				 			if (waitList.count<maxNum-1 || hasSecondRoster ) {
				 				
				 				waitList.add(addname);
				 				
				 			}
				 			else if (waitList.count==maxNum-1){
				 				//add the name to the wait list 
				 				//so that the number of names in the wait = max
				 				waitList.add(addname);
				 				//copy the names in the wait list to the roster2	
				 				for (int i=0; i<maxNum;i++) {
				 					roster2.add(waitList.head.getValue());
				 					waitList.remove(0);
				 					
				 				}
				 				//print out a helper message for users
				 				System.out.println("Cause the number of people "+ 
				 				"on the wait reachs the maxium number of a roster"+
				 				"one more roster is created");
				 				//since we already have the second roster 
				 				hasSecondRoster = true;
				 			}
				 				
				 		}
				 			
				 	}
				 		//else if (charArray[i]=='R') {
				 	else if (action.equals("R")) {
				 		DoublyLinkedListNode<String> CurNode = roster.head;
				 		DoublyLinkedListNode<String> CurNode2 = roster2.head;
				 		//the name to remove 
				 		String removeName = LineScanner.readNextLine();
				 		//if the roster is empty 
				 		if (roster.head==null) {
				 			System.out.println("The roster is empty, "
				 						         + "please add name first");
				 		}
				 		//if the name to remove is not in the rosters
				 		else if (!roster.contains(removeName) 
				 				&& !roster.contains(removeName)) {
				 			System.out.println("The name ' "+ removeName +
				 			   " ' you trying to remove is not on the roster");
				 		}
				 		//if the name to remove is on the first roster
				 		else if(roster.contains(removeName)){
				 			//remove the name from the roster 
				 			while (CurNode!=null) {
					 			if (CurNode.getValue().equals(removeName)) {
					 				roster.remove(roster.getIndex(CurNode));
					 			}
					 			CurNode=CurNode.getNext();
				 			} 
				 			//if there are names in the waitlist add it to the roster
					 		if (waitList.head!=null) {
					 			roster.add(waitList.head.getValue());
					 			waitList.remove(0);
					 		}
				 		}
				 		//if the name to remove is on the second roster
				 		else if(roster2.contains(removeName)){
				 			//remove the name from the roster 
				 			while (CurNode2!=null) {
					 			if (CurNode2.getValue().equals(removeName)) {
					 				roster2.remove(roster2.getIndex(CurNode2));
					 			}
					 			CurNode2=CurNode2.getNext();
				 			} 
				 			//if there are names in the waitlist add it to the roster
					 		if (waitList.head!=null) {
					 			roster2.add(waitList.head.getValue());
					 			waitList.remove(0);
					 		}
				 		}
				 			
				 	}
				 		
				 	else if (action.equals("D")) {
				 		//sort the roster then print it 	
				 		roster=sorter.sortAlphabetical(roster);
				 		System.out.println("Roster: \n"+roster.toString());
				 		//if roster2 has name in it sort it then print 
						if (roster2.head!=null) {
							roster2=sorter.sortAlphabetical(roster2);
							System.out.println("Roster2: \n"+roster2.toString());		
						}
						//if wait list has name in it print it 
						if (waitList.head!=null) {
							System.out.println("Waitlist: \n" + waitList.toString());
								
						}							
				 	}				 		
				} 				 	
			} catch (IOException e) {
				System.out.print("IOException");					
			}
		} catch (FileNotFoundException e1) {
			System.out.print("FileNotFoundException");
		}
	}
}

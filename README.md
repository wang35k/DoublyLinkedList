# DoublyLinkedList
This is one of my homework of the Data Structure class. 
The program HW1.java will handle the addition and removal of students to a class roster and associated wait list. 
The program have the following capabilities:
1.Ask the user to specify the maximum size for the class roster
2.Make it possible for the user to use the following commands to manage the class: 
    a.user types A to add a student to the class
    b.user type R to remove a student from the class
    c.user types D to display the roster and wait list (but do not display the wait list if it is empty)
3.The roster is in alphabetic order at all times. 
4.If the roster reaches the specified maximum size, students added subsequently should be added to a second list, 
  the “wait list”. The wait list is not alphabetized. 
5.If a student is removed from a full roster, dropping it below the maximum size, the first student on the waitlist 
  should be added to the roster (in correct alphabetical order) and removed from the waitlist.  
  There is no way to explicitly remove a student from the wait list otherwise.  
6.All student names on the roster and wait list should be displayed in the form “Lastname, Firstname”

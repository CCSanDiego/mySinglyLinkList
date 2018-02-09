import java.util.LinkedList;
import java.util.Scanner;

public class mySinglyLinkedList<E> { //Generic

	  Node head;              //Head of List Node.

	  public mySinglyLinkedList() {
		  head = new Node();
	  }
	    class Node {
	    	
	        E data;
	        Node next;       
	        
	 public Node() {
		 data = null; 
		 next = null;
	 }	  	   

	 public Node(E newData, int index) { //Empty
		 Node current = head;
		 int counter = 1;
		 while(counter-1 !=index) {
			 current = current.next;			 
		 }	
		 data = newData;
		 this.next = current.next;
		 current.next = this;
	 		}
	 }
	    
		public int getSize() {
			Node temp = head;
			int count = 1;
			while (temp != null)
			{
				count++;
				temp = temp.next;
			}
			return count;
		}
	    
	public void push(E item) {    //Add at the beginning
		  
		  Node newNode = new Node();
		  newNode.data = item;
		  
		  if(head == null) {
			  head = new Node();
			  head.next = newNode;
			  return;
		  }
		  newNode.next = head.next;
		  head.next = newNode;
	  }
	
	public void insertAfter(E item, int index) {    //Add in between
		
			Node newNode = new Node();
			newNode.data = item;
			newNode.next = null;			
		
			if (index == 0) {
				push(item);
			}
			else {
			Node tempHead = head;
			for(int i=0; i< index; i++) {
				tempHead = tempHead.next;				
			}
			newNode.next = tempHead.next;
			tempHead.next = newNode;
			}
		}	
	
	  public void append(E item) {     //Add after the last 
		
		  	Node newNode = new Node();
		  	 newNode.next = null;
		  	 newNode.data = item;
		  	 Node tail = head;		  			  	
		  	while(tail.next !=null)
		  		tail = tail.next;
		  		tail.next = newNode;
		  		return;
		}
	  
	    void deleteFirst() {   //Remove from the list/first
	       	   
	        if (head == null) {
	        	return;
	        }	 
	        if (head != null){
	        head = head.next;
	        }
	    }
	    void deleteLast() {    //Remove from the list/last
	    	   Node newNode = head;
	    	   Node end = null;
	    	   while(newNode.next != null) {
	    		   end = newNode;
	    		   newNode = newNode.next;
	    	   }
	    	   end.next = null;
	    }
	     
	    void delete(int index) {     //Remove from the list/inside
	    	if(index == 0) {
	    		deleteFirst();
	    		}
	    	else {
	    		Node tempHead = head;
	    		Node deleteNode = null;
	    		for(int i=0; i<index; i++) {
	    			tempHead = tempHead.next;
	    		}
	    		deleteNode = tempHead.next;
	    		tempHead.next = deleteNode.next;
	    		System.out.println("Delete: " + deleteNode.data);
	    		deleteNode = null;
	    		}	    			  
	   }
	    	    
	    public void change(E item, int index){     // Function to change an item 
    
	    	Node current = head.next;
	    	int counter = 0;
	    	while(counter != index) {
	    		current = current.next;
	    		counter++;
	    	}
	    	System.out.println("This is the name to be change: " + current.data);
	    	current.data = item;
	  }

	    public void traverse() {
			
			Node current = head.next;
			while(current.next !=null) {
				System.out.println(current.data);
				current = current.next;
			}
				System.out.println(current.data);
	  }	
	
	    public static void main(String[] args) { 
	 
	  mySinglyLinkedList<String> llist = new mySinglyLinkedList<String>();
	  
	  			System.out.println("My list is: ");  //Print the list
	  			llist.push("Juan");
	  			llist.push("Pedro");
	  			llist.push("Maria");
	  			llist.push("Tom");
	  			llist.traverse();

	  			System.out.println("\nMy list with last: "); // Add at End
	  			llist.append("Carlos");
	  			llist.append("Rosa");
	  			llist.traverse();
	  			
	  			System.out.println("\nMy list with new name: ");	// Add Pepe at [3]  			
	  			llist.insertAfter("Pepe",3);
	  			llist.traverse();
	  			
	  			System.out.println("\nMy list with out: ");	 // Delete the first+last+[3]			
	  			llist.deleteFirst();
	  			llist.deleteLast();
	  			llist.delete(3);
	  			llist.traverse();

	  			System.out.println("\nMy list with the new name after change: "); //Change 	  			
	  			llist.change("Fernando",3);
	  			llist.change("Paulina", 0);
	  			llist.traverse();
	  			
	  			System.out.println("\nThe size of Linked List is: " + llist.getSize());
	    } 
	  
}
	  
		  
	  

    

	
	
	
	
	
	
	
	
	
	

/*
 * singly linked list of integers
 *
 * CSI2510 Algortihmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2017
 *
*/
public class SimpleLinkedList {

  private class Node {
  
    public int element;
	public Node next;
	
	public Node(int v, Node p) { 
	  element= v;
	  next= p;
	}
  }
 
  private Node head; 
  private int size;

 
  // construct empty list
  public SimpleLinkedList() {
       
	head= null;
	size= 0;
  }
  
  // get the list size
  public int getSize() {
  
	return size;
  }

  // add a new integer (most efficient)
  public boolean add(int value) {

    Node newNode= new Node(value, head);
	head= newNode;
		
	size++;
	
    return true;
  }
  
   // add a new integer (least efficient)
  public boolean addOppositeSide(int value) {
 
    Node newNode= new Node(value, null);
	
	if (head == null) {
	  head= newNode;
	
	} else {
	
	  Node n= head;
	  
	  while (n.next!=null) {
	    n= n.next; 
	  }
	  
	  n.next= newNode;
	}
	
	size++; 
	
    return true;
  }

  // search if a given integer is in the array
  public boolean search(int value) {

    Node n= head;
	
    while (n!=null && n.element!=value)
	  n= n.next;
	  
	if (n==null)
	  return false;
	else 
	  return true;
  }

  // remove a given integer (first occurrence of)
  public boolean searchAndRemove(int value) {

    if (head.element == value) {
	  head= head.next;
	  size--;
	  return true;  
	}
	
	Node n= head.next;
	Node p= head;
	
    while (n!=null && n.element!=value) {
	  p= n;
	  n= n.next;
	}

    if (n!=null) {

	  p.next= n.next;
	  n.next= null;
	  size--;
      return true;
	  
	} else {
	
	  return false;
	}	
  }

  // remove element at a given index
  public boolean removeAt(int index) {

    if (index<0 || index>=size)
	  return false;
	
	size--;
	
	if (index==0) {
	  head= head.next;
	  
	} else {
	
	  Node n= head;
      for (int i=1; i<index; i++)
	    n= n.next;

	  n.next= n.next.next;
	}
	  
	return true;
  }
  
  // return the first element of the list
  public int getFirst() {
  
	return head.element;
  }
  
  // string representation
  public String toString() {
  
    StringBuffer s = new StringBuffer("");
  
    for (Node node= head; node!= null; node= node.next) {
	  s.append("["+node.element+"]");
	}
	
	s.append("("+size+")");
	  
	return s.toString();
  }
  
  public static void main(String[] args) {
  
    SimpleLinkedList list= new SimpleLinkedList();
	
	list.add(34);
	list.add(93);
	list.add(67);
	list.add(23);
	list.add(51);
	System.out.println("A:" + list);
	
	list.addOppositeSide(33);
	System.out.println("B:" + list);
	
	list.searchAndRemove(51);
	System.out.println("C:" + list);
	list.searchAndRemove(67);
	System.out.println("D:" + list);
	
	System.out.println("E1:" + list.search(93));
	System.out.println("E2:" + list.search(11));

	list.removeAt(1);
	System.out.println("F1:" + list);
	list.removeAt(0);
	System.out.println("F2:" + list);
	list.removeAt(list.getSize()-1);
	System.out.println("F3:" + list);
	
  }
}

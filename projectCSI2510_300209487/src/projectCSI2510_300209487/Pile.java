package projectCSI2510_300209487;

import java.util.*;

public class Pile {

	static Stack <String> Pile = new Stack<String>(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pile.add("Andie");
		Pile.add("Erwan");
		Pile.add("Kiswendsida");
		System.out.println(Pile.firstElement());//Andie
		System.out.println(Pile.peek());//Kiswendsida 
		Pile.pop();//
		System.out.println(Pile.peek());//Erwan
		Pile.get(0);
		Pile.get(1);
		System.out.println(Pile.get(0));
		System.out.println(Pile.get(1));
		

	}

}

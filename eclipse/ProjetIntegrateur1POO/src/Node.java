import java.util.ArrayList;

/*
 * Nom : Andie SAMADOULOUGOU
 * NE : 300209487
 * */
public class Node {

	public static ArrayList<String> liste ;
	int capacity ;
	double value ;
	Node left ;
	Node right ;
	Node(int capacity , double  value)
	{
		this.left = null;
		this.right = null;
		this.capacity = capacity;
		this.value = value;
		this.liste = new ArrayList<String>();
	}
	 
	
	
}

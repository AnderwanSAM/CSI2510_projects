import java.util.ArrayList;

/*
 * Nom : Andie SAMADOULOUGOU
 * NE : 300209487
 * */
/*La classe se nomme arbre mais en fait, si l'on se refere a l'arbre binaire parfait global,
 * Cette classe represente un sous arbre 
 * 
 * Construire un arbre binaire gardant a tout moment toutes les possibilités deviendrait trop grand 
 * pour etre garde en memoire si les possibilitees sont trop nombreuses.
 * Par consequent, Une fois que les feuilles d'un arbre sont toutes crees de nouveaux arbres seront crees
 *  avec comme racine ces feuilles et les anciens parents seront supprimés  
 * */
public class Arbre {
	
	 Node root ;
	
	Arbre()
	{
		root = null ;
	}
	
	public void setRoot(Node n) 
	{
		root = n ;
	}
	public Node getRoot() 
	{
		return root ;
	}
	public  void addLeft(Node n ) 
	{
		root.left = n ;
	}
	public  void addRight(Node n) 
	{
		root.right = n ;
	}
	public  Node getLeft() 
	{
		return root.left;
	}
	public Node getRight() 
	{
		return root.right;
	}
	
}

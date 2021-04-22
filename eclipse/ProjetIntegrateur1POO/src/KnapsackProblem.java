import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Nom : Andie SAMADOULOUGOU
 * NE : 300209487
 * */
//version Force brute 

/*Note : 
 *  Un arbre binaire gardant a tout moment toutes les possibilités deviendrait trop grand 
 * pour etre garde en memoire si les possibilitees sont trop nombreuses.
 * Par consequent, Une fois que les feuilles d'un arbre sont toutes crees,
 *  de nouveaux arbres seront crees
 *  avec comme racine ces feuilles et les anciens parents seront supprimés car on a plus besoin d'eux
 *   pour continuer le traitement
 *  Une fois les nouveaux sous arbres(sous arbres crees), les adresses des racines sont stockees dans la
 *   liste Subtrees_list 
 *   
 *   En somme, on profite de la structure de l'arbre sans avoir a se souvenir de tout ses elements
 * */

public class KnapsackProblem {

	// variables 
	
	//variables du probleme
	public static List <Item> Item_list = new ArrayList<Item>();
	public static Knapsack knapsack = new Knapsack();
	
	//variables pour la resolutions
	
	/*une liste qui contiendra a chaque moment les racines
	 *  des arbres avec lesquels on travaille*/
	public static LinkedList<Arbre> Subtrees_list = new LinkedList<Arbre>(); 
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file_name;
		try {
			file_name = args[0];
		}
		catch( Exception e)
		{
			file_name = "C:\\Users\\erwan\\OneDrive\\Documents\\ApprenonsJava\\eclipse\\ProjetIntegrateur1POO\\src\\Entry.txt";
		}

		getData(file_name);
		
		process(file_name);
		//saveData(file_name); save se fait appeler dans process
	}

	//Methode (s) de traitement
	
	public static void process(String file_name) throws IOException 
	{
		int nb_de_niveaux = Item_list.size();
		//pour chaque niveau,
		for(int i =0 ; i < nb_de_niveaux  ; i++) 
		{
			if (i == 0 ) // on est au debut 
			{
				//creer les deux premieres feuilles 
				Node N = new Node(knapsack.getWeight(),0);
				Arbre temp = new Arbre();
				temp.setRoot(N);
				//le choix positif
				Node a = new Node(knapsack.getWeight()-Item_list.get(0).getWeight(),Item_list.get(0).getValue());
				a.liste.add(Item_list.get(0).getName());
				temp.addLeft(a);
				temp.addRight(new Node(knapsack.getWeight(),0));
				Subtrees_list.add(temp);
			}
			else 
			{
				//System.out.println("Niveau "+ i);
				//pour chaque arbre present dans la liste des sous arbres ,
				int nb = Subtrees_list.size();
				//System.out.println("Debut  = Nombre d'arbres " + nb);
				for(int j =0 ; j < nb ; j++) 
				{
					
					//Acceder a ses feuilles 
					Node left = Subtrees_list.get(j).getLeft();
					Node right = Subtrees_list.get(j).getRight();
					 
					
					//transformer ses feuilles en racines d'arbres 
					Arbre temp_left = new Arbre();
					Arbre temp_right = new Arbre();
					temp_left.setRoot(left);
					temp_right.setRoot(right);
					//ajouter de nouvelles feuilles aux nouveaux arbres 
					 //les feuilles qui refusent le nouvel objet
					Node Nope1 = new Node(left.capacity,left.value);
					Node Nope2 = new Node(right.capacity,right.value);
					    //les feuilles qui acceptent le nouvel objet
					Node t1 = new Node(left.capacity-Item_list.get(i).getWeight(),Item_list.get(i).getValue()+left.value);
					Node t2 = new Node(right.capacity-Item_list.get(i).getWeight(),Item_list.get(i).getValue()+right.value);
					//mettre a jour leur liste en copiant celle du parent et en ajoutant le nouvel objet
					for(int v = 0 ; v < left.liste.size();v++) 
					{
						t1.liste.add(left.liste.get(v));
						Nope1.liste.add(left.liste.get(v));
					}
					for(int v = 0 ; v < left.liste.size();v++) 
					{
						t2.liste.add(right.liste.get(v));
						Nope2.liste.add(right.liste.get(v));
					}
					t1.liste.add(Item_list.get(i).getName());
					t2.liste.add(Item_list.get(i).getName());
					temp_left.addLeft(t1);
					temp_right.addLeft(t2);
					//mettre a jour leurs listes d'objet en copiant celle du parent 
					
					temp_left.addRight(Nope1);
					temp_right.addRight(Nope2);
					//ajouter les nouveaux arbres a la SubtreesList 
					Subtrees_list.add(temp_left);
					Subtrees_list.add(temp_right);
					
				
				}
				//System.out.println("FIN  = Nombre d'arbres " + Subtrees_list.size());
				//Retirer les anciens arbres 
				for (int k =0 ; k < nb ; k++) 
				{
					Subtrees_list.removeFirst();
				}
				System.out.println("FIN  = Nombre d'arbres " + Subtrees_list.size());
			}
			
		
		}
		//Une fois tous les niveaux traites, on est au dernier niveau, il reste a determiner la meilleure solution 
		//Parcourir la liste des sous arbres pour retirer tout ceux qui des capacites negatives 
		int count = Subtrees_list.size();
		for (int b = 0 ; b< count ; b++) 
		{
			//System.out.println("Sous arbre  "+ b );
			//System.out.println( "Left Capacity "+ Subtrees_list.get(b).getLeft().capacity + " Value : " + Subtrees_list.get(b).getLeft().value);
			//System.out.println( "Right Capacity "+ Subtrees_list.get(b).getRight().capacity + " Value : " + Subtrees_list.get(b).getRight().value);
			
			
		}
		List<Integer> recordLeft = new ArrayList<Integer>(); //recueillir les index des arbres ayant une feuille gauche a capacite positive
		List<Integer> recordRight = new ArrayList<Integer>(); //recueillir les index des arbres ayant une feuille droite  a capacite positive
		//Determiner les feuilles aux capacites positives
		for(int c = 0; c<count ; c++) 
		{
			if (Subtrees_list.get(c).getLeft().capacity >= 0) 
			{
				recordLeft.add(c);
			}
			if (Subtrees_list.get(c).getRight().capacity >= 0) 
			{
				recordRight.add(c);
			}
		}
		//Determiner les maximum parmi les feuilles gauches et les feuilles droites
		int IndexMaxLeft = recordLeft.get(0);
		for(int t = 0 ; t < recordLeft.size(); t++) 
		{
			if (Subtrees_list.get(recordLeft.get(t)).getLeft().value > Subtrees_list.get(IndexMaxLeft).getLeft().value) //nouveau maximum
			{
			IndexMaxLeft = recordLeft.get(t) ; 	
			}
		}
		int IndexMaxRight = recordRight.get(0);
		for(int t = 0 ; t < recordLeft.size(); t++) 
		{
			if (Subtrees_list.get(recordRight.get(t)).getRight().value > Subtrees_list.get(IndexMaxRight).getRight().value) //nouveau maximum
			{
			IndexMaxRight = recordRight.get(t) ; 	
			}
		}
		//Determiner lequels des sous arbres  a la plus grand valeur et sauvegarder la solution
		ArrayList<String>  selected_items = new ArrayList<String>();
		int final_capacity =0;
		double final_value =0 ;
		if(Subtrees_list.get(IndexMaxLeft).getLeft().value > Subtrees_list.get(IndexMaxRight).getRight().value) 
		{
			selected_items = Subtrees_list.get(IndexMaxLeft).getLeft().liste;
			final_capacity = Subtrees_list.get(IndexMaxLeft).getLeft().capacity;
			final_value = Subtrees_list.get(IndexMaxLeft).getLeft().value;
		}
		else 
		{
			selected_items = Subtrees_list.get(IndexMaxRight).getRight().liste;
			final_capacity = Subtrees_list.get(IndexMaxRight).getRight().capacity;
			final_value = Subtrees_list.get(IndexMaxRight).getRight().value;
			
		}
		//Sauvegarde de la solution
		//appeller save 
		System.out.println("Solution");
		System.out.println(final_value);
		for(int h = 0 ; h< selected_items.size(); h++) 
		{
			System.out.print(selected_items.get(h) + " " );
		}
		saveData(file_name,selected_items,final_value);
	}
	
	
	
	//Methodes de lecture et de sauvegarde 
		public static void getData(String nom_de_fichier) throws FileNotFoundException 
		{
			File file = new File(nom_de_fichier);
			Scanner scan = new Scanner(file);
			//lecture du nombre d'objets 
			String a = scan.nextLine();
			int number_of_items = Integer.parseInt(a.trim());
			//System.out.println(number_of_items);
			//pour chaque objet,
			for(int i =0 ; i < number_of_items; i++) 
			{
				
				//lire l'information
				String jeton  = scan.nextLine();
				//Separer le nom , le poids et la valeur 
				String[] tab = jeton.split(" ");
				double value = Integer.parseInt(tab[1]);
				int weight = Integer.parseInt(tab[2]);
				Item objet = new Item(tab[0],value,weight);
				//ajout
				Item_list.add(objet);
				objet = null;
			}
			int w = Integer.parseInt(scan.nextLine().trim());
			knapsack.setWeight(w);
			
		}
		
		public static void saveData(String nom_de_fichier , ArrayList<String> selected_items, double final_) throws IOException
		{
			String [] tab = nom_de_fichier.split(".txt");
			System.out.println(tab.length);
			PrintWriter writer = new PrintWriter(new FileWriter((tab[0]+".sol"),true));
			writer.println(final_);
			for(int h = 0 ; h< selected_items.size(); h++) 
			{
				writer.print(selected_items.get(h) + " " );
			}
			writer.close();
		}
		
}

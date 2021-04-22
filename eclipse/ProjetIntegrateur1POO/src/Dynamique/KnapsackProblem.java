package Dynamique;

/*
 * Nom : Andie SAMADOULOUGOU
 * NE : 300209487
 * */



/*
 * Je me suis inspire de l'article auquel le lien des instructions fait référence : 
 * https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapsackProblem {

	public static List <Item> Item_list = new ArrayList<Item>();
	public static Knapsack knapsack = new Knapsack();
	
	/*la KTable contient les  instances des sacs qui seront utilisés
	 * La taille est determinée en fonction du nombre d'objets que l'on devra tester et du poids 
	 * Ainsi pour des tests avec x objets et une capacite de y pour le sacs, on va tester x*y sacs 
	 * Pas la peine de tester avec les sacs de fwpacite nulle car le resultat est deja connu 
	 *  */
	public static Knapsack [] KTable;
	//une table auxiliere qui permettra de traiter les donner en remplissant les resultats dans les sacs 
		static int [][] table_auxiliaire; //= new int[Item_list.size()+1][knapsack.getWeight()+1];
	
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
		
		//
		table_auxiliaire = new int[Item_list.size()+1][knapsack.getWeight()+1];
		KTable =  new Knapsack[Item_list.size()*knapsack.getWeight()];
		for(int i = 0 ; i <(Item_list.size()*knapsack.getWeight()); i++) 
		{
			KTable[i] = new Knapsack();
			
		}
		
            
		
		process();
		saveData(file_name);
	}
	
	
	//Methode de traitement 
	
	public static void process() 
	{
	
		//Donner aux sacs leurs capacites . Le nombre de sacs ayant la meme capacite est egal au nombre d'objet 
		for(int c =0 ; c < knapsack.getWeight() ; c++) 
		{
			for(int i = 0 ; i < Item_list.size() ; i++) 
			{
				KTable[i] = new Knapsack();
				KTable[i].setWeight(c);
			}
			
		}
		//Remplissage des sacs 
		 //mise a jour des premiers niveaux de la table auxiliaire
		for (int r = 0; r < knapsack.getWeight()+ 1; r++) {
		    table_auxiliaire[0][r] = 0;
		}
		for (int c = 0; c < Item_list.size() + 1; c++) {
		    table_auxiliaire[c][0] = 0;
		}
		
		  for (int item = 1; item <= Item_list.size(); item++) {
	            for (int capacity = 1; capacity <= knapsack.getWeight(); capacity++) {
	                int maxValWithoutCurr = table_auxiliaire[item - 1][capacity]; 
	                int maxValWithCurr = 0; //Initialisation a   0
	                
	                int weightOfCurr =  Item_list.get(item-1).getWeight(); // item -1 permet de contourner le probleme de la range suplemeentaire inutile
	                if (capacity >= weightOfCurr) { // Verifier que l'objet peut entrer dans le sac 
	                    maxValWithCurr = (int) Item_list.get(item-1).getValue(); // Si c'est le cas, alors maxValWithCurr est au moins egale a celle de l'objet que l'on essai d'utiliser 
	                    
	                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity doit etre au moins  0
	                    maxValWithCurr += table_auxiliaire[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
	                }
	                
	                table_auxiliaire[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
	                 // Trouver le bon sac et y inserer les objets 
	                int Indice_du_sac = (capacity - 1 ) * Item_list.size() + item  - 1;
	                //Mettre a jour la valeur
	                KTable[Indice_du_sac].setValue(table_auxiliaire[item][capacity]);
	                //determiner les objets
	                //apres la boucle
	            }
	        }
		  //Parcourir la table auxiliere afin de mettre ajour les sacs avec les elements inseres 
		  //Enfin seule la derniere colonne est necessaire pour resoudre le probleme
		  /*for(int i = 0 ; i < Item_list.size(); i++) 
		  {
			  for(int j = 1 ; j < knapsack.getWeight(); j++) 
			  {
				  if( table_auxiliaire[i +1 ][j] == Item_list.get(i).getValue()|| table_auxiliaire[i+ 1][j] == Item_list.get(i).getValue() + table_auxiliaire[i][j] ) 
				  {
					  //ajouter l'objet 
					  KTable[(j-1)*Item_list.size() + (i+ 1)].objects.add(Item_list.get(i));
					  
				  }
			  }
		  }*/
		  int count = 0;
		  for(int i = KTable.length-Item_list.size() ; i < KTable.length ; i++ ) 
		  {
			  if(i ==  KTable.length-Item_list.size() ) 
			  {
				  if (Item_list.get(count).getWeight() < KTable[i].weight) 
				  {
					  KTable[i].objects.add(Item_list.get(count));
				  }
			  }
			  else 
			  {
				  if (KTable[i].getValue() == Item_list.get(count).value) //alors , seul cet objet s'y trouve 
				  {
					  KTable[i].objects.add(Item_list.get(count));
				  }
				  else if(KTable[i].getValue() > Item_list.get(count).getValue()) //alors cet objet et l'objet precedent sont dans le sac 
				  {
					  //ajouter les anciens 
					  for(int j =0 ; j < KTable[i-1].objects.size(); j++) 
					  {
						  KTable[i].objects.add(KTable[i-1].objects.get(j));
					  }
					  //ajouter le nouveau
					  KTable[i].objects.add(Item_list.get(count));
				  }
				  else {}
			  }
			  count+=1;
		  }
		  //la methode Save accedera au dernier sac et utilisera ses donnes 
		
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
			public static void saveData(String nom_de_fichier) throws IOException
			{
				String [] tab = nom_de_fichier.split(".txt");
				System.out.println(tab.length);
				PrintWriter writer = new PrintWriter(new FileWriter((tab[0]+".sol"),true));
				writer.println(KTable[KTable.length-1].getValue());
				for(int i =0 ; i < KTable[KTable.length-1].objects.size(); i++) 
				{
					writer.print(KTable[KTable.length-1].objects.get(i).name + " ");
				}
				writer.close();
			}
}

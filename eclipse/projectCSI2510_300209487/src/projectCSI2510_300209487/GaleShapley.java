package projectCSI2510_300209487;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.*; 
import java.util.Comparator;
import java.util.PriorityQueue;

public class GaleShapley {

	private static String path ;
	static Stack <String> Sue = new Stack<String>(); 
	static Stack <Employer> Suep = new Stack<Employer>();
	public static int nombre = 3; 
	//static int[] students ;
	//static int [] employers; 
	//static int [][] matrice ;
	static String [] Liste_etudiants;
	static Comparator comparator = new ComparateurDeCle();
	static PriorityQueue<Entry> PQ = new PriorityQueue<Entry>(10, comparator);
	
	GaleShapley(String absolute_path)
	{
		path = absolute_path;
		// lecture des informations du fichier texte 
		BufferedReader lecteur;
		try {
			lecteur = new BufferedReader(new FileReader(absolute_path));
			//lire la premiere ligne correspondant au nombre n et le convertir en int 
			String line = lecteur.readLine();
			String n = line;
			
			nombre = Integer.parseInt(n);	
			
			lecteur.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int [][] employers_rankings = new int[nombre][nombre];
	  static int[] students = new int[nombre];
	  static int [] employers = new int [nombre];
	  static int [][]  matrice = new int [nombre][nombre];
	public static void Initialize() 
	{
	
		// lecture des informations du fichier texte 
				BufferedReader lecteur;
				try {
					lecteur = new BufferedReader(new FileReader(path));
					//lire la premiere ligne correspondant au nombre n et le convertir en int 
					String line = lecteur.readLine();
					
					
					for (int i =0 ; i < nombre ; i++) 
					{
						//Lire et empiler les employeurs 
						line = lecteur.readLine();
						Sue.add(line);
						Employer d = new Employer(i,line);
						Suep.add(d);
					}
					//initialiser les tableaux 
					 
					 for ( int i =0 ; i < nombre ; i++) 
					 {
						 students[i] = employers[i] = (-1) ; 				 
					 }
					 
					 // recueillir les informations sur les etudiants 
					 for (int i = 0 ; i< nombre ; i++) 
					 {

						 line = lecteur.readLine();
						 
						// Liste_etudiants[i] = line ; 
					 }

					 lecteur.close();
					 //lire les informations de la matrice
					 File file = new File(path); 
					    Scanner sc = new Scanner(file); 
					    String jeton ;
					     //int [][] employers_rankings = new int[nombre][nombre]; //un tableau pour recueillir les 
					    
					    for (int i = 0 ; i < (2* nombre + 2); i++) {sc.next();}
					    for (int i =0 ; i < nombre; i++) 
					    {
					    	for (int j =0 ; j < nombre ; j++ )
					    	{
					    		//lire un element 
						    	jeton = sc.next();
						    	//le diviser 
						    	String fragments [] = new String [2];
						    	fragments = jeton.split(",",2);
						    	//System.out.println(fragments[0]);
						    	
						    	int temp = Integer.parseInt(fragments[fragments.length-1]);
						    	//Inserer les parties dans la matrice	// students ranking 		    
						         matrice[i][j] = temp;
						         //insertion dans la file de priorité
						         int rank = Integer.parseInt(fragments[0]) ;
						         employers_rankings[i][j] = rank;					        
						         
					    	}
					    	
					    }
					  
					     
					//lecteur.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// insertion dans la file de priorité
				for (int s =0 ; s < nombre ; s++) 
				{
					for(int er =0 ; er<nombre ; er++) 
					{
						Entry E = new Entry(employers_rankings[s][er],0);
						PQ.add(E);
					}
				}
				
	}
	
	public static int [] Execute() {
		
		/*
		 *  while ( !Sue.empty() )
o e= Sue.pop() // e is looking for a student
o s= PQ[e].removeMin() // most preferred student of e
o e’= students[s]
o if (students[s] == -1) // student is unmatched
 students[s]= e
 employers[e]= s // match (e,s)
o else if (A[s][e] < A[s][e’]) // s prefers e to employer e’
 students[s]= e
 employers[e]= s // Replace the match
 employers[e’]= -1 // now unmatched
 Sue.push(e’)
o else s rejects offer from e
 Sue.push(e)
 return the set of stable matches

		 * */
		int  s;
		int  e ;
		Entry temp;
		Employer t ;
		int e_p ; // une variable pour garder la valeur numerique de l'employeur
		//e_p = nombre ;
		while(!Sue.empty()) 
		{
			
			/*e = Sue.pop();
			e_p -=1;*/
			t = Suep.pop();
			e = t.position;
			temp = PQ.remove();
			s = temp.value;
			int e1 = students[s];
			if (students[s] == -1 )
			{
				students[s] = e;
				employers[e] = s;
			}
			else if (matrice[s][e] < matrice[s][e1]) 
			{
				students[s]  =e;
				employers[e1] = -1;
				Employer emp = new Employer(e1,"none");
				Suep.push(emp);
			}
			else 
			{
				Employer x = new Employer(e,t.name);
				Suep.push(x);
			}
			
		}
		
		return employers;
	}
	
	
	
	
	public static void main(String[] args) {
		GaleShapley a = new GaleShapley("C:\\\\Users\\\\erwan\\\\OneDrive\\\\Documents\\\\ApprenonsJava\\\\CSI2510\\\\EssaiLectureFichier.txt");
		a.Initialize();
		int []set = a.Execute();
		int n = a.nombre;
		for (int i =0 ; i < n;i++) 
		{
			System.out.println("set ["+ i+ " ] = " +  set[i]); 
		}
		
		
	}
	
	
	
}

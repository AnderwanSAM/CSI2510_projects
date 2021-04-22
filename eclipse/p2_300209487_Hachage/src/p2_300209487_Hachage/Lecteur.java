package p2_300209487_Hachage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Lecteur {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\erwan\\OneDrive\\Documents\\ApprenonsJava\\eclipse\\p2_300209487_Hachage\\src\\p2_300209487_Hachage\\input2.txt"));
		String  line = in.readLine();
		
		int nombre_de_file = Integer.parseInt(line);
		//System.out.println(nombre_de_file);
		int longueur_traversier;
		//creer une liste pour les vehicules
		ArrayList<Integer> liste ; //= new ArrayList<Integer>();
		for(int i =0 ; i< nombre_de_file; i++) 
		{
			liste = new ArrayList<Integer>();
			//lire la longueur du traversier
			String jeton = "";
			jeton = in.readLine();
			jeton = in.readLine();
			
			longueur_traversier = Integer.parseInt(jeton);
			int a = -1 ;
			//tant que ce n'est pas 0, enregistrer les reponses 
			while( a != 0) 
			{
				//lire le jeton
				jeton = in.readLine();
				//le convertir en integer
				a = Integer.parseInt(jeton);
				if(a == 0) { break ;}
				liste.add(a);
			}
			for(int j =0 ; j < liste.size(); j++) 
			{
				System.out.println(liste.get(j));
			}
			liste = null;
			System.out.println("----");
		}
		
		/*while ((line = in.readLine()) != null)
		{
	      // Afficher le contenu du fichier
			  System.out.println (line);
		}*/
		in.close();
		
		
	}

}

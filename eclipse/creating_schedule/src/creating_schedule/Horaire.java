package creating_schedule;

import java.util.ArrayList;
import java.util.List;

/*
 * Un horaire est un composee de 5 cours qui ne sont pas en conflit 
 * */
public class Horaire {
	Horaire(){};

	public static List<Cours> schedule = new ArrayList<Cours>();
	
	public static void afficher_horaire() 
	{
		int nbr_fr = 0; 
		int nbr_en = 0;
		for ( int j =0 ; j< 3; j++) {System.out.println(" ");}
		System.out.println("================================");
		System.out.println("Nouvel Horaire");
		System.out.println(" ");
		for (int i = 0 ; i < schedule.size();i++) 
		{
			if(schedule.get(i).getLangue().equalsIgnoreCase("fr")) {nbr_fr++;}
			else if (schedule.get(i).getLangue().equalsIgnoreCase("en")) {nbr_en++;}
			else {}
			System.out.println("Nbr de cours : " + schedule.size());
			System.out.println(" ");
			schedule.get(i).afficher_le_cours();
			for ( int j =0 ; j< 3; j++) {System.out.println(" ");}
		}
		System.out.println("================================");
	}
}

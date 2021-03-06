package creating_schedule;

import java.util.Scanner;
public class Cours {

	Timeslot CoursMagistral ;
	Timeslot CoursMagistral2;
	Timeslot DGD;
	Timeslot Laboratoire;
	Timeslot Tutoriel;
	String  langue;
	String nom ;
	int rang ; 
	Scanner input  = new Scanner(System.in);
	
	boolean dgd = false ; boolean  tutoriel = false ; boolean  laboratoire = false; boolean second_cours_M = false ;
	Cours()
	{
		System.out.println("Entrez le rang du cours ");
		this.rang=  Integer.parseInt(input.nextLine());
		System.out.println("Nom du Cours : ");
		this.nom = input.nextLine();
		System.out.println("Bonjour Veuillez entrer les informations de votre cours Magistral 1  : ");
		this.CoursMagistral = Initialiser();
		System.out.println("Avez vous un 2nd cours magistral  ? : ");
		String reponse = input.nextLine();
		if(reponse.equalsIgnoreCase("oui")) 
		{
			second_cours_M = true;
			this.CoursMagistral2 = Initialiser();
		}
		else 
		{
			System.out.println("Suivant alors XD ");
		}
		System.out.println("Avez vous un DGD ? : ");
		 reponse = input.nextLine();
		if(reponse.equalsIgnoreCase("oui")) 
		{
			dgd = true;
			this.DGD = Initialiser();
		}
		else 
		{
			System.out.println("Suivant alors XD ");
		}
		System.out.println("Avez vous un Laboratoire ? : ");
		reponse = input.nextLine();
		if(reponse.equalsIgnoreCase("oui")) 
		{
			laboratoire = true ;
			this.Laboratoire = Initialiser();
		}
		else 
		{
			System.out.println("Suivant alors XD ");
		}
		System.out.println("Avez vous un Tutoriel ? : ");
		reponse = input.nextLine();
		if(reponse.equalsIgnoreCase("oui")) 
		{
			tutoriel = true;
			this.Tutoriel = Initialiser();
		}
		else 
		{
			System.out.println("Suivant alors XD ");
		}
		System.out.println("Veuillez entrez la langue du cours : ");
		this.langue = input.nextLine();
		
		
	
		
	}
	

	public Timeslot Initialiser() 
	{
		
		System.out.println("Jour: ");
		String jour = input.nextLine();
		System.out.println("heure Debut | coller les chiffres sans  lettres ");
		String h_d = input.nextLine();
		System.out.println("heure fin | coller les chiffres sans lettres ");
		String h_f = input.nextLine();
		Timeslot a = new Timeslot(jour,h_d,h_f);
		return a ;
	}
	
	public int getRang() 
	{
		return this.rang;
	}
	public void afficher_le_cours() 
	{
		System.out.println("Rang  du cours : " + this.rang);
		System.out.println("Nom du cours " + this.nom);
		System.out.println("langue du cours " + this.langue);
		System.out.println("Jour du Cours magistral 1  " + this.CoursMagistral.getJour());
		System.out.println("Debut du cours Magistral  1  " + this.CoursMagistral.getHeureDebut());
		System.out.println("fin du cours Magistral  1 " + this.CoursMagistral.getHeureFin());
		if (second_cours_M) 
		{
			System.out.println("Jour du Cours magistral 2  " + this.CoursMagistral2.getJour());
			System.out.println("Debut du cours Magistral  2  " + this.CoursMagistral2.getHeureDebut());
			System.out.println("fin du cours Magistral  2 " + this.CoursMagistral2.getHeureFin());
		}
		if(dgd) 
		{
			System.out.println("Jour du DGD   " + this.DGD.getJour());
			System.out.println("Debut du DGD  " + this.DGD.getHeureDebut());
			System.out.println("fin du DGD " + this.DGD.getHeureFin());
		}
		if(laboratoire) 
		{
			System.out.println("Jour du Laboratoire  " + this.Laboratoire.getJour());
			System.out.println("Debut du lab  " + this.Laboratoire.getHeureDebut());
			System.out.println("fin du lab " + this.Laboratoire.getHeureFin());
		}
		if(tutoriel) 
		{
			System.out.println("Jour du Tutoriel  " + this.Tutoriel.getJour());
			System.out.println("Debut du Tutoriel  " + this.Tutoriel.getHeureDebut());
			System.out.println("fin du Tutoriel " + this.Tutoriel.getHeureFin());
		}
	}
	
	boolean getBdgd() {return dgd;};
	boolean getBlab() {return laboratoire;}
	boolean getBsCoursM() {return second_cours_M;}
	boolean getBtutoriel() {return tutoriel;}
	String getLangue() {return langue;};
	
	boolean estEnConflitavec(Cours Autre ) 
	{
		// est en conflit avec Autre cours si : 
		
		//cours magistral 1
		//est en conflit avec cours magistral1 autre 
		if(this.CoursMagistral.estEnConflit(Autre.CoursMagistral)) 
		{
			return true;
		}
		//est en conflit avec cours magistral2 autre si existe 
		if(Autre.getBsCoursM()) 
		{
			if(this.CoursMagistral.estEnConflit(Autre.CoursMagistral2)) 
			{
				return true ; 
			}
		}
		//est en conflit avec DGD autre autre si existe 
		if(Autre.getBdgd()) 
		{
			if(this.CoursMagistral.estEnConflit(Autre.DGD)) 
			{
				return true ; 
			}
		}
		//est en conflit avec tutoriel autre si existe 
		if(Autre.getBtutoriel()) 
		{
			if(this.CoursMagistral.estEnConflit(Autre.Tutoriel)) 
			{
				return true ; 
			}
		}
		//est en conflit avec laboratoire autre si existe 
		if(Autre.getBlab()) 
		{
			if(this.CoursMagistral.estEnConflit(Autre.Laboratoire)) 
			{
				return true ; 
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//cours magistral 2 si existe
		if (this.second_cours_M) 
		{
			if(this.CoursMagistral2.estEnConflit(Autre.CoursMagistral)) 
			{
				return true;
			}
			//est en conflit avec cours magistral2 autre si existe 
			if(Autre.getBsCoursM()) 
			{
				if(this.CoursMagistral2.estEnConflit(Autre.CoursMagistral2)) 
				{
					return true ; 
				}
			}
			//est en conflit avec DGD autre autre si existe 
			if(Autre.getBdgd()) 
			{
				if(this.CoursMagistral2.estEnConflit(Autre.DGD)) 
				{
					return true ; 
				}
			}
			//est en conflit avec tutoriel autre si existe 
			if(Autre.getBtutoriel()) 
			{
				if(this.CoursMagistral2.estEnConflit(Autre.Tutoriel)) 
				{
					return true ; 
				}
			}
			//est en conflit avec laboratoire autre si existe 
			if(Autre.getBlab()) 
			{
				if(this.CoursMagistral2.estEnConflit(Autre.Laboratoire)) 
				{
					return true ; 
				}
			}
		}
				 
	
		//tutoriel si existe 
		if (tutoriel) 
		{
			if(this.Tutoriel.estEnConflit(Autre.CoursMagistral)) 
			{
				return true;
			}
			//est en conflit avec cours magistral2 autre si existe 
			if(Autre.getBsCoursM()) 
			{
				if(this.Tutoriel.estEnConflit(Autre.CoursMagistral2)) 
				{
					return true ; 
				}
			}
			//est en conflit avec DGD autre autre si existe 
			if(Autre.getBdgd()) 
			{
				if(this.Tutoriel.estEnConflit(Autre.DGD)) 
				{
					return true ; 
				}
			}
			//est en conflit avec tutoriel autre si existe 
			if(Autre.getBtutoriel()) 
			{
				if(this.Tutoriel.estEnConflit(Autre.Tutoriel)) 
				{
					return true ; 
				}
			}
			//est en conflit avec laboratoire autre si existe 
			if(Autre.getBlab()) 
			{
				if(this.Tutoriel.estEnConflit(Autre.Laboratoire)) 
				{
					return true ; 
				}
			}
		}
				//est en conflit avec cours magistral1 autre 
				//est en conflit avec cours magistral2 autre si existe 
				//est en conflit avec DGD autre autre si existe 
				//est en conflit avec tutoriel autre si existe 
				//est en conflit avec laboratoire autre si existe 
		
		//DGD si existe 
		if(this.dgd) 
		{
			if(this.DGD.estEnConflit(Autre.CoursMagistral)) 
			{
				return true;
			}
			//est en conflit avec cours magistral2 autre si existe 
			if(Autre.getBsCoursM()) 
			{
				if(this.DGD.estEnConflit(Autre.CoursMagistral2)) 
				{
					return true ; 
				}
			}
			//est en conflit avec DGD autre autre si existe 
			if(Autre.getBdgd()) 
			{
				if(this.DGD.estEnConflit(Autre.DGD)) 
				{
					return true ; 
				}
			}
			//est en conflit avec tutoriel autre si existe 
			if(Autre.getBtutoriel()) 
			{
				if(this.DGD.estEnConflit(Autre.Tutoriel)) 
				{
					return true ; 
				}
			}
			//est en conflit avec laboratoire autre si existe 
			if(Autre.getBlab()) 
			{
				if(this.DGD.estEnConflit(Autre.Laboratoire)) 
				{
					return true ; 
				}
			}
		}
				//est en conflit avec cours magistral1 autre 
				//est en conflit avec cours magistral2 autre si existe 
				//est en conflit avec DGD autre autre si existe 
				//est en conflit avec tutoriel autre si existe 
				//est en conflit avec laboratoire autre si existe 
		
		//laboratoire  si existe 
		if(this.laboratoire) 
		{
			if(this.Laboratoire.estEnConflit(Autre.CoursMagistral)) 
			{
				return true;
			}
			//est en conflit avec cours magistral2 autre si existe 
			if(Autre.getBsCoursM()) 
			{
				if(this.Laboratoire.estEnConflit(Autre.CoursMagistral2)) 
				{
					return true ; 
				}
			}
			//est en conflit avec DGD autre autre si existe 
			if(Autre.getBdgd()) 
			{
				if(this.Laboratoire.estEnConflit(Autre.DGD)) 
				{
					return true ; 
				}
			}
			//est en conflit avec tutoriel autre si existe 
			if(Autre.getBtutoriel()) 
			{
				if(this.Laboratoire.estEnConflit(Autre.Tutoriel)) 
				{
					return true ; 
				}
			}
			//est en conflit avec laboratoire autre si existe 
			if(Autre.getBlab()) 
			{
				if(this.Laboratoire.estEnConflit(Autre.Laboratoire)) 
				{
					return true ; 
				}
			}
		}
				//est en conflit avec cours magistral1 autre 
				//est en conflit avec cours magistral2 autre si existe 
				//est en conflit avec DGD autre autre si existe 
				//est en conflit avec tutoriel autre si existe 
				//est en conflit avec laboratoire autre si existe 
	
		return false ;
	}
	
}

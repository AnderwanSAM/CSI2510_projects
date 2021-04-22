import java.util.*;
public class Comparateur {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnCours Table[] = null; 
		Programme Grille[] = new Programme[100];
		Scanner input = new Scanner(System.in);
		// recuperer les infos 
		int continuer = 1;
		int compteur = 0;
		while(continuer == 1) 
		{
			System.out.println("Entrez la valeur de travail (continuer) : ");
			continuer = input.nextInt();
			System.out.println("Entrez nom du cours  : ");
			Table[compteur].nomDuCours = input.next();
			System.out.println("Entrez cote du cours  : ");
			Table[compteur].Cote = input.nextInt();
			System.out.println("Entrez laboratoire du cours  : ");
			Table[compteur].Laboratoire = input.nextLine();
			System.out.println("Entrez Cours Magistral1 du cours  : ");
			Table[compteur].CoursMagistral1 = input.nextLine();
			System.out.println("Entrez Cous Magistral2 du cours  : ");
			Table[compteur].CoursMagistral2 = input.nextLine();
			System.out.println("Entrez Tutoriel  du cours  : ");
			Table[compteur].Tutoriel = input.nextLine();
			compteur++;
		}
		
		for (int i = 0 ; i< compteur ; i++) 
		{
			System.out.println(Table[i].nomDuCours);
			System.out.println(Table[i].Cote);
			System.out.println(Table[i].Laboratoire);
			System.out.println(Table[i].CoursMagistral1);
			System.out.println(Table[i].CoursMagistral2);
			System.out.println(Table[i].Tutoriel);
		}
		/*
		int compteur_de_programme =0;
		//generer un programme 
		for(int i = 0 ; i < compteur ; i++)
		{
			Grille[compteur_de_programme].un =  Table[i]
		}
		*/
		

		
	}

	public boolean meme_cours(UnCours A , UnCours B) // comparer les cours pour s'assurer qu'on ne prends pas le meme cour
	{
		if (A.nomDuCours == B.nomDuCours) 
		{
			if (A.Cote == B.Cote || A.Cote == (B.Cote -400) || (A.Cote -400) == B.Cote) 
			{
				return true ;
			}
			return false ;
		}
		else 
		{
			return false ;
		}
		
	}
	
	public boolean meme_laboratoire(UnCours A , UnCours B) 
	{
		if (A.Laboratoire == B.Laboratoire) 
		{
			return true ;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean  meme_cours_magistral1(UnCours A , UnCours B)
	{
		if (A.CoursMagistral1 == B.CoursMagistral2) { return true ;}
		else {return false ;}
	}
	
	public boolean  meme_Tutoriel (UnCours A , UnCours B)
	{
		if (A.Tutoriel == B.Tutoriel) { return true ;}
		else {return false ;}
	}
	
  +
}

package main;

import java.util.ArrayList;
import java.util.List;

public class Matches {

	public static int getMatchingIndex(List <String> keywords , String research_terms ) 
	{
		//int index = -1 ;
		int list_size = keywords.size();
		int i = 0 ;
		//String fragments [] = new String [5];// String jeton ;
		while (i < list_size) // parcourir la liste de mots clés 
		{
			//fragments = keywords.get(i).split(",",5); // recuperer une ligne du tableau de mots clés et la fragmenter 
			// tester les fragments 
			if (research_terms == keywords.get(i)) {return i ;}
			 
			i++;
		}
		
		
		return -1;
	}
	
	public static String printMatchingSentence(int index , List<String> answers  ) 
	{
		return  answers.get(index);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matches a = new Matches();
		List <String> essai = new ArrayList<String>();
		essai.add("Le marketing c'est bien ");
		essai.add("Bon c'est just un essai ");
		essai.add("Theo is theo");
		List<String> keywords = new ArrayList<String>();
		keywords.add("marketing");
		keywords.add("essai");
		keywords.add("Theo");
		String research ="essai";
		printMatchingSentence(getMatchingIndex(keywords,research),essai);

	}

}

import java.util.ArrayList;

/*
 * Nom : Andie SAMADOULOUGOU
 * NE : 300209487
 * */
public class Knapsack {

	static int weight;
	public static ArrayList<Item> objects ;
	
	Knapsack()
	{
		objects = new ArrayList<Item>();
	}
	public  int getWeight() 
	{
		return weight;
	}
	public void setWeight(int a ) 
	{
		weight = a ;
	}
}

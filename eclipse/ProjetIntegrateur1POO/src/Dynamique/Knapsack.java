package Dynamique;


/*
 * Nom : Andie SAMADOULOUGOU
 * NE : 300209487
 * */
import java.util.ArrayList;

public class Knapsack {
	 int weight;
	 double value;
	
	public ArrayList<Item> objects ;
	
	Knapsack()
	{
		objects = new ArrayList<Item>();
	}
	public  int getWeight() 
	{
		return weight;
	}
	public  void setWeight(int a ) 
	{
		weight = a ;
	}
	public  int getValue() 
	{
		return (int) value;
	}
	public  void setValue(int a ) 
	{
		value = a ;
	}
}

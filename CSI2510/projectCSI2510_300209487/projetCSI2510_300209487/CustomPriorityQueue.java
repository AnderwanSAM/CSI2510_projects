package projetCSI2510_300209487;


/* 
 * 
 * 
 * Andie Erwan Kiswendsida SAMADOULOUGOU 
 * 300209487
 * */

import java.util.ArrayList;
import java.util.List;

public class CustomPriorityQueue {

	//les elements avec la plus petite Queue sont au debut  de la liste
	public List<Entry> Queue = new ArrayList<Entry>();
	
	private int size ;
	
	
	int size() 
	{
		return size;
	};

	/**
	 * Tests whether the priority queue is empty.
	 * @return true if the priority queue is empty, false otherwise
	 */
	boolean isEmpty() 
	{
		if(size==0) {return true ;} else {return false ;}
	};

	/**
	 * Inserts a key-value pair and returns the entry created.
	 * @param key     the key of the new entry
	 * @param value   the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	//Entry <K, V>insert( K key, V value ) throws IllegalArgumentException;
	
	public  boolean insert(int k,int e) 
	{
		Entry temporaire = new Entry(k,e);
		boolean ok = false  ;
		if (this.isEmpty())
		{
			Queue.add(temporaire); size++;
			return true ;
		}
		else // rechercher la bonne position pour l'insertion 
		{
			//int i =0 ;
			//la priorite du nouvel element est plus grande// on continue  
			for (int i =0 ; i < size ; i++) 
			{
				if (temporaire.getKey() < Queue.get(i).getKey()) 
				{
					Queue.add(i,temporaire);
					size++;
					ok = true;
					break ;
				}
			}
			if (ok) {return true; }
			else {
				Queue.add(temporaire); size++ ;return true ;
			}
			//la priorite est plus petite 
		}
	}

	public Entry removeMin() {
	 Entry e = new Entry(0,0);
	 e = Queue.remove(0);
	 size--;
	 return e;
	}
	
	public Entry min() 
	{
		Entry e = new Entry(-1,-1);
		if (size ==0) {return e;}
		else {
			return Queue.get(0);
		}
	}
	
	public int minKey() 
	{
		return Queue.get(0).getKey();
	}
	
	/*public static void main(String[] args) {
		CustomPriorityQueue a = new CustomPriorityQueue();
		a.insert(0,5);
		a.insert(10, 8);
	    a.insert(7, 6);
	    Entry b = a.removeMin();
	    b = a.removeMin();
	    System.out.println(a.size());
		for (int i =0 ; i< a.size() ; i++) 
		{
			//System.out.println(a.Queue.get(i).getValue());
			//System.out.println(b.getValue());
		}
		
		
	}*/
	
}

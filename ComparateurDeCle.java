package projectCSI2510_300209487;

import java.util.Comparator;
public class ComparateurDeCle implements Comparator<Entry> {

	

	@Override
	public int compare(Entry o1, Entry o2) {
		// TODO Auto-generated method stub
		if (o1.key < o2.key) 
		{
			 return -1;
		}
		if( o1.key > o2.key) 
		{
			return  1 ;
		}
		
		
		return 0;
	}

}

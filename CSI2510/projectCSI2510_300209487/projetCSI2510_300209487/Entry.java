package projetCSI2510_300209487;

/*Andie Erwan Kiswendsida SAMADOULOUGOU 
* 300209487*/
public class Entry implements Comparable<Entry> {
    private int key;
    private int value;

    public Entry(int  key, int value) {
        this.key = key;
        this.value = value;
    }

    // getters
    int getKey() { return key;}
    
    int getValue() {return value;}

    @Override
    public int compareTo(Entry other) {
        if (this.getKey() < other.getKey()) 
        {
        	return -1 ;
        }
        else if (this.getKey() == other.getKey()) 
        {
        	return 0;
        }
        else 
        {
        	return 1 ; 
        }
    }
}
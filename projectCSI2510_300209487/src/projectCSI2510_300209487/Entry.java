package projectCSI2510_300209487;


public class Entry <K extends Comparable, V> {
	int key;
	int  value;

	/**
	 * Returns the key stored in this entry.
	 * @return the entry's key
	 */
int  getKey() {
		return key;
	} /* getKey */


	/**
	 * Returns the value stored in this entry.
	 * @return the entry's value
	 */
	int  getValue() {
		return value;
	} /* getValue */


	public Entry( int k, int  v ) {
		key   = k;
		value = v;
	}


}

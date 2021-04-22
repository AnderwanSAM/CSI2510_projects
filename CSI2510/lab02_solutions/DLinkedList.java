/**  CSI2510 Lab 2 - DLinkedList.java
 *
 *  Class doubly linked list.
 *  @author Jeff Souza
 */
class DLinkedList {

	// First node of the list.
	ListNode firstNode;

	// Last node of the list.
	ListNode lastNode;

	/**
	 * Appends a node to the end of the list.
	 * @param ListNode nNode Node to append.
	 */
	void AppendNode( ListNode nNode ) {
		InsertNode ( nNode, lastNode );
	} /* AppendNode */


	/**
	 * Inserts a node into the list after pAfter node.
	 * @param ListNode nNode  Node to insert.
	 * @param ListNode pAfter Node after which the insertion is done.
	 */
	void InsertNode( ListNode nNode, ListNode pAfter ) {
		nNode.next     = pAfter.next;
		nNode.previous = pAfter;

		if( pAfter.next != null )
			pAfter.next.previous = nNode;
		else
			lastNode = nNode;

		pAfter.next = nNode;
	} /* InsertNode */


	/**
	 * Removes the specified node from the list.
	 * @param ListNode nNode Node to remove.
	 */
	void RemoveNode( ListNode nNode ) {
		if( nNode.previous == null )
			firstNode = nNode.next;
		else
			nNode.previous.next = nNode.next;

		if( nNode.next == null )
			lastNode = nNode.previous;
		else
			nNode.next.previous = nNode.previous;
	} /* RemoveNode */


	/**
	 * Prints the content of the list.
	 */
	void print() {
		ListNode    nNode = null;

		System.out.print ( "Current list: " );

		for( nNode = firstNode; nNode != null; nNode = nNode.next ) {
			System.out.print ( nNode.data + " " );
		}
		System.out.println ( "" );
	} /* print */


}

/**
 * Class to check balanced brackets in math expressions
 *
 * Usage: java bracketsBalance <expression>
 */
class bracketsBalance_v2 {

	// Checks balanced brackets in exp (the expression)
	private boolean bBalance( String exp ) {

		// The bracket pairs
		String    brackets = "(){}[]";

		// Create a new stack
		ArrayStack    stk = new ArrayStack ( 10 );

		// Scan across expression
		for( int i = 0; i < exp.length(); i++ ) {
			char    ch       = exp.charAt ( i );
			int     inputPos = brackets.indexOf ( ch );

			if( inputPos % 2 == 0 ) {

				// Push an opening bracket onto the stack
				try {
					stk.push ( new Character ( ch ) );
				}
				catch( StackFullException e ) {
				}
			}
			else
			if( inputPos != -1 ) {
				// Process a closing bracket

				// If stack empty, then error
				if( stk.isEmpty() ) return false;

				// Retrieve bracket from stack
				char    chFrmStk = '\0';

				try {
					chFrmStk = ( (Character) stk.pop() ).charValue();
				}
				catch( StackEmptyException e ) {
				}

				int    stackedPos = brackets.indexOf ( chFrmStk );

				// If the opening and closing brackets are of different types, then error
				if( stackedPos + 1 != inputPos ) return false;
			}
		}

		// If the stack is empty then no error, else error
		return stk.isEmpty();
	} /* bBalance */


	public static void main( String [] args ) {

		bracketsBalance_v2    b      = new bracketsBalance_v2();
		boolean               result = b.bBalance ( args [ 0 ] );

		if( result ) System.out.println ( "The expression is balanced." );
		else System.out.println ( "The expression is NOT balanced." );
	} /* main */


}

/**
 * Class to check balanced brackets in math expressions
 *
 * Usage: java bracketsBalance <expression>
 */
class bracketsBalance_v1 {

	// Checks balanced brackets in exp (the expression)
	private boolean bBalance( String exp ) {

		// The bracket pairs
		String    lefts  = "({[";
		String    rights = ")}]";

		// Create a new stack
		ArrayStack    stk = new ArrayStack ( 10 );

		// Scan across expression
		for( int i = 0; i < exp.length(); i++ ) {
			char    ch = exp.charAt ( i );

			if( lefts.indexOf ( ch ) != -1 ) {

				// Push an opening bracket onto the stack
				try {
					stk.push ( new Character ( ch ) );
				}
				catch( FullStackException e ) {
				}
			}
			else
			if( rights.indexOf ( ch ) != -1 ) {
				// Process a closing bracket

				// If stack empty, then error
				if( stk.isEmpty() ) return false;

				// Retrieve bracket from stack
				char    chFrmStk = '\0';

				try {
					chFrmStk = ( (Character) stk.pop() ).charValue();
				}
				catch( EmptyStackException e ) {
				}

				// If the opening and closing brackets are of different types, then error
				if( rights.indexOf ( ch ) != lefts.indexOf ( chFrmStk ) ) return false;
			}
		}

		// If the stack is empty then no error, else error
		return stk.isEmpty();
	} /* bBalance */


	public static void main( String [] args ) {

		bracketsBalance_v1    b      = new bracketsBalance_v1();
		boolean               result = b.bBalance ( args [ 0 ] );

		if( result ) System.out.println ( "The expression is balanced." );
		else System.out.println ( "The expression is NOT balanced." );
	} /* main */


}

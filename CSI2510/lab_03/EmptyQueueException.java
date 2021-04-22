/**
 * Runtime exception thrown when one tries to perform operation remove on an empty queue.
 */
public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException( String err ) {
		super(err);
	}


}

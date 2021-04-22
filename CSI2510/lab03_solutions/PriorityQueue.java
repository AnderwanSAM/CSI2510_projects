import static java.lang.System.*;

public class PriorityQueue {
	private Queue high;
	private Queue medium;
	private Queue low;

	public PriorityQueue() {
		this.high   = new Queue();
		this.medium = new Queue();
		this.low    = new Queue();
	}


	public void initFromTasks( Queue tasks ) {
		Task    task;

		while( !tasks.isEmpty() ) {
			task = tasks.remove();

			switch( (int) task.getPriority() ) {
			case 0 : {
				this.high.add ( task );
			}
			break;
			case 1 : {
				this.medium.add ( task );
			}
			break;
			case 2 : {
				this.low.add ( task );
			}
			break;
			} /* switch */
		}
	} /* initFromTasks */


	public Task getTask() throws EmptyQueueException {
		Task    task;

		if( !this.high.isEmpty() )
			task = this.high.remove();
		else
		if( !this.medium.isEmpty() )
			task = this.medium.remove();
		else
		if( !this.low.isEmpty() )
			task = this.low.remove();
		else
			throw new EmptyQueueException ( "Empty priority queue." );

		return task;
	} /* getTask */


	public boolean isEmpty() {
		return this.high.isEmpty() && this.medium.isEmpty() && this.low.isEmpty();
	} /* isEmpty */


}

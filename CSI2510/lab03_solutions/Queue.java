import java.util.LinkedList;

public class Queue {

	private LinkedList <Task>tasks;

	public Queue() {
		this.tasks = new LinkedList <Task>();
	}


	public void add( Task task ) {
		this.tasks.addFirst ( task );
	} /* add */


	public Task remove() throws EmptyQueueException {
		if( !this.isEmpty() ) {
			Task    task = this.tasks.removeLast();

			return task;
		}
		else {
			throw new EmptyQueueException ( "Empty queue." );
		}
	} /* remove */


	public boolean isEmpty() {
		return this.tasks.isEmpty();
	} /* isEmpty */


}

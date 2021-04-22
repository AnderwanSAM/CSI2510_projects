import static java.lang.System.*;

public class TestPriority {

	public static void main( String [] args ) {
		int      time          = 1;
		int      priority      = (new java.util.Random() ).nextInt ( 3 );
		Queue    mainQueue     = new Queue();
		Queue    mainQueueCopy = new Queue();

		for( int i = 1; i <= 15; i++ ) {
			priority = (new java.util.Random() ).nextInt ( 3 );
			mainQueue.add ( new Task ( priority, i ) );
			mainQueueCopy.add ( new Task ( priority, i ) );
		}

		System.out.println ( "Tasks before priority ordering..." );

		while( !mainQueueCopy.isEmpty() ) {
			Task    task = mainQueueCopy.remove();

			System.out.println ( "Time: " + task.getTime() + ", priority:" + task.getPriority() );
		}
		System.out.println ( "" );

		PriorityQueue    priorityQueue = new PriorityQueue();

		priorityQueue.initFromTasks ( mainQueue );

		System.out.println ( "Tasks after priority ordering..." );

		while( !priorityQueue.isEmpty() ) {
			Task    task = priorityQueue.getTask();

			System.out.println ( "Time: " + task.getTime() + ", priority: " + task.getPriority() );
		}
	} /* main */


}

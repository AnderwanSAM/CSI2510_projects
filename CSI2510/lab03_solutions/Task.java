public class Task {

	private int priority;
	private int time;

	public Task() {

	}


	public Task( int priority, int time ) {
		this.priority = priority;
		this.time     = time;
	}


	public int getTime() {
		return this.time;
	} /* getTime */


	public int getPriority() {
		return this.priority;
	} /* getPriority */


	public void setTime( int time ) {
		this.time = time;
	} /* setTime */


	public void setPriority( int priority ) {
		this.priority = priority;
	} /* setPriority */


}

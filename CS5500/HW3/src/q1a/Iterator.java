package q1a;

/**
* A generic iterator
* 
* @author Samanjate Sood
*/
public interface Iterator<T> {

	/**
	 * Check if there are more elements
	*/
	boolean hasAnotherElement();
	
	/**
	 * Return the next element
	 */
	T nextElement();
}

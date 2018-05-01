package q4a;

/**
* A generic set
* 
* @author Samanjate Sood
*/
interface Set<T> {
	/**
	 * Add an element
	 */
	void add(T t);

	/**
	 * Add all elements in the argument set
	 */
	void addAll(Set<T> s);
 
	/**
	 * Check if an element occurs in the set
	 */
	boolean contains(T t);
 
	/**
	 * Remove an element
	 */
	void remove(T t);
 
	/**
	 * Return the number of arguments in the set
	 */
	int size(); 
 
	/**
	 * Return an iterator over the set
	 */
	Iterator<T> iterator();
 }

package q2;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic Queue implementation of IQueue interface
 * 
 * @author Samanjate Sood
 *
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {

	List<T> que;
	
	public Queue() {
		que = new ArrayList<>();
	}
	
	/**
	 * adds the given element to the head of the queue
	 */
	@Override
	public boolean add(T t) {
		return que.add(t);
	}

	/**
	 * remove an element from the end of the queue. Returns null if queue is empty
	 */
	@Override
	public T remove() {
		if(que.isEmpty()) {
			return null;
		}
		return que.remove(0);
	}

	/**
	 * returns the head of the queue. Returns null if queue is empty
	 */
	@Override
	public T peek() {
		if(que.isEmpty()) {
			return null;
		}
		return que.get(que.size()-1);
	}

}

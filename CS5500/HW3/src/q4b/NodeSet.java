package q4b;

/**
* Class NodeSet represents a set of AST Nodes.
*
* @author Samanjate Sood
*/
public class NodeSet implements Set<Node> {
	
	public NodeSet() {
		adaptee = new BitVector();
	}
	
	/**
	 * A method used to add a Node to our NodeSet.
	 * @param A Node
	 * 
	 * Reuses the Bit-Vector's set functionality by converting AST nodes to integers
	 */
	@Override public void add(Node n) {
		adaptee.set(n.getId());
	}
	
	/**
	 * A method used to add the elements of the given Set of Nodes to this NodeSet
	 * @param A Set of Node
	 * 
	 * Reuses the Bit-Vector's copy functionality by converting AST nodes to integers
	 */
	@Override 
	public void addAll(Set<Node> n) {
		Iterator<Node> it = n.iterator();
		IBitVector setToBeAdded = new BitVector();
		while(it.hasAnotherElement()) {
			setToBeAdded.set(it.nextElement().getId());
		}
		adaptee.copy(setToBeAdded);
	}
 
	/**
	 * A method used to remove a Node from the NodeSet
	 * @param A Node
	 * 
	 * Reuses the Bit-Vector's clear functionality by converting AST nodes to integers
	 */
	@Override public void remove(Node n) {
		adaptee.clear(n.getId());
	}
	
	/**
	 * @return true iff the Node provided is contained in the NodeSet
	 * @param A Node
	 * 
	 * Reuses the Bit-Vector's get functionality by converting AST nodes to integers
	 */
	@Override public boolean contains(Node n) { 
		return adaptee.get(n.getId());
	}
	
	/**
	 * @return true size of the NodeSet representing the distinct number of elements
	 * 
	 * Reuses the Bit-Vector's size functionality by converting AST nodes to integers
	 */
	@Override public int size() { 
		return adaptee.size();
	}
	
	/**
	 * @return Iterator to iterate over the set elements
	 * 
	 * Has an anonymous class that implements the Iterator interface.
	 * Reuses the Bit-Vector's iterator functionality by converting AST nodes to integers
	 */
	@Override public Iterator<Node> iterator() { 
		return new Iterator<Node>() {
			
			Iterator<Integer> nodeIds = adaptee.iterator();
			
			@Override
			public boolean hasAnotherElement() {
				return nodeIds.hasAnotherElement();
			}

			@Override
			public Node nextElement() {
				return Node.getNode(nodeIds.nextElement());
			}
			
		};
	}
	
	/**
	 * @return The string representation of the NodeSet
	 * 
	 */
	@Override public String toString() {
		Iterator<Node> it = this.iterator();
		if(!it.hasAnotherElement()) {
			return "Empty Set";
		}
		StringBuilder text = new StringBuilder("{ " + it.nextElement().textRepresentation());
		while(it.hasAnotherElement()) {
			text.append(", " + it.nextElement().textRepresentation());
		}
		text.append(" }");
		return text.toString();
	}
	
	private IBitVector adaptee;
}

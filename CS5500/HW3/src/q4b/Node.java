package q4b;

import java.util.NoSuchElementException;

/**
 * This interface represents every element of our program
 * 
 * @author Samanjate Sood
 *
 */
public abstract class Node {
	
	private static int nodeCount = 0;
	private int nodeId;
	private static Node[] nodes = new Node[32];
	
	protected Node() {
		nodeId = nodeCount+1;
		init(this);
	}
	
	private static void init(Node node) {
		if(nodeCount >= nodes.length) {
			Node[] temp = new Node[nodes.length * 2];
			for(int i = 0; i < nodes.length; i++) {
				temp[i] = nodes[i];
			}
			nodes = temp;
		}
		nodes[nodeCount] = node;
		nodeCount++;
	}

	/**
	 * @return The textual representation of the program Node.
	 * 
	 */
	public abstract String textRepresentation();
	
	/**
	 * Returns unique identifier for each node.
	 */
	public int getId(){ 
		return nodeId;
	}

	/**
	 * Reverse mapping from Nodes to their unique identifiers
	 */
	public static Node getNode(int id) 
			throws NoSuchElementException {
		if(id <= 0 || id > nodeCount || nodes[id-1] == null) {
			throw new NoSuchElementException("There is no Node mapping to the provided ID");
		}
		return nodes[id-1];
	}
	
	/**
	 * A method signifying that each Node is visit-able, using the Visitor Design pattern
	 */
	public abstract void accept(ASTVisitor visitor);
}

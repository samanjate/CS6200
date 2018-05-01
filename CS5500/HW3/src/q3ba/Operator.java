package q3ba;

/**
 * 
 * This class implements the Node class and represents different operators
 * that are in the program.
 * 
 * @author Samanjate Sood
 *
 */
public class Operator {
	
	private String opr;

	public Operator(String opr) {
		this.opr = opr;
	}
	
	/**
	 * @return the textual representation of an operator.
	 */
	public String getText() {
		return opr;
	}
}

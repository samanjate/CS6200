package ast3;

/**
 * 
 * This class implements the Expression interface and can be used to produce
 * an element in another expression.
 * 
 * @author Samanjate Sood
 *
 */
public class NumberExpression implements Expression {
	
	private int val;

	public NumberExpression(int val) {
		this.val = val;
	}
	
	/**
	 * @return The textual representation of an integer in the program.
	 */
	@Override
	public String textRepresentation() {
		return Integer.toString(val);
	}

}

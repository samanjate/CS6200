package q3a;

/**
 * 
 * This class implements the Expression interface and can be used to produce
 * an expression in a statement.
 * 
 * @author Samanjate Sood
 *
 */
public class PrefixExpression extends Expression {

	private Operator opr;
	private Expression exp1;
	private Expression exp2;
	
	public PrefixExpression(Operator opr, Expression exp1, Expression exp2) {
		this.opr = opr;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	/**
	 * @return The textual representation of a Infix Expression with the operator
	 * 		   in before the two expressions
	 */
	@Override
	public String textRepresentation() {
		return opr.getText() + 
				" " + 
				exp1.textRepresentation() + 
				" " + 
				exp2.textRepresentation();
	}

}

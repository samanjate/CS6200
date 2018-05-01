package q4c;

/**
 * 
 * This class implements the Statement interface and can be used to produce
 * a statement in the output sequence.
 * 
 * @author Samanjate Sood
 *
 */
public class Declaration extends Statement {
	
	private Variable var;

	public Declaration(Variable var) {
		this.var = var;
	}

	/**
	 * @return Returns the textual representation of a variable declaration.
	 */
	@Override
	public String textRepresentation() {
		return "var " + var.getText();
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
	public Variable getVariable() {
		return var;
	}

}

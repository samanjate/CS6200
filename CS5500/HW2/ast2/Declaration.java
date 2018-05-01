package ast2;

/**
 * 
 * This class implements the Statement interface and can be used to produce
 * a statement in the output sequence.
 * 
 * @author Samanjate Sood
 *
 */
public class Declaration implements Statement {
	
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

}

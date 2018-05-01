package q4a;

/**
 * A visitor interface for every Node type in the AST
 * 
 * @author Samanjate Sood
 *
 */
public interface ASTVisitor {

	/**
	 * A visit method for the InfixExpression class
	 * 
	 * @param An InfixExpression Node
	 */
	public void visit(InfixExpression node);
	
	/**
	 * A visit method for the PrefixExpression class
	 * 
	 * @param An PrefixExpression Node
	 */
	public void visit(PrefixExpression node);
	
	/**
	 * A visit method for the NumberExpression class
	 * 
	 * @param An NumberExpression Node
	 */
	public void visit(NumberExpression node);
	
	/**
	 * A visit method for the StringExpression class
	 * 
	 * @param An StringExpression Node
	 */
	public void visit(StringExpression node);
	
	/**
	 * A visit method for the VariableExpression class
	 * 
	 * @param An VariableExpression Node
	 */
	public void visit(VariableExpression node);
	
	/**
	 * A visit method for the Declaration class
	 * 
	 * @param An Declaration Node
	 */
	public void visit(Declaration node);
	
	/**
	 * A visit method for the Assignment class
	 * 
	 * @param An Assignment Node
	 */
	public void visit(Assignment node);
	
	/**
	 * A visit method for the Sequence class
	 * 
	 * @param An Sequence Node
	 */
	public void visit(Sequence node);
}

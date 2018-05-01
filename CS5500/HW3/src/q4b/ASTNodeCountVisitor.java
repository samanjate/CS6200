package q4b;

/**
 * A class that implements the ASTVisitor interface and keeps the count of 
 * the number of times each Node is visited.
 * 
 * @author Samanjate Sood
 *
 */
public class ASTNodeCountVisitor implements ASTVisitor {

	private int numOfInfixExpression;
	private int numOfPrefixExpression;
	private int numOfNumberExpression;
	private int numOfStringExpression;
	private int numOfVariableExpression;
	private int numOfDeclaration;
	private int numOfAssignment;
	private int numOfSequence;
	
	public ASTNodeCountVisitor() {
		numOfInfixExpression = 0;
		numOfPrefixExpression = 0;
		numOfNumberExpression = 0;
		numOfStringExpression = 0;
		numOfVariableExpression = 0;
		numOfDeclaration = 0;
		numOfAssignment = 0;
		numOfSequence = 0;
	}
	
	/**
	 * Increments the count of the number of times InfixExpression is visited
	 */
	@Override
	public void visit(InfixExpression node) {
		numOfInfixExpression++;
	}

	/**
	 * Increments the count of the number of times PrefixExpression is visited
	 */
	@Override
	public void visit(PrefixExpression node) {
		numOfPrefixExpression++;
	}

	/**
	 * Increments the count of the number of times NumberExpression is visited
	 */
	@Override
	public void visit(NumberExpression node) {
		numOfNumberExpression++;
	}

	/**
	 * Increments the count of the number of time StringExpression is visited
	 */
	@Override
	public void visit(StringExpression node) {
		numOfStringExpression++;
	}

	/**
	 * Increments the count of the number of times VariableExpression is visited
	 */
	@Override
	public void visit(VariableExpression node) {
		numOfVariableExpression++;
	}

	/**
	 * Increments the count of the number of times Declaration is visited
	 */
	@Override
	public void visit(Declaration node) {
		numOfDeclaration++;
	}

	/**
	 * Increments the count of the number of times Assignment is visited
	 */
	@Override
	public void visit(Assignment node) {
		numOfAssignment++;
	}

	/**
	 * Increments the count of the number of times Sequence is visited
	 */
	@Override
	public void visit(Sequence node) {
		numOfSequence++;
	}
	
	//Getter functions for private fields
	
	public int getNumOfInfixExpression() {
		return numOfInfixExpression;
	}
	
	public int getNumOfPrefixExpression() {
		return numOfPrefixExpression;
	}
	
	public int getNumOfNumberExpression() {
		return numOfNumberExpression;
	}
	
	public int getNumOfStringExpression() {
		return numOfStringExpression;
	}
	
	public int getNumOfVariableExpression() {
		return numOfVariableExpression;
	}
	
	public int getNumOfDeclaration() {
		return numOfDeclaration;
	}
	
	public int getNumOfAssignment() {
		return numOfAssignment;
	}
	
	public int getNumOfSequence() {
		return numOfSequence;
	}

}

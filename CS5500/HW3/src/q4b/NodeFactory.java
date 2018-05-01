package q4b;

import java.util.logging.Logger;

/**
 * 
 * This is a factory for different 'Node's in the program.
 * 
 * @author Samanjate Sood
 *
 */
public class NodeFactory {
	
	private static final Logger LOGGER = Logger.getLogger(NodeFactory.class.getName());
	
	/**
	 * These member variable are used to store the count of the different 
	 * instances of the classes created by the factory
	 */
	private static NodeFactory instance;
	private int numOfDeclaration;
	private int numOfAssignment;
	private int numOfSequence;
	private int numOfInfixExpression;
	private int numOfPrefixExpression;
	private int numOfNumberExpression;
	private int numOfStringExpression;
	private int numOfVariableExpression;
	
	private NodeFactory() {
		numOfDeclaration = 0;
		numOfAssignment = 0;
		numOfSequence = 0;
		numOfInfixExpression = 0;
		numOfPrefixExpression = 0;
		numOfNumberExpression = 0;
		numOfStringExpression = 0;
		numOfVariableExpression = 0;
	}
	
	/**
	 * This method restricts the multiple object creation of this factory
	 * @return the instance of the factory if there is one, otherwise create 
	 *  	   a new one, store it an return.
	 */
	public static NodeFactory getInstance() {
		if(instance == null) {
			instance = new NodeFactory();
			return instance;
		} else {
			return instance;
		}
	}
	
	/**
	 * 
	 * @param a Variable
	 * @return an instance of the Declaration of that variable which is the
	 *         textual representation of that variable
	 */
	public Statement makeDeclaration(Variable var) {
		numOfDeclaration++;
		return new Declaration(var);
	}
	
	/**
	 * 
	 * @param a Variable
	 * @param an Expression
	 * @return an instance of the Assignment class which assigns the variable
	 *  	   with the given expression.
	 */
	public Statement makeAssignment(Variable var, Expression exp) {
		numOfAssignment++;
		return new Assignment(var, exp);
	}
	
	/**
	 * 
	 * @param an array of Statements
	 * @return an instance of the Sequence class which is the textual 
	 *         representation of the provided statements in that order
	 */
	public Statement makeSequence(Statement... statements) {
		numOfSequence++;
		return new Sequence(statements);
	}
	
	/**
	 * 
	 * @param an Operator
	 * @param an Expression
	 * @param another expression
	 * @return an instance of the InfixExperssion class which puts the operator 
	 * 	       between the two expressions
	 */
	public Expression makeInfixExpression(Operator opr, Expression exp1, Expression exp2) {
		numOfInfixExpression++;
		return new InfixExpression(opr, exp1, exp2);
	}
	
	/**
	 * 
	 * @param an Operator
	 * @param an Expression
	 * @param another expression
	 * @return an instance of the PrefixExperssion class which puts the operator 
	 * 	       before the two expressions
	 */
	public Expression makePrefixExpression(Operator opr, Expression exp1, Expression exp2) {
		numOfPrefixExpression++;
		return new PrefixExpression(opr, exp1, exp2);
	}
	
	/**
	 * 
	 * @param an Integer
	 * @return an instance of the NumberExpression class which is the textual 
	 * 		   representation of the provided integer.
	 */
	public Expression makeNumberExpression(int val) {
		numOfNumberExpression++;
		return new NumberExpression(val);
	}
	
	/**
	 * 
	 * @param a String
	 * @return an instance of the StringExpression class which is the textual 
	 * 		   representation of the provided String.
	 */
	public Expression makeStringExpression(String val) {
		numOfStringExpression++;
		return new StringExpression(val);
	}
	
	/**
	 * 
	 * @param a Variable
	 * @return an instance of the VariableExpression class which is the textual 
	 * 		   representation of the provided Variable.
	 */
	public Expression makeVariableExpression(Variable val) {
		numOfVariableExpression++;
		return new VariableExpression(val);
	}
	
	/**
	 * This method reports the count of the number of instances of the different 
	 * classes that are created by the factory during a program run.
	 */
	public void report() {
		String log = String.format("Declarations: %d%nAssignments: %d%nSequences: %d%n"
								   + "Infix Expressions: %d%nPrefixExpressions: %d%n"
								   + "Number Expressions: %d%nString Expressions: %d%n"
								   + "Variable Expressions: %d%n", 
								   numOfDeclaration, numOfAssignment, numOfSequence,
								   numOfInfixExpression, numOfPrefixExpression, 
								   numOfNumberExpression, numOfStringExpression,
								   numOfVariableExpression);
		LOGGER.info(log);
	}
}

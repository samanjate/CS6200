package ast2;

/**
 * 
 * This is a factory for different 'Node's in the program.
 * 
 * @author Samanjate Sood
 *
 */
public class NodeFactory {
	
	/**
	 * 
	 * @param a Variable
	 * @return an instance of the Declaration of that variable which is the
	 *         textual representation of that variable
	 */
	public Statement makeDeclaration(Variable var) {
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
		return new Assignment(var, exp);
	}
	
	/**
	 * 
	 * @param an array of Statements
	 * @return an instance of the Sequence class which is the textual 
	 *         representation of the provided statements in that order
	 */
	public Statement makeSequence(Statement... statements) {
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
		return new PrefixExpression(opr, exp1, exp2);
	}
	
	/**
	 * 
	 * @param an Integer
	 * @return an instance of the NumberExpression class which is the textual 
	 * 		   representation of the provided integer.
	 */
	public Expression makeNumberExpression(int val) {
		return new NumberExpression(val);
	}
	
	/**
	 * 
	 * @param a String
	 * @return an instance of the StringExpression class which is the textual 
	 * 		   representation of the provided String.
	 */
	public Expression makeStringExpression(String val) {
		return new StringExpression(val);
	}
	
	/**
	 * 
	 * @param a Variable
	 * @return an instance of the VariableExpression class which is the textual 
	 * 		   representation of the provided Variable.
	 */
	public Expression makeVariableExpression(Variable val) {
		return new VariableExpression(val);
	}
}

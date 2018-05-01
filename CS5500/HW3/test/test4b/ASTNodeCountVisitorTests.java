package test4b;

import static org.junit.Assert.*;

import org.junit.Test;

import q4b.ASTNodeCountVisitor;
import q4b.Expression;
import q4b.NodeFactory;
import q4b.Operator;
import q4b.Statement;
import q4b.Variable;

public class ASTNodeCountVisitorTests {

	/**
	 * A method to test the count of different types of Nodes
	 */
	@Test
	public void testNodeCount1(){
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 0", 0, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 0", 0, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfSequence());
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		one.accept(visitor);
		
		Expression two = nodeFactory.makeNumberExpression(2);
		two.accept(visitor);
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		exp.accept(visitor);
		
		Statement decl = nodeFactory.makeDeclaration(x);
		decl.accept(visitor);
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assign.accept(visitor);
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		seq.accept(visitor);
		
		assertEquals("Count of InfixExpressions should be 1", 1, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 2", 2, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 1", 1, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 1", 1, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 1", 1, visitor.getNumOfSequence());
	}
	
	/**
	 * A method to test the count of different types of Nodes
	 */
	@Test
	public void testNodeCount2(){
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 0", 0, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 0", 0, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfSequence());
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		one.accept(visitor);
		
		Expression two = nodeFactory.makeNumberExpression(2);
		two.accept(visitor);
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makePrefixExpression(plus, one, two);
		exp.accept(visitor);
		
		Statement decl = nodeFactory.makeDeclaration(x);
		decl.accept(visitor);
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assign.accept(visitor);
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		seq.accept(visitor);
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 1", 1, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 2", 2, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 1", 1, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 1", 1, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 1", 1, visitor.getNumOfSequence());
	}
	
	/**
	 * A method to test the count of different types of Nodes
	 */
	@Test
	public void testNodeCount3(){
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 0", 0, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 0", 0, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfSequence());
		
		Variable x = new Variable("x");
		
		Expression firstName = nodeFactory.makeStringExpression("Samanjate");
		firstName.accept(visitor);
		
		Expression lastName = nodeFactory.makeStringExpression("Sood");
		lastName.accept(visitor);
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, firstName, lastName);
		exp.accept(visitor);
		
		Statement decl = nodeFactory.makeDeclaration(x);
		decl.accept(visitor);
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assign.accept(visitor);
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		seq.accept(visitor);
		
		assertEquals("Count of InfixExpressions should be 1", 1, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 2", 2, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 1", 1, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 1", 1, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 1", 1, visitor.getNumOfSequence());
	}
	
	/**
	 * A method to test the count of different types of Nodes
	 */
	@Test
	public void testNodeCount4(){
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 0", 0, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 0", 0, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfSequence());
		
		Variable x = new Variable("x");
		Variable varA = new Variable("a");
		Variable varB = new Variable("b");
		
		Expression a = nodeFactory.makeVariableExpression(varA);
		a.accept(visitor);
		
		Expression b = nodeFactory.makeVariableExpression(varB);
		b.accept(visitor);
		
		Operator minus = new Operator("-");
		
		Expression exp = nodeFactory.makePrefixExpression(minus, a, b);
		exp.accept(visitor);
		
		Statement decl = nodeFactory.makeDeclaration(x);
		decl.accept(visitor);
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assign.accept(visitor);
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		seq.accept(visitor);
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 1", 1, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 2", 2, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 1", 1, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 1", 1, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 1", 1, visitor.getNumOfSequence());
	}
	
	/**
	 * A method to test the count of different types of Nodes
	 */
	@Test
	public void testNodeCount5(){
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		NodeFactory nodeFactory = NodeFactory.getInstance();
		
		assertEquals("Count of InfixExpressions should be 0", 0, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 0", 0, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 0", 0, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 0", 0, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 0", 0, visitor.getNumOfSequence());
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		one.accept(visitor);
		
		Expression two = nodeFactory.makeNumberExpression(2);
		two.accept(visitor);
		
		Operator plus = new Operator("+");
		
		Expression preExp = nodeFactory.makePrefixExpression(plus, one, two);
		preExp.accept(visitor);
		
		Statement declX = nodeFactory.makeDeclaration(x);
		declX.accept(visitor);
		
		Statement assignX = nodeFactory.makeAssignment(x, preExp);
		assignX.accept(visitor);
		
		Variable y = new Variable("y");
		
		Expression five = nodeFactory.makeNumberExpression(5);
		five.accept(visitor);
		
		Expression six = nodeFactory.makeNumberExpression(6);
		six.accept(visitor);
		
		Operator divide = new Operator("/");
		
		Expression inExp = nodeFactory.makeInfixExpression(divide, five, six);
		inExp.accept(visitor);
		
		Statement declY = nodeFactory.makeDeclaration(y);
		declY.accept(visitor);
		
		Statement assignY = nodeFactory.makeAssignment(y, inExp);
		assignY.accept(visitor);
		
		Statement seq1 = nodeFactory.makeSequence(declX, assignX, declY, assignY);
		seq1.accept(visitor);
		
		Statement seq2 = nodeFactory.makeSequence(declX, declY, assignX, assignY);
		seq2.accept(visitor);
		
		assertEquals("Count of InfixExpressions should be 1", 1, visitor.getNumOfInfixExpression());
		assertEquals("Count of PreExpressions should be 1", 1, visitor.getNumOfPrefixExpression());
		assertEquals("Count of NumberExpressions should be 4", 4, visitor.getNumOfNumberExpression());
		assertEquals("Count of StringExpression should be 0", 0, visitor.getNumOfStringExpression());
		assertEquals("Count of  VariableExpressions should be 0", 0, visitor.getNumOfVariableExpression());
		assertEquals("Count of Declaration should be 2", 2, visitor.getNumOfDeclaration());
		assertEquals("Count of Assignment should be 2", 2, visitor.getNumOfAssignment());
		assertEquals("Count of NumberExpressions should be 2", 2, visitor.getNumOfSequence());
		
	}

}

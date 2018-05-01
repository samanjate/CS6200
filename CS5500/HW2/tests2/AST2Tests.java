package tests2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ast2.Expression;
import ast2.NodeFactory;
import ast2.Operator;
import ast2.Statement;
import ast2.Variable;

public class AST2Tests {

	/**
	 * Provided test, Testing InfixExpression
	 */
	@Test
	public void test1(){
		NodeFactory nodeFactory = new NodeFactory();
		Variable x = new Variable("x");
		Expression one = nodeFactory.makeNumberExpression(1);
		Expression two = nodeFactory.makeNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		Statement decl = nodeFactory.makeDeclaration(x);
		Statement assign = nodeFactory.makeAssignment(x, exp);
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}
	
	/**
	 * Testing PrefixExpression
	 */
	@Test
	public void test2(){
		NodeFactory nodeFactory = new NodeFactory();
		Variable x = new Variable("x");
		Expression one = nodeFactory.makeNumberExpression(1);
		Expression two = nodeFactory.makeNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = nodeFactory.makePrefixExpression(plus, one, two);
		Statement decl = nodeFactory.makeDeclaration(x);
		Statement assign = nodeFactory.makeAssignment(x, exp);
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = + 1 2;");
	}
	
	/**
	 * Testing StringExpression
	 */
	@Test
	public void test3(){
		NodeFactory nodeFactory = new NodeFactory();
		Variable x = new Variable("x");
		Expression firstName = nodeFactory.makeStringExpression("Samanjate");
		Expression lastName = nodeFactory.makeStringExpression("Sood");
		Operator plus = new Operator("+");
		Expression exp = nodeFactory.makeInfixExpression(plus, firstName, lastName);
		Statement decl = nodeFactory.makeDeclaration(x);
		Statement assign = nodeFactory.makeAssignment(x, exp);
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = \"Samanjate\" + \"Sood\";");
	}
	
	/**
	 * Testing VariableExpression
	 */
	@Test
	public void test4(){
		NodeFactory nodeFactory = new NodeFactory();
		Variable x = new Variable("x");
		Variable varA = new Variable("a");
		Variable varB = new Variable("b");
		Expression a = nodeFactory.makeVariableExpression(varA);
		Expression b = nodeFactory.makeVariableExpression(varB);
		Operator minus = new Operator("-");
		Expression exp = nodeFactory.makePrefixExpression(minus, a, b);
		Statement decl = nodeFactory.makeDeclaration(x);
		Statement assign = nodeFactory.makeAssignment(x, exp);
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = - a b;");
	}
	
	/**
	 * Testing Sequence
	 */
	@Test
	public void test5(){
		NodeFactory nodeFactory = new NodeFactory();
		Variable x = new Variable("x");
		Expression one = nodeFactory.makeNumberExpression(1);
		Expression two = nodeFactory.makeNumberExpression(2);
		Operator plus = new Operator("+");
		Expression preExp = nodeFactory.makePrefixExpression(plus, one, two);
		Statement declX = nodeFactory.makeDeclaration(x);
		Statement assignX = nodeFactory.makeAssignment(x, preExp);
		Variable y = new Variable("y");
		Expression five = nodeFactory.makeNumberExpression(5);
		Expression six = nodeFactory.makeNumberExpression(6);
		Operator divide = new Operator("/");
		Expression inExp = nodeFactory.makeInfixExpression(divide, five, six);
		Statement declY = nodeFactory.makeDeclaration(y);
		Statement assignY = nodeFactory.makeAssignment(y, inExp);
		Statement seq1 = nodeFactory.makeSequence(declX, assignX, declY, assignY);
		assertEquals(seq1.textRepresentation(), "var x; x = + 1 2; var y; y = 5 / 6;");
		Statement seq2 = nodeFactory.makeSequence(declX, declY, assignX, assignY);
		assertEquals(seq2.textRepresentation(), "var x; var y; x = + 1 2; y = 5 / 6;");
	}
}

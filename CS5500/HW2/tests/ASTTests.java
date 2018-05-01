package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ast.Assignment;
import ast.Declaration;
import ast.Expression;
import ast.InfixExpression;
import ast.NumberExpression;
import ast.Operator;
import ast.PrefixExpression;
import ast.Sequence;
import ast.Statement;
import ast.StringExpression;
import ast.Variable;
import ast.VariableExpression;

public class ASTTests {

	/**
	 * Provided test, Testing InfixExpression
	 */
	@Test
	public void test1(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}
	
	/**
	 * Testing PrefixExpression
	 */
	@Test
	public void test2(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new PrefixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = + 1 2;");
	}
	
	/**
	 * Testing StringExpression
	 */
	@Test
	public void test3(){
		Variable x = new Variable("x");
		Expression firstName = new StringExpression("Samanjate");
		Expression lastName = new StringExpression("Sood");
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, firstName, lastName);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = \"Samanjate\" + \"Sood\";");
	}
	
	/**
	 * Testing VariableExpression
	 */
	@Test
	public void test4(){
		Variable x = new Variable("x");
		Variable varA = new Variable("a");
		Variable varB = new Variable("b");
		Expression a = new VariableExpression(varA);
		Expression b = new VariableExpression(varB);
		Operator minus = new Operator("-");
		Expression exp = new PrefixExpression(minus, a, b);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = - a b;");
	}
	
	/**
	 * Testing Sequence
	 */
	@Test
	public void test5(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression preExp = new PrefixExpression(plus, one, two);
		Statement declX = new Declaration(x);
		Statement assignX = new Assignment(x, preExp);
		Variable y = new Variable("y");
		Expression five = new NumberExpression(5);
		Expression six = new NumberExpression(6);
		Operator divide = new Operator("/");
		Expression inExp = new InfixExpression(divide, five, six);
		Statement declY = new Declaration(y);
		Statement assignY = new Assignment(y, inExp);
		Statement seq1 = new Sequence(declX, assignX, declY, assignY);
		assertEquals(seq1.textRepresentation(), "var x; x = + 1 2; var y; y = 5 / 6;");
		Statement seq2 = new Sequence(declX, declY, assignX, assignY);
		assertEquals(seq2.textRepresentation(), "var x; var y; x = + 1 2; y = 5 / 6;");
	}
}

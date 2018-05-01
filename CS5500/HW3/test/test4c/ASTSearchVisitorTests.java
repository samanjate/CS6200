package test4c;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import q4c.Iterator;
import q4c.ASTSearchVisitor;
import q4c.Expression;
import q4c.Node;
import q4c.NodeFactory;
import q4c.Operator;
import q4c.Statement;
import q4c.Variable;

public class ASTSearchVisitorTests {

	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 */
	@Test
	public void testNodeSearch1(){
		ASTSearchVisitor visitor = new ASTSearchVisitor("x");
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
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
		
		Iterator<Node> it = visitor.getSearchResult().iterator();
		List<Node> nodes = new ArrayList<Node>();
		while(it.hasAnotherElement()) {
			Node node = it.nextElement();
			nodes.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 2, nodes.size());
		assertThat(nodes, CoreMatchers.hasItems(assign, decl));
	}
	
	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 */
	@Test
	public void testNodeSearch2(){
		ASTSearchVisitor visitor = new ASTSearchVisitor("x");
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		Variable x = new Variable("y");
		
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
		
		Iterator<Node> it = visitor.getSearchResult().iterator();
		List<Node> nodes = new ArrayList<Node>();
		while(it.hasAnotherElement()) {
			Node node = it.nextElement();
			nodes.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 0, nodes.size());
	}
	
	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 */
	@Test
	public void testNodeSearch3(){
		ASTSearchVisitor visitor = new ASTSearchVisitor("x");
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
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
		
		Iterator<Node> it = visitor.getSearchResult().iterator();
		List<Node> nodes = new ArrayList<Node>();
		while(it.hasAnotherElement()) {
			Node node = it.nextElement();
			nodes.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 2, nodes.size());
		assertThat(nodes, CoreMatchers.hasItems(assign, decl));
	}
	
	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 */
	@Test
	public void testNodeSearch4(){
		ASTSearchVisitor visitor = new ASTSearchVisitor("x");
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
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
		
		Iterator<Node> it = visitor.getSearchResult().iterator();
		List<Node> nodes = new ArrayList<Node>();
		while(it.hasAnotherElement()) {
			Node node = it.nextElement();
			nodes.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 2, nodes.size());
		assertThat(nodes, CoreMatchers.hasItems(assign, decl));
	}
	
	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 */
	@Test
	public void testNodeSearch5(){
		ASTSearchVisitor visitor = new ASTSearchVisitor("x");
		NodeFactory nodeFactory = NodeFactory.getInstance();
		
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
		
		Iterator<Node> it = visitor.getSearchResult().iterator();
		List<Node> nodes = new ArrayList<Node>();
		while(it.hasAnotherElement()) {
			Node node = it.nextElement();
			nodes.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 2, nodes.size());
		assertThat(nodes, CoreMatchers.hasItems(assignX, declX));
		
	}
	
	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 * 
	 * Complex case
	 */
	@Test
	public void testNodeSearch6(){
		ASTSearchVisitor visitor1 = new ASTSearchVisitor("x");
		ASTSearchVisitor visitor2 = new ASTSearchVisitor("y");
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable varA = new Variable("a");
		Variable varB = new Variable("x");
		
		Expression a = nodeFactory.makeVariableExpression(varA);
		a.accept(visitor1);
		a.accept(visitor2);
		
		Expression b = nodeFactory.makeVariableExpression(varB);
		b.accept(visitor1);
		b.accept(visitor2);
		
		Operator minus = new Operator("-");
		
		Expression exp = nodeFactory.makePrefixExpression(minus, a, b);
		exp.accept(visitor1);
		exp.accept(visitor2);
		
		Statement decl1 = nodeFactory.makeDeclaration(x);
		Statement decl2 = nodeFactory.makeDeclaration(y);
		decl1.accept(visitor1);
		decl1.accept(visitor2);
		decl2.accept(visitor1);
		decl2.accept(visitor2);
		
		Statement assign1 = nodeFactory.makeAssignment(x, exp);
		Statement assign2 = nodeFactory.makeAssignment(y, exp);
		assign1.accept(visitor1);
		assign1.accept(visitor2);
		assign2.accept(visitor1);
		assign2.accept(visitor2);
		
		Statement seq = nodeFactory.makeSequence(decl1, assign1, decl2, assign2);
		seq.accept(visitor1);
		seq.accept(visitor2);
		
		Iterator<Node> it1 = visitor1.getSearchResult().iterator();
		List<Node> nodes1 = new ArrayList<Node>();
		while(it1.hasAnotherElement()) {
			Node node = it1.nextElement();
			nodes1.add(node);
		}
		
		Iterator<Node> it2 = visitor2.getSearchResult().iterator();
		List<Node> nodes2 = new ArrayList<Node>();
		while(it2.hasAnotherElement()) {
			Node node = it2.nextElement();
			nodes2.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 3, nodes1.size());
		assertThat(nodes1, CoreMatchers.hasItems(assign1, decl1, assign2));
		
		assertEquals("Incorrect number of values returned", 2, nodes2.size());
		assertThat(nodes2, CoreMatchers.hasItems(assign2, decl2));
	}
	
	/**
	 * A method to test the search of a variable that might appear in the an
	 * Assignment or Declaration
	 * 
	 * Complex case
	 */
	@Test
	public void testNodeSearch7(){
		ASTSearchVisitor visitor1 = new ASTSearchVisitor("x");
		ASTSearchVisitor visitor2 = new ASTSearchVisitor("y");
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable varA = new Variable("x");
		Variable varB = new Variable("a");
		
		Expression a = nodeFactory.makeVariableExpression(varA);
		a.accept(visitor1);
		a.accept(visitor2);
		
		Expression b = nodeFactory.makeVariableExpression(varB);
		b.accept(visitor1);
		b.accept(visitor2);
		
		Operator minus = new Operator("-");
		
		Expression exp = nodeFactory.makePrefixExpression(minus, a, b);
		exp.accept(visitor1);
		exp.accept(visitor2);
		
		Statement decl1 = nodeFactory.makeDeclaration(x);
		Statement decl2 = nodeFactory.makeDeclaration(y);
		decl1.accept(visitor1);
		decl1.accept(visitor2);
		decl2.accept(visitor1);
		decl2.accept(visitor2);
		
		Statement assign1 = nodeFactory.makeAssignment(x, exp);
		Statement assign2 = nodeFactory.makeAssignment(y, exp);
		assign1.accept(visitor1);
		assign1.accept(visitor2);
		assign2.accept(visitor1);
		assign2.accept(visitor2);
		
		Statement seq = nodeFactory.makeSequence(decl1, assign1, decl2, assign2);
		seq.accept(visitor1);
		seq.accept(visitor2);
		
		Iterator<Node> it1 = visitor1.getSearchResult().iterator();
		List<Node> nodes1 = new ArrayList<Node>();
		while(it1.hasAnotherElement()) {
			Node node = it1.nextElement();
			nodes1.add(node);
		}
		
		Iterator<Node> it2 = visitor2.getSearchResult().iterator();
		List<Node> nodes2 = new ArrayList<Node>();
		while(it2.hasAnotherElement()) {
			Node node = it2.nextElement();
			nodes2.add(node);
		}
		
		assertEquals("Incorrect number of values returned", 3, nodes1.size());
		assertThat(nodes1, CoreMatchers.hasItems(assign1, decl1, assign2));
		
		assertEquals("Incorrect number of values returned", 2, nodes2.size());
		assertThat(nodes2, CoreMatchers.hasItems(assign2, decl2));
	}
	
}

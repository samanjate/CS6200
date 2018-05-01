package test3a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import q3a.Expression;
import q3a.Node;
import q3a.NodeFactory;
import q3a.Operator;
import q3a.Statement;
import q3a.Variable;

/**
 * A class to test the ID generator of the abstract Node class
 * 
 * @author Samanjate Sood
 *
 */
public class ASTTests {
	
	/**
	 * A method to test the getNode method returns the correct Node
	 * 
	 * This method tests that the id returned by the getNode method does in fact 
	 * return the Node when passed its Id 
	 */
	@Test
	public void testGetNode() {
		NodeFactory nodeFactory = NodeFactory.getInstance();
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertEquals(Node.getNode(one.getId()), one);
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertEquals(Node.getNode(two.getId()), two);
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertEquals(Node.getNode(exp.getId()), exp);
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertEquals(Node.getNode(decl.getId()), decl);
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertEquals(Node.getNode(assign.getId()), assign);
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertEquals(Node.getNode(seq.getId()), seq);
		
		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());
	}
	
	/**
	 * A method to test the unique ID generator of the Node class up to 
	 * 100000 nods
	 * 
	 * This method tests that the ID's generated are unique
	 */
	@Test
	public void testUniqueId() {
		NodeFactory nodeFactory = NodeFactory.getInstance();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i < 100000; i++) {
			Expression node = nodeFactory.makeNumberExpression(1);
			assertFalse(list.contains(node.getId()));
			list.add(node.getId());
		}
	}
	
	/**
	 * A method to test the getId of the Node class up to 100000 nods
	 * 
	 * This method tests that the ID's generated are incremental
	 */
	@Test
	public void testGetId() {
		NodeFactory nodeFactory = NodeFactory.getInstance();
		int expextedId = 1;
		
		for(int i = 1; i < 100000; i++) {
			Expression node = nodeFactory.makeNumberExpression(1);
			assertEquals(expextedId++, node.getId());
		}
	}
}

package test3ba;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import q3ba.Expression;
import q3ba.Iterator;
import q3ba.Node;
import q3ba.NodeFactory;
import q3ba.NodeSet;
import q3ba.Operator;
import q3ba.Statement;
import q3ba.Variable;

/**
 * A test suite to test the NodeSet class 
 * 
 * @author Samanjate Sood
 *
 */
public class NodeSetTests {
	
	/**
	 * A method to test the toString method of the NodeSet class
	 * 
	 * Test cases:
	 * 1) An empty set returns "Empty Set"
	 * 2) Elements added shows up as expected
	 * 3) Elements removed is removed from the string
	 */
	@Test
	public void testString() {
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet = new NodeSet();
		assertEquals("Should return \"Empty Set\"","Empty Set", nodeSet.toString());
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertFalse(nodeSet.contains(one));
		nodeSet.add(one);
		assertEquals("Should return { 1 }", "{ 1 }", nodeSet.toString());
		assertTrue(nodeSet.contains(one));
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertFalse(nodeSet.contains(two));
		nodeSet.add(two);
		assertEquals("Should return { 1, 2 }", "{ 1, 2 }", nodeSet.toString());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertFalse(nodeSet.contains(exp));
		nodeSet.add(exp);
		assertEquals("Should return { 1, 2, 1 + 2 }", "{ 1, 2, 1 + 2 }", nodeSet.toString());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertFalse(nodeSet.contains(decl));
		nodeSet.add(decl);
		assertEquals("Should return { 1, 2, 1 + 2, var x }", 
					 "{ 1, 2, 1 + 2, var x }", 
					 nodeSet.toString());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertFalse(nodeSet.contains(assign));
		nodeSet.add(assign);
		assertEquals("Should return { 1, 2, 1 + 2, var x, x = 1 + 2 }", 
				 "{ 1, 2, 1 + 2, var x, x = 1 + 2 }", 
				 nodeSet.toString());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertFalse(nodeSet.contains(seq));
		nodeSet.add(seq);
		assertEquals("Should return { 1, 2, 1 + 2, var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 "{ 1, 2, 1 + 2, var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 nodeSet.toString());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(one);
		assertEquals("Should return { 2, 1 + 2, var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 "{ 2, 1 + 2, var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 nodeSet.toString());
		assertFalse(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(two);
		assertEquals("Should return { 1 + 2, var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 "{ 1 + 2, var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 nodeSet.toString());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(exp);
		assertEquals("Should return { var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 "{ var x, x = 1 + 2, var x; x = 1 + 2; }", 
				 nodeSet.toString());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(decl);
		assertEquals("Should return { x = 1 + 2, var x; x = 1 + 2; }", 
				 "{ x = 1 + 2, var x; x = 1 + 2; }", 
				 nodeSet.toString());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(assign);
		assertEquals("Should return { var x; x = 1 + 2; }", 
				 "{ var x; x = 1 + 2; }", 
				 nodeSet.toString());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertFalse(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(seq);
		assertEquals("Should return \"Empty Set\"","Empty Set", nodeSet.toString());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertFalse(nodeSet.contains(assign));
		assertFalse(nodeSet.contains(seq));
		
		assertEquals(0, nodeSet.size());
	}

	/**
	 * A method to test the add method of the NodeSet class
	 * 
	 * Test cases:
	 * 1) The Node added is in the set
	 * 2) Previously added nodes are not affected by the new Nodes.
	 * 3) Adding the node twice does not affect the size
	 */
	@Test
	public void testAddContains() {
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet = new NodeSet();
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertFalse(nodeSet.contains(one));
		nodeSet.add(one);
		assertTrue(nodeSet.contains(one));
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertFalse(nodeSet.contains(two));
		nodeSet.add(two);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertFalse(nodeSet.contains(exp));
		nodeSet.add(exp);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertFalse(nodeSet.contains(decl));
		nodeSet.add(decl);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertFalse(nodeSet.contains(assign));
		nodeSet.add(assign);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertFalse(nodeSet.contains(seq));
		nodeSet.add(seq);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		//adding element a second time to the set
		int preSize = nodeSet.size();
		nodeSet.add(seq);
		assertTrue(nodeSet.contains(seq));
		assertEquals(preSize, nodeSet.size());
		
		nodeSet.add(assign);
		assertTrue(nodeSet.contains(assign));
		assertEquals(preSize, nodeSet.size());
	}
	
	/**
	 * A method to test the remove method of the NodeSet class
	 * 
	 * Test cases:
	 * 1) The Nodes removed from the set are no longer contained in it
	 * 2) Previously added Nodes are not removed from the Set
	 * 3) Removing a Node twice does not have any affect on the size of the set
	 */
	@Test
	public void testRemoveContains() {
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet = new NodeSet();
		assertEquals(0, nodeSet.size());
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertFalse(nodeSet.contains(one));
		nodeSet.add(one);
		assertTrue(nodeSet.contains(one));
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertFalse(nodeSet.contains(two));
		nodeSet.add(two);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertFalse(nodeSet.contains(exp));
		nodeSet.add(exp);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertFalse(nodeSet.contains(decl));
		nodeSet.add(decl);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertFalse(nodeSet.contains(assign));
		nodeSet.add(assign);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertFalse(nodeSet.contains(seq));
		nodeSet.add(seq);
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(one);
		assertFalse(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(two);
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(exp);
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(decl);
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(assign);
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertFalse(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		//removing element that does not exist in the set
		int preSize = nodeSet.size();
		nodeSet.remove(assign);
		assertEquals(preSize, nodeSet.size());
		
		nodeSet.remove(seq);
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertFalse(nodeSet.contains(assign));
		assertFalse(nodeSet.contains(seq));
		
		//removing element that does not exist in the set
		preSize = nodeSet.size();
		nodeSet.remove(assign);
		assertEquals(preSize, nodeSet.size());
		
		assertEquals(0, nodeSet.size());
	}
	
	/**
	 * A method to test the size method of the NodeSet class
	 * 
	 * Test cases:
	 * 1) The initial size and size of empty set are zero
	 * 2) The Node added is in the set increments size by 1
	 * 3) Removing a Node decrements the size by 1.
	 */
	@Test
	public void testSize() {
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet = new NodeSet();
		assertEquals(0, nodeSet.size());
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertFalse(nodeSet.contains(one));
		nodeSet.add(one);
		assertEquals(1, nodeSet.size());
		assertTrue(nodeSet.contains(one));
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertFalse(nodeSet.contains(two));
		nodeSet.add(two);
		assertEquals(2, nodeSet.size());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertFalse(nodeSet.contains(exp));
		nodeSet.add(exp);
		assertEquals(3, nodeSet.size());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertFalse(nodeSet.contains(decl));
		nodeSet.add(decl);
		assertEquals(4, nodeSet.size());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertFalse(nodeSet.contains(assign));
		nodeSet.add(assign);
		assertEquals(5, nodeSet.size());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertFalse(nodeSet.contains(seq));
		nodeSet.add(seq);
		assertEquals(6, nodeSet.size());
		assertTrue(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(one);
		assertEquals(5, nodeSet.size());
		assertFalse(nodeSet.contains(one));
		assertTrue(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(two);
		assertEquals(4, nodeSet.size());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertTrue(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(exp);
		assertEquals(3, nodeSet.size());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertTrue(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(decl);
		assertEquals(2, nodeSet.size());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertTrue(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(assign);
		assertEquals(1, nodeSet.size());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertFalse(nodeSet.contains(assign));
		assertTrue(nodeSet.contains(seq));
		
		nodeSet.remove(seq);
		assertEquals(0, nodeSet.size());
		assertFalse(nodeSet.contains(one));
		assertFalse(nodeSet.contains(two));
		assertFalse(nodeSet.contains(exp));
		assertFalse(nodeSet.contains(decl));
		assertFalse(nodeSet.contains(assign));
		assertFalse(nodeSet.contains(seq));
		
		assertEquals(0, nodeSet.size());
	}
	
	/**
	 * A method to test the addAll method of the NodeSet class
	 * 
	 * Test cases:
	 * 1) Union of two sets that have no elements in common
	 * 2) The second set should be unaffected by the first
	 */
	@Test
	public void testAddAll1() {
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet1 = new NodeSet();
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertFalse(nodeSet1.contains(one));
		nodeSet1.add(one);
		assertTrue(nodeSet1.contains(one));
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertFalse(nodeSet1.contains(two));
		nodeSet1.add(two);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertFalse(nodeSet1.contains(exp));
		nodeSet1.add(exp);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertFalse(nodeSet1.contains(decl));
		nodeSet1.add(decl);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertFalse(nodeSet1.contains(assign));
		nodeSet1.add(assign);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		assertTrue(nodeSet1.contains(assign));
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertFalse(nodeSet1.contains(seq));
		nodeSet1.add(seq);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		assertTrue(nodeSet1.contains(assign));
		assertTrue(nodeSet1.contains(seq));
		
		NodeSet nodeSet2 = new NodeSet();
		
		Variable y = new Variable("y");
		
		Expression five = nodeFactory.makeNumberExpression(5);
		assertFalse(nodeSet2.contains(five));
		nodeSet2.add(five);
		assertTrue(nodeSet2.contains(five));
		
		Expression six = nodeFactory.makeNumberExpression(6);
		assertFalse(nodeSet2.contains(six));
		nodeSet2.add(six);
		assertTrue(nodeSet2.contains(five));
		assertTrue(nodeSet2.contains(six));
		
		Operator divide = new Operator("/");
		
		Expression inExp = nodeFactory.makeInfixExpression(divide, five, six);
		assertFalse(nodeSet2.contains(inExp));
		nodeSet2.add(inExp);
		assertTrue(nodeSet2.contains(five));
		assertTrue(nodeSet2.contains(six));
		assertTrue(nodeSet2.contains(inExp));
		
		Statement declY = nodeFactory.makeDeclaration(y);
		assertFalse(nodeSet2.contains(declY));
		nodeSet2.add(declY);
		assertTrue(nodeSet2.contains(five));
		assertTrue(nodeSet2.contains(six));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		
		Statement assignY = nodeFactory.makeAssignment(y, inExp);
		assertFalse(nodeSet2.contains(assignY));
		nodeSet2.add(assignY);
		assertTrue(nodeSet2.contains(five));
		assertTrue(nodeSet2.contains(six));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		assertTrue(nodeSet2.contains(assignY));
		
		Statement seq1 = nodeFactory.makeSequence(declY, assignY);
		assertFalse(nodeSet2.contains(seq1));
		nodeSet2.add(seq1);
		assertTrue(nodeSet2.contains(five));
		assertTrue(nodeSet2.contains(six));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		assertTrue(nodeSet2.contains(assignY));
		assertTrue(nodeSet2.contains(seq1));
		
		//set 1 elements
		assertFalse(nodeSet1.contains(five));
		assertFalse(nodeSet1.contains(six));
		assertFalse(nodeSet1.contains(inExp));
		assertFalse(nodeSet1.contains(declY));
		assertFalse(nodeSet1.contains(assignY));
		assertFalse(nodeSet1.contains(seq1));
		
		//set 2 elements
		assertFalse(nodeSet2.contains(one));
		assertFalse(nodeSet2.contains(two));
		assertFalse(nodeSet2.contains(exp));
		assertFalse(nodeSet2.contains(decl));
		assertFalse(nodeSet2.contains(assign));
		assertFalse(nodeSet2.contains(seq));
		
		int set1Size = nodeSet1.size();
		int set2Size = nodeSet2.size();
		nodeSet1.addAll(nodeSet2);
		
		assertEquals(set1Size + set2Size, nodeSet1.size());
		assertEquals(set2Size, nodeSet2.size());
		
		//set 1 elements
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		assertTrue(nodeSet1.contains(assign));
		assertTrue(nodeSet1.contains(seq));
		assertTrue(nodeSet1.contains(five));
		assertTrue(nodeSet1.contains(six));
		assertTrue(nodeSet1.contains(inExp));
		assertTrue(nodeSet1.contains(declY));
		assertTrue(nodeSet1.contains(assignY));
		assertTrue(nodeSet1.contains(seq1));
		
		//set 2 elements
		assertFalse(nodeSet2.contains(one));
		assertFalse(nodeSet2.contains(two));
		assertFalse(nodeSet2.contains(exp));
		assertFalse(nodeSet2.contains(decl));
		assertFalse(nodeSet2.contains(assign));
		assertFalse(nodeSet2.contains(seq));
		assertTrue(nodeSet2.contains(five));
		assertTrue(nodeSet2.contains(six));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		assertTrue(nodeSet2.contains(assignY));
		assertTrue(nodeSet2.contains(seq1));
	}
	
	/**
	 * A method to test the addAll method of the NodeSet class
	 * 
	 * Test cases:
	 * 1) Union of two sets that have some elements in common
	 * 2) The second set should be unaffected by the first
	 */
	@Test
	public void testAddAll2() {
		NodeFactory  nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet1 = new NodeSet();
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		assertFalse(nodeSet1.contains(one));
		nodeSet1.add(one);
		assertTrue(nodeSet1.contains(one));
		
		Expression two = nodeFactory.makeNumberExpression(2);
		assertFalse(nodeSet1.contains(two));
		nodeSet1.add(two);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		assertFalse(nodeSet1.contains(exp));
		nodeSet1.add(exp);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		
		Statement decl = nodeFactory.makeDeclaration(x);
		assertFalse(nodeSet1.contains(decl));
		nodeSet1.add(decl);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		assertFalse(nodeSet1.contains(assign));
		nodeSet1.add(assign);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		assertTrue(nodeSet1.contains(assign));
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		assertFalse(nodeSet1.contains(seq));
		nodeSet1.add(seq);
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		assertTrue(nodeSet1.contains(assign));
		assertTrue(nodeSet1.contains(seq));
		
		NodeSet nodeSet2 = new NodeSet();
		
		Variable y = new Variable("y");
		
		assertFalse(nodeSet2.contains(one));
		nodeSet2.add(one);
		assertTrue(nodeSet2.contains(one));
		
		assertFalse(nodeSet2.contains(two));
		nodeSet2.add(two);
		assertTrue(nodeSet2.contains(one));
		assertTrue(nodeSet2.contains(two));
		
		Operator divide = new Operator("/");
		
		Expression inExp = nodeFactory.makeInfixExpression(divide, one, two);
		assertFalse(nodeSet2.contains(inExp));
		nodeSet2.add(inExp);
		assertTrue(nodeSet2.contains(one));
		assertTrue(nodeSet2.contains(two));
		assertTrue(nodeSet2.contains(inExp));
		
		Statement declY = nodeFactory.makeDeclaration(y);
		assertFalse(nodeSet2.contains(declY));
		nodeSet2.add(declY);
		assertTrue(nodeSet2.contains(one));
		assertTrue(nodeSet2.contains(two));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		
		Statement assignY = nodeFactory.makeAssignment(y, inExp);
		assertFalse(nodeSet2.contains(assignY));
		nodeSet2.add(assignY);
		assertTrue(nodeSet2.contains(one));
		assertTrue(nodeSet2.contains(two));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		assertTrue(nodeSet2.contains(assignY));
		
		Statement seq1 = nodeFactory.makeSequence(declY, assignY);
		assertFalse(nodeSet2.contains(seq1));
		nodeSet2.add(seq1);
		assertTrue(nodeSet2.contains(one));
		assertTrue(nodeSet2.contains(two));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		assertTrue(nodeSet2.contains(assignY));
		assertTrue(nodeSet2.contains(seq1));
		
		//set 1 elements
		assertFalse(nodeSet1.contains(inExp));
		assertFalse(nodeSet1.contains(declY));
		assertFalse(nodeSet1.contains(assignY));
		assertFalse(nodeSet1.contains(seq1));
		
		//set 2 elements
		assertFalse(nodeSet2.contains(exp));
		assertFalse(nodeSet2.contains(decl));
		assertFalse(nodeSet2.contains(assign));
		assertFalse(nodeSet2.contains(seq));
		
		int set2Size = nodeSet2.size();
		nodeSet1.addAll(nodeSet2);
		
		assertEquals(10, nodeSet1.size());
		assertEquals(set2Size, nodeSet2.size());
		
		//set 1 elements
		assertTrue(nodeSet1.contains(one));
		assertTrue(nodeSet1.contains(two));
		assertTrue(nodeSet1.contains(exp));
		assertTrue(nodeSet1.contains(decl));
		assertTrue(nodeSet1.contains(assign));
		assertTrue(nodeSet1.contains(seq));
		assertTrue(nodeSet1.contains(inExp));
		assertTrue(nodeSet1.contains(declY));
		assertTrue(nodeSet1.contains(assignY));
		assertTrue(nodeSet1.contains(seq1));
		
		//set 2 elements
		assertFalse(nodeSet2.contains(exp));
		assertFalse(nodeSet2.contains(decl));
		assertFalse(nodeSet2.contains(assign));
		assertFalse(nodeSet2.contains(seq));
		assertTrue(nodeSet2.contains(inExp));
		assertTrue(nodeSet2.contains(declY));
		assertTrue(nodeSet2.contains(assignY));
		assertTrue(nodeSet2.contains(seq1));
	}
	
	/**
	 * A method to test the iterator functionality of the NodeSet class
	 * 
	 * The cases tested are: 
	 * 1) Correct values are returned by the iterator
	 * 2) The correct number of values are returned
	 */
	@Test
	public void testIterator() {
		NodeFactory nodeFactory = NodeFactory.getInstance();
		NodeSet nodeSet = new NodeSet();
		
		Variable x = new Variable("x");
		
		Expression one = nodeFactory.makeNumberExpression(1);
		nodeSet.add(one);
		
		Expression two = nodeFactory.makeNumberExpression(2);
		nodeSet.add(two);
		
		Operator plus = new Operator("+");
		
		Expression exp = nodeFactory.makeInfixExpression(plus, one, two);
		nodeSet.add(exp);
		
		Statement decl = nodeFactory.makeDeclaration(x);
		nodeSet.add(decl);
		
		Statement assign = nodeFactory.makeAssignment(x, exp);
		nodeSet.add(assign);
		
		Statement seq = nodeFactory.makeSequence(decl, assign);
		nodeSet.add(seq);

		Iterator<Node> it = nodeSet.iterator();
		List<Node> nodes = new ArrayList<Node>();
		while(it.hasAnotherElement()) {
			Node node = it.nextElement();
			nodes.add(node);
		}
		assertEquals("Incorrect number of values returned", nodes.size(), nodeSet.size());
		assertThat(nodes, CoreMatchers.hasItems(one,two,exp,decl,assign,seq));	
	}
}

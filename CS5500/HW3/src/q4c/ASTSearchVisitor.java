package q4c;

public class ASTSearchVisitor implements ASTVisitor {

	NodeSet result;
	String searchVar = "";
	
	/**
	 * @param A Variable that need to be searched.
	 */
	public ASTSearchVisitor(String var) {
		result = new NodeSet();
		if(var != null) {
			searchVar = var;
		}
	}
	
 	@Override
	public void visit(InfixExpression node) {
		//Does nothing as we don't want to add an InfixExpression in the result set
	}

	@Override
	public void visit(PrefixExpression node) {
		//Does nothing as we don't want to add a PrefixExpression in the result set
		
	}

	@Override
	public void visit(NumberExpression node) {
		//Does nothing as we don't want to add a NumberExpression in the result set
	}

	@Override
	public void visit(StringExpression node) {
		//Does nothing as we don't want to add a StringExpression in the result set
	}

	@Override
	public void visit(VariableExpression node) {
		//Does nothing as we don't want to add a VariableExpression in the result set
	}

	/**
	 * Adds the node to the result set if it contains value same as the searchVar
	 */
	@Override
	public void visit(Declaration node) {
		if(node.getVariable().getText().equals(searchVar)) {
			result.add(node);
		}
	}

	/**
	 * Adds the node to the result set if the assignment expression contains the 
	 * serachVar or if the assignment is for the searchVar
	 */
	@Override
	public void visit(Assignment node) {
		if(node.getVariable().getText().equals(searchVar) 
		   || node.getExpression().textRepresentation().contains(" "+ searchVar +" ")
		   || node.getExpression().textRepresentation().contains(" "+ searchVar)) {
			result.add(node);
		}
	}

	@Override
	public void visit(Sequence node) {
		//Does nothing as we don't want to add a Sequence in the result set
	}
	
	/**
	 * 
	 * @return the search result in form of a NodeSet
	 */
	public NodeSet getSearchResult() {
		return result;
	}

}

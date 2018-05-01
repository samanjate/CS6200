package ast3;

/**
 * 
 * This class implements the Statement interface and represents the final 
 * output of the program.
 * 
 * @author Samanjate Sood
 *
 */
public class Sequence implements Statement {

	private Statement[] statements;
	
	public Sequence(Statement... statements) {
		this.statements = statements;
	}
	/**
	 * @return The final formatted sequence of statements of the program.
	 */
	@Override
	public String textRepresentation() {
		StringBuilder text = new StringBuilder();
		for(Statement statement : statements) {
			text.append(statement.textRepresentation()).append("; ");
		}
		return text.toString().trim();
	}

}

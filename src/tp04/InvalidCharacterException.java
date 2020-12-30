package tp04;

public class InvalidCharacterException extends Exception {
	
	private final String name;
	
	public InvalidCharacterException(String name) {
		super("Invalid character: " + name);
		this.name = name;
	}
	
	public final String getName() {
		return name;
	}
}

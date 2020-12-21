package tp04;

public abstract class MBox implements VertexInterface{
	
	private final int xPos ;
	private final int yPos ;
	private final String label ; 
	
	protected MBox(int xPos, int yPos, String label) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.label = label;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public String getLabel() {
		return this.label;
	}
}

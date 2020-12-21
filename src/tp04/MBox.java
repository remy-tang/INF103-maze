package tp04;

public abstract class MBox implements VertexInterface{
	
	private final int xPos ;
	private final int yPos ;
	private String label ;
	
	public MBox(int xPos, int yPos) {
		this.xPos = xPos ;
		this.yPos = yPos ;
	}
	
	public int getXPos() {
		return xPos ;
	}
	
	public int getYPos() {
		return yPos ;
	}
	
	public String getLabel() {
		return this.label;
	}
}

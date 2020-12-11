package tp04;

public abstract class MBox {
	
	private final int xPos ;
	private final int yPos ;
	
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

}

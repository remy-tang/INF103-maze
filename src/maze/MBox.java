package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface{
	
	private final int xPos;
	private final int yPos;
	private final String label; 
	private int status = 0; // 0 if not part of solution, 1 if it is in the shortest path
	
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
	
	public int getStatus() {
		return this.status;
	}
	
	public void updateStatus() {
		this.status = 1;
	}
}

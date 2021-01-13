package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface{
	
	private final int nPos;
	private final int pPos;
	private final String label; 
	private int status = 0; // 0 if not part of solution, 1 if it is in the shortest path
	
	protected MBox(int nPos, int pPos, String label) {
		this.nPos = nPos;
		this.pPos = pPos;
		this.label = label;
	}
	
	public int getNPos() {
		return nPos;
	}
	
	public int getPPos() {
		return pPos;
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

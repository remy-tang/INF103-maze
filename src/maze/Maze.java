package maze;
import java.io.*;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	
	private MBox[][] boxes;
	private final int xMax;				/* Indice maximum selon les x */
	private final int yMax;				/* Indice maximum selon les y */
	
	public Maze(int xMax, int yMax) {
		boxes = new MBox[xMax+1][yMax+1];
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
    public ArrayList<VertexInterface> getAllVertices() {
    	
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < xMax+1; i++) {
    		for (int j = 0; j < yMax+1; j++) {
    			boxesList.add(boxes[i][j]);
    		}
    	}
    	return boxesList;
    }
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		
		MBox box = (MBox)vertex ;
		int x = box.getXPos();
		int y = box.getYPos();
		ArrayList<VertexInterface> neighbourList = new ArrayList<VertexInterface>() ; 
		
		if (x != 0)
			neighbourList.add(boxes[x-1][y]);
		if (x != xMax)
			neighbourList.add(boxes[x+1][y]);
		if (y != 0)
			neighbourList.add(boxes[x][y-1]);
		if (y != yMax)
			neighbourList.add(boxes[x][y+1]);
			
		return neighbourList;	}

    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
    
    public final void initFromTextFile(String fileName) 
    		throws MazeReadingException {
    	
    	FileReader fr = null;
    	BufferedReader br = null;
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		int i = 0; // i correspond à xPos
    		String currentLine = br.readLine();
    				
    		while (currentLine != null && i<=xMax) {
    			
    			int lineLen = currentLine.length() - 1;
    			if (lineLen != xMax)
    				throw new MazeReadingException(fileName, 91, "Wrong maze size along x axis: " + lineLen + ", expected " + xMax);
    			
    			for (int j=0; j<=yMax; j++) { // j correspond à yPos
    				String currentLetter = Character.toString(currentLine.charAt(j)).toUpperCase();
    				
    				if (currentLetter.equals("E"))
    					boxes[i][j] = new EBox(i,j);
    				else if (currentLetter.equals("W"))
    					boxes[i][j] = new WBox(i,j);
    				else if (currentLetter.equals("D")) // On suppose qu'il n'y a qu'un D et qu'un A dans fileName pour l'instant
    					boxes[i][j] = new DBox(i,j);
    				else if (currentLetter.equals("A"))
    					boxes[i][j] = new ABox(i,j);
    				else
    					throw new MazeReadingException(fileName, 91, "Wrong character: " + currentLetter + ", expected 'E','W','D','A'.");
    			}
    			currentLine = br.readLine();
    			i ++;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			br.close();
    			fr.close();}
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public final void saveToTextFile(String fileName) {
    	
    	FileReader fr = null;
    	BufferedReader br = null;
    	FileOutputStream fos = null;
    	PrintWriter pw = null;
    	
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		fos = new FileOutputStream("data/labyrinthe2.txt");
    		pw = new PrintWriter(fos);
    		
    		String currentLine = br.readLine();
    		while (currentLine != null) {
    			pw.println(currentLine);
    			currentLine = br.readLine();
    		}
    			
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			br.close();
    			fr.close();
    			pw.close();
    			fos.close();
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	}
    }
}

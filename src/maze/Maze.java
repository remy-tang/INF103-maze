package maze;
import java.io.*;
import java.util.ArrayList;

import dijkstra.*;

public class Maze implements GraphInterface {
	
	private MBox[][] boxes;
	private final int nMax;				/* Indice maximum selon les lignes */
	private final int pMax;				/* Indice maximum selon les colonnes */
	private MBox DBox;
	private MBox ABox;
	
	public Maze(int nMax, int pMax) {
		boxes = new MBox[nMax+1][pMax+1];
		this.nMax = nMax;
		this.pMax = pMax;
	}
	
    public ArrayList<VertexInterface> getAllVertices() {
    	
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < nMax+1; i++) {
    		for (int j = 0; j < pMax+1; j++) {
    			boxesList.add(boxes[i][j]);
    		}
    	}
    	return boxesList;
    }
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		
		MBox box = (MBox)vertex ;
		int n = box.getNPos();
		int p = box.getPPos();
		ArrayList<VertexInterface> neighbourList = new ArrayList<VertexInterface>() ; 
		
		if (n != 0)
			neighbourList.add(boxes[n-1][p]);
		if (n != nMax)
			neighbourList.add(boxes[n+1][p]);
		if (p != 0)
			neighbourList.add(boxes[n][p-1]);
		if (p != pMax)
			neighbourList.add(boxes[n][p+1]);
			
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
    		
    		int n = 0; // n parcourt les lignes
    		String currentLine = br.readLine();
    				
    		while (currentLine != null && n<=nMax) {
    			int lineLen = currentLine.length() - 1; // Vérification du format des lignes
    			
    			if (lineLen != pMax) 
    				throw new MazeReadingException(fileName, 91, "Wrong size along horizontal axis: " + lineLen + ". Expected: " + nMax);
    			
    			for (int p=0; p<=pMax; p++) { // p parcourt les colonnes
    				String currentLetter = Character.toString(currentLine.charAt(p)).toUpperCase();
    				
    				if (currentLetter.equals("E"))
    					boxes[n][p] = new EBox(n,p);
    				else if (currentLetter.equals("W"))
    					boxes[n][p] = new WBox(n,p);
    				else if (currentLetter.equals("D")) { // On suppose qu'il n'y a qu'un D et qu'un A dans fileName
    					boxes[n][p] = new DBox(n,p);
    					DBox = boxes[n][p];
    				}
    				else if (currentLetter.equals("A")) {
    					boxes[n][p] = new ABox(n,p);
    					ABox = boxes[n][p];
    				}
    				else
    					throw new MazeReadingException(fileName, 91, "Wrong character: " + currentLetter + ", expected 'E','W','D','A'.");
    			}
    			currentLine = br.readLine();
    			n++;
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
    
    private static void updateBox(Maze maze, int i, int j) {
    	maze.boxes[i][j].updateStatus();
    }
    
    public static String solvedMazeString(Maze maze) { //weird thing for arguments here  : maze.func(maze)....
    	
    	Maze solvedMaze = maze;
    	PreviousInterface solution;
    	solution = Dijkstra.dijkstra(maze,maze.DBox);
		ArrayList<VertexInterface> shortestPath = solution.getShortestPathTo(maze.ABox);
		String solvedMazeString = "";
		
		for (VertexInterface vertex : shortestPath) {
			if (((MBox)vertex).getLabel().equals("EBox")) {
				int i=((MBox)vertex).getNPos();
				int j=((MBox)vertex).getPPos();
				updateBox(solvedMaze,i,j);
			}
		}
		
		for (int i=0; i<=maze.nMax; i++) {
			String newline = "";
			for (int j=0; j<=maze.pMax; j++) {
				if (solvedMaze.boxes[i][j].getLabel().equals("EBox")) {
					if (solvedMaze.boxes[i][j].getStatus() == 1)
						newline += "*";
					else
						newline += "E";
				}
				else if (solvedMaze.boxes[i][j].getLabel().equals("WBox"))
					newline += "W";
				else if (solvedMaze.boxes[i][j].getLabel().equals("DBox"))
					newline += "D";
				else if (solvedMaze.boxes[i][j].getLabel().equals("ABox"))
					newline += "A";
			}
			solvedMazeString += newline + "\n";
		}
		
    	return solvedMazeString;
    }
}

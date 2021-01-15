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
		
		if (n != 0 && boxes[n-1][p].getLabel() != "WBox")
			neighbourList.add(boxes[n-1][p]);
		if (n != nMax && boxes[n+1][p].getLabel() != "WBox")
			neighbourList.add(boxes[n+1][p]);
		if (p != 0 && boxes[n][p-1].getLabel() != "WBox")
			neighbourList.add(boxes[n][p-1]);
		if (p != pMax && boxes[n][p+1].getLabel() != "WBox")
			neighbourList.add(boxes[n][p+1]);
			
		return neighbourList;	}

	
    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
    
    public final int countLines(String fileName) {
    	FileReader fr = null;
    	BufferedReader br = null;
        int lineCount = 0;
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		while (br.readLine() != null) 
    			lineCount++;
    	} 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        return lineCount;

    }
    
    public final void initFromTextFile(String fileName) 
    		throws MazeReadingException {
    	
    	FileReader fr = null;
    	BufferedReader br = null;
    	
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		int lineCount = countLines(fileName);
    		
    		if (lineCount != nMax) 
				throw new MazeReadingException(fileName, 73, "Wrong size along vertical axis: " + lineCount + ". Expected: " + nMax);
    				
    		String currentLine = br.readLine();
    		
    		int n = 0; // n parcourt les lignes
    		while (n<=nMax) {
    			
    			/* Vérification du format des lignes */
    			int lineLen = currentLine.length() - 1; // 
    			if (lineLen != pMax) 
    				throw new MazeReadingException(fileName, 79, "Wrong size along horizontal axis: " + lineLen + ". Expected: " + pMax);
    			
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
    	} 
    	catch (Exception e) {
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
    
    public final void saveToTextFile(String fileName, String solvedMazeString) {
    	
    	FileOutputStream fos = null;
    	PrintWriter pw = null;
    	
    	try {
    		String filePath = "data/" + fileName + ".txt";
    		fos = new FileOutputStream(filePath);
    		pw = new PrintWriter(fos);
    		pw.print(solvedMazeString);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			pw.close();
    			fos.close();
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	}
    }
    
    /* Permet d'indiquer que la box fait partie du plus court chemin */
    private void updateBox(int i, int j) {
    	boxes[i][j].updateStatus();
    }
    
    public Maze solvedMaze() {
    	
    	Maze solvedMaze = this;
    	PreviousInterface solution = Dijkstra.dijkstra(this,this.DBox);
		ArrayList<VertexInterface> shortestPath = solution.getShortestPathTo(this.ABox);
		
		for (VertexInterface vertex : shortestPath) {
			int i=((MBox)vertex).getNPos();
			int j=((MBox)vertex).getPPos();
			solvedMaze.updateBox(i,j);
		}
		
		return solvedMaze;
    }

    /* Création du string du labyrinthe résolu */
    public String solvedMazeToString() {
		
		String solvedMazeString = "";
		int pathLen = 0;
		int solved = 0;
		
		for (int i=0; i<=nMax; i++) {
			String newline = "";
			for (int j=0; j<=pMax; j++) {
				if (boxes[i][j].getLabel().equals("EBox")) {
					if (boxes[i][j].getStatus() == 1) {
						newline += "."; 
						pathLen++;
						solved = 1;
					}
					else
						newline += "E";
				}
				else if (boxes[i][j].getLabel().equals("WBox"))
					newline += "W";
				else if (boxes[i][j].getLabel().equals("DBox"))
					newline += "D";
				else if (boxes[i][j].getLabel().equals("ABox")) {
					newline += "A";
					pathLen++;
				}
			}
			solvedMazeString += newline + "\n";
		}
		
		if (solved==1) {
			solvedMazeString += "A solution was found!\n";
			solvedMazeString += "Path length : " + pathLen;
		}
    	return solvedMazeString;
    }
}

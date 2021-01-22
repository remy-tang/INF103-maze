package maze;

import java.io.*;
import java.util.ArrayList;
import dijkstra.*;

/**
 * Repr�sente un labyrinthe rectangulaire.
 * 
 * @author Remy
 */
public class Maze implements GraphInterface {
	private MBox[][] boxes;
	private final int nMax;			
	private final int pMax;				
	private MBox DBox;
	private MBox ABox;
	
	/**
	 * Constructeur de classe qui cr�e un labyrinthe vide.
	 * Le labyrinthe est de dimension (nMax + 1, pMax +1).
	 * Les indices commencent � 0.
	 * 
	 * @param nMax  l'indice maximal selon les lignes
	 * @param pMax  l'indice maximal selon les colonnes
	 */
	public Maze(int nMax, int pMax) {
		boxes = new MBox[nMax+1][pMax+1];
		this.nMax = nMax;
		this.pMax = pMax;
	}
	
    public final ArrayList<VertexInterface> getAllVertices() {
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < nMax+1; i++) {
    		for (int j = 0; j < pMax+1; j++) {
    			boxesList.add(boxes[i][j]);
    		}
    	}
    	return boxesList;
    }
	
    /**
     * Renvoie une ArrayList qui contient tous les voisins d'une box
     * dont le label n'est pas "WBox".
     * 
     * @param  vertex  la box consid�r�e
     * @return         l'ArrayList des voisins de vertex qui ne sont pas des murs
     */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox box = (MBox) vertex ;
		int n = box.getNPos();
		int p = box.getPPos();
		ArrayList<VertexInterface> neighbourList = new ArrayList<VertexInterface>() ; 
		
		/* On teste les cas limites avec les if */
		if ((n != 0) && (boxes[n-1][p].getLabel() != "WBox"))
			neighbourList.add(boxes[n-1][p]);
		if ((n != nMax) && (boxes[n+1][p].getLabel() != "WBox"))
			neighbourList.add(boxes[n+1][p]);
		if ((p != 0) && (boxes[n][p-1].getLabel() != "WBox"))
			neighbourList.add(boxes[n][p-1]);
		if ((p != pMax) && (boxes[n][p+1].getLabel() != "WBox"))
			neighbourList.add(boxes[n][p+1]);
			
		return neighbourList;	
	}

	/**
	 * Renvoie 1.
	 * <p>
	 * Dans le cadre du projet du labyrinthe, les poids de tous les arcs valent 1.
	 * 
	 * @param  src 	la box au d�part de l'arc
	 * @param  dst  la box � l'arriv�e de l'arc
	 * @return      l'entier 1
	 */
    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
    
    /**
     * Renvoie le nombre de lignes cons�cutives non nulles 
     * d'un fichier texte, en comptant � partir du d�but du fichier.
     * Ce fichier doit �tre plac� dans le dossier data.
     * 
     * @param  fileName  le nom du fichier texte
     * @return           le nombre de lignes cons�cutives non nulles du fichier
     */
    public static final int countLines(String fileName) {
    	FileReader fr = null;
    	BufferedReader br = null;
        int lineCount = 0;
        
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		while (br.readLine() != null) 
    			lineCount++;
    		
    		return lineCount;
    	} catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    
    /**
     * Renvoie le nombre de caract�res de la premi�re ligne d'un fichier texte. 
     * Le caract�re '\n' n'est pas pris en compte. 
     * Ce fichier doit �tre plac� dans le dossier data.
     * 
     * @param  fileName  le nom du fichier
     * @return           le nombre de caract�res de la premi�re ligne du fichier
     */
    public static final int firstLineLen(String fileName) {
    	FileReader fr = null;
    	BufferedReader br = null;
    	
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		String firstLine = br.readLine();
    		
    		return firstLine.length();
    	} catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
    }
    
    /**
     * Renvoie le nombre de caract�res dans une ligne du fichier
     * si toutes les lignes ont la m�me longueur.
     * Le caract�re '\n' n'est pas pris en compte. 
     * Si une ligne a une longueur diff�rente de la premi�re ligne, 
     * la fonction renvoie la premi�re longueur qui diff�re.
     * En cas d'erreur, la fonction renvoie 0.
     * 
     * @param  fileName  le nom du fichier texte
     * @return			 la longueur des lignes du fichier, 
     * 					 ou la premi�re longueur qui diff�re de la premi�re ligne,
     * 					 ou 0 en cas d'erreur
     */
    public final int checkLinesLen(String fileName) {
    	FileReader fr = null;
    	BufferedReader br = null;
        
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		int lineLen;
    		String currentLine = br.readLine();
    		
    		/* Si le fichier est nul */
    		if (currentLine == null)
    			return 0;
    		
    		while (currentLine != null) {
    			lineLen = currentLine.length() - 1;
    			if (lineLen != pMax)
    				return lineLen;
    			currentLine = br.readLine();
    		}
    		return pMax;
    	} catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
    }
    
    /**
     * Initialise le labyrinthe � partir d'un fichier texte.
     * Ce fichier doit �tre plac� dans le dossier data.
     * <p>
     * Un fichier constitue un labyrinthe valide s'il comporte :
     * le m�me nombre de caract�res sur chacune des lignes,
     * une unique entr�e 'D', et une unique sortie 'A'.
     * De plus, les seuls caract�res accept�s sont : 'D', 'A', 'E', ou 'W'.
     * 
     * @param  fileName				 le nom du fichier texte
     * @throws MazeReadingException  si le fichier ne constitue pas un labyrinthe valide
     */
    public final void initFromTextFile(String fileName) throws MazeReadingException {
    	FileReader fr = null;
    	BufferedReader br = null;
    	
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		String currentLine = br.readLine();
    		
            /* V�rification du format des lignes */
    		int lineLen = checkLinesLen(fileName);
			if (lineLen != pMax) 
				throw new MazeReadingException(fileName, 0, 
											   "Wrong size along horizontal axis "
											   + "while reading data/" 
										       + fileName + ".txt : " 
											   + lineLen + ". Expected: " + pMax);
    		
            /* Initialisation */
    		int n = 0;
    		int dBoxFlag = 0;
    		int aBoxFlag = 0;
    		while (n<=nMax) {
    			
    			for (int p=0; p<=pMax; p++) {
    				String currentLetter = Character.toString(currentLine.charAt(p));
    				currentLetter = currentLetter.toUpperCase();
    				/* On compare � chaque lettre accept�e */
    				/* On v�rifie qu'il n'y a qu'un 'D' et qu'un 'A' */
    				if (currentLetter.equals("E")) {
    					boxes[n][p] = new EBox(n,p);
    				} else if (currentLetter.equals("W")) {
    					boxes[n][p] = new WBox(n,p);
    				} else if (currentLetter.equals("D")) {
    					if (dBoxFlag == 0) {
    						boxes[n][p] = new DBox(n,p);
    						DBox = boxes[n][p];
    						dBoxFlag = 1;
    					} else {
    						throw new MazeReadingException(fileName, 0, 
									   "Multiple characters 'D' detected. "
									   + "Only one authorized. "
									   + "Please check the maze at "
									   + "data/" + fileName + ".txt");
    					}
    				} else if (currentLetter.equals("A")) {
    					if (aBoxFlag == 0) {
    						boxes[n][p] = new ABox(n,p);
    						ABox = boxes[n][p];
    					} else {
    						throw new MazeReadingException(fileName, 0, 
									   "Multiple characters 'A' detected. "
									   + "Only one authorized. "
									   + "Please check the maze at "
									   + "data/" + fileName + ".txt");
    					}
    				} else { /* S'il y a un autre caract�re */
    					throw new MazeReadingException(fileName, 91, 
    												   "Wrong character: " + currentLetter 
    												   + ", expected 'D','A','E', or 'W'.");
    				}
    			}
    			currentLine = br.readLine();
    			n++;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			br.close();
    			fr.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * Sauvegarde un String sous la forme d'un fichier texte.
     * Le fichier ainsi cr�� se situe dans le dossier data.
     * 
     * @param fileName			le nom du fichier de sauvegarde
     * @param solvedMazeString  le String du labyrinthe r�solu
     */
    public final static void saveToTextFile(String fileName, String solvedMazeString) {
    	FileOutputStream fos = null;
    	PrintWriter pw = null;
    	
    	try {
    		String filePath = "data/" + fileName + ".txt";
    		fos = new FileOutputStream(filePath);
    		pw = new PrintWriter(fos);
    		pw.print(solvedMazeString);
    		System.out.println("Maze saved in data/" + fileName + ".txt");
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
    
    /**
     *  Permet d'indiquer que la box fait partie du plus court chemin.
     *  
     *  @param i  l'indice de la ligne de la box
     *  @param j  l'indice de la colonne de la box
     *  */
    private final void updateBox(int i, int j) {
    	boxes[i][j].updateStatus();
    }
    
    /**
     * Renvoie une copie r�solue du labyrinthe actuel, c'est-�-dire avec des 
     * box dont le status a �t� mis � jour
     * pour indiquer qu'elles appartiennent au plus court chemin.
     * Le plus court chemin entre DBox et Abox est celui qui a �t� trouv� 
     * par l'algorithme de Dijkstra.
     * 
     * @return une copie r�solue du labyrinthe
     */
    public final Maze solvedMaze() {
    	Maze solvedMaze = this;
    	PreviousInterface solution = Dijkstra.dijkstra(this, this.DBox);
		ArrayList<VertexInterface> shortestPath = solution.getShortestPathTo(this.ABox);
		
		for (VertexInterface vertex : shortestPath) {
			int i = ((MBox)vertex).getNPos();
			int j = ((MBox)vertex).getPPos();
			solvedMaze.updateBox(i, j);
		}
		return solvedMaze;
    }

    /**
     * Renvoie le String correspondant � un labyrinthe r�solu.
     * Le String contient des '.' pour indiquer le chemin � suivre, 
     * et la longueur du chemin trouv�.
     * Si le labyrinthe n'est pas r�solu, renvoie le labyrinthe sous forme de String.
     * 
     * @return le String correspondant � un labyrinthe, r�solu ou non
     */
    public final String solvedMazeToString() {
		String solvedMazeString = "";
		int pathLen = 0;
		int solved = 0;
		
		for (int i = 0; i <= nMax; i++) {
			String newline = "";
			
			for (int j = 0; j <= pMax; j++) {
				if (boxes[i][j].getLabel().equals("EBox")) {
					if (boxes[i][j].getStatus() == 1) {
						newline += "."; 
						pathLen++;
						solved = 1;
					} else {
						newline += "E";
					}
				} else if (boxes[i][j].getLabel().equals("WBox")) {
					newline += "W";
				} else if (boxes[i][j].getLabel().equals("DBox")) {
					newline += "D";
				} else if (boxes[i][j].getLabel().equals("ABox")) {
					newline += "A";
					pathLen++;
				}
			}
			solvedMazeString += newline + "\n";
		}
		
		if (solved == 1) {
			solvedMazeString += "A solution was found!\n"
							  + "Path length : " + pathLen + "\n";
		}
		
    	return solvedMazeString;
    }
}

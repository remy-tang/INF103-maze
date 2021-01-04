package dijkstra;

public interface PiInterface {
	
	/* pi(racine) = 0 , pour tout autre sommet x du graphe pi(x)=+infini */
	public void initialisePi();
	
	/* Met � jour la valeur pi(y)  */
	public void newPiValue(VertexInterface y); 
	
}

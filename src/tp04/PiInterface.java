package tp04;

public interface PiInterface {
	void initialisePi() ; /* pi(racine) = 0 , pour tout autre sommet x du graphe pi(x)=+infini */
	void newPiValue(Vertex y); /* Met à jour la valeur pi(y) si celle calculée est meilleure */
}

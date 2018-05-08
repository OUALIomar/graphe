package grapheorienté;

/*
 *  
 *  
 */
public interface InterfaceGraph {

	int[][] creerGraphe(int s); // creer un graphe avec s sommets

	void associerESommet(int s, String etiq) throws SommetInexistantException ; // associer etiquette a un sommet s

	void ajouterArc(int depart, int arrive) throws SommetInexistantException; // ajouter arc entre sommet depart et arrive

	void associerEArc(int d, int a, String etiq) throws ArcInexistantException; // associer etiquette a un arcs

	String getEtiquettesommet(int s) throws SommetInexistantException; // renvoie etiquette d'un sommet

	String getEtiquetteArc(int d, int a) throws ArcInexistantException; // renvoie etiquette d'un arc
}

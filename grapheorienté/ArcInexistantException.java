package grapheorienté;

@SuppressWarnings("serial")
public class ArcInexistantException extends Exception {
	
	public ArcInexistantException() {}
	public ArcInexistantException(int o, int e) {
		super("L'arc reliant le sommet " + o + " au sommet " + e + " n'est pas défini.");
	}
}
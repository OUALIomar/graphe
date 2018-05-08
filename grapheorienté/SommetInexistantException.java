package grapheorienté;

@SuppressWarnings("serial")
public class SommetInexistantException extends Exception {
	
	public SommetInexistantException() {}
	public SommetInexistantException(int i,String etiq) {
		super("Le sommet " + i + " n'est pas défini. ");
	}

}
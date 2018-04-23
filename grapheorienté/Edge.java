package grapheorienté;

public class Edge <E> {

	
	 private final int from;
	 private final int to;
	 
	 private String label;

	public Edge(int from, int to, String label) {
		super();
		this.from = from;
		this.to = to;
		this.label = label;
	}
	 
}

package grapheorienté;

public class Vertex<T> {
	
	private final int idx;
	
	private String label;
	
	 public int vertexID() {
	        return idx;
	}

	public Vertex(int idx, String label) {
		super();
		this.idx = idx;
		this.label = label;
	}
	 
	 
}

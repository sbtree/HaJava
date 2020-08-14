package de.tubs.prog2.b001.graph.provided;

/**
 * Edge interface.
 */
public interface Edge {

	/**
	 * Returns the "start" of that edge.
	 * @return Start node of this edge.
	 */
	Node getFirstNode();
	
	/**
	 * Returns the "end" of that edge.
	 * @return End node of this edge.
	 */
	Node getSecondNode();
	
	// Take care! Must return true for edges with switched firstNode and secondNode
	@Override
	boolean equals(Object obj);
	
	// Take care! Must have the same value for an edge with switched firstNode and secondNode
	@Override
	int hashCode();
}

package de.tubs.prog2.b001.graph.provided;

/**
 * Node interface.
 */
public interface Node {

	/**
	 * Returns the x coordinate of the node
	 * @return X coordinate
	 */
	int getX();

	/**
	 * Returns the y coordinate of the node
	 * @return Y coordinate
	 */
	int getY();
	
	@Override
	boolean equals(Object obj);
	
	@Override
	int hashCode();
}

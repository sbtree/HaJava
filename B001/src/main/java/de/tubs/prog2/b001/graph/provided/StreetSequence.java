package de.tubs.prog2.b001.graph.provided;

import java.util.Collection;

/**
 * StreetSequence interface.
 */
public interface StreetSequence extends Comparable<StreetSequence> {

	@Override
	int compareTo(StreetSequence streetSequence);
	
	/**
	 * Returns an ordered collection of edges that represent the street sequence.
	 * Lowest index is the start of that sequence, highest index is the target of that sequence.
	 * @return Ordered collection of edges that represent the street sequence. May not be null.
	 */
	Collection<Edge> getEdgeSequence();
	
	/**
	 * Returns a collection containing the nodes that have been passed on that street sequence.
	 * Each node may only be contained once.
	 * @return Collection of nodes that have been passed on that street sequence. May not be null.
	 */
	Collection<Node> getPassedNodes();
	
	/**
	 * 
	 * @return Color of that street sequence.
	 */
	String getColor();
	
}

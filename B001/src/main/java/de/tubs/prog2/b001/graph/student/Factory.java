package de.tubs.prog2.b001.graph.student;

import de.tubs.prog2.b001.graph.provided.ColoredGraph;
import de.tubs.prog2.b001.graph.provided.StreetSequence;
import de.tubs.prog2.b001.graph.provided.Edge;
import de.tubs.prog2.b001.graph.provided.Node;

public class Factory {

	/**
	 * Creates an empty colored graph.
	 */
    public static ColoredGraph createColoredGraph() {
        // TODO Fill in here
        return null;
    }

	/**
	 * Creates a node with given coordinates
	 * @param x X coordinate of the node
	 * @param y Y coordinate of the node
	 * @throws IllegalArgumentException Thrown if at least one coordinate is negative
	 */
    public static Node createNode(int x, int y) throws IllegalArgumentException {
        // TODO Fill in here
        return null;
    }
	
	/**
	 * Constructor to create a new edge that connects the specified nodes.
	 * @param firstNode
	 * @param secondNode
	 * @throws IllegalArgumentException Exception is thrown if this edge is a loop (i.e., nodes are equal) or if any of the nodes is null
	 */
    public static Edge createEdge(Node firstNode, Node secondNode) throws IllegalArgumentException {
        // TODO Fill in here
        return null;
    }

	/**
	 * Creates a StreetSequence of a specific color
	 * @param color
	 */
    public static StreetSequence createStreetSequence(String color) {
        // TODO Fill in here
        return null;
    }
}

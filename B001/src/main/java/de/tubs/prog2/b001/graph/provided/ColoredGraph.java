package de.tubs.prog2.b001.graph.provided;

import java.awt.Dimension;
import java.util.Collection;

/**
 * A colored graph.
 */
public abstract class ColoredGraph {

	/**
	 * Returns the dimensions of the colored graph. This is represented by the
	 * maximum x coordinate of all nodes and the maximum y coordinate of all nodes.
	 * 
	 * @return The graph's dimensions
	 */
	public Dimension getBounds() {
		int maxX = 0;
		int maxY = 0;
		for (Node node : getNodes()) {
			if (node.getX() > maxX) {
				maxX = node.getX();
			}
			if (node.getY() > maxY) {
				maxY = node.getY();
			}
		}
		return new Dimension(maxX, maxY);
	}

	/**
	 * Only nodes with positive coordinates may be added. Only one node per
	 * coordinate may be added.
	 * 
	 * @param node Node to be added. Catch null parameter.
	 * @throws IllegalArgumentException Thrown if parameter is null or already
	 *                                  existent in the graph.
	 */
	public abstract void addNode(Node node) throws IllegalArgumentException;

	/**
	 * Edge can only be added if connecting nodes already exist in graph. No
	 * multi-edges (connecting the same nodes) and no loops are permitted. Only
	 * edges for adjacent nodes can be added (not diagonal) -> x+1/-1 (exclusive or)
	 * y+1/-1.
	 * 
	 * @param edge Edge to be adde to the graph.
	 * @throws IllegalArgumentException Thrown if parameter is null, if nodes of
	 *                                  edges are not contained in graph, if edge is
	 *                                  already contained in graph, or if nodes are
	 *                                  not adjacent.
	 */
	public abstract void addEdge(Edge edge) throws IllegalArgumentException;

	/**
	 * Only one city can be built per node (i.e., one color per node). It is not
	 * allowed to build that city there if two streets of the same other color are
	 * adjacent to that node (see Abbildung 4). If this color does not already have
	 * a city, it can be built without further restrictions. If this is not the
	 * first city of that color, an adjacent street of that color must exist.
	 * 
	 * @param node  Node on which the city should be built. Catch null value.
	 * @param color Color for which the city should be built. Catch null value.
	 * @throws IllegalArgumentException Throws if a parameter is null, if the node
	 *                                  is not contained in the graph, if the node
	 *                                  is already colored, or if other restrictions
	 *                                  apply why that street cannot be built.
	 */
	public abstract void buildCity(Node node, String color) throws IllegalArgumentException;

	/**
	 * Only one street can be built per edge (i.e., one color per edge). Edge must
	 * exist in graph. At least one of the two following properties must hold: (1)
	 * adjacent node of that edge is colored in color (2) adjacent edge of that edge
	 * is colored in color
	 * 
	 * @param edge  Edge on which the street should be built on
	 * @param color Color for which the street should be built
	 * @throws IllegalArgumentException Thrown if edge parameter or color parameter
	 *                                  are null. Also if edge is not contained in
	 *                                  the graph, if a street is already built on
	 *                                  that edge, or if other restrictions do not
	 *                                  allow to build the street here.
	 */
	public abstract void buildStreet(Edge edge, String color) throws IllegalArgumentException;

	/**
	 * Returns the color of a node (i.e., a city has been built)
	 * 
	 * @param node Node for which the color should be retrieved.
	 * @return The color of that node. null if not colored.
	 */
	public abstract String getColorOfNode(Node node);

	/**
	 * Returns the color of an edge (i.e., a street has been built)
	 * 
	 * @param edge Edge for which the color should be retrieved.
	 * @return The color of that edge. null if not colored.
	 */
	public abstract String getColorOfEdge(Edge edge);

	/**
	 * Calculates the set of longest existing street sequences. All colors are
	 * considered that have built a city. Each street may occur only once in a
	 * sequence. Streets of a StreetSequence must fulfill path properties of a graph
	 * (each street only once, connected, ...) Only streets of the same color may be
	 * contained in a sequence. A city of own color than the streets may exist
	 * between two streets of a sequence. No city of different color than the
	 * streets may exist between two streets of a sequence. A node may only be
	 * passed once (i.e., a node may be not common for more than two streets of that
	 * sequence. See Abbildung 6). Multiple longest street sequences may exist
	 * (i.e., if multiple colors have a sequence of the same length). Only one
	 * longest street sequence per color may exist. Only street sequences of the
	 * longest length may be added (e.g., if the longest green StreetSequence is 12
	 * and the longest red StreetSequence is 13, only the red one is added). The
	 * edges in the sequence should be ordered.
	 * 
	 * @return The collection of longest street sequences. Choose appropriate
	 *         collection type. May only be empty but never null.
	 */
	public abstract Collection<StreetSequence> calculateLongestStreetSequence();

	/**
	 * Calculates the longest existing street sequence of a color. Each street may
	 * occur only once the sequence. Streets of a StreetSequence must fulfill path
	 * properties of a graph (each street only once, connected, ...) Only streets of
	 * parameter color may be contained in the sequence. A city of parameter color
	 * may exist between two streets of a sequence. No city of different color than
	 * parameter color may on the path, i.e., not other colored city is allowed
	 * between two subsequently used streets for the sequence. A node may only be
	 * passed once (i.e., a node may be not common for more than two streets of that
	 * sequence. See Abbildung 6). The edges in the sequence should be ordered.
	 * Note: You must use a collection that automatically sorts the street sequence
	 * to retrieve the longest.
	 * 
	 * @param color Color for which the longest street sequence should be retrieved.
	 * @return The longest street sequence of color. Null if no street sequence
	 *         exists for that color. Null if color parameter is null.
	 */
	public abstract StreetSequence calculateLongestStreetSequence(String color);

	/**
	 * Calculates the longest existing street sequence starting from startingEdge.
	 * startingEdge must be contained in the graphs edges (otherwise null is
	 * returned). startingEdge must have a color (otherwise null is returned).
	 * Streets of a StreetSequence must fulfill path properties of a graph (each
	 * street only once, connected, ...) Only streets of parameter color may be
	 * contained in the sequence. A city of the same color as startingEdge may exist
	 * between two streets of a sequence. A node may only be passed once (i.e., a
	 * node may be not common for more than two streets of that sequence. See
	 * Abbildung 6). No city of different color than startingEdge color may exist
	 * between two streets the sequence. The edges in the sequence should be
	 * ordered.
	 * 
	 * @param startingEdge Edge from which the street sequence should start. If it
	 *                     is null, null is returned.
	 * @return The longest street sequence starting at startingEdge only with
	 *         streets of the same color of startingEdge. Null if no street sequence
	 *         exists for that color.
	 */
	public abstract StreetSequence calculateLongestStreetSequenceStartingFromEdge(Edge startingEdge);

	/**
	 * Calculates the shortest existing path (ordered collection of edges) starting
	 * from startingNode to targetNode. startNode must be contained in the graphs
	 * edges (otherwise null is returned). targetNode must be contained in the
	 * graphs edges (otherwise null is returned). startNode must have a color
	 * (otherwise null is returned). targetNode must be non-colored or have the same
	 * color as start node (otherwise null is returned). Path must fulfill graph
	 * path properties (each edge only once, no loops, edges must be connected, ...)
	 * Only edges that are not colored or colored the same as startNode may be used
	 * Nodes that are passed on the path (i.e., are connected by two edges of the
	 * used edges), must be non-colored or have the same color as startNode. If
	 * startNode == targetNode -> empty collection is returned (but other checks
	 * above have priority) Nodes that are connected to at least two edges of the
	 * same different color may not be passed (see Abbildung 7). If no valid path
	 * exists from startNode to targetNode, null is returned. Use appropriate
	 * collection for return value!
	 * 
	 * @param startNode  Node from the the path should start.
	 * @param targetNode Node which should be reached by the path
	 * 
	 * @return Ordered collection of edges representing a path from startNode to
	 *         targetNode (lowest index == first edge taken from startNode)
	 */
	public abstract Collection<Edge> calculateShortestPathToNode(Node startNode, Node targetNode);

	/**
	 * Returns the collection of nodes that exist in the graph. Each node only
	 * contained once. Choose appropriate collection type!
	 * 
	 * @return Collection of nodes that exist in the graph. May not be null.
	 */
	public abstract Collection<Node> getNodes();

	/**
	 * Returns the collection of edges that exist in the graph. Each edge only
	 * contained once. Choose appropriate collection type!
	 * 
	 * @return Collection of edges that exist in the graph. May not be null.
	 */
	public abstract Collection<Edge> getEdges();

}

package de.tubs.prog2.b001.graph.student;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.SwingUtilities;

import de.tubs.prog2.b001.graph.provided.ColoredGraph;
import de.tubs.prog2.b001.graph.provided.Edge;
import de.tubs.prog2.b001.graph.provided.GraphViewer;
import de.tubs.prog2.b001.graph.provided.Node;
import de.tubs.prog2.b001.graph.provided.StreetSequence;

/**
 * This is an example illustrating how to use the ColoreGraph class and the
 * GraphViewer
 */
public class Main {

	/**
	 * Exemplary usage of the ColoredGraph class. Note that several GraphViewer
	 * windows are opened and if one is closed, all others are closed as well
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ColoredGraph graph = Factory.createColoredGraph();
		Node node00 = Factory.createNode(0, 0);
		graph.addNode(node00);
		Node node01 = Factory.createNode(0, 1);
		graph.addNode(node01);
		Node node10 = Factory.createNode(1, 0);
		graph.addNode(node10);
		Node node11 = Factory.createNode(1, 1);
		graph.addNode(node11);
		Node node02 = Factory.createNode(0, 2);
		graph.addNode(node02);
		Node node12 = Factory.createNode(1, 2);
		graph.addNode(node12);

		Edge edge0001 = Factory.createEdge(node00, node01);
		graph.addEdge(edge0001);
		Edge edge0010 = Factory.createEdge(node00, node10);
		graph.addEdge(edge0010);
		Edge edge0111 = Factory.createEdge(node01, node11);
		graph.addEdge(edge0111);
		Edge edge1011 = Factory.createEdge(node10, node11);
		graph.addEdge(edge1011);
		Edge edge0102 = Factory.createEdge(node01, node02);
		graph.addEdge(edge0102);
		Edge edge1112 = Factory.createEdge(node11, node12);
		graph.addEdge(edge1112);
		Edge edge0212 = Factory.createEdge(node02, node12);
		graph.addEdge(edge0212);

		graph.buildCity(node00, "#254a95");
		graph.buildStreet(edge0001, "#254a95");

		graph.buildCity(node11, "#6c000f");
		graph.buildStreet(edge0111, "#6c000f");
		graph.buildStreet(edge1011, "#6c000f");
		graph.buildStreet(edge0102, "#6c000f");
		graph.buildCity(node02, "#6c000f");

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GraphViewer(graph);
			}
		});

		Collection<StreetSequence> longestSequences = graph.calculateLongestStreetSequence();
		Iterator<StreetSequence> it = longestSequences.iterator();
		if (it.hasNext()) {
			StreetSequence longestSequence = it.next();

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new GraphViewer(graph, longestSequence); 
				}
			});
		}

		StreetSequence longestBlueSequence = graph.calculateLongestStreetSequence("#254a95");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GraphViewer(graph, longestBlueSequence);
			}
		});

		StreetSequence longestRedSequenceStartingFromEdge0111 = graph.calculateLongestStreetSequenceStartingFromEdge(edge0111);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GraphViewer(graph, longestRedSequenceStartingFromEdge0111);
			}
		});
		
		
		Collection<Edge> shortestPath = graph.calculateShortestPathToNode(node00, node10);
		System.out.println("Shortest path contains the edge from node00 to node 10: "+shortestPath.contains(edge0010));
	}

}

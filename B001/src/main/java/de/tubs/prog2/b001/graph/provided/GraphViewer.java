package de.tubs.prog2.b001.graph.provided;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Application drawing a graph
 */
public class GraphViewer extends JFrame {

	private static final long serialVersionUID = -1755381678364101326L;
	
	// Define constants
	/**
	 * Preferred width of the canvas to draw on
	 */
	public static final int CANVAS_WIDTH = 720;
	/**
	 * Preferred height of the canvas to draw on
	 */
	public static final int CANVAS_HEIGHT = 640;

	// Declare an instance of the drawing canvas,
	// which is an inner class called DrawCanvas extending javax.swing.JPanel.
	private DrawCanvas canvas;
	
	private ColoredGraph graph;
	private StreetSequence sequence;

	/**
	 * Constructor to visualize a colored graph and a street sequence
	 * @param graph The graph to visualize
	 * @param sequence The street sequence to visualize
	 */
	public GraphViewer(ColoredGraph graph, StreetSequence sequence) {
		this.graph = graph;
		this.sequence = sequence;
		
		canvas = new DrawCanvas(); // Construct the drawing canvas
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		// Set the Drawing JPanel as the JFrame's content-pane
		Container cp = getContentPane();
		cp.add(canvas);
		// or "setContentPane(canvas);"

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Handle the CLOSE button
		pack(); // Either pack() the components; or setSize()
		setTitle("Graph Viewer"); // "super" JFrame sets the title
		setVisible(true); // "super" JFrame show
		setResizable(false);
	}

	/**
	 * Constructor to visualize a colored graph
	 * @param graph The graph
	 */
	public GraphViewer(ColoredGraph graph) {
		this(graph, null);
	}

	/**
	 * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	 */
	private class DrawCanvas extends JPanel {
		private static final long serialVersionUID = -5874599280331110214L;

		// Override paintComponent to perform your own painting
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // paint parent's background
			setBackground(Color.white); // set background color for this JPanel
			
		    Graphics2D g2 = (Graphics2D) g;
		    g2.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
		    g2.setRenderingHints(new RenderingHints(
		             RenderingHints.KEY_ANTIALIASING,
		             RenderingHints.VALUE_ANTIALIAS_ON));
		    g2.getRenderingHints();
			
			Dimension graphSize = graph.getBounds();
			int offsetX = (int) (CANVAS_WIDTH - graphSize.getWidth() * 100) / 2;
			int offsetY = (int) (CANVAS_HEIGHT - graphSize.getHeight() * 100) / 2;

			for (Edge edge : graph.getEdges()) {
				g2.setColor(getColor(graph.getColorOfEdge(edge))); // set the drawing color

				int node1X = offsetX + edge.getFirstNode().getX() * 100;
				int node1Y = offsetY + ((int) graphSize.getHeight() - edge.getFirstNode().getY()) * 100;
				int node2X = offsetX + edge.getSecondNode().getX() * 100;
				int node2Y = offsetY + ((int) graphSize.getHeight() - edge.getSecondNode().getY()) * 100;

				if (graph.getColorOfEdge(edge) != null) {
					g2.setStroke(new BasicStroke(5));
					g2.drawLine(node1X, node1Y, node2X, node2Y);
					
					if (sequence != null && sequence.getEdgeSequence().contains(edge)) {
						g2.setStroke(new BasicStroke(10, 0, 0, 1.0f, new float[]{10.0f, 10.0f}, 5.0f));
						g2.drawLine(node1X, node1Y, node2X, node2Y);
					}
				} else {
					g2.setStroke(new BasicStroke(2));
					g2.drawLine(node1X, node1Y, node2X, node2Y);
				}
			}

			for (Node node : graph.getNodes()) {
				g2.setColor(getColor(graph.getColorOfNode(node))); // set the drawing color

				int nodeX = offsetX + node.getX() * 100;
				int nodeY = offsetY + ((int) graphSize.getHeight() - node.getY()) * 100;
				
				if (graph.getColorOfNode(node) != null) {
					g2.fillOval(nodeX - 15, nodeY - 15, 30, 30);
				} else {
					g2.fillOval(nodeX - 7, nodeY - 7, 14, 14);
				}
			}
		}
	}

	private static Color getColor(String colorString) {
		Color color = hex2Rgb(colorString);
		if (color == null) {
			color = Color.gray;
		}
		return color;
	}

	private static Color hex2Rgb(String colorStr) {
		if (colorStr == null) {
			return null;
		}
		if (colorStr.length() != 7) {
			return null;
		}
		
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
}
package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
// Enter your code here
		initPopulation();
		int k = 0;
		while (k++ < MUTATION_RATE) {

			for (int i = 0; i < POP_SIZE; i++) {

				Node x = this.getParentByRandomSelection();
				Node y = this.getParentByRandomSelection();
				Node child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0)
					return child;
			}
		}
		population = new ArrayList<Node>();
		Collections.sort(population);

		return population.get(0);
	}

// Mutate an individual by selecting a random Queen and 
//move it to a random row.
	public void mutate(Node node) {
// Enter your code here
		node.setRow(rd.nextInt(), MAX_ITERATIONS);

	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
//Enter your code here
		int c = rd.nextInt(Node.N);
		Node re = new Node();
		re.generateBoard();
		for (int i = 0; i < c; i++) {
			re.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			re.setRow(i, y.getRow(i));
		}
		return re;
	}

//Select K individuals from the population at random and 
//Select K individuals from the population at random and 
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
//Enter your code here
		this.population.get(k);
		Node n = new Node();
//		List<Node> candidates = new ArrayList<>();
//		for (int i = 0; i < k; i++) {
//			int index = (int) (Math.random() * population.size());
//			candidates.add(population.get(index));
//		}
//
//		// Select the node with the highest fitness from the candidates
//		Node bestNode = null;
//		double bestFitness = Double.MIN_VALUE;
//		for (Node node : candidates) {
//			double fitness = fitnessFunction.fitness(node);
//			if (fitness > bestFitness) {
//				bestFitness = fitness;
//				bestNode = node;
//			}
//		}
//
//		return bestNode;
		return n;
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
//Enter your code here
		return null;
	}
}
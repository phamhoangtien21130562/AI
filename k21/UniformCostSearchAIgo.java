package k21;

import java.util.*;

public class UniformCostSearchAIgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		List<Node> explorer = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explorer.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if (!frontier.contains(end) && !explorer.contains(end)) {
						frontier.add(end);
						end.setParent(current);
						end.setPathCost(newPathCost);
					} else if (end.getPathCost() > newPathCost) {
						end.setParent(current);
						end.setPathCost(newPathCost);

					}

				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		boolean started = false;
		frontier.add(root);
		List<Node> explorer = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explorer.clear();
				current.setParent(null);
			}
			if (current.getLabel().equals(goal) && started) {
				return current;
			} else {
				explorer.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if (!frontier.contains(end) && !explorer.contains(end)) {
						frontier.add(end);
						end.setParent(current);
						end.setPathCost(newPathCost);
					} else if (end.getPathCost() > newPathCost) {
						end.setParent(current);
						end.setPathCost(newPathCost);

					}

				}
			}
		}
		return null;
	}
}

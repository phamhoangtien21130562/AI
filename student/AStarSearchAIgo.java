package student;

import java.util.*;

public class AStarSearchAIgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByH());
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
					if (!frontier.contains(end) && !explorer.contains(end)) {
						frontier.add(end);
						end.setParent(current);
						end.setG(current.getG() + child.getWeight());
					} else if (frontier.contains(end) && end.getG() > current.getG() + child.getWeight()) {
						end.setG(current.getG() + child.getWeight());
						end.setParent(current);
					}
				}

			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByH());
		frontier.add(root);
		boolean started = false;
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
					if (!frontier.contains(end) && !explorer.contains(end)) {
						frontier.add(end);
						end.setParent(current);
						end.setG(current.getG() + child.getWeight());
					} else if (frontier.contains(end) && end.getG() > current.getG() + child.getWeight()) {
						end.setG(current.getG() + child.getWeight());
						end.setParent(current);
					}
				}

			}
		}
		return null;
	}

}

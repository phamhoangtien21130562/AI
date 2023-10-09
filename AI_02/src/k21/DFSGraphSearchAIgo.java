package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSGraphSearchAIgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		
		List<Node> explorer = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal))
				return current;
			explorer.add(current);
			List<Node> children = current.getChildrenNodes();
			Stack<Node> frontierTam = new Stack<Node>();
			for (Node child : children) {
				//Neu la tree search thi khong can them dong if vi trong tree co the them node da xuat hien
				//Them ham coppy de add node do them lan nua
				if (!frontier.contains(child) && !explorer.contains(child)) {
					frontierTam.add(child);
					child.setParent(current);
				}
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}

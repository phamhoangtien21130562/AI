package game_nim_student;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));
		System.out.println(node.getSuccessors());
//		List<Node> n = node.getSuccessors();
//		System.out.println(n.getFirst().getSuccessors());
//		System.out.println(node.isTerminal());

//		MinimaxAlgo algo = new MinimaxAlgo();
//		algo.execute(node);
	}
}
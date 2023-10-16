package k21;

import junit.framework.TestCase;

public class testAI extends TestCase {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		BFSGraphSearchAIgo bfsGraphSearchAIgo = new BFSGraphSearchAIgo();
		Node nodeTest=bfsGraphSearchAIgo.execute(nodeS, nodeG.getLabel());
		mainLap.printPath(nodeTest);
	}
}

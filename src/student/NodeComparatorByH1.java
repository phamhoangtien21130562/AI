package student;

import java.util.Comparator;

public class NodeComparatorByH1 implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		int comparaPath=Double.compare(o1.getH(),o2.getH());
		return comparaPath;
	}

}
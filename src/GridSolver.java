import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GridSolver {
	public static int counter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point rootPoint = new Point(0,0);
		MyTree<Point> root = new MyTree<>(rootPoint);
		System.out.println("Enter grid height (e.g. 5)");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		treeFormer(root, size);
	    System.out.println(counter);
	    return;
	}
	
	public static MyTree<Point> childGenerator(MyTree<Point> parent, int maxPoint) {
		Point data = parent.getData();
		int x = data.getX();
		int y = data.getY();
		int newX = x + 1;
		int newY = y + 1;
		if (newX <= maxPoint) {
			Point point1 = new Point(newX, y);
			MyTree<Point> child1 = new MyTree<>(point1);
			parent.addChild(child1);
		}
		if (newY <= maxPoint) {
			Point point2 = new Point(x, newY);
			MyTree<Point> child2 = new MyTree<>(point2);
			parent.addChild(child2);
		}
		if (parent.getChildren().isEmpty()) {
			counter++;
		}
		return parent;
	}
	
	public static void treeFormer(MyTree<Point> parent, int maxPoint) {
		MyTree<Point> currentParent = childGenerator(parent, maxPoint);
		List<MyTree<Point>> children = currentParent.getChildren();
		if (children.isEmpty()) {
			return;
		} else {
	        for (MyTree<Point> child: children) {
	        	treeFormer(child, maxPoint);
	        }	
		}
	}
}

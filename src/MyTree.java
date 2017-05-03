import java.util.ArrayList;
import java.util.List;

public class MyTree<Point>{
    private Point data = null;
    private List<MyTree<Point>> children = new ArrayList<>();
    private MyTree<Point> parent = null;

    public MyTree(Point data) {
        this.data = data;
    }

    public void addChild(MyTree<Point> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Point data) {
    	MyTree<Point> newChild = new MyTree<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }
    public List<MyTree<Point>> getChildren() {
        return children;
    }

    public Point getData() {
        return data;
    }

    public void setData(Point data) {
        this.data = data;
    }

    private void setParent(MyTree<Point> parent) {
        this.parent = parent;
    }

    public MyTree<Point> getParent() {
        return parent;
    }
}
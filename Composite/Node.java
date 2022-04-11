import java.util.ArrayList;
import java.util.List;

public class Node<T> implements Tree<T> {

    private T value;
    private List<Tree<T>> children; 

    public Node(T value, List<Tree<T>> trees){
        this.value = value;
        this.children = trees; //possibly a copy
    }
    /*
    @Override
    public List<T> depthFirst() {
        List<T> result = new ArrayList<>();
        result.add(value);
        for(Tree<T> t : children){
            result.addAll(t.depthFirst());
        }

        return result;
    }

    @Override
    public int height() {
        int h = 0;
        for(Tree<T> t : children){
            int x = t.height();
            h = Math.max(x, h);
        }
        return h + 1;
    }

    @Override
    public int nrOfValues() {
        int n = 1;
        for(Tree<T> t : children){
            n += t.nrOfValues();
        }
        return n;
    }

    @Override
    public String show(int level) {
        String result = "";
        for (Tree<T> t : children) {
            result += t.show(level + 1) + "\n";
        }
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "\t";
        }

        return indent + value.toString() +"\n" +result;
    }
    */
    @Override
    public T getValue() {
        return value;
    }

    public List<Tree<T>> getChildren(){
        return children;
    }
    /*
    @Override
    public String toString() {
        return show(0);
    }*/
    @Override
    public <R> R accept(TreeVisitor<T, R> visitor) {
        return visitor.visit(this);
    }
    
}

package tree;

import java.util.List;

public class Node<T> extends XMLElement implements Tree<T> {

    private T value;

    private List<Tree<T>> children;

    public Node(T value, List<Tree<T>> trees) {
        this.value = value;
        this.children = trees; // possibly a copy
    }

    public void setValue(T value){
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    @Override
    public <R, A> R accept(TreeVisitor<T, R, A> visitor, A acc) {
        return visitor.visit(this, acc);
    }

    public void addChild(Tree<T> child){
        children.add(child);
    }
    
}

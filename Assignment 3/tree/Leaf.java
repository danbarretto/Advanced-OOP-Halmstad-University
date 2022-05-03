package tree;


public class Leaf<T> extends XMLElement implements Tree<T> {

    private T value;
    

    public Leaf(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public <R, A> R accept(TreeVisitor<T, R, A> visitor, A acc) {
        return visitor.visit(this, acc);
    }

    @Override
    public void setValue(T value) {
        this.value = value;        
    }

    @Override
    public String getSubNodesName() {
        return "";
    }

    @Override
    public void setSubNodesName(String subNodesName) {
        return;
    }

}
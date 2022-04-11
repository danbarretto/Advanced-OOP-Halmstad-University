import java.util.List;

public interface Tree<T> {
    // List<T> depthFirst();
    // int height();
    // int nrOfValues();
    // String show(int level);
    T getValue();
    <R> R accept(TreeVisitor<T,R> visitor);
}

package tree;

public interface Tree<T> {
    <R, A> R accept(TreeVisitor<T, R, A> visitor, A acc);

    T getValue();
    void setValue(T value);
}

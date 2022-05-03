package tree;

public interface TreeVisitor<T, R, A> {
    R visit(Leaf<T> l, A acc);
    R visit(Node<T> n, A acc);
}
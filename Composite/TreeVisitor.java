public interface TreeVisitor<T,R> {
    R visit(Leaf<T> l);
    R visit(Node<T> n);    
    // R visit(Tree<T> t);

}   

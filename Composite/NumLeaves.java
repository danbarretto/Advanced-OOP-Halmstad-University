public class NumLeaves<T> implements TreeVisitor<T, Integer>{

    @Override
    public Integer visit(Leaf<T> l) {
        return 1;
    }

    @Override
    public Integer visit(Node<T> n) {
        int result = 1;
        for(Tree<T> t : n.getChildren()){
            result += t.accept(this);
        }
        return result;
    }

    // @Override
    // public Integer visit(Tree<T> t) {
    //     return t.accept(this);
    // }

    
    
}

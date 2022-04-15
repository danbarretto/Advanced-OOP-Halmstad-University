import java.util.ArrayList;
import java.util.List;

public class ListLeaves<T> implements TreeVisitor<T, List<T>, List<T>> {

    //for pretty printing need to keep info about the visitation depth / level
    

    @Override
    public List<T> visit(Leaf<T> l, List<T> result) {
        result.add(l.getValue());
        return result;
    }

    @Override
    public List<T> visit(Node<T> n, List<T> result) {
        result.add(n.getValue());
        for(Tree<T> child : n.getChildren()){
            result.addAll(child.accept(this, new ArrayList<T>()));
        }
        return result;
    }
    
}

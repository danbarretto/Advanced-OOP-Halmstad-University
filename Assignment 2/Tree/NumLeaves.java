

public class NumLeaves<T> implements TreeVisitor<T, Integer, Integer> {

	@Override
	public Integer visit(Leaf<T> l, Integer acc) {
		return 1;
	}

	@Override
	public Integer visit(Node<T> n, Integer acc) {
		int result = 1;
		for(Tree<T> t : n.getChildren()) {
		   result += t.accept(this, acc); 		}
		return result;
	}

	// @Override
	//public Integer visit(Tree<T> t) {
		// check if t is Leaf or Node
        // call visitLeaf, or visitNode accordingly
        //if(t instanceof Leaf) 
        //	return visitLeaf((Leaf<T>)t);
        //return visitNode((Node<T>)t);
    //    return t.accept(this);
	//}

	
}

import java.util.List;

public class ListLeaves<T> implements TreeVisitor<T,List<T>,List<T>> {

	// for pretty printing need to keep info about the visitation depth / level
	
	@Override
	public List<T> visit(Leaf<T> l, List<T> result) {
		// List<T> result = new ArrayList<T>();
		result.add(l.getValue());
		return result;
	}

	@Override
	public List<T> visit(Node<T> n, List<T> result) {
		result.add(n.getValue());
		for(Tree<T> c : n.getChildren()) {
			//result.addAll(c.accept(this, new ArrayList<T>()));
			// 
			// A much better way of doing this
			// (this way the result can be also kept as an instance variable
			// inside this class):
			c.accept(this, result);
		}
		return result;
	}

}

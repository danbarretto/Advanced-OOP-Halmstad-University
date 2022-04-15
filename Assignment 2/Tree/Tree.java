import java.util.List;

public interface Tree<T> {
	// List<T> depthFirst();
	// int height();
	// int nrOfValues();
	// String show(int level);

	<R,A> R accept(TreeVisitor<T,R,A> visitor, A acc);
	
	T getValue();
}
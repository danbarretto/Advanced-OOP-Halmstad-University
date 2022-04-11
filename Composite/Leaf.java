import java.util.ArrayList;
import java.util.List;

public class Leaf<T> implements Tree<T> {

    private T value;

    public Leaf(T value){
        this.value = value;
    }
    
    /*
    @Override
    public List<T> depthFirst() {
        List<T> result = new ArrayList<>();
        result.add(value);
        return result;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int nrOfValues() {
        return 1;
    }

    @Override
    public String show(int level) {
        String indent = "";
        for(int i=0; i<level; i++){
            indent += "\t";
        }
        return indent+value.toString()+"\n";
    }   
    */
    @Override
    public T getValue() {
        return value;
    }
    /*
    @Override
    public String toString() {
        return show(0);
    }
    */

    @Override
    public <R> R accept(TreeVisitor<T, R> visitor) {
        return visitor.visit(this);
    }
}

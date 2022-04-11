import java.util.ArrayList;
import java.util.List;

public abstract class Filter<T>{

    protected abstract boolean accept(T element);

    public List<T> filter(List<T> elements){
        List<T> result = new ArrayList<>();

        for(T e : elements){
            if(accept(e)) result.add(e);
        }
        return result;
    }

}
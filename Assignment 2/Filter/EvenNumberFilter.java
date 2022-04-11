
public class EvenNumberFilter extends Filter<Integer> {

    @Override
    protected boolean accept(Integer element) {
        return element % 2 == 0;
    }
    
}

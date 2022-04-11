import java.util.ArrayList;
import java.util.List;

public class FilterTester {
    
    public static void main(String[] args) {
        LengthFilter filter =  new LengthFilter();
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Mom");
        words.add("Goodbye");
        words.add("Dad");
        
        words = filter.filter(words);
        System.out.println(words);

        List<Integer> numbers = new ArrayList<>();
        EvenNumberFilter numberFilter = new EvenNumberFilter();
        numbers.add(1);
        numbers.add(2);
        numbers.add(55);
        numbers.add(69);
        numbers.add(420);
        numbers = numberFilter.filter(numbers);
        System.out.println(numbers);

    }
}

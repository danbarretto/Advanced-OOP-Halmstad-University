import java.util.ArrayList;
import java.util.List;

public class FilterTester {
    
    public static String[] filter(String[] a, IFilter f){
        List<String> acceptedStrs = new ArrayList<>();
        for (String str : a) {
            if(f.accept(str)){
                acceptedStrs.add(str);
            }
        }
        return acceptedStrs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] strs = {"a","ab","abc","abcd","abcde"};
        LengthFilter filter = new LengthFilter();
        strs = filter(strs, filter);
        for (String string : strs) {
            System.out.println(string);
        }
    }
}

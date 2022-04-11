
public class LengthFilter extends Filter<String> {

    @Override
    public boolean accept(String element) {
        return element.length() > 3;
    }

}

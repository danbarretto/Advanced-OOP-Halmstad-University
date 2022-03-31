public class LengthFilter implements IFilter {
    
    @Override
    public boolean accept(String x) {
        return x.length() >= 3;
    }   
    
}
import java.util.ArrayList;
import java.util.List;

@Element(name="basket")
public class Test {
    
    private String value;
    private List<Test> children = new ArrayList<>();

    public Test(String value, List<Test> children){
        this.value = value;
        this.children = children;
    }

    public Test(String value){
        this.value = value;
        children = new ArrayList<>();
    }

    @ElementField(name="fruit")
    public String getValue(){
        return value;
    }

    @SubElements(name="sub-basket")
    public List<Test> getChildren(){
        return children;
    }
}

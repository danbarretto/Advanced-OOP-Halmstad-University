import java.util.ArrayList;
import java.util.List;

@Element(name="node")
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

    @ElementField(name="value")
    public String getValue(){
        return value;
    }

    @SubElements(name="child")
    public List<Test> getChildren(){
        return children;
    }
}

package tree;

public class XMLElement {
    private String fieldName = "";
    private String nodeName = "";
    private String subNodesName = "";

    public String getSubNodesName() {
        return subNodesName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setSubNodesName(String subNodesName) {
        this.subNodesName = subNodesName;
    }

}

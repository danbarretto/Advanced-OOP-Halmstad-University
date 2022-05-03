package tree;


public class XMLTreePrinter<T> implements TreeVisitor<T, String, Integer>{

    @Override
    public String visit(Leaf<T> l, Integer level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "\t";
            // indent += " ";
        }
        return indent + "<"+l.getNodeName()+" "+l.getFieldName()+"=\""+l.getValue().toString()+"\"/>";
    }

    private String createIndent(int level){
        String indent = "";
        for(int i=0; i<level; i++) indent += "\t";
        return indent;
    }

    @Override
    public String visit(Node<T> n, Integer level) {
        String indent = createIndent(level);
        String result = "";
        result+= indent+"\t<"+n.getSubNodesName()+">\n";

        for (Tree<T> t : n.getChildren()) {
            result += t.accept(this, level + 2) + "\n";
        
        }
        result += "\t"+indent+"</"+n.getSubNodesName()+">\n";

        result += indent+"</"+n.getNodeName()+">";
        return indent + "<"+n.getNodeName()+" "+n.getFieldName()+"=\""+n.getValue().toString() + "\">\n" + result;

    }
    


}

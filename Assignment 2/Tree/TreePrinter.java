public class TreePrinter<T> implements TreeVisitor<T, String, Integer>{

    @Override
    public String visit(Leaf<T> l, Integer level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "\t";
            // indent += " ";
        }
        return indent + l.getValue().toString();
    }

    @Override
    public String visit(Node<T> n, Integer level) {
        String result = "";
        for (Tree<T> t : n.getChildren()) {
            result += t.accept(this, level + 1) + "\n";
        }
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "\t";
            // indent += " ";
        }
        return indent + n.getValue().toString() + "\n" + result;

    }
    


}

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tree.Leaf;
import tree.Node;
import tree.Tree;
import tree.XMLTreePrinter;

public class Saver {

    /**
     * Creates a tree data structure with for the given object. Uses Element, ElementField and SubElement
     * custom annotations to define XML parameters.
     * @param obj The object that is going to be parsed
     * @precondition Object obj must have Element, ElementField and SubElement annotations
     * @return The root of the tree
     */
    private Tree<String> mountTree(Object obj) {
        Class<?> objClass = obj.getClass();
        Element elementAnnotation = objClass.getAnnotation(Element.class);

        Method subElementMethod = null;
        SubElements subElementAnnotaiton = null;

        String nodeName = "", fieldName = "", fieldValue = "";
        Node<String> node = new Node<String>("", new ArrayList<>());
        
        if (elementAnnotation != null) {
            nodeName = elementAnnotation.name();

            Method methods[] = objClass.getMethods();
            Method elementFieldMethod = null;
            ElementField elementFieldAnnotation = null;

            //Checks every annotation for every method in the class
            for (Method m : methods) {
                Annotation methodAnnotations[] = m.getAnnotations();
                for (Annotation an : methodAnnotations) {
                    //Saves instances of annotations and methods for further use
                    if (an instanceof ElementField) {
                        elementFieldAnnotation = (ElementField) an;
                        elementFieldMethod = m;

                    } else if (an instanceof SubElements) {
                        subElementAnnotaiton = (SubElements) an;
                        subElementMethod = m;
                    }
                }
            }

            if (elementFieldAnnotation != null && elementFieldMethod != null) {
                fieldName = elementFieldAnnotation.name();
                try {
                    fieldValue = elementFieldMethod.invoke(obj).toString();
                    //Updates the current node's values
                    node.setFieldName(fieldName);
                    node.setNodeName(nodeName);
                    node.setValue(fieldValue);

                } catch (Exception e) {
                    System.out.println("Could not invoke elementFieldMethod" + e);
                    return null;
                }
            }
            //Construction of subtrees
            if (subElementAnnotaiton != null && subElementMethod != null) {
                node.setSubNodesName(subElementAnnotaiton.name());

                try {
                    Object children = subElementMethod.invoke(obj);
                    //If the method with SubElements annotation was invoked properly, checks if
                    //current node is a Leaf or Node by the absence or not of childre
                    if (children != null && children instanceof Collection<?>
                            && ((Collection<?>) children).size() > 0) {
                        //Children is a collection (Array, List, ArrayList, Set, etc..), therefore,
                        //Mount subtree for each child and appends to the current subtree
                        for (Object child : (Collection<?>) children) {
                            node.addChild(mountTree(child));
                        }
                    } else {
                        //Current node is a Leaf, create instance and return it
                        Leaf<String> leaf = new Leaf<String>(fieldValue);
                        leaf.setFieldName(fieldName);
                        leaf.setNodeName(nodeName);
                        return leaf;
                    }

                } catch (Exception err) {
                    System.out.println("Error while calling save on children" + err);
                    return null;
                }
            }
        }
        return node;
    }

    /**
     * Creates a XMLString for the given object
     * @param obj The object that is going to be read.
     * @precondition Object must use annotations Element, SubElements and ElementField
     * @return String representing XML for Object obj
     */
    public String save(Object obj) {
        Tree<String> root = mountTree(obj);
        if (root == null)
            return "";

        XMLTreePrinter<String> xmlTpv = new XMLTreePrinter<>();
        return root.accept(xmlTpv, 0);
    }

    public static void main(String[] args) {
        Saver s = new Saver();

        List<Test> children1 = new ArrayList<>();
        children1.add(new Test("Banana", null));
        children1.add(new Test("Papaya", null));

        List<Test> children2 = new ArrayList<>();
        children2.add(new Test("Cacao", children1));
        children2.add(new Test("Kiwi", null));

        Test t = new Test("Fruits", children2);
        System.out.println(s.save(t));
    }
}
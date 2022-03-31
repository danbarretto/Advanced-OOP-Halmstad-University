public class Element {
    private int info;
    private Element next = null;

    
    public Element(int info) {
        this.info = info;
    }


    public Element getNext() {
        return next;
    }


    public void setNext(Element next) {
        this.next = next;
    }


    public int getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return info + "\n";
    }
    
}

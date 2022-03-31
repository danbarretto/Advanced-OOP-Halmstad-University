import java.util.ArrayList;
import java.util.List;

public class Stack {
    private Element top = null;
    private int noElements = 0;

    /**
     * Pushes new Element to the stack
     * @param newElement the new element that is going to be pushed
     */
    public void push(Element newElement) {
        noElements++; 
        if(top == null){
            top = newElement;
            return;
        }
        Element oldTop = top;
        top = newElement;
        newElement.setNext(oldTop);
    }

    /**
     * Remove the element on the top of the stack
     * @return the removed element
     */
    public int pop(){
        int popped = Integer.MIN_VALUE;
        if(top == null){
            System.out.println("Stack is empty!");
            return popped;
        }
        popped = top.getInfo();
        top = top.getNext();        
        noElements--;
        return popped;
    }

    /**
     * Pops n elements from the stack
     * @param n the amount of elements that are being removed
     * @return The list of removed items
     */
    public List<Integer> popN(int n){
        List<Integer> poppedItems = new ArrayList<>();
        for(int i=0; i<n; i++){
            poppedItems.add(pop());
        }

        return poppedItems;
    }

    /**
     * Pushes n elements to the stack
     * @param n The amount of pushed elements
     * @param elements The elements that are going to be pushed
     */
    public void pushN(int n, int[] elements){
        assert n==elements.length;

        for(int i=0; i<n; i++){
            push(new Element(elements[i]));
        }
    }

    public int getNoElements() {
        return noElements;
    }

    public Element getTop(){
        return top;
    }

    @Override
    public String toString() {
        Element curr = top;
        String res = "";
        while(curr != null){
            res += curr.getInfo() +"\n";
            curr = curr.getNext();
        }
        return res;
    }
}
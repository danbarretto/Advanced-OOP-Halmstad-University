import java.security.DrbgParameters.Capability;

/**
 * A first-in, first-out bounded colection of messages.
 */
public class MessageQueue {
    private Message[] elements;
    private int head;
    private int tail;
    private int count;

    /**
     * Constructs an empty message queue.
     * 
     * @param capacity the maximum capacity of the queue
     * @precondition capacity > 0
     * 
     */
    public MessageQueue(int capacity) {
        assert capacity > 0;
        elements = new Message[capacity];
        count = 0;
        head = 0;
        tail = 0;
    }

    /**
     * Removes message at head.
     * @return the message that has been removed from the queue
     * @precondition size() > 0
     */
    public Message remove(){
        assert size() > 0;
        Message r = elements[head];
        head = (head + 1) % elements.length;
        count--;
        return r;
    }

    /**
     * Append a message at tail
     * @param aMessage the message to be appended
     */
    public void add(Message aMessage){
        if(isFull()){
            Message[] temp = new Message[elements.length];
            for(int i=0; i<elements.length; i++){
                temp[i] = elements[i]; //Copy elements to temporary array
            }
            elements = new Message[elements.length + 1];

            assert elements.length == temp.length + 1;
            
            for (int i = 0; i < temp.length; i++) {
                elements[i] = temp[i];
            }
            
        }
        elements[tail] = aMessage;
        tail = (tail+1) % elements.length;
        count++;
    }

    /**
     * Get the total number of messages in the queue.
     * @return the total number of messages in the queue
     */
    public int size(){
        return count;
    }

    /**
     * Checks whether this queue is full
     * @return true if the queue is full
     */
    public boolean isFull(){
        return count == elements.length;
    }

    /**
     * Get message at head.
     * @return the message that is at the head of the queue
     * @precondition size() > 0
     */
    public Message peek(){
        assert size() > 0;
        return elements[head];
    }

    public static void main(String[] args) {
        MessageQueue q = new MessageQueue(5);
        q.add(new Message("a"));
        q.add(new Message("b"));
        q.add(new Message("c"));
        q.add(new Message("d"));
        q.add(new Message("e"));
        System.out.println(q.count);
        q.add(new Message("f"));
        System.out.println(q.count);
    
    }
}
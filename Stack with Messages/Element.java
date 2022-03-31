public class Element {
    private Message message;
    private Element next = null;

    public Element(String messageText) {
        this.message = new Message(messageText);
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Message getInfo() {
        return message;
    }

    @Override
    public String toString() {
        return message.toString();
    }

}
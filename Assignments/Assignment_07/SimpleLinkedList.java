/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    /** Add element to the end of the list (Queue behavior) */
    @Override
    public boolean add(String e) {
        Node newNode = new Node(e);
        if (tail != null) {
            tail.setNext(newNode);
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        return true;
    }

    /** Remove element from the front of the list (Queue behavior) */
    @Override
    public String remove() {
        if (head == null) {
            return null;
        }
        String data = head.toString();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return data;
    }

    /** Add element to the front of the list (Stack behavior) */
    @Override
    public boolean push(String e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        return true;
    }

    /** Remove element from the front of the list (Stack behavior) */
    @Override
    public String pull() {
        return remove();
    }

    public static void main(String[] args) {
        SimpleLinkedList demoQueue = new SimpleLinkedList();
        SimpleLinkedList demoStack = new SimpleLinkedList();

        demoQueue.add("A");
        demoQueue.add("B");
        demoQueue.add("C");

        boolean queueWorks = demoQueue.remove().equals("A") &&
                demoQueue.remove().equals("B") &&
                demoQueue.remove().equals("C") &&
                demoQueue.remove() == null;

        demoStack.push("A");
        demoStack.push("B");
        demoStack.push("C");

        boolean stackWorks = demoStack.pull().equals("C") &&
                demoStack.pull().equals("B") &&
                demoStack.pull().equals("A") &&
                demoStack.pull() == null;

        System.out.println(queueWorks);
        System.out.println(stackWorks);
    }
} // class SimpleLinkedList

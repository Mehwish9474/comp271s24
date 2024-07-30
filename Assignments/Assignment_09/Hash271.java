public class Hash271 {

    /** Default size for foundation array */
    private static final int DEFAULT_SIZE = 4;

    /** Default threshold for rehashing */
    private static final double DEFAULT_THRESHOLD = 0.75;

    /** Foundation array of node objects */
    Node[] foundation;

    /** Current load factor */
    private double loadFactor;

    /** User-specified threshold for rehashing */
    private double threshold;

    /** Number of nodes in the hash table */
    private int nodeCount;

    /** Basic constructor */
    public Hash271(int size) {
        this.foundation = new Node[size];
        this.threshold = DEFAULT_THRESHOLD;
        this.loadFactor = 0.0;
        this.nodeCount = 0;
    } // constructor

    /** Default constructor */
    public Hash271() {
        this(DEFAULT_SIZE);
    } // default constructor

    /** Method to compute array position */
    private int computeArrayPosition(int hashCode) {
        return Math.abs(hashCode % this.foundation.length);
    } // method computeArrayPosition

    /** Rehash method to resize and rehash the nodes */
    private void rehash() {
        Node[] oldFoundation = this.foundation;
        this.foundation = new Node[oldFoundation.length * 2];
        this.nodeCount = 0;

        // Move nodes from the old array to the new array
        for (Node node : oldFoundation) {
            while (node != null) {
                Node next = node.getNext();
                node.setNext(null);
                this.put(node);
                node = next;
            }
        }
    } // method rehash

    /** Method to add a node to the hash table */
    public void put(Node node) {
        if (node != null) {
            // Use the hash code of the node to determine its position in the underlying array
            int destination = computeArrayPosition(node.hashCode());
            // If the position in the array is occupied by another node, place that node under the new node we wish to insert
            if (this.foundation[destination] != null) {
                node.setNext(this.foundation[destination]);
            }
            // Put the new node to the array position
            this.foundation[destination] = node;
            this.nodeCount++;
            this.loadFactor = (double) this.nodeCount / this.foundation.length;

            // Check if rehashing is needed
            if (this.loadFactor > this.threshold) {
                rehash();
            }
        }
    } // method put

    /**
     * Wrapper for put(Node). Accepts a string, creates a Node object and passes it
     * to the put(Node) method.
     * 
     * @param string String to create a node for, then chain that node to the
     *               underlying array.
     */
    public void put(String string) {
        if (string != null && string.length() > 0) {
            Node node = new Node(string);
            this.put(node);
        }
    } // method put

    /** String representation of this object */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.foundation.length; i++) {
            sb.append(String.format("[ %03d ]: ", i));
            Node current = this.foundation[i];
            while (current != null) {
                sb.append(String.format("<%s> ", current.toString()));
                current = current.getNext();
            }
            sb.append("\n");
        }
        return sb.toString();
    } // method toString

    /** Driver code */
    public static void main(String[] args) {
        Hash271 h = new Hash271();
        h.put(new Node("Java"));
        h.put(new Node("Python"));
        h.put(new Node("Lisp"));
        h.put(new Node("Fortran"));
        h.put(new Node("Prolog"));
        h.put(new Node("Cobol"));
        h.put(new Node("C++"));
        h.put(new Node("C"));
        h.put(new Node("C#"));
        System.out.println(h);
    } // method main
} // class Hash271

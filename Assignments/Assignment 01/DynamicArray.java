/* 
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN. Mehwish Tabassum
 */
public class DynamicArray {

    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Basic constructor for the object
     * @param size initial size of array data
     */
    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Adds a new item to array data after ensuring there is 
     * sufficient room by resizing the array if necessary.
     * @param string new item to add to array
     */
    public void add(String string) {
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add

    /**
     * Resizes the underlying array to accommodate more elements.
     */
    private void resize() {
        String[] newData = new String[this.data.length * 2];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    } // method resize

    /**
     * Counts the number of times the specified string appears in the array.
     * @param string the string to count in the array
     * @return the number of occurrences of the string
     */
    public int countOf(String string) {
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.data[i].equals(string)) {
                count++;
            }
        }
        return count;
    } // method countOf

    /**
     * The main method to test the DynamicArray class.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add("dog");
        dynamicArray.add("cat");
        dynamicArray.add("dot");
        dynamicArray.add("cat");
        dynamicArray.add("bird");

        System.out.println("Count of 'dot': " + dynamicArray.countOf("dot")); // should print 1
        System.out.println("Count of 'cat': " + dynamicArray.countOf("cat")); // should print 2
        System.out.println("Count of 'frog': " + dynamicArray.countOf("frog")); // should print 0
    } // method main
} // class DynamicArray

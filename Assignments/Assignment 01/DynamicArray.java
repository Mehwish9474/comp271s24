/*
 * In the class below, write two methods:
 * 
 * First, method resize() to expand the existing array data by doubling its size.
 *
 * Second, method contains(String string) that returns true if String string already
 * exists in array data and false otherwise.
 *
 * Your code must have comments explaining what is done and why it is done in the
 * way you do it.
 *
 * DO NOT USE any tools that require to be imported, ie, do not use the import command.
 *
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN.
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
     * Increases the size of the underlying array by doubling its size.
     * A larger temporary array is created, contents of this.data are
     * copied over, and the temp then replaces this.data.
     */
    private void resize() {
        int newSize = this.data.length * 2;
        String[] temp = new String[newSize];
        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    } // method resize

    /**
     * Determines if a String value is present in the underlying array
     * @param string String to search for
     * @return true if string found in array; false otherwise.
     */
    public boolean contains(String string) {
        for (int i = 0; i < this.position; i++) {
            if (this.data[i].equals(string)) {
                return true;
            }
        }
        return false;
    } // method contains

    /**
     * Returns the number of times a string appears in the underlying array
     * @param string String to search for
     * @return count of occurrences.
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
     * Adds a string to the underlying array only if the string is not
     * already present.
     * @param string String to add
     * @return true if addition was successful, false otherwise (indicating a duplicate)
     */
    public boolean addUnique(String string) {
        if (!this.contains(string)) {
            this.add(string);
            return true;
        }
        return false;
    } // method addUnique

} // class DynamicArray

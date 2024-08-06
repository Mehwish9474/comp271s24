public class TrainLine {

    private static final String EMPTY_LINE_MESSAGE = "The line is empty.";

    /** Points to first station in the train line */
    private Station head;

    /** Points to the last station and facilitates O(1) performance when adding
     * a new station at the end of the line
     */
    private Station tail;

    /** Current number of stations in this object */
    private int numberOfStations;

    /** Default constructor - redundant but good to show intent */
    public TrainLine() {
        this.head = null;
        this.tail = null;
        this.numberOfStations = 0;
    } // default constructor

    /** Accessor for number of stations present in this trainline */
    public int getNumberOfStations() {
        return this.numberOfStations;
    } // method getNumberOfStations

    /**
     * Add a new station at the end of this trainline. The method creates
     * a new station object, first, with the given name. Then it checks to
     * if this line has a head station yet; if not, the new station becomes
     * the head station. If this line has a head station, the method begins
     * traversing this line from its head station, following the next points
     * untils it finds a station whose next is null. That station, by definition
     * is presently the last station in the line. The new station is added after
     * that last station.
     * 
     * @param name String with name of new station to add
     */
    public void addStation(String name) {
        // Create a new station object with the given name
        Station newStation = new Station(name);
        // Use addStation(Station) method
        this.addStation(newStation);
    } // method addStation

    /**
     * Add a new station at the end of this trainline. The method takes
     * a station object and it checks if this line has a head station yet;
     * if not, the new station becomes the head station. If this line has a
     * head station, the method begins traversing this line from its head
     * station, following the next points until it finds a station whose
     * next is null. That station, by definition is presently the last station
     * in the line. The new station is added after that last station.
     * 
     * @param newStation Station object with name of new station to add
     */
    public void addStation(Station newStation) {
        // If the line is empty, the new station is both the head and the tail
        if (this.head == null) {
            this.head = newStation;
            this.tail = newStation;
        } else {
            // Add new station to the end of the line
            this.tail.setNext(newStation);
            this.tail = newStation;
        }
        this.numberOfStations++;
    } // method addStation

    /**
     * This method returns a string with the names of the train stations
     * in reverse order.
     * 
     * @return A string with station names in reverse order.
     */
    public String reverseListStations() {
        if (this.head == null) {
            return EMPTY_LINE_MESSAGE;
        }

        // Use a recursive approach to reverse the station names
        return reverseStations(this.head);
    } // method reverseListStations

    /**
     * Helper method to reverse station names recursively.
     * 
     * @param current The current station being processed.
     * @return A string with the reversed order of station names.
     */
    private String reverseStations(Station current) {
        if (current.getNext() == null) {
            return current.getName();
        }
        return reverseStations(current.getNext()) + "\n" + current.getName();
    } // method reverseStations

    public static void main(String[] args) {
        TrainLine lincolnService = new TrainLine();
        lincolnService.addStation("Chicago");
        lincolnService.addStation("Summit");
        lincolnService.addStation("Joliet");
        lincolnService.addStation("Dwight");
        lincolnService.addStation("Pontiac");
        lincolnService.addStation("Bloomington");
        lincolnService.addStation("Lincoln");
        lincolnService.addStation("Springfield");
        lincolnService.addStation("Carlinville");
        lincolnService.addStation("Alton");
        lincolnService.addStation("Saint Louis");

        String result = lincolnService.reverseListStations();
        System.out.println(result);
    } // method main
} // class TrainLine

class Station {
    private String name;
    private Station next;

    public Station(String name) {
        this.name = name;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Station getNext() {
        return next;
    }

    public void setNext(Station next) {
        this.next = next;
    }
} // class Station

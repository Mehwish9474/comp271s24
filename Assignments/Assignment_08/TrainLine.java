public class TrainLine {

    /** Points to first station in the train line */
    private Station head;

    /**
     * Points to the last station and facilitates O(1) performance when adding
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
        // Use addStion(Station) method
        this.addStation(newStation);
    } // method addStation

    /**
     * Add a new station at the end of this trainline. The method takes
     * a station object and it checks if this line has a head station yet;
     * if not, the new station becomes the head station. If this line has a
     * head station, the method places the new station after the last station
     * in the line and makes sure that this new station's previous station is
     * the current last station.
     *
     * @param station Station object to add
     */
    public void addStation(Station station) {
        if (this.head == null) {
            // If no head station, this new station becomes the head
            this.head = station;
        } else {
            // Otherwise, append it after the tail and make it the new tail
            this.tail.setNext(station);
        }
        // Either way, we have a new tail now
        this.tail = station;
        this.numberOfStations++;
    } // method addStation

    /**
     * Accessor for head of this trainline
     * 
     * @return head Station object
     */
    public Station getHead() {
        return this.head;
    } // method getHead

    /**
     * Accessor for tail of this trainline
     * 
     * @return tail Station object
     */
    public Station getTail() {
        return this.tail;
    } // method getTail

    /**
     * Returns a string with names of the stations in the train line.
     * @return String with station names, each on a new line, or "The line is empty." if no stations.
     */
    public String listStations() {
        if (head == null) {
            return "The line is empty.";
        }
        StringBuilder stationsList = new StringBuilder();
        Station current = head;
        while (current != null) {
            stationsList.append(current.getName()).append("\n");
            current = current.getNext();
        }
        return stationsList.toString().trim();
    }

    /**
     * Checks if the invoking TrainLine intersects with another TrainLine.
     * @param other TrainLine to check for intersection
     * @return boolean true if they intersect, false otherwise
     */
    public boolean intersects(TrainLine other) {
        if (this.head == null || other.head == null) {
            return false;
        }
        Station current = this.head;
        while (current != null) {
            Station otherCurrent = other.head;
            while (otherCurrent != null) {
                if (current.getName().equals(otherCurrent.getName())) {
                    return true;
                }
                otherCurrent = otherCurrent.getNext();
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Compares this TrainLine with another TrainLine.
     * @param other TrainLine to compare with
     * @return int negative if this is smaller, zero if equal, positive if greater
     */
    public int compareTo(TrainLine other) {
        return Integer.compare(this.getNumberOfStations(), other.getNumberOfStations());
    }

    /**
     * Appends a trainline to the current trainline object
     * @param other Trainline to append to present object
     */
    public void append(TrainLine other) {
        // First make sure that the trainline we wish to append is not null or empty
        if (other != null && other.getHead() != null) {
            // OK, we have something to append, now how to append it?
            if (this.head == null) {
                // If this trainline is empty, we use the other trainline's head and tail
                this.head = other.getHead();
            } else {
                // otherwise, we point this.tail to other.head ae 
                this.tail.setNext(other.getHead());
            }
            // Either way it's the same tail
            this.tail = other.getTail();
        }
    } // method append

} // class TrainLine

class Station {
    String name;
    Station next;

    public Station(String name) {
        this.name = name;
        this.next = null;
    }
}

class TrainLine {
    Station head;

    public TrainLine() {
        this.head = null;
    }

    // Method to add a station to the train line
    public void add(String stationName) {
        Station newStation = new Station(stationName);
        if (head == null) {
            head = newStation;
        } else {
            Station temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStation;
        }
    }

    // Method to return the names of the stations in reverse order
    public String reverseListStations() {
        if (head == null) {
            return "The line is empty.";
        }

        return reverseStations(head);
    }

    // Recursive method to reverse the station names
    private String reverseStations(Station current) {
        if (current.next == null) {
            return current.name;
        }
        return reverseStations(current.next) + "\n" + current.name;
    }

    // Main method for testing the reverse list printing
    public static void main(String[] args) {
        TrainLine lincolnService = new TrainLine();
        lincolnService.add("Chicago");
        lincolnService.add("Summit");
        lincolnService.add("Joliet");
        lincolnService.add("Dwight");
        lincolnService.add("Pontiac");
        lincolnService.add("Bloomington");
        lincolnService.add("Lincoln");
        lincolnService.add("Springfield");
        lincolnService.add("Carlinville");
        lincolnService.add("Alton");
        lincolnService.add("Saint Louis");

        String result = lincolnService.reverseListStations();
        System.out.println(result);
    }
}

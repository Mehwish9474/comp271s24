public class TrainLineTest {

    public static void main(String[] args) {
        // Test listStations
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
        
        System.out.println("Testing listStations:");
        System.out.println(lincolnService.listStations());

        // Test intersects
        TrainLine t1 = new TrainLine();
        t1.addStation("A");
        t1.addStation("B");
        t1.addStation("C");
        t1.addStation("D");

        TrainLine t2 = new TrainLine();
        t2.addStation("Y");
        t2.addStation("B");
        t2.addStation("Z");

        TrainLine t3 = new TrainLine();
        t3.addStation("K");
        t3.addStation("L");

        TrainLine t4 = new TrainLine();

        System.out.println("Testing intersects:");
        System.out.println("t1 intersects t2: " + t1.intersects(t2)); // true
        System.out.println("t2 intersects t1: " + t2.intersects(t1)); // true
        System.out.println("t1 intersects t1: " + t1.intersects(t1)); // true
        System.out.println("t1 intersects t3: " + t1.intersects(t3)); // false
        System.out.println("t1 intersects t4: " + t1.intersects(t4)); // false

        // Test compareTo
        System.out.println("Testing compareTo:");
        System.out.println("t1 compareTo t2: " + t1.compareTo(t2)); // positive number
        System.out.println("t2 compareTo t3: " + t2.compareTo(t3)); // positive number
        System.out.println("t3 compareTo t4: " + t3.compareTo(t4)); // positive number
        System.out.println("t1 compareTo t1: " + t1.compareTo(t1)); // zero
        System.out.println("t4 compareTo t1: " + t4.compareTo(t1)); // negative number
    }
}

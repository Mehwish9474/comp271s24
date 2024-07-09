public class TestTrainLine {
    public static void main(String[] args) {
        // Create a new TrainLine
        TrainLine trainLine = new TrainLine();

        // Add stations
        trainLine.addStation("Howard");
        trainLine.addStation("Jarvis");
        trainLine.addStation("Morse");
        trainLine.addStation("Loyola");

        // Print the train line from head to tail
        System.out.println("Train line from head to tail:");
        Station current = trainLine.getHead();
        while (current != null) {
            System.out.print(current.getName() + " ");
            current = current.getNext();
        }
        System.out.println();

        // Print the train line from tail to head
        System.out.println("Train line from tail to head:");
        current = trainLine.getTail();
        while (current != null) {
            System.out.print(current.getName() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
}
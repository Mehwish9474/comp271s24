public class SimpleTesting {

    private static final String PASS = "Successful";
    private static final String FAIL = "Failed";
    private static final String NON_EXISTENT = "Minas Tirinth";

    public static void main(String[] args) {
        // Create a small train line and add a few stations to it with names
        // drawn from a String[]
        TrainLine redLineSB = new TrainLine();
        String[] stationNames = { "Howard", "Jarvis", "Morse", "Loyola", "Granville", "Thorndale" };
        for (String name : stationNames) {
            redLineSB.addStation(name);
        }
        // Test sequence
        boolean sequence = true;
        for (int i = 0; i < stationNames.length; i++) {
            sequence = sequence && (redLineSB.indexOf(stationNames[i]) == i);
        }
        System.out.printf("\n\nSequence test: %s", (sequence ? PASS : FAIL));
        // Test non existent
        boolean nonExisting = (redLineSB.indexOf(NON_EXISTENT) == -1);
        System.out.printf("\n\nNon-existent test: %s", (nonExisting ? PASS : FAIL));

        // Create another train line to append
        TrainLine blueLineSB = new TrainLine();
        String[] blueLineStations = { "Granville", "Thorndale", "Bryn Mawr" };
        for (String name : blueLineStations) {
            blueLineSB.addStation(name);
        }

        // Append blueLineSB to redLineSB
        redLineSB.append(blueLineSB);
        
        // Check the sequence after append
        String[] combinedStations = { "Howard", "Jarvis", "Morse", "Loyola", "Granville", "Thorndale", "Granville", "Thorndale", "Bryn Mawr" };
        boolean appendSequence = true;
        for (int i = 0; i < combinedStations.length; i++) {
            appendSequence = appendSequence && (redLineSB.indexOf(combinedStations[i]) == i);
        }
        System.out.printf("\n\nAppend sequence test: %s", (appendSequence ? PASS : FAIL));
    }
}
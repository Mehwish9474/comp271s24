public class SimpleTesting {

    private static final String PASS = "Successful";
    private static final String FAIL = "Failed";
    private static final String NON_EXISTENT = "Minas Tirith";
    
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
        
        // Test append method
        TrainLine blueLineSB = new TrainLine();
        String[] blueStationNames = { "Addison", "Belmont", "Fullerton" };
        for (String name : blueStationNames) {
            blueLineSB.addStation(name);
        }
        redLineSB.append(blueLineSB);
        boolean appendTest = redLineSB.indexOf("Howard") == 0 &&
                             redLineSB.indexOf("Jarvis") == 1 &&
                             redLineSB.indexOf("Thorndale") == 5 &&
                             redLineSB.indexOf("Addison") == 6 &&
                             redLineSB.indexOf("Fullerton") == 8;
        System.out.printf("\n\nAppend test: %s", (appendTest ? PASS : FAIL));
    }
}
package USCapitals;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class USCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> capitals = importFile("/home/kristian/IdeaProjects/ListStackQueues/src/USCapitals/USCapitals.txt");

        UI ui = new UI(capitals);
        ui.startUI();

    }

    static Map<String, String> importFile(String filename) {
        Map<String, String> capitalMap = new HashMap<>();

        try {
            File file = new File(filename);
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String input;
            String[] capitols;

            while ((input = bufferedReader.readLine()) != null) {
                capitols = input.split(",");
                capitalMap.put(capitols[0].toLowerCase(), capitols[1].toLowerCase());
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return capitalMap;
    }
}

class UI {
    private final Scanner scan;
    private final Map<String, String> capitals;

    UI(Map<String, String> capitals) {
        this.capitals = capitals;
        scan = new Scanner(System.in);
    }

    public void startUI() {
        System.out.println("Enter state name:");
        String state = scan.nextLine().toLowerCase();


        if (capitals.containsKey(state)) {
            System.out.printf("The capital of %s is %s", titleCase(state), titleCase(capitals.get(state)));
        } else {
            System.out.println("Invalid input");
        }
    }

    public String titleCase(String s) {
        String[] sArr = s.split(" ");

        StringBuilder returnString = new StringBuilder();
        for (String str : sArr) {
            if (str.length() > 0) {
                returnString.append(str.substring(0, 1).toUpperCase()).append(str.substring(1).toLowerCase()).append(" ");
            }
        }
        return returnString.toString().trim();
    }
}

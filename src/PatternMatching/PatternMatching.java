package PatternMatching;

import java.util.Scanner;

public class PatternMatching {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter string pattern: ");
        String patternString = scan.nextLine();
        System.out.println("Enter string to search for pattern match:");
        String matchString = scan.nextLine();

        int matchIndex = patternMatcher(patternString, matchString);

        if (matchIndex == -1) {
            System.out.println("No matching substring in string");
        } else {
            System.out.println("Matching string starts at: " + matchIndex);
        }

    }

    static int patternMatcher(String subString, String mainString) {
        int refLength = subString.length();
        int counter = 0;
        int matchStartIndex = 0;
        for (int i = 0; i < mainString.length(); i++) {
            if (mainString.charAt(i) == subString.charAt(counter)) {
                counter ++;
                if (counter == refLength) {
                    return matchStartIndex;
                }
            }
            else {
                counter = 0;
                matchStartIndex = i + 1;
                if (mainString.charAt(i) == subString.charAt(counter)) {
                    counter++;
                    matchStartIndex--;
                }
            }
        }
        return -1;
    }
}

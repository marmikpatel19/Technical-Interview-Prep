import java.util.HashMap;

/* Question 1.1: Is Unique */

/*
 * Question: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 */

/* Solution */

class IsUnique {

    // Time: O(n). Space: O(n)
    public static boolean isUnique(String input) {
        // Tracks traversed chars
        HashMap<Character, Character> trackedCharacters = new HashMap<>();

        // Traverse the string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // If the currentChar exists in the hashap, then it is a duplicate; return
            // false. Otherwise, insert char into hashmap
            if (trackedCharacters.get(currentChar) != null) {
                return false;
            } else {
                trackedCharacters.put(currentChar, currentChar);
            }
        }

        // No duplicate chars founds => unique string
        return true;
    }

    /* Testing */
    public static void main(String[] args) {

        // String that does not have duplicate chars
        String test1 = "absfe";

        if (isUnique(test1) == false) {
            System.out.println("Failed test case 1");
        }

        // String that has duplicate chars
        String test2 = "abszsfe";

        if (isUnique(test2) == true) {
            System.out.println("Failed test case 2");
        }

        // String that has duplicate chars at the front
        String test3 = "aabsfe";

        if (isUnique(test3) == true) {
            System.out.println("Failed test case 3");
        }

        // String that has duplicate char at the end
        String test4 = "absfee";

        if (isUnique(test4) == true) {
            System.out.println("Failed test case 4");
        }

        // String of size one
        String test5 = "a";

        if (isUnique(test5) == false) {
            System.out.println("Failed test case 5");
        }
    }
}
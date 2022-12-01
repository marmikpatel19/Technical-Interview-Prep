/* Question 1.5: One Away */

/*
 * Question: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */

/* Example

pale, ple -> true
pales , pale -> true
pale, bale -> true
pale, bake -> false

 */

/* Solution */

class OneAwayA2 {

    // time: O(n) space: O(n)
    public static Boolean oneAway(String input1, String input2) {
        // trivial checks
        if (input1 == input2) {
            return true;
        }

        if (Math.abs(input1.length() - input2.length()) > 1) {
            return false;
        }

        char[] input1Array = input1.toCharArray();
        char[] input2Array = input2.toCharArray();

        // potentially a replaced char
        if (input1.length() == input2.length()) {
            int numDisimilarities = 0;

            for (int i = 0; i < input1.length(); i++) {
                if (input1Array[i] != input2Array[i]) {
                    numDisimilarities++;

                    if (numDisimilarities > 1) {
                        return false;
                    }
                }
            }

            return true;
        }
        // potentially an inserted or removed char
        else {
            int numAltered = 0; // number of removed or inserted chars
            char[] longerInput;
            char[] shorterInput;

            if (input1.length() > input2.length()) {
                longerInput = input1Array;
                shorterInput = input2Array;
            } else {
                longerInput = input2Array;
                shorterInput = input1Array;
            }

            int longerPointer = 0;

            for (int i = 0; i < shorterInput.length; i++) {
                if (longerInput[longerPointer] != shorterInput[i]) {
                    longerPointer++;
                    numAltered++;
                }

                if (numAltered > 1) {
                    System.out.println(numAltered);
                    return false;
                }

                longerPointer++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple")); // true
        System.out.println(oneAway("pales", "pale")); // true
        System.out.println(oneAway("pale", "bale")); // true
        System.out.println(oneAway("pale", "bake")); // false
        System.out.println(oneAway("pale", "pe")); // false
    }
}
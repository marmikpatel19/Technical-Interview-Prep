import java.util.HashMap;

/* Question 1.4: Palindrome Permutation */

/*
 * Question: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 */

/* Solution */

/* Example

input: Tact Coa
output: True 
    (permutations: "taco cat", "atco cta", etc. )

 */

/**
 * assumption
 * 
 * spaces do not matter
 * 
 * uppercase == lowercase
 */

class PalindromePermutation {

    // Time: O(n), Space: O(n)
    public static boolean palindromePermutation(String s) {

        char[] sChar = s.toCharArray();

        removeSpaces(sChar);

        // Insert chars into hashmap
        HashMap<Character, Integer> appearances = insertIntoMap(sChar);

        // number of times a character appears an odd number of times
        int numOdds = 0;

        // Iterate through unique chars, checking for hte number of odd-numbered
        // appeahrces of chars
        for (char key : appearances.keySet()) {
            if (appearances.get(key) % 2 != 0) {
                numOdds++;
            }
        }

        // of odd-lenght, if there is more than one character that appeares an odd
        // number of times,
        // then it's not a palindorme. for even, >0 is not palindrome.
        String sString = sChar.toString();
        if (sString.length() % 2 != 0) {
            if (numOdds > 1) {
                return false;
            } else {
                return true;
            }
        } else {
            if (numOdds > 0) {
                return false;
            } else {
                return true;
            }
        }

    }

    public static void removeSpaces(char[] sChar) {
        int length = sChar.length;

        // iterate through string
        for (int i = 0; i < sChar.length; i++) {

            // if current char is a space, shift all the characters leftward, overrding the
            // space, and reduce the length by one
            if (sChar[i] == ' ') {

                for (int j = i; j < sChar.length - 1; j++) {
                    sChar[j] = sChar[j + 1];
                }

                length--;
            }
        }

        // add in null char at the corresponding positions
        if (length < sChar.length) {
            sChar[length - 1] = '\0';
        }
    }

    public static HashMap<Character, Integer> insertIntoMap(char[] sChar) {
        HashMap<Character, Integer> appearances = new HashMap<>();

        // Store all the chars into a hashmap
        for (int i = 0; i < sChar.length; i++) {

            if (sChar[i] != '\0') {
                // convert uppercase to lowercase
                int intRep = (int) sChar[i];
                int diff = 'A' - 'a';
                if (intRep > 65 && intRep < 90) {
                    sChar[i] = (char) (sChar[i] - diff);
                }

                // if the char has already appeared, increment its value by one
                if (appearances.get(sChar[i]) != null) {
                    int numOccurrences = appearances.get(sChar[i]);
                    appearances.put(sChar[i], numOccurrences + 1);
                }
                // else, add the key-value pair in
                else {
                    appearances.put(sChar[i], 1);
                }
            }

        }

        return appearances;
    }

    /* Testing */
    public static void main(String[] args) {

        String test1 = "Tact Coa";
        System.out.println(palindromePermutation(test1));

        String test2 = "abc";
        System.out.println(palindromePermutation(test2));

        String test3 = "oaoa";
        System.out.println(palindromePermutation(test3));

    }

}
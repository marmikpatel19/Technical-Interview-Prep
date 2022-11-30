import java.util.HashMap;

/* Question 1.4: Palindrome_Permutation */

/*
 * Question: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 */

/* Example

input: Tact Coa
output: True 
    (permutations: "taco cat", "atco cta", etc. )

 */

/*
 * Assumptions
 * - space are not a part of the permutation 
 * - emptry string true
 * - upper and lower case are seen as the same
 */

/* Solution */

class PalindromePermutationA2 {

    // time: O(n) space: O(n)
    public static Boolean palindromePermutation(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        char[] inputArray = input.toCharArray();

        int inputArrayLength = input.length();

        HashMap<Character, Integer> numOccurences = new HashMap<>();

        // insert chars and their num occurences into numOccurences
        for (int i = 0; i < input.length(); i++) {
            if (inputArray[i] != ' ') {

                // covert upper case into lower case
                if (inputArray[i] >= 65 && inputArray[i] <= 90) {
                    int diff = 'A' - 'a';
                    inputArray[i] = (char) (inputArray[i] - diff);
                }

                if (numOccurences.get(inputArray[i]) == null) {
                    numOccurences.put(inputArray[i], 1);
                } else {
                    numOccurences.put(inputArray[i], (numOccurences.get(inputArray[i]) + 1));
                }
            } else {
                inputArrayLength--;
            }
        }

        // iterate through list and count number of odd chracters
        int numOdd = 0;

        for (int value : numOccurences.values()) {
            if (value % 2 != 0) {
                numOdd++;
            }
        }

        // even or odd number of characters
        if (inputArrayLength % 2 == 0) {
            return numOdd == 0;
        } else {
            return numOdd == 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(palindromePermutation("Tact Coa")); // true
        System.out.println(palindromePermutation("TaCoa")); // false
        System.out.println(palindromePermutation("raccar")); // true
        System.out.println(palindromePermutation("av")); // false
        System.out.println(palindromePermutation("rAcCar")); // true
    }
}
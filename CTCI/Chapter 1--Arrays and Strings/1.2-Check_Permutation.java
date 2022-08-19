import java.util.HashMap;

/* Question 1.2: Check Permutation */

/*
 * Question: Given two strings, write a method to decide if one 
 * is a permutation of the other.
 */

/* Solution */

/*
 * Assumptions
 * 
 * non-empty
 * same string does not count as a permutation
 */

/* 
 * Example
 * 
 * a: "held"
 * b: "ehdl"
*/

class CheckPermutation {

    // Time: O(n). Space: O(n)
    public static boolean checkPermutation(String a, String b) {

        // If the string are not the same lenght, they cannot be permutations of one
        // another
        if (a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> aHashMap = permutationMap(a);
        HashMap<Character, Integer> bHashMap = permutationMap(b);

        // Traverse hashmaps to compare for equality
        for (Character key : aHashMap.keySet()) {
            if (aHashMap.get(key) != bHashMap.get(key)) {
                return false;
            }
        }

        return true;
    }

    public static HashMap<Character, Integer> permutationMap(String input) {

        // Each char as a key and the number of appearches as the value
        HashMap<Character, Integer> permutationsHashMap = new HashMap<Character, Integer>();

        // Iterate through string, storing each char as a key and the number of
        // appearches as the value
        for (int i = 0; i < input.length(); i++) {

            // If the current char is not in the map, insert it with a appearance value of
            // 1,
            if (permutationsHashMap.get(input.charAt(i)) == null) {
                permutationsHashMap.put(input.charAt(i), 1);
            }
            // else, increment the value by 1
            else {
                permutationsHashMap.put(input.charAt(i), permutationsHashMap.get(input.charAt(i)) + 1);
            }
        }

        return permutationsHashMap;
    }

    /* Testing */
    public static void main(String[] args) {

        // permutations
        if (!checkPermutation("hello", "ehllo")) {
            System.out.println("test case 1 failed");
        }

        // permutations
        if (!checkPermutation("heeelo", "eeelho")) {
            System.out.println("test case 2 failed");
        }

        // not permuations
        if (checkPermutation("hello", "eqllo")) {
            System.out.println("test case 3 failed");
        }

        // not permutation, diffent size lenghts
        if (checkPermutation("hello", "ehsllo")) {
            System.out.println("test case 4 failed");
        }

        // permutations strings of size one
        if (!checkPermutation("h", "h")) {
            System.out.println("test case 5 failed");
        }
    }
}
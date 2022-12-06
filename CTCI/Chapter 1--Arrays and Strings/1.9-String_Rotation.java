/* Question 1.9: String Rotation */

/*
 * Question: Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
call to isSubstring
 */

/*
 * examples
 * "waterbottle" is a rotation of "erbottlewat"
 */

/*
 * assumptions
 * a string can be a substring of itself 
 */

/* Solution */

class StringRotation {
    // time: O(n) space: O(1)
    // public static Boolean stringRotation(String s1, String s2) {
    // if (s1.length() != s2.length()) {
    // return false;
    // }
    // if (s1.length() == 0) {
    // return true;
    // }

    // int s1Pointer = 0;

    // // iterate through s2, looking for where the start of s1 aligns
    // for (int i = 0; i < s2.length(); i++) {
    // if (s1.charAt(s1Pointer) == s2.charAt(i)) {
    // s1Pointer++;
    // } else {
    // s1Pointer = 0;
    // }
    // }

    // if (s1Pointer == 0) {
    // return false;
    // }

    // String first = s1.substring(0, s1Pointer + 1);
    // String second = s2.substring(0, s2.length() - s1Pointer);

    // return isSubstring(s1, first + second);
    // }

    // time: O(substring), space: O(n)
    public static Boolean stringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }

        String doubleS2 = s2 + s2;

        return isSubstring(doubleS2, s1);
    }

    // temp
    public static Boolean isSubstring(String s1, String s2) {
        return true;
    }
}
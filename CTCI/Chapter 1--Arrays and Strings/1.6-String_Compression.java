/* Question 1.6: String Compression */

/*
 * Question: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3, If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z)
 */

/*
 * Assumptions
 * upper and lower case treated differently 
 */

/* Solution */

class StringCompression {

    // time: O(n + k^2) (k is number of diff chars, because string concatenation
    // is O(n^2)) space O(n)
    public static String stringCompression(String input) {

        if (input.length() == 0) {
            return input;
        }

        String compressedInput = "";

        char currentChar = input.charAt(0);
        int numCurrentChar = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                numCurrentChar++;
            } else {
                compressedInput = compressedInput + currentChar + numCurrentChar;

                currentChar = input.charAt(i);
                numCurrentChar = 1;
            }
        }

        compressedInput = compressedInput + currentChar + numCurrentChar;

        if (compressedInput.length() < input.length()) {
            return compressedInput;
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("aabcccccaaa")); // a2b1c5a3
        System.out.println(stringCompression("ggaaa")); // g2a3
        System.out.println(stringCompression("aba")); // aba
    }
}
/* Question 1.3: URLify */

/*
 * Question: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

/* Solution */

/* Example
 * 
 * Input: "Mr John Smith" ,  13
 * Output: "Mr%20John%20Smith"
 */

/* Assumption
 * 
 * spaces at the end and start of the string  do not get removed and do not get replaced by "%20"'s'
 *
 * the same string is updated and a new one is not created
 *
 * more than one space in a row => each get converted into %20 
 */

class URLify {

    // Time: O(n^2). Space: O(n)

    // Unitial incorrect solution:
    /*
     * public static void urlify(char[] s, int length) {
     * // empty string
     * if (length == 0) {
     * return;
     * }
     * 
     * // find start index
     * int startIndex = findStart(s);
     * 
     * // empty string
     * if (startIndex == -1) {
     * return;
     * }
     * 
     * // find end index
     * int endIndex = findEnd(startIndex, length);
     * 
     * // Replaces spaces
     * replaceSpaces(s, startIndex, endIndex);
     * }
     * 
     * // find the start index
     * public static int findStart(char[] s) {
     * int curIndex;
     * 
     * // Traverse until the for non-space char is found
     * for (curIndex = 0; curIndex < s.length; curIndex++) {
     * // when the start index is found, break out of the loop
     * if (s[curIndex] != ' ') {
     * return curIndex;
     * }
     * }
     * 
     * // start index not found
     * 
     * return -1;
     * }
     * 
     * // find the "true" end of the string
     * public static int findEnd(int startIndex, int length) {
     * return startIndex + length;
     * }
     * 
     * // Replace in-string spaces with %20
     * public static void replaceSpaces(char[] s, int startIndex, int endIndex) {
     * // Current index
     * int curIndex = startIndex;
     * 
     * // end index
     * int updatedEndIndex = endIndex;
     * 
     * // Iterate through the string
     * while (curIndex < updatedEndIndex) {
     * 
     * // if current char is a space, move all remaining chars right by two and
     * replace
     * // new spaces with "%20"
     * if (s[curIndex] == ' ') {
     * 
     * updatedEndIndex = updatedEndIndex + 2;
     * int cur = curIndex + 3;
     * int next = cur + 4;
     * char curValue = s[curIndex + 1];
     * char nextValue = s[curIndex + 2];
     * 
     * s[curIndex] = '%';
     * s[curIndex + 1] = '2';
     * s[curIndex + 2] = '0';
     * 
     * while (next <= updatedEndIndex) {
     * cur = cur + 2;
     * next = next + 2;
     * char tempCurValue = curValue;
     * char tempNextValue = nextValue;
     * curValue = s[cur];
     * nextValue = s[next];
     * s[curValue] = tempCurValue;
     * s[nextValue] = tempNextValue;
     * }
     * }
     * 
     * curIndex++;
     * 
     * // "he l lo    "
     * // "he%20lo    "
     * }
     * }
     */

    public static void urlify(char[] s, int length) {
        // length of final string
        int finalLength = length + countSpaces(s, length) * 2;

        // replace spaces with "%20", traversing backwords
        for (int i = length - 1; i >= 0; i--) {
            // check if cur char is a space
            if (s[i] == ' ') {
                s[finalLength - 1] = '0';
                s[finalLength - 2] = '2';
                s[finalLength - 3] = '%';
                finalLength = finalLength - 3;
            } else {
                // copy char from string to the end of the buffer
                s[finalLength - 1] = s[i];
                finalLength--;
            }
        }
    }

    // "he llo " i = 6, finalLength = 8

    public static int countSpaces(char[] s, int length) {
        int numSpaces = 0;

        for (int i = length - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                numSpaces++;
            }
        }

        return numSpaces;
    }

    /* Testing */
    public static void main(String[] args) {

        // without spaces

        String test1 = "hello";
        char[] test1Char = test1.toCharArray();

        urlify(test1Char, 5);

        System.out.println(test1Char);

        // with one space
        String test2 = "he llo  ";
        char[] test2Char = test2.toCharArray();

        urlify(test2Char, 6);

        System.out.println(test2Char);

        // with two spaces
        String test3 = "he l lo    ";
        char[] test3Char = test3.toCharArray();

        urlify(test3Char, 7);

        System.out.println(test3Char);

        // with two consequtive spaces
        String test4 = "he  llo    ";
        char[] test4Char = test4.toCharArray();

        urlify(test4Char, 7);

        System.out.println(test4Char);

    }

}
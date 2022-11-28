/* Big-O Question 0.11AP
 * Additional Problem 11 */

/* The following code prints all strings of length k where the characters 
are in sorted order. It does this by generating all strings of length k 
and then checking if each is sorted.
Question: What is its runtime? */
class Question11AP {

    int numChars = 26;

    void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithletter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithletter(s.charAt(i - 1));
            int curr = ithletter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }

        return true;
    }

    char ithletter(int i) {
        return (char) (((int) 'a') + i);
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * let c be number of characters and n length of string.
 * 
 * isInOrder: the loop iterates s.length = n times
 * 
 * printSortedStrings: the for loop iterates a c times. Each iteration has a
 * recursive call. If the if statement is entered (isInOrder is executed), then
 * the complexity of each call is O(n). If the else statement is entered, then
 * there are c recursive calls; this set of c recursive calls occurs n times
 * because for each character in the string, c chracters are substituted, making
 * c strings (for example, for a five digit string that is currently "abcde",
 * for the first character, there wil be c combinations ("abcde", "bbcde",
 * "cbcde", etc.), which represents the c recursive calls. This occurs five
 * times, one for each character in the string). Thus, the complexity would be
 * c^n. Since each call executes both the if and else statements, the total
 * complexity becomes O(nc^n)
 * 
 * 
 * time complexity: O(nc^n)
 *
 */

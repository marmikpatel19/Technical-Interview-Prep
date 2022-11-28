/* Big-O Question 0.12
 * Example 12 */

/* This code counts all permutations of a string.
Question: What is its time complexity? */
class Question12 {
    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * Let length of string be n. Since this calculates permutations, the number of
 * recursive calls is n! The for-loop iterates n times in the worst case. Thus,
 * the number if total iterations is n * n!.
 * String concatenation takes O(n) time.
 * Thus, the total runtime is O(n^2 * n!)
 * 
 * time complexity: O(n^2 * n!)
 * 
 */

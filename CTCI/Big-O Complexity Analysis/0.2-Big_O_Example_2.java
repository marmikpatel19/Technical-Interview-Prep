/* Big-O Question 0.2 
 * Example 2 */

/* Question: What is the runtime of the below code? */
class Question2 {
    void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * outer loop: O(n)
 * inner loop: O(n)
 * 
 * time complexity: O(n) * O(n) = O(n^2)
 * 
 */

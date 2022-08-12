/* Big-O Question 0.3 
 * Example 3 */

/* Question: What is the runtime of the below code? */
class Question {
    void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * outer loop:
 * inner loop:
 * iterates a total of Σ(i) from i to n - 1 times <=> n(n + 1)/2 => O(n^2)
 * 
 * 
 * time complexity: O(n^2)
 * 
 */

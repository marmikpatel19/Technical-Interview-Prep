/* Big-O Question 0.5 
 * Example 5 */

/* Question: What is the runtime of the below code? */
class Question {
    void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 160800; k++) {
                    System.out.println(arrayA[i] + arrayB[j]);
                }
            }
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * outer loop: O(n), where n is length of arrayA
 * inner loop: O(m), where m is the length of arrayB
 * inner inner loop: O(1)
 * 
 * 
 * time complexity: O(nm)
 * 
 */

/* Big-O Question 0.4 
 * Example 4 */

/* Question: What is the runtime of the below code? */
class Question4 {
    void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + arrayB[i]);
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
 * 
 * 
 * time complexity: O(nm)
 * 
 */

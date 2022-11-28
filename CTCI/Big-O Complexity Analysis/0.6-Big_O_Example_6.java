/* Big-O Question 0.6 
 * Example 6 */

/* Question: What is the runtime of the below code? */
class Question6 {
    void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * outer loop: O(n)
 * number of iteration is n/2 => O(n)
 * 
 * 
 * time complexity: O(n)
 * 
 */

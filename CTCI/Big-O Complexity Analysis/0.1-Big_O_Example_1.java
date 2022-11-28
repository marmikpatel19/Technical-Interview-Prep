/* Big-O Question 0.1 
 * Example 1 */

/* Question: What is the runtime of the below code? */
class Question1 {
    void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];

            System.out.println(sum + ", " + product);
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * for loop 1: O(n)
 * for loop 2: O(n)
 * 
 * time complexity: O(n) + O(n) = O(n)
 * 
 */

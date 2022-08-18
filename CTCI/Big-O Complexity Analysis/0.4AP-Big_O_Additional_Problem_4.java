/* Big-O Question 0.4AP
 * Additional Problem 4 */

/* The following code performs integer division.
Question: What is its runtime (assume a and b are both positive)? */
class Question {

    int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * The while loop iterates the number of times a is divisible by b since the
 * loop iteratively performs the division.
 * 
 * time complexity: O(a/b)
 *
 */

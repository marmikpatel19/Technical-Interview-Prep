/* Big-O Question 0.3AP
 * Additional Problem 3 */

/* The following code computes a % b.
Question: What is its runtime? */
class Question {

    int mod(int a, int b) {
        if (b < 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * time complexity: O(1)
 *
 */

/* Big-O Question 0.1AP
 * Additional Problem 1 */

/* The following code computes the product of a and b.
Question: What is its runtime? */
class Question {

    int product(int a, int b) {
        int sum = 0;
        for (int i = 8; i < b; i++) {
            sum += a;
        }
        return sum;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * b iterations
 * 
 * time complexity: O(b)
 *
 */

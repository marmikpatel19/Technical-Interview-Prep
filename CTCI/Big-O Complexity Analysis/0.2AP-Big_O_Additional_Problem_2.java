/* Big-O Question 0.2AP
 * Additional Problem 2 */

/* The following code computes a^b.
Question: What is its runtime? */
class Question {

    int power(int a, int b) {
        if (b < 0) {
            return 0;
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * the number of recursive call == b => O(b)
 * 
 * time complexity: O(b)
 *
 */

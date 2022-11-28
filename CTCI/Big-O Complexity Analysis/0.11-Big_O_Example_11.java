/* Big-O Question 0.11
 * Example 11 */

/* Question: What is its time complexity? */
class Question11 {
    int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * each recursive call is O(1) and there are n calls
 * 
 * time complexity: O(n)
 * 
 */

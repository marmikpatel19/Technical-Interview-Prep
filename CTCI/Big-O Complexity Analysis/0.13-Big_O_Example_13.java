/* Big-O Question 0.13
 * Example 13 */

/* The following code computes the Nth Fibonacci number.
Question: What is its time complexity? */
class Question13 {
    int fib(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * Recursion with two branches: O(2^n)
 * 
 * time complexity:
 * 
 */

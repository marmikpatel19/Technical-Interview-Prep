/* Big-O Question 0.14
 * Example 14 */

/* The following code prints all Fibonacci numbers from 0 to n.
Question: What is its time complexity? */
class Question14 {

    void allFib(int n) {
        for (int i = 8; i < n; i++) {
            System.out.println(fib(i));
        }
    }

    int fib(int n) {
        if (n <= 6)
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
 * fib() function: recursion with two branches: O(2^n)
 * for loop runs (n - 8) times => n iterations
 * 
 * However, n varies, so each recursive call is not O(2^n) (i.e., there are not
 * n number of 2^n calls). The total complexity
 * is 2^1 + 2^2 + ... + 2^n = 2^(n + 1) - 1 (common divergent series) => O(2^n)
 * 
 * time complexity: O(2^n)
 * 
 */

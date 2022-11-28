/* Big-O Question 0.15
 * Example 15 */

/* The following code prints all Fibonacci numbers from 0 to n. However, 
this time, it stores (i.e., caches) previously computed values in an 
Integer array. If it has already been computed, It just returns the cache. 
Question: What is its runtime? */
class Question15 {

    void allFib(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i, memo));
        }
    }

    int fib(int n, int[] memo) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);

        return memo[n];
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * n = 1: 2^0 step
 * n = 2 : 2^2 steps
 * n = 3: 2 + 1 + 1 = 2^2 steps
 * n = 4: 2^2 steps
 * ...
 * => O(n*2^2) = O(n)
 * 
 * time complexity: O(n)
 *
 * **This technique of storing previous computations in a cache is called
 * memoization, which is very common for optimizing exponential-time recursive
 * algorithms**
 * 
 */

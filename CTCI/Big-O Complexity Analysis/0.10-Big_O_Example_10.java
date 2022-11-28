/* Big-O Question 0.10 
 * Example 10 */

/* The following method checks if a number is prime by checking for divisibility on numbers less than it. It only
needs to go up to the square root of n because if n is divisible by a number greater than its square root then
it's divisible by something smaller than it.
For example, while 33 is divisible by 11 (which is greater than the square root of 33), the "counterpart" to 11
is 3 (3 * 11 = 33). 33 will have already been eliminated as a prime number by 3.

Question: What is the time complexity of this function? */
class Question10 {
    boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * loop: x * x <= n <=> x < sqrt(n) => x goes from 2 to sqrt(n) by incrementing
 * by one => O(sqrt(n))
 * 
 * time complexity: O(sqrt(n))
 * 
 */

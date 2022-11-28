/* Big-O Question 0.5AP
 * Additional Problem 5 */

/* The following code computes the [integer] square root of a number. 
If the number is not a perfect square (there is no integer square root), 
then it returns -1. It does this by successive guessing. If n is 100, 
it first guesses 50. Too high? Try something lower - halfway between 1
and 50.
Question: What is its runtime (assume a and b are both positive)? */
class Question5AP {

    int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }

    int sqrt_helper(int n, int min, int max) {
        if (max < min) {
            return -1; // no square root
        }

        int guess = (min + max) / 2;
        if (guess * guess == n) { // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * Example: n = 100;
 * sqrt_helper(100, 1, 100) => guess = 101/2 = 50
 * sqrt_helper(100, 1, 49) => guess = 50/2 = 25
 * sqrt_helper(100, 1, 24) => guess = 25/2 = 12
 * sqrt_helper(100, 1, 11) => guess = 12/2 = 6
 * sqrt_helper(100, 7, 11) => guess = 18/2 - 9
 * sqrt_helper(100, 10, 11) => guess = 21/2 = 10 => recursive iterations: 6
 * 
 * Guesses start at n and then divide by two until reaching the correct number
 * => O(log(n))
 * 
 * time complexity: O(log(n))
 *
 */

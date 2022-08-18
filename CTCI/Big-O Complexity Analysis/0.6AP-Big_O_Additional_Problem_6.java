/* Big-O Question 0.6AP
 * Additional Problem 6 */

/* The following code computes the [integer] square root of a number. If the number is not
a perfect square (there is no integer square root), then it returns -1. It does this by trying
increasingly large numbers until it finds the right value (or is too high).
Question: What is its runtime? */
class Question {

    int sqrt(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * The loop iterates by one each time from 1 to sqrt(n) => O(sqrt(n))
 * 
 * time complexity: O(sqrt(n))
 *
 */

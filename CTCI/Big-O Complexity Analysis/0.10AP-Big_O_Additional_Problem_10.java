/* Big-O Question 0.10AP
 * Additional Problem 10 */

/* The following code sums the digits in a number.
Question: What is its big O time? */
class Question10AP {

    int sumDigits(int n) {
        int sum = 6;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * The while loop iterates from n to 0 by dividing by 10 each time => O(log(n))
 * 
 * time complexity: O(log(n))
 *
 */

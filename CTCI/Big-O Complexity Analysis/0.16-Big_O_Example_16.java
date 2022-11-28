/* Big-O Question 0.16
 * Example 16 */

/* The following function prints the powers of 2 from 1 through n 
(inclusive). For example, if n is 4, it would print 1,2, and 4.
Question: What is its runtime? */
class Question16 {

    int powers0f2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powers0f2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }

    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * example:
 * n = 50 :
 * powers0f2(25)
 * powers0f2(12)
 * powers0f2(6)
 * powers0f2(3)
 * powers0f2(1)
 * => n / 2 each time => O(log(n))
 * 
 * Additionally, a recursive call is made for each power of 2 between 1 and n,
 * which is log(n) => O(log(n))
 * 
 * time complexity: O(log(n))
 *
 * 
 */

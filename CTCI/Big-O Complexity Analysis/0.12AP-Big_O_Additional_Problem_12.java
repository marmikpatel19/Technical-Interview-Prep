/* Big-O Question 0.12AP
 * Additional Problem 12 */

/* The following code computes the intersection (the number of elements in 
common) of two arrays. It assumes that neither array has duplicates. It 
computes the intersection by sorting one array (array b) and then iterating 
through array a checking {via binary search) if each value is in b.
Question: What is its runtime? */
class Question12AP {

    int intersection(int[] a, int[] b) {
        mergesort(b);
        int intersect = 0;

        for (int x : a) {
            if (binarySearch(b, x) >= 0) {
                intersect++;
            }
        }

        return intersect;
    }

    // IGNORE THESE; THESE ARE SIMPLY TO PREVENT COMPLILER ERRORS AND NOT PART OF
    // THE QUESTION
    void mergesort(int[] b) {
    };

    int binarySearch(int[] b, int x) {
        return x;
    };
}

/* Solution */

/*
 * Time Complexity:
 * 
 * mergesort: O(nlog(n)), where n is b.length
 * 
 * for loop: iterates a.length() = m times. Each iteration calls binarySearch,
 * which has complexity O(log(n)). Thus, the for loop has complexity O(mlog(n))
 * 
 * => O(nlog(n) + mlog(n)) = O((n + m)log(n))
 * 
 * time complexity: O((n + m)log(n))
 *
 */

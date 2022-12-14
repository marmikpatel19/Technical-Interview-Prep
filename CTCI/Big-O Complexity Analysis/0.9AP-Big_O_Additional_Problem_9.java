/* Big-O Question 0.9AP
 * Additional Problem 9 */

/* The appendToNew method appends a value to an array by creating a new, longer array and
returning this longer array. You've used the appendToNew method to create a copyArray
function that repeatedly calls appendToNew.
Question: How long does copying an array take? */
class Question9AP {

    int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew(copy, value);
        }
        return copy;
    }

    int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }
        // add new element
        bigger[bigger.length - 1] = value;

        return bigger;
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * copyArray: iterates through array => O(n)
 * 
 * appendToNew: iterates through array => O(n)
 * 
 * time complexity: O(n^2)
 *
 */

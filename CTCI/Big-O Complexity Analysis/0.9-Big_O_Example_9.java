/* Big-O Question 0.9 
 * Example 9 */

/* Question: The following simple code sums the values of all the nodes in a balanced binary search tree. What is its
runtime? */
class Question {

    abstract class Node {
        Node left;
        Node right;
        int value;
    }

    int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + node.value + sum(node.right);
    }
}

/* Solution */

/*
 * Time Complexity:
 * 
 * Approach 1: each node is visited => O(n)
 * 
 * Approach 2: Recursion with two branches. Assume number of node is n => height
 * of tree is log2(n).
 * O(2^(log(n))
 * Let P = 2^(log(n) <=> log(P) = log(2^(log(n)) <=> log(P) = log(n)*log(2) <=>
 * log(P) = log(n), since log2(2) = 1 <=> P = n => 2^(log(n) = n
 * ∴ O(n)
 * 
 * time complexity: O(n)
 * 
 */

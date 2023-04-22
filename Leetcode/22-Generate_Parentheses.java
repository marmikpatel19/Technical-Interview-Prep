import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    // 'all combinations' => backtracking

    /*
     * Backtrack if 1) solution has already been added, 2) it reaches > n open
     * parentheses,
     * or 3) num of closed parentheses > num of open parentheses
     */

    // time: O(nCr), space: O(n)
    // time: O(nCr), space: O(n)
    public List<String> generateParenthesis(int n) {
        List<String> allParens = new ArrayList<>();

        findCombs(allParens, "", 0, 0, n);

        return allParens;
    }

    private void findCombs(List<String> allParens, String currParens, int numOpen, int numClosed,
            int n) {
        System.out.println("curr: " + currParens + ", numOpen: " + numOpen + ", numClosed: " + numClosed);
        /* backtracking base cases */
        // solution already inserted
        if (allParens.contains(currParens)) {
            return;
        }
        // too many open parentheses
        else if (numOpen > n) {
            return;
        }
        // too many closed parentheses
        else if (numClosed > numOpen) {
            return;
        }
        // reached bottom of recursion; add element in
        else if (numOpen == n && numClosed == n) {
            allParens.add(currParens);
            return;
        } else {
            // add open parenthesis
            String temp = currParens;
            numOpen++;

            findCombs(allParens, currParens + "(", numOpen, numClosed, n);

            numOpen--;
            currParens = temp;

            // add closed parenthesis
            temp = currParens;
            numClosed++;

            findCombs(allParens, currParens + ")", numOpen, numClosed, n);

            numClosed--;
            currParens = temp;
        }
    }

}
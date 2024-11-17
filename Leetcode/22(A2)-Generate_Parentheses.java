import java.util.ArrayList;
import java.util.List;

class GenerateParenthesesA2 {
    // time: O(2^n), space: O(2^n) 
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(n, res, new StringBuilder(), 0, 0);
        return res;
    }

    public void backtrack(int n, ArrayList<String> res, StringBuilder 
    currS, int numOpen, int numClose){
        // base cases
        if(numOpen < numClose){return;}
        if(numOpen > n || numClose > n){return;}
        if(numOpen == n && numClose == n){res.add(currS.toString());}

        // recursion
        currS.append("(");
        backtrack(n, res, currS, numOpen + 1, numClose);
        currS.deleteCharAt(currS.length() - 1);

        currS.append(")");
        backtrack(n, res, currS, numOpen, numClose + 1);
        currS.deleteCharAt(currS.length() - 1);
    }
}
import java.util.Stack;

class EvaluateReversePolishNotation {
    // time: O(n), space: O(n)
    public int evalRPN(String[] tokens) {
        // maintains the current numbers
        Stack<Integer> nums = new Stack<>();

        // iterate through all the tokens
        for (String token : tokens) {
            // operator encourated; execute the operator on the last two nums in the stack
            // and
            // push the result
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int numOne = Integer.valueOf(nums.pop());
                int numTwo = Integer.valueOf(nums.pop());

                if (token.equals("+")) {
                    nums.push(numTwo + numOne);
                } else if (token.equals("-")) {
                    nums.push(numTwo - numOne);
                } else if (token.equals("*")) {
                    nums.push(numTwo * numOne);
                } else {
                    nums.push(numTwo / numOne);
                }
            }
            // num encountered; add it to nums
            else {
                nums.push(Integer.valueOf(token));
            }
        }

        return nums.pop();
    }
}
import java.util.HashMap;
import java.util.Stack;

class ValidParentheses {
    // time: O(n), space: O(n)
    public boolean isValid(String s) {
        Stack<Character> currentParentheses = new Stack<>();

        // insert the current relations
        HashMap<Character, Character> relations = new HashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (relations.containsValue(currentChar)) {
                currentParentheses.push(currentChar);
            } else {
                if (currentParentheses.empty()) {
                    return false;
                }
                if (currentParentheses.peek() == relations.get(currentChar)) {
                    currentParentheses.pop();
                } else {
                    return false;
                }
            }
        }

        return currentParentheses.empty();

    }
}
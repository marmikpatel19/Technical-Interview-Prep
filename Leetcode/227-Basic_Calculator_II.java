class BasicCalculatorII {
    /**
    Grabbing digits and handeling whitespace
        we cannot Integer.valueOf() b/c it does not handle white space

        Instead, we go character-by-character, and store the curr num ouutside of
        the loop.
        If char is space:
            skip curr char
        if char is num:
            iteratwe update number by x10 to move to the next digit space and add 
            the current char. We can add the current char using 
            Integer.valueOf(Character.toString(c))
        if char is op
            update lastOp
            update currNum to 0
    
    The problem itself
        Store each number in a stack. for -, store -num

        as we iterate, we keep track of the last operation
        if the last operation was * or /, we pop the last num, complete the operation,
            and push the result.
        if the last op is + or -, we do nothing 

        at the end, sum all the numbers. 
     */
    
     public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        char lastOp = ' ';
        int currNum = 0;

        for(int i = 0; i <= s.length(); i++){
            // current chracter is an operation
            if(i == s.length() || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '){ 
                // handle last operation
                if(lastOp == '+'){
                    nums.push(currNum);
                }else if(lastOp == '-'){
                    nums.push(-currNum);
                }else if(lastOp == '*'){
                    int leftNum = nums.pop();
                    nums.push(leftNum * currNum);
                }else if(lastOp == '/'){
                    int leftNum = nums.pop();
                    nums.push(leftNum / currNum);
                }else{ // very first num
                    nums.push(currNum);
                }

                // update operation
                if(i < s.length()){lastOp = s.charAt(i);}
                
                // update currNum
                currNum = 0;
            }// if current char is digit => update currNum  
            else if(Character.isDigit(s.charAt(i))){
                currNum = currNum * 10 + Integer.valueOf(Character.toString(s.charAt(i)));
            }
        }

        // sum all nums
        int sum = 0;
        while(!nums.isEmpty()){
            sum += nums.pop();
        }

        return sum;
    }
}
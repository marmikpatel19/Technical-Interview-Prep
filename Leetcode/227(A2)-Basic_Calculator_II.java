class BasicCalculatorIIA2 {
    class Solution {  
        /** Optimal O(1) space solution
        
        We do the same logical essentially as if we used a stack, but instead a 
        cumulative sum. We keep track of the prevOp, prevNum, and the sum. 
    
        For parsing, we can use Character.isDigit() to check if number and that 
        plus != ' ' to check for operation.
    
        Iterate character by character:
            if a digit is encountered, do a while loop to sum the entire number. 
            We can do this using currNum = currNum * 10 + newDigit to move
            the digit up by a tenths place
    
            after we grab the full number, execute the last operation. We can do 
            this by remove the prevNum from sum, executing the last operation, 
            and adding it back to sum, while updating the relevant variables. 
            This works because it's the same as the stack apporach in that we're
            create a sum of sums. E.g., for "3 * 4 * 5", when we iterate through
            5, we would have prevNum 12, sum 12, lastOp *. We would then do 
            = sum = (12 - 12) + 12 * 5. i.e., since we sum the product, doing
            subtract/addition works because we remove/add the full product.
    
            finally if we encounter an operation, just update lastOp
         */
    
        // time: O(n), space: O(1)
        public int calculate(String s) {
            int sum = 0;
            int prevNum = 0;
            char lastOp = '+';
    
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    // iterate through the whole number
                    int currNum = 0;
    
                    while(i < s.length() && Character.isDigit(s.charAt(i))){
                        currNum = currNum * 10 + Integer.valueOf(Character.toString(s.charAt(i)));
                        i++;
                    }
                    i--;
    
                    // execute the last operation
                    if(lastOp == '+'){
                        sum += currNum;
                        prevNum = currNum;
                    }else if(lastOp == '-'){
                        sum -= currNum;
                        prevNum = -currNum;
                    }else if(lastOp == '*'){
                        sum = sum - prevNum + prevNum * currNum;
                        prevNum = prevNum * currNum;
                    }else{ // division
                        sum = sum - prevNum + prevNum / currNum;
                        prevNum = prevNum / currNum;
                    }
    
                }else if(!Character.isDigit(c) && c != ' '){
                    lastOp = c;
                }
            }
    
            return sum;
        }
    }    
}
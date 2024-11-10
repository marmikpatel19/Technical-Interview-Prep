class MinimumRemovetoMakeValidParentheses {
    /**
    clarifications
        - so valid if for every left parenthesis there is a right one, and
            left comes before right?
        - is () valid or must contain something?
        - should we check for uppercase letters or can we expect all input
            to be lower case? 
        - empty string is valid?
        - edge case "(("
    
    Approaches
        - bruteforce: create every combination of string and check if it's valid
            O(2^n)
        - stack. push (. everytime we come across ), pop. if wanting to pop
        but none on stack, delete from string. if at the end, we have left's
        left, do another iteration to remove them. 
            O(n), O(n)
        - keep in variable to keep track of number of left. same logic. 
            O(n), O(n)
                time:
                    first loop: O(n)
                    second loop: O(n)
                    O(2n) = O(n)
                space:
                    res: O(n)
                    res2: O(n)
                    deleteIndicies: O(n)
                    three loops: O(3n)
                    O(6n) = O(n)

    tests:
        - full string w one odd right
        - right before left
        - only parentheses in string and right before left
     */
    public String minRemoveToMakeValid(String s) {
        int numLeftParentheses = 0;
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                numLeftParentheses++;
            }
            else if(c == ')'){
                if(numLeftParentheses > 0){
                    numLeftParentheses--;
                }else{continue;}
            }

            res.append(c);
        }

        /** 
        We could just do a simple backward iteration snd used
        .deleteCharAt(), but that technically becomes O(n^2) for
        worst-case b/c .deleteCharAt() is O(n). (we can update 
        original res b/c StringBuilder does not thrown 
        concurrentModification error)

        just discuss these two approaches in the interview and ask 
        which one they prefer.
         */
        HashSet<Integer> deleteIndicies = new HashSet<>();
        int numLeftParentheses2 = numLeftParentheses;
        for (int i = res.length() - 1; i >= 0; i--){
            char c = res.charAt(i);
            if(numLeftParentheses2 > 0 && c == '('){
                deleteIndicies.add(i);
                numLeftParentheses2--;
            }
        }

        StringBuilder res2 = new StringBuilder();
        for (int i = 0; i < res.length(); i++){ 
            if(!deleteIndicies.contains(i)){
                res2.append(res.charAt(i));
            }
        }

        return res2.toString();
    }
}
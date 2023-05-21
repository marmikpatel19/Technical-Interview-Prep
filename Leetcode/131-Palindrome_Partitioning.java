class PalindromePartitioning{
    /*
    Backtracking:

    For any given string, we backtrack on all the possible strings start from the start index
    and end at each following index. For example, "aab" is broken into three backtracking 
    calls: "a", "aa", and "aab". As a second example, "lamp" is broken into: "l", "la", 
    "lam", and "lamp".

    At each call, the string is checked to be a palindrome. This is the condition to 
    determine whether to backtrack--if the current string is not a palindrome, backtrack.
    If the end of string is reached, also backtrack. 

    Repeat the backtracking call structure defined above, just now starting at the next index.
    For instance, with the above example:
    - The "a" call will work with the string starting at index 1, "ab", and break that
    down into the calls for "a" and "ab"
    - The "aa" call will work with the string at index 2, "b", and break that into the call
    "b"
    - The "aab" call will bakctrack because the end of string is reaached.

    -----------------------

    Continuing the example:
    - The second "a" call will make the call at the index 2 of "b"
    - The "ab" call will backtrack because "ab" is not a palindrome
    - The "b" call succeeds and make a call out of bounds which eventually backtracks

    - The "b" call succeeds and make a call out of bounds which eventually backtracks

    See visualized tree for this example here: https://www.youtube.com/watch?v=3jvWodd7ht0
    */

    /*
    Complexity Analysis:

    Time Complexity:
    O(N*2^N)
    For each n characters there are two choices, two continue recursing or backtrack. At each
    goal, isPalindrome() is called, which is O(N)

    Space Complexity: 
    O(N)
    Call stack depth on the wqorst case is N levels deep
     */

     public List<List<String>> partition(String s) {
        List<List<String>> allPalindromes = new ArrayList<>();
        
        findPartitions(s, allPalindromes, new ArrayList<>(), 0);

        return allPalindromes;
    }

    private void findPartitions(String s, List<List<String>> allPalindromes, List<String> currPalindromes, int start){
        if(start >= s.length() && currPalindromes.size() != 0){
            allPalindromes.add(new ArrayList<String>(currPalindromes));
        }
        else{
            // Generate all substrings
            for(int end = start; end < s.length(); end++){
                String currS = s.substring(start, end + 1);

                // Recursive calls
                if(isPalindrome(currS)){
                    // add current values
                    currPalindromes.add(currS);

                    findPartitions(s, allPalindromes, currPalindromes, end + 1);
                    
                    // remove current values 
                    currPalindromes.remove(currPalindromes.size() - 1);
                }
            }
        }   
    }

    // Time: O(N), space: O(1)
    private Boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
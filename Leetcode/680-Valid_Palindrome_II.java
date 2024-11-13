class ValidPalindromeII {
    /**
    Clarifications
        - what characters does the string consists of--alphanumeric?
            - uppercase/lowercase? 
        - empty string is palindrome? 
            - so if I have a single char strng "a" and delete it, 
            still palindrome right?
        - return boolean if it's a palindrome?
        - we can remove zero chars too right? 

    approaches
        - iterate throihg the string and createw a new string that's reverse. 
            then compare the two strings by iterating char by char. if a
            char doesnt match, that can be the charater we delete. if we 
            delete more than one, return false otherwise true.
            O(n), O(n)
        - two pointers
            - l and r. while l < r. if there's a mismatch, delete/skip
            that char. if more than one mismatch then we returen false.
            O(n), O(1)
    
    tests
        - palindrome by default & odd and even: aaa, aaaa
        - delete one char and it's a palindrome: aabba
        - delete on char and not a plaindrome: abc

    */
    public boolean validPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1, true);
    }

    private boolean isPalindromeHelper(String s, int l, int r, boolean canDelete){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                if(!canDelete){return false;}
            
                if(!isPalindromeHelper(s, l, r - 1, false) && 
                !isPalindromeHelper(s, l + 1, r, false)){
                    return false;
                }
                return true;
            }

            l++;
            r--;
        }

        return true;
    }
}
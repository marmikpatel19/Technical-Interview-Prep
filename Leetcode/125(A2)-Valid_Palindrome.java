class ValidPalindromeA2 {
    /**
    clarifications
        - upper case vs lower case
        - are we treating numbers the same way as letters?
        - don't compare any non-alphanumeric, right? 
            - so no whitespace too right? '
        - empty string 

    approaches
        - create new string fromt he first one iterating backwards 
        and then compare them. O(n), O(n) space for 2nd str
        - two pointer: O(n), O(1)
            still O(n) for the new string at the top
        - two pointer but don't create the new string, simply have 
        nested while loops that check within 

    tests
        - even
        - odd
        - non alphanumeric
        - regular
    */

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(l >= r){break;}

            char lChar = s.charAt(l);
            if(!Character.isDigit(lChar) && (int)lChar < 97){ // 'A' = 65, 'a' = 97
                lChar = (char)(lChar + ('a' - 'A'));
            }
            char rChar = s.charAt(r);
            if(!Character.isDigit(rChar) && (int)rChar < 97){ // 'A' = 65, 'a' = 97
                rChar = (char)(rChar + ('a' - 'A'));
            }

            if(lChar != rChar){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
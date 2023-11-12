class LongestPalindromicSubstring {
    /**
    While it may not seem like it, this can actually be a subproblem question.
    e.g., even case: if "ababa" is a palindrome, so is substring "bab"
    e.g., odd case: if "abba" is a palindrome, so is substring "bb"

    We solve this question by doing two iterations, one for odd-length strings and 
    one for even-length strings. 

    For odd, we check the surrounding characters of each index to see if it's a palindrome and 
    continue expanding until it is no.

    For even, we do the same thing but iterate at two indicies at a time.
     */

    // time: O(n^2), space: O(n)
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = String.valueOf(s.charAt(0));

        // odd case
        for(int i = 0; i < n; i++){
            int l = i - 1;
            int r = i + 1;

            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    if(r - l  + 1 > longest.length()){
                        longest = s.substring(l, r + 1);
                    }  
                }
                else{break;}

                l--;
                r++;
            }
        }

        // even case
        for(int i = 0; i < n; i++){
            int l = i;
            int r = i + 1;

            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    if(r - l  + 1 > longest.length()){
                        longest = s.substring(l, r + 1);
                    }  
                }
                else{break;}

                l--;
                r++;
            }
        }

        return longest;
    }
}
class LongestSubstringWithoutRepeatingCharactersA2 {
    /** Sliding window

    use a HashSet to maintain list of chars in current string. every 
    increment of r, check if new character exists in HashSet. If not,
    increment r. If so, increment l until it no longer does.
     */

    // time: O(n), space: O(n)
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        HashSet<Character> currLetters = new HashSet<>();
        int l = 0;
        int r = 0;

        while(r < s.length()){
            if(!currLetters.contains(s.charAt(r))){
                currLetters.add(s.charAt(r));
            }else{
                while(currLetters.contains(s.charAt(r))){
                    currLetters.remove(s.charAt(l));
                    l++;
                }
                currLetters.add(s.charAt(r)); // adding current letter in
            }

            r++;
            longestLength = Math.max(longestLength, r - l); // checking between l and r
        }

        return longestLength;
    }
}
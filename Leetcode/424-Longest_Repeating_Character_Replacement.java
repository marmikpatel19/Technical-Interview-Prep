class LongestRepeatingCharacterReplacement {
    /**
    Overlapping subarrays --> sliding window
    Subarrays of different size --> dynamically-sized sliding window

    The sliding window interates in this fashion: the right pointer iterates while a 
    consistent substring exists. When it no longer does, the left pointer iterated
    until a consistent substring is found. This continues until the right pointer
    reaches the end of the string.

    A given substring can be checked for consistency by substracting the length by the 
    the most frequent character in the substring and determine if it is <= k. e.g,
    for substring "avaw" and k=2, we do 4 (length) - 2 (most freq) <= 2 => consistent.

    We can keep track of the most frequent characters by using an alphabet HashMap.
    We can use a variable to keep track of the current maximum frequence so as to not 
    need to traverse all values of the hashmap to determine the character of max freq
    for each substring. When the window slides, the variable does not need to be updated
    (only the hashmap freq does) because we have already found a max length so using that
    max length on different substrings does not make a difference; and, when a longer
    length is found, the variable would automatically be updated.
     */

    // time: O(n), space: O(1)
    public int characterReplacement(String s, int k) {
        if(s.length() == 0){return 0;}

        int l = 0;
        int maxLength = 1;
        int n = s.length();
        HashMap<Character, Integer> letterFreq = new HashMap<>();
        int currMaxCharFreq = 1;

        for(int r = 1; r <= n; r++){
            char currChar = s.charAt(r - 1);
            letterFreq.put(currChar, letterFreq.getOrDefault(currChar, 0) + 1);
            currMaxCharFreq = Math.max(currMaxCharFreq, letterFreq.get(currChar));

            // Iterate left pointer until condition is met
            while((r - l) - currMaxCharFreq > k){
                currChar = s.charAt(l);
                letterFreq.put(currChar, letterFreq.get(currChar) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l);
        }

        return maxLength;
    }
}

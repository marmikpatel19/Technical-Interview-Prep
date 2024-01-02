class MinimumWindowSubstring{
    /**
    overlapping subarrays of different sizes --> dynamic sliding window.

    slide r until substring is found. slide l while it sustains.

    Traverse t to create a frequency hashmap of each char. When a 
    relevant char is found while traversing s, update a variable 
    instantiated with 0 to determine if the substring contains all
    m characters. We can determine sepcific chars by updating the freq
    of the char in the hashmap. 
     */

    // time: O(m), space: O(n)
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int minLeft = 0;
        if(n > m){return "";}
        if(s.equals(t)){return s;}
        int minSubstringLength = m + 1; // if it stays > m then it means no valid string found
        int currNumValidChars = 0;
        int l = 0, r = 1;
        HashMap<Character, Integer> tCharFreq = new HashMap<>();

        for(int i = 0; i < n; i++){tCharFreq.put(t.charAt(i), tCharFreq.getOrDefault(t.charAt(i), 0) + 1);}

        while(r <= m){
            char currCharR = s.charAt(r - 1);
            if(tCharFreq.containsKey(currCharR)){
                tCharFreq.put(currCharR, tCharFreq.get(currCharR) - 1);
                if(tCharFreq.get(currCharR) >= 0){currNumValidChars++;}
            }

            while(currNumValidChars == n){
                if(r - l < minSubstringLength){
                    minLeft = l;
                    minSubstringLength = r - l;
                }

                char currChar = s.charAt(l);
                if(tCharFreq.containsKey(currChar)){
                    tCharFreq.put(currChar, tCharFreq.get(currChar) + 1);
                    if(tCharFreq.get(currChar) > 0){currNumValidChars--;}
                }

                l++;
            }

            r++;
        }

        return minSubstringLength > m ? "" : s.substring(minLeft, minLeft + minSubstringLength);
    }
}
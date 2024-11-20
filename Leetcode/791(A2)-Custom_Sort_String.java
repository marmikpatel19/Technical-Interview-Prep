class CustomSortString(A2) {
    /**
    clarifications
        - order and s need nto have the same characters right?
        - order's all chars are unqiue but the case for s
        - if order is empty, return s?
        - all lowercase english letters? 
    
    approaches
        - exhastive approach. for eacdh char in new streing, check
            if the order is correct comparing it order string.
            T: O(n!)

        - hashmap + two pointer.
            build hashmap char -> position 

            for each char iterate fromt he start through new string 
            to check iter char > ranking than curr char. if so, prepend
            the char. 

            if char doesn't exist, just add

            e.g., cba abcd
            a
            a b -> a > b -> ba
            ba c -> c > a -> cba
            cba d -> cbad

            T: O(N^2), S: O(N)
        
        - hashmap diff
            build a frequency hashmap from s
            iterate through order, as we come 
            across a character, if it exists in s,
            add it frequency number of times in res
            and remove it from the map. at the end,
            add remaining numbs in map

            T: O(n + m), S: O(n)
    tests
        - regular
        - mismatch chars
     */
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> charToFreq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            charToFreq.put(s.charAt(i), charToFreq.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(charToFreq.containsKey(c)){
                res.append(String.valueOf(c).repeat(charToFreq.get(c)));
                charToFreq.remove(c);
            }
        }

        // add in remaining characters
        for(Character c : charToFreq.keySet()){
            res.append(String.valueOf(c).repeat(charToFreq.get(c)));
        }

        return res.toString();
    }
}
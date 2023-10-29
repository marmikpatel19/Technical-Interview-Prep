class ValidAnagramA2 {
    // time: O(n), space: O(n)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){return false;}

        HashMap<Character, Integer> letterFreq = new HashMap<>(); // char to freq

        for(int i = 0; i < s.length(); i++){
            letterFreq.put(s.charAt(i), letterFreq.getOrDefault(s.charAt(i), 0) + 1);
            letterFreq.put(t.charAt(i), letterFreq.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(int freq : letterFreq.values()){
            if(freq != 0){return false;}
        }

        return true; 
    }
}
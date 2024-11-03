import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagramsA3 {
    // time: O(nm), space: O(nm)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> freqmapToAnagrams = new HashMap<>();

        for(String s : strs){
            // create a freq hashmap
            HashMap<Character, Integer> letterToFreq = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                letterToFreq.put(c, letterToFreq.getOrDefault(c, 0) + 1);
            }

            // store new hashmap or append string to existing one
            if(freqmapToAnagrams.containsKey(letterToFreq)){
                freqmapToAnagrams.get(letterToFreq).add(s);
            }else{
                ArrayList<String> anagram = new ArrayList<>();
                anagram.add(s);
                freqmapToAnagrams.put(letterToFreq, anagram);
            }
        }

        List<List<String>> groupedAnagrams = new ArrayList<>();
        for(ArrayList<String> l : freqmapToAnagrams.values()){
            groupedAnagrams.add(l);
        }

        return groupedAnagrams;
    }
}
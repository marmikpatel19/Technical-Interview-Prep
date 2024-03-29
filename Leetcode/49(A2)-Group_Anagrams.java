import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagramsA2 {
    /**
    iterate through each word. for each word, sort it.
    Use a hashmap to store each sorted word to an arraylist of its variations
    iterate through the keys of the hashmap and for each arraylist, store it as an element in 
        the final list.
    */

    // time: O(n * mlog(m))) m = length of longest string, space: O(n) 
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<>();
        HashMap<String, List<String>> sortedToAnagrams = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] sArray = strs[i].toCharArray();
            Arrays.sort(sArray);
            String sortedS = new String(sArray);
            if(sortedToAnagrams.containsKey(sortedS)){
                sortedToAnagrams.get(sortedS).add(strs[i]);
                sortedToAnagrams.put(sortedS, sortedToAnagrams.get(sortedS));
            }
            else{
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                sortedToAnagrams.put(sortedS, anagrams);
            }
        }

        for(List<String> anagrams : sortedToAnagrams.values()){
            anagramGroups.add(anagrams);
        }

        return anagramGroups;
    }
}
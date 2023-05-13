import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    // time: O(n*mlog(m)), where n is strs.length and m is length of longest string
    // space: O(nm)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedToOriginal = new HashMap<>();

        // insert strings into sortedToOriginal and sort them
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];

            char[] sortedS = strs[i].toCharArray();
            Arrays.sort(sortedS);

            String s = new String(sortedS);

            // insert into sortedToOriginal
            if (sortedToOriginal.get(s) == null) {
                List<String> strings = new ArrayList<String>();
                strings.add(temp);
                sortedToOriginal.put(s, strings);
            } else {
                sortedToOriginal.get(s).add(temp);
            }
        }

        // create entire list
        List<List<String>> anagrams = new ArrayList<>();
        for (List<String> anagram : sortedToOriginal.values()) {
            anagrams.add(anagram);
        }

        return anagrams;
    }
}
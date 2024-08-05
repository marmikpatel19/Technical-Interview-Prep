import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(findConsistentLogs(new int[] {1,2,1,3,4,2,4,3,3,4})); // answer: 8
        System.out.println(findConsistentLogs(new int[] {9, 9, 9})); // answer: 3
        System.out.println(findConsistentLogs(new int[] {9,8,5,9,2})); // answer: 4
    }
    
    /**
    First, we find every subarray. This includes an nested loop approach where we 
    go from i = 0 to n in outer loop and j = i to n in inner loop. this is just the 
    convention for finding all subarrays.
    
    We use two dependent frequency hashmaps. the first is is a regular frequency hashmap:
    in the current subarray, it maintains the frequency of each element. the second
    holds the amount of elements of each frequency (e.g., frequency two: three elements, 
    frequency one: one element). 
    
    As we iterate to a new element, we find the frequency of that element in hashmap1. 
    Let's say it's two. Then we -= the occurences in hashmap two (number of elements
    of frequency two - 1). We update hashmap1. and then += the occurences in hashmap
    two of that new frequeency (number of elements with frequency trhee + 1). Also,
    when an element in map 2 has 0, remove that element. 
    
    e.g.,
        "1 2 2". m1: {1: 1, 2: 2}, m2: {1: 1, 2: 1}
        new element 2: "1, 2, 2, 2"
        update old freq in map2: m2: {1: 1}
        update map1: m1: {1: 1, 2: 3}
        update new freq in map2: m2: {1: 1, 3: 1}
        
    During each subarray, if map2 has only on element, then all elements have the same
    frequency. we would a consistent log. maintain a var over all subarrays to 
    find maximum.
    */
    
    // time: O(n^2), space: O(n)
    private static int findConsistentLogs(int[] userEvents){
        int maxOccurences = 0;
        int n = userEvents.length;
        
        for(int i = 0; i < n; i++){
            HashMap<Integer, Integer> userToFreq = new HashMap<>();
            HashMap<Integer, Integer> freqToOccurences = new HashMap<>();
            
            for(int j = i; j < n; j++){
                int user = userEvents[j];
                int currFreq = userToFreq.getOrDefault(user, 0);
                
                if(currFreq > 0){
                    freqToOccurences.put(currFreq, freqToOccurences.get(currFreq) - 1);
                    if(freqToOccurences.get(currFreq) == 0){
                        freqToOccurences.remove(currFreq);
                    }
                }
                
                userToFreq.put(user, userToFreq.getOrDefault(user, 0) + 1);
                int newFreq = userToFreq.get(user);
                
                freqToOccurences.put(newFreq, freqToOccurences.getOrDefault(newFreq, 0) + 1);
                
                if(freqToOccurences.size() == 1){
                    maxOccurences = Math.max(maxOccurences, j - i + 1);
                }
            }
        }
        
        return maxOccurences;
    }
}
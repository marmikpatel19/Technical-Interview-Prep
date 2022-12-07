package Leetcode;

class LongestSubstringWithoutRepeatingCharacters {
    // time: O(n)?, space: O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int largest = 1;
        int currentLargest = 1;
        int initialPointer = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.substring(initialPointer, i).contains(String.valueOf(s.charAt(i)))) {

                while (s.substring(initialPointer, i).contains(String.valueOf(s.charAt(i)))) {
                    initialPointer++;
                }

                currentLargest = i - initialPointer + 1;
            } else {
                currentLargest++;
            }

            if (currentLargest > largest) {
                largest = currentLargest;
            }
        }

        return largest;
    }

    // Attempt two after solution

    // dynamically-sized sliding window
    // time: O(n), space: O(n)
    // public int lengthOfLongestSubstring(String s) {
    // if(s.length() == 0){
    // return 0;
    // }

    // HashMap<Character, Integer> characters = new HashMap<>();

    // int l = 0;
    // int r = 0;
    // int largest = 1;

    // while(r < s.length()){

    // // input current value at r into characters
    // Character rightValue = s.charAt(r);
    // characters.put(rightValue, characters.getOrDefault(rightValue, 0) + 1);

    // // increment l until there are no repeated characters
    // while(characters.get(rightValue) > 1){
    // Character leftValue = s.charAt(l);
    // characters.put(leftValue, characters.get(leftValue) - 1);
    // l++;
    // }

    // largest = Math.max(largest, r - l + 1);

    // r++;
    // }

    // return largest;
    // }
}
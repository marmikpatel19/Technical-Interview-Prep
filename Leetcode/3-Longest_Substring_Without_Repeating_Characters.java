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
}
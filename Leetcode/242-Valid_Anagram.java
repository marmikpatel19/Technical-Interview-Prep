class ValidAnagram {
    // Time: O(nlogn), space: O(n)
    public boolean isAnagram(String s, String t) {
        // edge case
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // compare both string sorted
        java.util.Arrays.sort(sArr);
        java.util.Arrays.sort(tArr);
        return java.util.Arrays.equals(sArr, tArr);
    }
}
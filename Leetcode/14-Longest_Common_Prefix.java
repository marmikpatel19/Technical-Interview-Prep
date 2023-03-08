class LongestCommonPrefix {
    // time: O(max(nlog(n), O(m)), where n = strs.length, m = length of longest
    // string. Space: O(m)
    public String longestCommonPrefix(String[] strs) {
        // sort strs alphabetically to get the most dissimilar ones at the start and end
        // of the array
        java.util.Arrays.sort(strs);

        String currentPrefix = "";
        int n = strs.length;
        int maxSize;
        if (strs[0].length() < strs[n - 1].length()) {
            maxSize = strs[0].length();
        } else {
            maxSize = strs[n - 1].length();
        }

        // find the common prefix between the first and last string
        for (int i = 0; i < maxSize; i++) {
            if (strs[0].charAt(i) == strs[n - 1].charAt(i)) {
                currentPrefix = strs[0].substring(0, i + 1);
            } else {
                return currentPrefix;
            }
        }

        return currentPrefix;
    }
}
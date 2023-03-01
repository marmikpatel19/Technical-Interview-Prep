class PalindromeNumber {
    // time: O(n), space: O(n)
    public boolean isPalindrome(int x) {
        String xAsStr = String.valueOf(x);

        // left and right iterators
        int l = 0;
        int r = xAsStr.length() - 1;

        // iterate from left and right and check each character
        while (l < r) {
            if (xAsStr.charAt(l) != xAsStr.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
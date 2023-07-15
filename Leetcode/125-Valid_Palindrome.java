class ValidPalindrome {
    // time: O(n), space: O(1)
    public boolean isPalindrome(String s) {
        String sLower = s.toLowerCase();
        char[] sArray = sLower.toCharArray();

        int l = 0;
        int r = sArray.length - 1;

        while (l < r) {
            int lIntRepresentation = Integer.valueOf(sArray[l]);
            int rIntRepresentation = Integer.valueOf(sArray[r]);

            // move both pointers to comparable indices
            while (l < sArray.length && (!(lIntRepresentation >= 48 && lIntRepresentation <= 57)
                    && !(lIntRepresentation >= 97 && lIntRepresentation <= 122))) {
                l++;
                if (l < sArray.length) {
                    lIntRepresentation = Integer.valueOf(sArray[l]);
                }
            }

            while (r >= 0 && (!(rIntRepresentation >= 48 && rIntRepresentation <= 57)
                    && !(rIntRepresentation >= 97 && rIntRepresentation <= 122))) {
                r--;
                if (r >= 0) {
                    rIntRepresentation = Integer.valueOf(sArray[r]);
                }
            }

            if (l < r) {
                System.out.println(sArray[l] + ", " + sArray[r]);

                // compare
                if (sArray[l] != sArray[r]) {
                    return false;
                }

                l++;
                r--;
            }
        }

        return true;
    }
}
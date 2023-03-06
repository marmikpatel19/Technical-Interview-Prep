class SpiralMatrix {
    // time: O(n), space: O(n)
    public int[] plusOne(int[] digits) {
        int start = 0;
        int end = digits.length - 1;

        while (start <= end) {
            if (digits[end] + 1 > 9) {
                digits[end] = 0;
                end--;
            } else {
                digits[end] += 1;
                return digits;
            }
        }

        // add 1 to the start
        int[] updatedDigits = new int[digits.length + 1];
        updatedDigits[0] = 1;

        for (int i = 1; i < digits.length + 1; i++) {
            updatedDigits[i] = digits[i - 1];
        }

        return updatedDigits;
    }
}
class RomantoInteger {
    class Solution {
        // time: O(n), space: O(n)
        public int romanToInt(String s) {
            char[] roman = s.toCharArray();
            int num = 0;

            // iterate through roman backwards
            int l = roman.length - 2;
            int r = roman.length - 1;
            while (l > -1) {
                // subtraction is needed
                if (needsSub(roman[l], roman[r])) {
                    num += toInt(roman[r]) - toInt(roman[l]);
                    l--;
                    r--;
                }
                // no subtraction, so add single char
                else {
                    num += toInt(roman[r]);
                }

                l--;
                r--;
            }

            // if there is a char left, add it to the sum
            if (r == 0) {
                num += toInt(roman[r]);
            }

            return num;
        }

        private int toInt(char r) {
            switch (r) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }

            return 0;
        }

        private Boolean needsSub(char l, char r) {
            if (l == 'I' && (r == 'V' || r == 'X')) {
                return true;
            } else if (l == 'X' && (r == 'L' || r == 'C')) {
                return true;
            } else if (l == 'C' && (r == 'D' || r == 'M')) {
                return true;
            } else {
                return false;
            }
        }
    }
}
/* Question 1.5: One Away */

/*
 * Question: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */

/* Solution */

/* Example

pale, ple -> true
pales , pale -> true
pale, bale -> true
pale, bake -> false

 */

class OneAway {

    // time: O(n), space: O(1)
    public static boolean oneAway(String s, String t) {

        // convert to char arrays
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        // same string => zero edits
        if (sChar.equals(tChar)) {
            return true;
        }

        // if the string differ in length > 1, they are > 1 edit apart
        if (sChar.length - tChar.length > 1) {
            return false;
        } else {
            // if the lengths are equal, then check for a differnce in characters
            if (sChar.length == tChar.length) {
                int numDiff = 0;

                // iterate through strings, counting number of dissimilar chars
                for (int i = 0; i < sChar.length; i++) {
                    if (sChar[i] != tChar[i]) {
                        numDiff++;
                    }
                }

                if (numDiff > 1) {
                    return false;
                }
            }
            // lengths off by one
            else {
                int cur1 = 0;
                int cur2 = 0;

                int shortestLength = 0;
                boolean sIsLonger;

                // find longer string
                if (sChar.length < tChar.length) {
                    shortestLength = sChar.length;
                    sIsLonger = false;
                } else {
                    shortestLength = tChar.length;
                    sIsLonger = true;
                }

                int numDiff = 0;

                // iterate through strings, counting number of dissimilar chars
                for (int i = 0; i < shortestLength; i++) {
                    if (sChar[cur1] != tChar[cur2]) {
                        numDiff++;

                        // string differ by more than one edit
                        if (numDiff > 1) {
                            return false;
                        }

                        if (sIsLonger) {
                            cur1++;
                        } else {
                            cur2++;
                        }

                        cur1--;
                        cur2--;

                    }
                    cur1++;
                    cur2++;
                }

                // pale, ple
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // should be true
        System.out.print(oneAway("pale", "ple") + "\n");

        // should be true
        System.out.print(oneAway("pales", "pale") + "\n");

        // should be true
        System.out.print(oneAway("pale", "bale") + "\n");

        // should be false
        System.out.print(oneAway("pale", "bake") + "\n");

        // should be false
        System.out.print(oneAway("pale", "pwe") + "\n");
    }

}
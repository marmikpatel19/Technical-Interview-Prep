class LetterCombinationsofaPhoneNumber {
    // time: O(4^n), space: O(4^n)
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){return new ArrayList<String>();}

        List<String> combs = new ArrayList<String>();
        StringBuilder currComb = new StringBuilder();
        HashMap<Character, String> digitToLetters = getLettersForDigit(digits);
        
        backtrack(digits, 0, combs, currComb, digitToLetters);

        return combs;
    }

    private void backtrack(String digits, int i, List<String> combs, StringBuilder currComb, HashMap<Character, String> digitToLetters){
        // base case
        if(i >= digits.length()){
            combs.add(currComb.toString());
            return;
        }

        // recurse on each letter in curr digit
        String s = digitToLetters.get(digits.charAt(i));
        for(int j = 0; j < s.length(); j++){
            currComb.append(Character.toString(s.charAt(j)));
            backtrack(digits, i + 1, combs, currComb, digitToLetters);
            currComb.deleteCharAt(currComb.length() - 1);
        }
    }

    private HashMap<Character, String> getLettersForDigit(String digits){
        HashMap<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        return digitToLetters;
    }
}
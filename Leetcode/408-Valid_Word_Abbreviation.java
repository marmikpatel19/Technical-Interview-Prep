class ValidWordAbbreviation {
    // time: O(n), space: O(1)
    public boolean validWordAbbreviation(String word, String abbr) {
        int p1 = 0;
        int p2 = 0;

        while(p1 < word.length() && p2 < abbr.length()){
            if(Character.isDigit(abbr.charAt(p2))){
                // edge case of leading zero and empty string
                if(abbr.charAt(p2) == '0'){return false;}

                // capture the whole number
                StringBuilder fullNumAsString = new StringBuilder();
                while(p2 < abbr.length() && Character.isDigit(abbr.charAt(p2))){
                    fullNumAsString.append(abbr.charAt(p2));
                    p2++;
                }

                // convert string to int
                int num = Integer.valueOf(fullNumAsString.toString());

                // edge case of adjacent substrings
                if(num > word.length() - p1){return false;}

                // iterate word's p1 by num
                p1+=num;
            }else{
                if(word.charAt(p1) == abbr.charAt(p2)){
                    p1++;
                    p2++;
                }else{return false;}
            }
        }

        if(p1 == word.length() && p2 == abbr.length()){return true;}
        return false;
    }
}
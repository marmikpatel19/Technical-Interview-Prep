class IntegertoRoman {
    /**
    Create a list of all the roman symbols and their values. Add the values for the
    4's and 9's as well. 
    
    For num, iterate through these from largest to smallest, checking if num is 
    divisible by them. If so, then add the corresponding symbol that many
    times. Then, update num by moding it. Repeat until num == 0.
    
    e.g., 900
        700 / 500 = 1 => D. num = 700 % 500 = 200.
        200 / 100 = 2 => DCC. num = 200 / 100 = 0.

     */

    // time: O(digits), space: O(1)
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        HashMap<Integer, String> intToRoman = new LinkedHashMap<>();
        initializeHashMap(intToRoman);

        while(num != 0){
            for(Integer val : intToRoman.keySet()){
                if(num / val > 0){
                    for(int i = 0; i < num / val; i++){
                        roman.append(intToRoman.get(val));
                    }

                    num = num % val;
                    break;
                }
            }
        }

        return roman.toString();
    }

    private void initializeHashMap(HashMap<Integer, String> intToRoman){
        intToRoman.put(1000, "M");
        intToRoman.put(900, "CM");
        intToRoman.put(500, "D");
        intToRoman.put(400, "CD");
        intToRoman.put(100, "C");
        intToRoman.put(90, "XC");
        intToRoman.put(50, "L");
        intToRoman.put(40, "XL");
        intToRoman.put(10, "X");
        intToRoman.put(9, "IX");
        intToRoman.put(5, "V");
        intToRoman.put(4, "IV");
        intToRoman.put(1, "I");
    }
}
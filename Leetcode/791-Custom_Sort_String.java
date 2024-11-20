class CustomSortString {
    /**
    clarifications
        - order and s need nto have the same characters right?
        - order's all chars are unqiue but the case for s
        - if order is empty, return s?
        - all lowercase english letters? 
    
    approaches
        - exhastive approach. for eacdh char in new streing, check
            if the order is correct comparing it order string.
            T: O(n!)

        - hashmap + two pointer.
            build hashmap char -> position 

            for each char iterate fromt he start through new string 
            to check iter char > ranking than curr char. if so, prepend
            the char. 

            if char doesn't exist, just add

            e.g., cba abcd
            a
            a b -> a > b -> ba
            ba c -> c > a -> cba
            cba d -> cbad

            T: O(N^2), S: O(N)
    
    tests
        - regular
        - mismatch chars
     */
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> charToOrder = new HashMap<>();

        int increment = 0; 
        for(int i = 0; i < order.length(); i++){
            charToOrder.put(order.charAt(i), increment);
            increment++;
        }

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(charToOrder.containsKey(s.charAt(i))){
                boolean swapped = false;
                for(int j = 0; j < i; j++){
                    if(charToOrder.containsKey(res.charAt(j)) 
                    && charToOrder.get(res.charAt(j)) > charToOrder.get(s.charAt(i))){
                        res.insert(j, s.charAt(i));
                        swapped = true;
                        break;
                    }
                }

                if(!swapped){
                    res.append(s.charAt(i));
                }
            }else{
                res.append(s.charAt(i));
            }  
        }

        return res.toString();
    }
}
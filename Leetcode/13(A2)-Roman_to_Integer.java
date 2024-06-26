class RomantoIntegerA2 {
    /**
    Iterate through each char. if char is I, X, or C, check for 
    a following V/X, LC, DM, respectively. convert and add to 
    current sum. 
     */

    // time: O(n), space: O(1)
    public int romanToInt(String s) {
        int converted = 0;

        for(int i = 0; i < s.length(); i++){
            char currLetter = s.charAt(i);

            switch (currLetter){
                // single conversion cases
                case 'V':
                    converted+=5;
                    break;
                case 'L':
                    converted+=50;
                    break;
                case 'D':
                    converted+=500;
                    break;
                case 'M':
                    converted+=1000;
                    break;
                // subtraction cases
                case 'I':
                    if(i + 1 < s.length() && s.charAt(i + 1) == 'V'){
                        converted+=4;
                        i++;
                    }
                    else if(i + 1 < s.length() && s.charAt(i + 1) == 'X'){
                        converted+=9;
                        i++;
                    }
                    else{converted+=1;}
                    break;  
                case 'X':
                    if(i + 1 < s.length() && s.charAt(i + 1) == 'L'){
                        converted+=40;
                        i++;
                    }
                    else if(i + 1 < s.length() && s.charAt(i + 1) == 'C'){
                        converted+=90;
                        i++;
                    }
                    else{converted+=10;}
                    break;  
                case 'C':
                    if(i + 1 < s.length() && s.charAt(i + 1) == 'D'){
                        converted+=400;
                        i++;
                    }
                    else if(i + 1 < s.length() && s.charAt(i + 1) == 'M'){
                        converted+=900;
                        i++;
                    }
                    else{converted+=100;}
                    break;    
            }
        }

        return converted;
    }
        
}
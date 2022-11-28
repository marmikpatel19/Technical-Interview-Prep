/* Question 1.3: URLify */

/*
 * Question: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

 /* Example
 * 
 * Input: "Mr John Smith    " ,  13
 * Output: "Mr%20John%20Smith"
 */

 /*
  * Assumptions
  * - strings with only space are not allowed
  * - strings that are already urlified can exist 
  */

/* Solution */

class URLifyA2 {
    // time: O(n) space: O(n)
    public static void urlify(char[] input, int trueLength){

        // no spaces edge case
        if(trueLength == input.length){
            return;
        }

        int inputEndPointer = trueLength - 1;

        // iterate backwards through entire string
        for(int i = input.length - 1; i >= 0; i--){
            // current char is space
            if(input[inputEndPointer] == ' '){
                input[i] = '0';
                input[i - 1] = '2';
                input[i - 2] = '%';

                i = i - 2;
            }
            else{
                input[i] = input[inputEndPointer];
            }

            inputEndPointer--;
        }
    }

    public static void main(String[] args){

        String test = "Mr John Smith    ";
        char[] testArray = test.toCharArray();
        urlify(testArray, 13);
        System.out.println(testArray);
          
        String test2 = "Mr John  ";
        char[] test2Array = test2.toCharArray();
        urlify(test2Array, 7);
        System.out.println(test2Array);
        
        String test3 = "MrJohn";
        char[] test3Array = test3.toCharArray();
        urlify(test3Array, 6);
            System.out.println(test3Array);
    }
    
}
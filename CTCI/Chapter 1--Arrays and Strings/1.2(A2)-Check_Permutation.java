/* Question 1.2: Check Permutation */

/*
 * Question: Given two strings, write a method to decide if one is a 
 * permutation of the other.
 */

 /*
  * Assumptions
  * - empty strings true
  * - permutation -> rearrangement 
  * - not necessarily equal
  * - array lists allowed 
  * - upper/lower case different 
  */

  /*
   * Examples
   * abcd is a premutation of bacd
   */

/* Solution */

class CheckPermutationA2 {

    // time: space: O(n)

    public static Boolean checkPermutation(String inputOne, String inputTwo){
        if(inputOne.length() != inputTwo.length()){
            return false;
        }

        if(inputOne == ""){
            return true;
        }

        // convert strings into arrays
        char[] inputOneSorted = inputOne.toCharArray();
        char[] inputTwoSorted = inputTwo.toCharArray();

        // sorting
        java.util.Arrays.sort(inputOneSorted);
        java.util.Arrays.sort(inputTwoSorted);

        // comparison
        return java.util.Arrays.equals(inputOneSorted, inputTwoSorted);

    } 

    public static void main(String[] args){
        // permutation of the other
        if(!checkPermutation("hello", "eholl")){
            System.out.println("test one failed");
        }

        // not a permutation
        if(checkPermutation("hello", "ehell")){
            System.out.println("test one failed");
        }
    }
}
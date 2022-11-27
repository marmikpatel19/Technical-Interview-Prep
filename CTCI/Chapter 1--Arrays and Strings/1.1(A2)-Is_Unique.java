import java.util.HashMap;

/* Question 1.1: Is Unique */

/*
 * Question: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 */

 /* Assumptions
  *  - empty string, algorithm returns true
  *  - ASCII characters are allowed
  *  - capital and lower cases characters are different 
  */

  /* Examples:
   * 
   * "hello" => false
   * 
   * "brain" => true
   * 
   * "a" => true
   * 
   */

/* Solution */

class IsUniqueA2 {
    // time: O(n), space: O(n)

    public static Boolean isUnique(String s){
        HashMap<Character, Integer> uniqueChars = new HashMap<>();

        // Traversal
        for(int i = 0; i < s.length(); i++){
            if(uniqueChars.get(s.charAt(i)) == null){
                uniqueChars.put(s.charAt(i), 1);
            }
            else{
                return false;
            }
        }

        return true;
    } 

    public static void main(String[] args){
        // non-unique string
        if(isUnique("Hello")){
            System.out.println("test one failed");
        }

        // unique string
        if(!isUnique("Helo")){
            System.out.println("test two failed");
        }

        // single char string
        if(!isUnique("a")){
            System.out.println("test three failed");
        }

        // empty string
        if(!isUnique("")){
            System.out.println("test four failed");
        }

    }
}
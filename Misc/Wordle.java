/**
The word is exactly five letters long.

It must be English and only the alphabet – no punctuation, numbers or other symbols.

A guess yields clues:
- Letter X letter if the character and position in the word is correct.
- Letter Y  if the character is present in the word, but we chose the wrong position.
- Letter Z if the character is not in the world at all.

Ex: If the Wordle is (Hard coded inside a function) PIZZA
If someone guesses PLAZA
Then the encoded output is XZYXX

Assignment: Write a function the takes a str guess as an input, and outputs the "Encoded" str.
This is the EASY. The MEDIUM version of this problem is to write the Function in O(n) time complexity. Hard is such that the number of characters is consist. e.g., in medium, the above example would output "XZYXX" 
but the hard outputs "XZYXZ" because the A is already used up
Assume the guess is always a 5 alphabet letter and in Caps. (The Wordle game has this as a restriction)
*/

public static void main(String[] args) {
    System.out.println("wordleHard(\"PIZZA\", \"PLAZA\") should output \"XZYXZ\": " + wordleHard("PIZZA", "PLAZA")); 
    System.out.println("wordleHard(\"RIOTS\", \"ERROR\") should output \"ZYZYZ\": " + wordleHard("RIOTS", "ERROR")); 
}

/**
Use a hashmap that maps characters to their frequency. Iterate through both strings. At each index 
check if the characters match. If so, decrement that hashmap value for that char and add an X. If not,
check if the hashmap value for that char has freq > 0; if so, decrement it and add a Y. If not,
add a Z. 
*/

// time: O(n), space: O(n)
public static String wordleHard(String word, String guess) {
    int n = word.length();
    HashMap<Character, Integer> charToFreq = new HashMap<>();
    StringBuilder res = new StringBuilder();
    
    for(int i = 0; i < n; i++){
        char c = word.charAt(i);
        charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
    }
    
    for(int i = 0; i < n; i++){
        char currGuess = guess.charAt(i);
        char currWord = word.charAt(i);
        
        if(currGuess == currWord && charToFreq.containsKey(currGuess) && charToFreq.get(currGuess) > 0){
            res.append('X');
            charToFreq.put(currGuess, charToFreq.get(currGuess) - 1);
        }
        else if(charToFreq.containsKey(currGuess) && charToFreq.get(currGuess) > 0){
            res.append('Y');
            charToFreq.put(currGuess, charToFreq.get(currGuess) - 1);
        }
        else{
            res.append('Z');
        }
    }
    
    return res.toString();
}

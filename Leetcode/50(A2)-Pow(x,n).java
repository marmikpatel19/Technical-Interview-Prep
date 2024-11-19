class Pow(x,n)A2 {
    /**
    clarifications
        - is x a double? we return a double?
        - can n be negative? 0? 
        - can x be psotiive, 0, negative 
    
    notes
        posotive n --> x * x n times
        negatibe n --> 1/x * x n times
        zero n --> return 1
        zero x --> retuern 0
        negative x --> same logic 

    approaches
        - seperate into these cases. for exponentiation
            use a sum and repeatedly multiply.
            T(N): O(n), S(N): O(1)

        - DP w memoization. 
            x^n = x^(n/2) * x^(n/2) => we can use this 
            property to memoize res to not calculate
            the same exponent twice. 
            
            We can use a hashmap to store n -> value.

            If n is odd, we just multply dp res w x

            To avoid interger overflow when dealding w
            Integer.MIN_VALUE (-n would be out of range),
            we use Long in the hashmap and the value of n,
            and when making n positive, we multiply by 
            -1L (-1 in long and not int)

            T: O(log(N), S: O(log(N))
    
        - binary exponentiation 
            we can use a while loop and div n by 2 each time.
            at the same time, we can multiply currentProduct by itself.
            if currentProduct is odd, multipy res with it.

            e.g., for x = 2, n = 6
                res = 1, currentproduct = 2, n = 6
                res = 1, currentproduct = 4, n = 3
                res = 4, currentproduct = 16, n = 1
                res = 32, currentproduct = 256, n = 0
                
            T: O(logn), space: O(1)
    tests
        - all positibe
        - n negative
        - n zero
        - x negative
        - x zero
        - n is 1
        - n even vs odd
     */
    public double myPow(double x, int n) {
        boolean isNNegative = false;
        long absN = n;
        if(n < 0){
            isNNegative = true;
            absN = n * -1L;
        }

        double res = 1.0;
        double currentPower = x;
        while(absN > 0){
            if(absN % 2 == 1){
                res *= currentPower;
            }
            absN/=2;
            currentPower *= currentPower;
        }

        if(isNNegative){return 1 / res;}
        return res;
    }
}
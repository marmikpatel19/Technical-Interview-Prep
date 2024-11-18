class Pow(x,n) {
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
        HashMap<Long, Double> memo = new HashMap<>();

        double res = dp(x, absN, memo);
        if(isNNegative){return 1 / res;}
        return res;
    }

    private double dp(double x, long n, HashMap<Long, Double> memo){
        // base cases
        if(memo.containsKey(n)){return memo.get(n);}
        if(n == 0){return 1;}
        if(n == 1){return x;}

        // dp
        double half = dp(x, n / 2, memo);
        double res = half * half;
        if(n % 2 == 1){res *= x;}
        memo.put(n, res);
        return res;   
    }       
}
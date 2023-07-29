class SumofTwoIntegers {
    /*
     * Bitwise manipulation.
     * 
     * We can repeatedly do ^ (xor) and & << 1 until the second number in the
     * addition is 0. the ^ will add all the numbers without carry. The & << 1 will
     * add the carry and shift it left by one.
     * 
     * e.g.,
     * 1001
     * 1011
     * 
     * .....^: 00010
     * & << 1: 10010
     * 
     * .....^: 010000
     * & << 1: 000100
     * 
     * .....^: 010100
     * & << 1: 0000000
     * 
     * = 010100
     */

    // time: O(1), space: O(1)
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }

        return a;
    }
}

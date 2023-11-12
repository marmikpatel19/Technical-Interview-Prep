class ReverseInteger {
    /**
    We can iterate digit-by-digit by following the two mechanisms, irrespective of the sign:
    - To grab the digit at the 10's place, % by 10. To remove that place, / by 10.
    - To add a place, * 10. To add a digit to the 10's place, + by that digit.

    Determining if the reversed int is > the max integer value or < the min integer value 
    can be done by comparing the reversed int to the max/min value without the last place
    and then comparing the last place. Essentially, we are checking if the number is >< 
    Max/Min, just before the number is computed as it cannot be stored in an int.

    2^31 - 1 = 2147483647
     e.g., 2147483648 would fail becuase 8 > 7. 
     e.g.,  9999999990 would fail beause 999999999 > 214748364.
     */
    // time: O(n), space: O(1)
    public int reverse(int x) {
        int reverse = 0;

        while(x != 0){
            int dig = x % 10;
            x /= 10;

            if(reverse > Integer.MAX_VALUE / 10){return 0;}
            else if(reverse == Integer.MAX_VALUE / 10 && dig > Integer.MAX_VALUE % 10){return 0;}
            if(reverse < Integer.MIN_VALUE / 10){return 0;}
            else if(reverse == Integer.MIN_VALUE / 10 && dig < Integer.MIN_VALUE % 10){return 0;}

            reverse *= 10;
            reverse += dig;
        }

        return reverse;
    }
}
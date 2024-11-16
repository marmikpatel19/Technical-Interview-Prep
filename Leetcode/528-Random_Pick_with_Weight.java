class RandomPickwithWeight {
    /**
    Clarifications
        - pickIndex must retunr a valid index
        - can we have an empty array, so what does pickIndex return? no
        - not adding/deleting elements 
        - is it positive nums or negative too? 

    approaches
        - build array where each weight has that many elements in the array
            - S: O(sum_weight) -> very large space
        - we could simplify ^ by storing a cumulative sum, where
            the difference between current - prev represents the num.
            e.g., for [1,3,4] we store [1,4,7].
            we do .random in this and return the index that it falls 
            into.
            - T: O(n) for each pickIndex() due to a linear search required.
        - we can do same as ^ but b/c all the nums are positive, the 
            cumulative sum will be positive so we can can do binary search
            to bring it down to O(logn). 

            w = [1, 2, 4]
            s = [1, 3, 7]
            We run .random on (1,7). if we get a number, like 3, we return that
            index. if we get a number between two indicies, we retunr the upper
            index. so, if we get 5, we return 7, because 4 (original array) is
            the season that we have all the numbers from 4-7. 

            given a random number, we need to find the index that it belongs to.
            so, we use BS. if the num > curr, l = mid + 1. if it's < curr, 
            r = mid. we don't do mid - 1 b/c we do not have the third case where
            cur == mid; this is b/c we cannot garauntee that the num is in
            the array (it probably isn't). at the end, when the loop breaks due
            to l > r, we return that value at l b/c the larger of two indicies
            represent a num in the middle. 

            consturctore: T: O(n), S: O(n)
            pickIndex: T: O(logn), S: O(1)

            generating the random number is actually tricky. let's say we have
            [2, 3, 5], which would produce a cumulativeSum array of [2, 5, 10].
            The 2 at the beginning represetns 2/10 chance -> we want to include
            1 and 2 as a part of it but not 0. 3, 4, and 5 represent 4's chance.
            6 7 8 9 and 10 represent 5's chance. In other words, we want to 
            generate between 1 and cumulative sum, inclusive. random.nextInt()
            has exclusive upperbound and inclusive lowerbound. so, we can do
            random.nextInt(1, cumulativeSum[cumulativeSum.length - 1] + 1)

            The BS we'd want to use r as exclusive

    tests
        - single element
        - random value between nums
        - random value between 0 and first num
        - random value is a number

    */
    class Solution {
        int[] cumulativeSum;
        Random random; 

        public Solution(int[] w) {
            cumulativeSum = new int[w.length];
            int sum = 0;

            for(int i = 0; i < w.length; i++){
                sum += w[i];
                cumulativeSum[i] = sum;
            }

            random = new Random();
        }
        
        // run .random on 0 - cumulative sum
        public int pickIndex() {
            int randomValue = random.nextInt(1, cumulativeSum[cumulativeSum.length - 1] + 1); // see above note

            // BS to find the corresponding index
            int l = 0;
            int r = cumulativeSum.length; // r is exclusive so we don't do -1

            while(l < r){
                int mid = (l + r) / 2;
                if(randomValue > cumulativeSum[mid]){
                    l = mid + 1;
                }else{
                    r = mid; 
                }
            }
            return l;
        }
    }
}
class TwoSumA4 {
    /**
    Clarifications
        - is there only one solution or if there's multiple can we return any of them?
        - can we use a given element twice or does it have to be two diff nums?
            - are all the numbers unique or can there be repeittions and that's fine?
        - garwunteed to have a solution or handle no solution
        - can a single number just be the target or is must be two nums?
        - min number of nums? --> 2
        - returen indicies in any order? --> yes
    
    approaches
        - iterate the array with a nested loop and check each combintation.
            if they match, return that. 
            T(N): O(N^2), S(N): O(1)

        - hashmap: num -> list of indidies. 
            T(N): O(N), space: O(N)

        - hashmap: num -> index
            we can store just the last-most found index. this works because
            if target==nums[i]*2, then we come across first num first and the
            map will store latter num. we can do a !=i check to ensure that
            it's not the same number. 

            single pass. we can check before we put in the number. this 
            prevents duplicates. 
    
    tests
        - regular: [2, 3, 1, 4] , 7
        - duplicate [2, 2, 4, 1] , 4            
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(numToIndex.containsKey(target - nums[i]) &&
            numToIndex.get(target - nums[i]) != i){
                int[] res = new int[2];
                res[0] = i;
                res[1] = numToIndex.get(target - nums[i]);
                return res;
            }
            numToIndex.put(nums[i], i);
        }

        return new int[2];
    }
}
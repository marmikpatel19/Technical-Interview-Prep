/**
clarifciations
    - both vectors are the same lenght
    - empty vectors? --> at least size one
    - what are we given in constructo --> full vectro array? 

approaches
    - store interanl vectore as just default array .
        during multiplication, multiple both fully
        T(N): O(N), S(N): O(N)
    - store the the indicies->value 
        of non-zero elemements in a hashset. 
        during dotProduct(), we check which indicies aling
        betwene thw two vectors and multiple and store that. 
        T(N): O(N) for iterating through nums,
            O(number of non-zero elements in V1 + number of \
            non-zero elements in V2) 
        S(N): O(number of non-zero elements)

tests
    - regular
    - single element 
 */

 class SparseVector {
    HashMap<Integer, Integer> indxToVal;
    
    SparseVector(int[] nums) {
        indxToVal = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                indxToVal.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int index : indxToVal.keySet()){
            if(vec.indxToVal.containsKey(index)){
                sum += vec.indxToVal.get(index) * indxToVal.get(index);
            }
        }

        return sum;
    }
}
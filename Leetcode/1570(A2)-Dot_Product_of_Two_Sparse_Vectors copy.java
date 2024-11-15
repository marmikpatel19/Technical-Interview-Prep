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
    
        *hashmap can be inefficent (our assumption that it's 
        effivcient O(1) is not always correct irl). so in that
        scenario, this approach would be inefficent. 
    
    - Tuple solution
        store index-value Tuples for non-zero values, instead of 
        key-value pairs in the hashmap. stores into in an array.
        Do a two-pointer array traversal where we find same
        indicies for dot product.
        T(N): O(N+M), S(N): O(N+M)

tests
    - regular
    - single element 
 */

 public class Tuple{
    int index;
    int value;

    public Tuple(int index, int value){
        this.index = index;
        this.value = value;
    }
}

class SparseVector {
    ArrayList<Tuple> nonZeroValues;
    
    SparseVector(int[] nums) {
        nonZeroValues = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                Tuple t = new Tuple(i, nums[i]);
                nonZeroValues.add(t);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        int p1 = 0;
        int p2 = 0;
        int n = nonZeroValues.size();
        int m = vec.nonZeroValues.size();

        while(p1 < n && p2 < m){
            if(nonZeroValues.get(p1).index == vec.nonZeroValues.get(p2).index){
                sum += nonZeroValues.get(p1).value * vec.nonZeroValues.get(p2).value;
                p1++;
                p2++;
            }
            else if(nonZeroValues.get(p1).index < vec.nonZeroValues.get(p2).index){
                p1++;
            }else{
                p2++;
            }
        }

        return sum;
    }
}
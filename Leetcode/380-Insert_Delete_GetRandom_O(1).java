class InsertDeleteGetRandomO(1){
    /**
    Clarifications
        - no duplicates
            - so dont insert if not exist right
        - for getRandom, can I gaurantee that at least one 
            element exists?
        - can use Java Random class? 
        - is the O(1) average? 
        - just storing ints? 

    approaches
        (we can do Random() on index from 0 to size of set => we need O(1)
        get as well as indicies)

        - using HashSet is O(1) average for add and remove, but 
            there is not get method, so we must use an iterator. 
        - using ArrayList is O(1) average for add, O(n) average 
            for remove, and O(1) average for get. 

            remove is O(n) due to reorganization of the list. 
            but if we remove the last element, then the 
            complexity is O(1). 

            So, we can implement remove such that we swap the 
            element we want to delete with the last element
            (which is O(1)) and then delete the last 
            element. 

            However, even if .get() is O(1), we need the index
            of the element, for which .indexOf() is still O(n)
            due to traversal to find the element. 

            So, we can use a HashMap<num, index> to get the index.
            for which containsKey(), put(), get(), and remove() are all O(1). 
            We would need to do .set() to update the value at 
            that given index during the swap, but ArrayList
            .set() is also O(1)

    tests
        - regular
        - test adding or removing false
        - test random
    */
    class RandomizedSet {
        ArrayList<Integer> values;
        HashMap<Integer, Integer> valueToIndex;
        Random random;

        public RandomizedSet() {
            values = new ArrayList<>();
            valueToIndex = new HashMap<>();
            random = new Random();
        }
        
        public boolean insert(int val) {
            if(valueToIndex.containsKey(val)){ // O(1)
                return false;
            }
            values.add(val); // adds to end -> O(1)
            valueToIndex.put(val, values.size() - 1); // .put O(1), .size() O(1)
            return true;
        }
        
        public boolean remove(int val) {
            if(!valueToIndex.containsKey(val)){ // O(1)
                return false;
            }

            int lastIdx = values.size() - 1;
            int idx = valueToIndex.get(val); // O(1)
            values.set(idx, values.get(lastIdx)); // O(1)
            valueToIndex.put(values.get(lastIdx), idx); // O(1)
            values.set(lastIdx, val); // O(1)
            values.remove(lastIdx); // O(1) due to lastr element
            valueToIndex.remove(val); // O(1)
            return true;
        }
        
        public int getRandom() {
            int randomIdx = random.nextInt(values.size());

            return values.get(randomIdx); // O(1)
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
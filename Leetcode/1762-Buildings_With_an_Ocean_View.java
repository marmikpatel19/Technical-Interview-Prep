class BuildingsWithanOceanView {
    /**
    Claraifciations
        - can height be 0? not negatie tight?
        - same hight on right measn not ocean view?

    approaches
        - brute force: 
            iterate thought he array. for each check
            if ocean view
            O: N(^2)

        - one pass
            iterate from the right side. keep track of 
            largest. if curr > largest, add it and 
            update largest. 

            T: O(n), S: O(n)--arraylist (java issue otherwise O(1))
    tests
        - regular
        - all sorted
        - all reverse
        - signle
     */


     /**
        heights: [3] => [3]
        i = 3
        maxHeight: 5
        oceanViewIndicies: [3, 2, 1]
        res: [1, 2, 3]
    

      */
      public int[] findBuildings(int[] heights) {
        ArrayList<Integer> oceanViewIndicies = new ArrayList<>();
        int maxHeight = 0;

        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > maxHeight){
                oceanViewIndicies.add(i);
                maxHeight = heights[i];
            }
        }

        int[] res = new int[oceanViewIndicies.size()];
        for(int i = oceanViewIndicies.size() - 1; i >= 0; i--){
            res[oceanViewIndicies.size() - i - 1] = oceanViewIndicies.get(i);
        }
        return res;
    }
}
class NestedListWeightSum {
    /**
    Clarifications:
        - empty list? --> must have one
        - how do we access this nestedlist structue? 
            List. each value is a nestedInteger, which may be a list or an int,
            which we can check using isInteger()
        - can we garuentee that there's at least one list? so we can't just
            have an int like 5 it must be [5].

    approaches
        - brute: iterate thgrough the array, for each element, count the depth it has
            -- for each element start from the start and count the numnbr of 
            nesting.
            O(n^2), space: O(1)
        - DFS use a variable to keep track of number of current lists. += if entering a list
            and -= if exiting.

            loop through main list: helper funciton with list
                if not an integer, .getList(), recurse w depth +=
                when exiting, depth is now as before.

                sum mutable int to keep tracdk of the sum. 

            T(N): O(N), S(N): O(max_depth) 

        - coudl also use BFS where we iterate throuhg all elements in the queue during
            an interation, and add all nestedlists to the queue for the next loop.

            BFS is preferred if the depth is large to avoid stackoverflow 

    tests
        - regular 
        - single element tree

    */

    public int depthSum(List<NestedInteger> nestedList) {
        return exploreList(nestedList, 1);
    }

    private int exploreList(List<NestedInteger> nestedList, int currDepth){
        int sum = 0;

        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * currDepth;
            }else{
                sum += exploreList(ni.getList(), currDepth + 1);
            }
        }

        return sum;
    } 
}
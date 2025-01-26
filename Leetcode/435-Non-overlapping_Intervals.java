class Non-overlappingIntervals {
    /**
    clarifications:
        - end and start same not overlapp right
        - can there be zero? 
        - gauranteed start < end for a given interval
    
    approaches
        - brute force: every combination and see if there are overlaps. n!
        - sort intervals. iterate through checking if start of next >= 
            end of prev. if not, numOverlapping++ and skip that number

            however! we want *minimize*. So this is greedy. there can be 
            multiple overlaps, but we want to delete the largest overlap,
            so as to minimize. 

            to do this, we sort by end time in order to capture and erase 
            the largest end time. this put the latter end time intervals--
            the ones we want to delete--at the latter parts of the array,
            so we only delete them at the end.

            e.g., 
                [[1, 10], [2, 3], [3, 4], [5, 6]]
                sort by start: [[1, 10], [2, 3], [3, 4], [5, 6]]
                    we would delete the last three
                sort by end: [[2, 3], [3, 4], [5, 6], [1, 10]]
                    we would only delete the end one
     */
    
    // time: (nlogn), space: O(logn)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (A, B) -> {
            return Integer.compare(A[1], B[1]);
        });

        int numOverlapping = 0;
        int prevEnd = Integer.MIN_VALUE; 
        for(int[] interval : intervals){
            if(interval[0] < prevEnd){
                numOverlapping++;
            }else{
                prevEnd = interval[1];
            }
        }

        return numOverlapping;
    }
}
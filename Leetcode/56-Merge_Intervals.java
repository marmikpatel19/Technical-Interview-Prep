class MergeIntervals {
    // time: O(nlog(n)), space: O(1)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            Integer.compare(a[0], b[0])
        );

        // count number of final intervals
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 1;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]); 
            }else{
                count++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int[][] mergedIntervals = new int[count][2];

        // merge intervals
        start = intervals[0][0];
        end = intervals[0][1];
        mergedIntervals[0][0] = start;
        mergedIntervals[0][1] = end;
        int j = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                mergedIntervals[j][1] = Math.max(end, intervals[i][1]); 
                end = Math.max(end, intervals[i][1]); 
            }else{
                j++;
                start = intervals[i][0];
                end = intervals[i][1];
                mergedIntervals[j][0] = start;
                mergedIntervals[j][1] = end;
            }
        }

        return mergedIntervals;
    }
}
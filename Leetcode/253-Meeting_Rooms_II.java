class MeetingRoomsII {
    /**
    The solution comes out of a trick: we can determine number of required
    rooms by determining at any given time the number of meetings that are
    ongoing. If two meetings have begin but only but none have ended, then
    there must be two ongoing meetings (two rooms required).

    We can determine this by splitting the intervals into start times and end
    times and sorting both arrays. Then, we can use a two-pointer approach to
    traverse both arrays by sequential times. We can use a variable to 
    determine the largest number of meetings started at a given time.
    */

    // time: O(nlog(n)), space: O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> startTimes = new ArrayList<Integer>();
        List<Integer> endTimes = new ArrayList<Integer>();
        for(Interval i : intervals){
            startTimes.add(i.start);
            endTimes.add(i.end);
        }

        java.util.Collections.sort(startTimes);
        java.util.Collections.sort(endTimes);

        int maxRoomsOpen = 0;
        int currentRoomsOpen = 0;
        int openPointer = 0;
        int endPointer = 0;

        while (openPointer < startTimes.size()){
            if(startTimes.get(openPointer) < endTimes.get(endPointer)){
                currentRoomsOpen++;
                maxRoomsOpen = Math.max(maxRoomsOpen, currentRoomsOpen);
                openPointer++;
            } else{ 
                currentRoomsOpen--;
                endPointer++;
            }
        }

        return maxRoomsOpen;
    }
}
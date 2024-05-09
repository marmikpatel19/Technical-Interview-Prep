class MeetingRoomsI {
    // time: O(nlog(n)), space: O(n)
    public boolean canAttendMeetings(List<Interval> intervals) {
        List<Integer> startTimes = new LinkedList<Integer>();
        List<Integer> endTimes = new LinkedList<Integer>();
        for(Interval i : intervals){
            startTimes.add(i.start);
            endTimes.add(i.end);
        }
        java.util.Collections.sort(startTimes);
        java.util.Collections.sort(endTimes);

        int startPointer = 0;
        int endPointer = 0;
        int currentActiveMeetings = 0;

        while(startPointer < startTimes.size()){
            if(startTimes.get(startPointer) < endTimes.get(endPointer)){
                startPointer++;
                currentActiveMeetings++;
            }
            else{
                endPointer++;
                currentActiveMeetings--;
            }

            if(currentActiveMeetings > 1){
                return false;
            }
        }

        return true;
    }
}
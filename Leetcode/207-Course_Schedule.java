import java.util.HashMap;

class CourseSchedule {
    /* Graph problem. Each item in the prequisites array is an edge and each course
    is a node. 

    We use an adjacency list to store prerequisites for each course. 

    Go DFS for each course in the adjacency list. Base case is a course with no
    preqs. Wehn backtracking up the recursion, if a course is "valid" (had preqs),
    then update that preq list to be an empty array so as to get O(1) search the 
    following time that number is hit. Use a currentCoursesVisited list to 
    check for a cycle, in which case we return false. If we traverse the whole 
    adjacency list, return true. 
    */

    // time: O(n + P) (n = courses (nodes), P = preqs (edges)), space: O(n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adjacency list
        HashMap<Integer, ArrayList<Integer>> courseToPreqs = new HashMap<>();
        for(int[] preq : prerequisites){
            ArrayList<Integer> temp;
            if(courseToPreqs.get(preq[0]) != null){temp = courseToPreqs.get(preq[0]);} 
            else{temp = new ArrayList<>();}
            temp.add(preq[1]);
            courseToPreqs.put(preq[0], temp);
        }

        for(Integer course : courseToPreqs.keySet()){
            Set<Integer> currCourses = new HashSet<>();
            if(!dfs(course, currCourses, courseToPreqs)){return false;}
        }

        return true;
    }

    private boolean dfs(Integer currCourse, Set<Integer> currCourses, HashMap<Integer, ArrayList<Integer>> courseToPreqs){
        if(currCourses.contains(currCourse)){return false;}
        if(courseToPreqs.get(currCourse) == null || courseToPreqs.get(currCourse).isEmpty()){return true;}
        currCourses.add(currCourse);

        for(Integer course : courseToPreqs.get(currCourse)){
            if(!dfs(course, currCourses, courseToPreqs)){return false;} 
        }

        courseToPreqs.put(currCourse, new ArrayList<Integer>());
        currCourses.remove(currCourse);

        return true; 
    }
}
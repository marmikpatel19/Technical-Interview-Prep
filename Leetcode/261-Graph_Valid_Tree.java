
class GraphValidTree {
    /**
    clarification:
        Valid tree: no cycles + connected
        empty tree?
        is n valid? 
        nodes are lablled 0-n-1? garuanteed?
        valid tree must have exactly n-1 edges
    
    edge cases:
       - a valid tree must have exactly n-1 edges
       - a valid tree can have a single node and no edges

    create adjacency list. add both edges! so (0-1) means two entries:
        0:1 and 1:0

    conduct DFS with a visited set for cycle detection and prev for 
    not mistaking parent as cycle.
        if we hit a visited node -> cycle -> return false
        to not mistake the parent as a cycle, we need to 
        not recurse if the previous node is the neighbour of
        the current node. 

    if at the end num nodes visited < n, return false (disconnected graph)
    
    return true
    */

    // time: O(V + E), space: O(V + E)
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0){return true;}
        if(edges.length != n - 1){return false;}

        // contruct adjacency list 
        HashMap<Integer, ArrayList<Integer>> edgesMap = new HashMap<>();
        for(int[] edge : edges){
            if(edgesMap.containsKey(edge[0])){
                edgesMap.get(edge[0]).add(edge[1]);
            }else{
                ArrayList<Integer> val = new ArrayList<>();
                val.add(edge[1]);
                edgesMap.put(edge[0], val);
            }

            if(edgesMap.containsKey(edge[1])){
                edgesMap.get(edge[1]).add(edge[0]);
            }else{
                ArrayList<Integer> val = new ArrayList<>();
                val.add(edge[0]);
                edgesMap.put(edge[1], val);
            }
        }

        // dfs
        HashSet<Integer> visited = new HashSet<>();
        if(!dfs(edgesMap, visited, 0, -1)){return false;}

        return visited.size() == n;
    }

    private boolean dfs(HashMap<Integer, ArrayList<Integer>> edgesMap, 
    HashSet<Integer> visited, int curr, int prev){
        // base case
        if(visited.contains(curr)){return false;}
        visited.add(curr);
        
        for(Integer neighbour : edgesMap.get(curr)){
            if(neighbour == prev){continue;}
            if(!dfs(edgesMap, visited, neighbour, curr)){
                return false;
            }
        }

        return true;
    }
}
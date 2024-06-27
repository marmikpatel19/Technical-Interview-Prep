class NumberofConnectedComponentsinanUndirectedGraph {
    /**
    Create adjacency list and then dfs

    adjacency list must be created from nodes 
    b/c there can be nodes w/o edges.
    */

    // time: O(V + E), space: O(V + E)
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int numComponents = 0;

        // initialize adjacency list
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // dfs
        HashSet<Integer> visited = new HashSet<>();
        for(Integer n1 : adj.keySet()){
            if(!visited.contains(n1)){
                dfs(n1, visited, adj);
                numComponents++;
            }            
        }

        return numComponents;
    }

    private void dfs(Integer n, HashSet<Integer> visited, 
    HashMap<Integer, ArrayList<Integer>> adj){
        visited.add(n);

        for(Integer n2 : adj.get(n)){
            if(!visited.contains(n2)){
                dfs(n2, visited, adj);
            }
        }
    }
}
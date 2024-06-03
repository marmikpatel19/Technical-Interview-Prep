class Alien Dictionary {
    /**
    Topological sort.
        Letters can be see as nodes with the alphabet as the graph. When a letter 
        comes before another, a directed edge can be made (e.g., if a comes before b,
        then a-->b). This is acyclic because alphabets are ordered and letters are 
        unique. 

    Iterate through each *pair* of words. Find the first *differing* character
    to compare and create a edge with two nodes and insert it into the
    graph. Check if either of the nodes already exist in the graph; if so, 
    create the remainign nodes and edges, but do not create duplicates. 
    If all characters are the same or we run out it chars one one string, 
    then there is no comparison--nothing to input. 
        e.g, [wrt, wrf, er, ett, rftt]
        compare wrt with wrf. first differing char is t and f. create node
            t --> f
        compare wrf, er. We now have: w->e , t->f
        compare er, ett. We now have: w->e, r->t->f (we added node r with
            connection to t since t already exists)
        compare ett,rftt. We now have w->e->r->t->f (e and r both exist
            to add an edge)

    Topological sort is then conducted using post-order DFS. See interview 
    notes for why this has to be done. At the end, we obtain a reversed
    ordering, so we need to reverse it to get the correctly-sorted output. 

    Loop detection: use currentVisiting to check if the current c has been 
    used.

    Implementation
        A HashMap that maps each char to a set of its connections is used
        to represent the graph. A Visited set is used that's initially
        empty. Set is used s to prevent duplicate dfs calls.

    no real solution (cycle, one word inside another) => invalid string, return ""
    multiple unconnected graphs => multiple solutions, return any of them
    */

    // time: O(nm), space: O(m^2) (n = number of words, m = length of word)
    public String foreignDictionary(String[] words) {
        // edge cases
        if(words.length == 1 && words[0].length() == 1){return words[0];}
        if(words.length == 1){return "";}

        HashMap<Character, Set<Character>> graph = new HashMap<>();

        // initialize graph with nodes
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                if(!graph.containsKey(word.charAt(i))){
                    graph.put(word.charAt(i), new HashSet<Character>());
                }
            }
        }

        // Initialize graph with edges, iterating using pairs
        for(int i = 0; i < words.length - 1; i++){
            String wordOne = words[i];
            String wordTwo = words[i + 1];
            int minLength = Math.min(wordOne.length(), wordTwo.length());
            boolean diffExists = false;

            // find the first differing character
            for(int j = 0; j < minLength; j++){
                if(wordOne.charAt(j) != wordTwo.charAt(j)){
                    Character one = wordOne.charAt(j);
                    Character two = wordTwo.charAt(j);

                    if(!graph.get(one).contains(two)){
                        Set<Character> updated = graph.get(one);
                        updated.add(two);
                        graph.put(one, updated);
                    }

                    diffExists = true;
                    break; // only get the *first* differing char
                }
            }

            // edge case where word two is a subword of word one => invalid
            // (word one can be a subword of word two since that's correctly 
            // alphabetical ordering)
            if(!diffExists && wordOne.length() > wordTwo.length()){return "";}
        }

        StringBuilder res = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        Set<Character> currentlyVisiting = new HashSet<>();

        // run dfs on all char to encapsulate disconnected graphs.
        // Using visited prevent reruns
        for(char c : graph.keySet()){
            if(!PostOrderDFS(c, res, visited, graph, 
                currentlyVisiting)){ // invalid 
                    return "";
                } 
        }

        return res.reverse().toString();
    }

    // boolean is used to indicate invalid graph
    private boolean PostOrderDFS(Character c, StringBuilder res, 
    Set<Character> visited, HashMap<Character, Set<Character>> graph, 
    Set<Character> currentlyVisiting){
        if(visited.contains(c)){return true;} // base case
        if(currentlyVisiting.contains(c)){return false;} // loop => invalid

        // recurse on all pointed nodes of current node
        currentlyVisiting.add(c);
        for(Character c2 : graph.get(c)){
            if(!PostOrderDFS(c2, res, visited, graph, currentlyVisiting)){
                return false;
            };
        }
        currentlyVisiting.remove(c);

        // visit current node (post-order)
        res.append(c);
        visited.add(c);

        return true;
    }
}
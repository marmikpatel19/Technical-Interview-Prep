class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    /**
    Clarifications
        - empty tree --> empty list
        - BST not regualr BT
        - list should be smallest to largest? 
        - are all the values unique? 
        - all the same types 
        - if single node --> link to itself? 

    approaches
        - DFS in-order traversal. build a new list.
            at the end, link the new list and return it.
            not in-place, so T: O(N), S: O(N)
        - DFS in-order traversal. 
            use global min and max variables. min represens the 
            lowest node in the tree, and can be updated after
            left dfs if it is null (this unsures that we hit
            the smallest element and then update min).

            max is updated as a part of the current node evaluation
            during in-order traversal. 

            processing left:
                - dfs call on root.left
                - update min if null
                - if max exsits (not the first element, link left
                with root.
            
            processing curr
                - max = curr
            
            processing right:
                - dfs call on root.right
                - nothing else. right's curr will process the max 
                and everything
            
            at the end, link min and max                

            T(N): O(N), S(N): O(H) (not counting return list)
    
    tests
        - regular
        - missing left, missing right
        - single node
        - no nodes
     */

     Node min = null;
     Node max = null; // curr node as we iterate w in-order dfs
 
     public Node treeToDoublyList(Node root) {
         if(root == null){return root;}
 
         dfs(root);
 
         // final link
         max.right = min;
         min.left = max;
         
         return min;
     }
 
     private void dfs(Node root){
         // base cases
         if(root == null){return;}
 
         // in-order: left, curr, right. after a given call, max is updated
         dfs(root.left);
         if(max != null){
             root.left = max;
             max.right = root;
         }
         if(min == null){min = root;} // ensures that this only gets updated once
 
         max = root; 
 
         dfs(root.right);
     }
}
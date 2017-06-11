package Graph;
import java.util.*;

/*
 * 310. Minimum Height Trees
 * 
 * Difficulty: $$$$
 * 
 * Description:
 *  For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. 
 *  Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). 
 *  Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *  
 *  Format
 *  The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 *  You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *  
 *  Example 1:
 *  Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *  		0
 *  	    |
 *      1
 *     / \
 *    2   3
 *  return [1]
 *  
 *  Example 2:
 *  Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *   0  1  2
 *    \ | /
 *      3
 *      |
 *      4
 *      |
 *      5
 * return [3, 4]
 * 
 * Note:
 * (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *  
 * */

public class MinHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        
        if(n == 1){
            res.add(0);
            return res;
        }
        
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                queue.offer(i);
                visited[i] = true;
                cnt++;
            }
        }
        
        while(cnt < n){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                for(int neighbor : graph.get(node)){
                    graph.get(neighbor).remove(node);
                    if(graph.get(neighbor).size() == 1){
                        queue.offer(neighbor);
                        cnt++;        
                    }
                }
            }
        }
        
        res.addAll(queue);
        return res;
    }
}

package graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        // This graph has 2 components: {0, 1, 2} and {3, 4}
        int components = countComponents(n, edges);
        System.out.println("Total Connected Components: " + components); // Output: 2
    }

    /**
     * Time: O(V + E), or in your variables O(n + edges.length)
     * Space: O(V + E) for adjacency list + visited + DFS recursion stack
     * @param n
     * @param edges
     * @return
     */
    public static int countComponents(int n, int[][] edges) {
        int count=0;
        // create an adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i=0; i< n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // build the graph
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visisted = new boolean[n];
        for (int i=0; i<n; i++) {
            if(!visisted[i]) {
                count++;
                dfs(i, adjacencyList, visisted);
            }
        }
        return count;
    }

    static void dfs(int node, List<List<Integer>> adjacencylist, boolean[] visited) {
        visited[node] = true;

        for (int neighbor: adjacencylist.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencylist, visited);
            }
        }
    }
}

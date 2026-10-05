package graphs;

import java.util.*;

public class FindShortestPath {

    public static void main(String[] args) {

    }

    /**
     * Finds the shortest path between two vertices in an unweighted graph using BFS.
     * Time Complexity of this BFS shortest-path algorithm is O(V+E)
     * Space Complexity is O(V)
     * @param graph  The graph represented as an adjacency list (Node -> List of Neighbors).
     * @param start  The starting vertex.
     * @param target The destination vertex.
     * @return A list of vertices from start to target representing the shortest path,
     *         or an empty list if no path exists.
     */
    public <T> List<T> findShortestPath(Map<T, List<T>> graph, T start, T target) {
        // Implementation goes here
        if (start != null && start.equals(target)) {
            return Collections.singletonList(start);
        }

        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        Map<T, T> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            T curNode = queue.poll();

            // If target is found, reconstruct and return the path
            if (curNode.equals(target)) {
                return reconstructPath(parentMap, start, target);
            }

            // Explore neighbors
            List<T> neighbors = graph.get(curNode);
            for (T neighbor: neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, curNode);
                    queue.add(neighbor);
                }
            }
        }
        return new ArrayList<>();
    }

    // Helper method to backtrack and build the path
    private <T> List<T> reconstructPath(Map<T, T> parentMap, T start, T target) {
        LinkedList<T> path = new LinkedList<>();
        T current = target;

        while (current != null && !current.equals(start)) {
            path.addFirst(current); // Prepend to avoid reversing later
            current = parentMap.get(current);
        }

        if (current != null) {
            path.addFirst(start);
        }

        return path;
    }
}

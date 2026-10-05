package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main() {
// Test Case 1: Valid Schedule
        int numCourses1 = 2;
        int[][] prereqs1 = {{1, 0}};
        System.out.println("Test 1 (Expected true): " + canFinish(numCourses1, prereqs1));

        // Test Case 2: Invalid Schedule (Cycle)
        int numCourses2 = 2;
        int[][] prereqs2 = {{1, 0}, {0, 1}};
        System.out.println("Test 2 (Expected false): " + canFinish(numCourses2, prereqs2));

        // Test Case 3: Complex Valid Schedule
        int numCourses3 = 4;
        int[][] prereqs3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Test 3 (Expected true): " + canFinish(numCourses3, prereqs3));
    }

    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize adjacency list and in-degree array
        List<List<Integer>> adjacenyList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i=0; i< numCourses; i++) {
            adjacenyList.add(new ArrayList<>());
        }

        // build the graph
        for (int[] edge: prerequisites) {
            int course = edge[0];
            int preRequisite = edge[1];
            adjacenyList.get(preRequisite).add(course);
            inDegree[course]++;
        }

       // Add all courses with 0 prerequisites to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the graph
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCourses++;

            // "Take" the course and reduce the in-degree of dependent courses
            for (int neighbor : adjacenyList.get(current)) {
                inDegree[neighbor]--;
                // If a neighbor has no more prerequisites, it's ready to be taken
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If we processed all courses, no cycle exists
        return processedCourses == numCourses;
    }
}

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new List[numCourses];
        int[] numParents = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            map[pair[1]].add(pair[0]);
            numParents[pair[0]]++;
        }

        Queue<Integer> parent = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (numParents[i] == 0) {
                parent.add(i);
                count++;
            }
        }

        while (!parent.isEmpty()) {
            int course = parent.remove();
            for (int i : map[course]) {
                numParents[i]--;
                if (numParents[i] == 0) {
                    parent.add(i);
                    count++;
                }
            }
        }
        return count == numCourses;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] finished = new int[numCourses];
        List<List<Integer>> map = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            map.get(pair[0]).add(pair[1]);
        }
        // meaning of numbers in the array "finished"
        // '0': waiting to be explored
        // '1': the course can be finished now
        // '2': the course is possible to be finished in the future
        for (int i = 0; i < numCourses; i++) {
            if (finished[i] == 0) {
                if (!dfs(i, finished, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int course, int[] finished, List<List<Integer>> map) {
        if (finished[course] == 2) {
            return false;
        }
        finished[course] = 2;
        for (int i : map.get(course)) {
            if (!dfs(i, finished, map)) {
                return false;
            }
        }
        finished[course] = 1;
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] p = {{2,0},{0,1}};
        Solution so = new Solution();
        System.out.println(so.canFinish1(n, p));
    }
}
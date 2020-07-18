class Solution {
    
    /**
    Runtime: 6 ms, faster than 62.68% of Java online submissions for Course Schedule II.
    Memory Usage: 40.1 MB, less than 94.21% of Java online submissions for Course Schedule II.
    */

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer>[] prerequisitesOfCourses = new Set[numCourses];
        Set<Integer>[] courseEnableOtherCourses = new Set[numCourses];
        
        for (int i=0; i<numCourses; i++) {
            prerequisitesOfCourses[i] = new HashSet<>();
            courseEnableOtherCourses[i] = new HashSet<>();
        }
        
        for (int[] prerequisite : prerequisites) {
            prerequisitesOfCourses[prerequisite[0]].add(prerequisite[1]);
            courseEnableOtherCourses[prerequisite[1]].add(prerequisite[0]);
        }
        
        int[] answer = new int[numCourses];
        int nextAnswerIndex = 0;
        
        Deque<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (prerequisitesOfCourses[i].size() == 0) {
                // the course i can be taken
                queue.addLast(i);
            }
        }
        
        //bfs        
        while (! queue.isEmpty()) {
            int courseToTake = queue.poll();
            
            answer[nextAnswerIndex] = courseToTake;
            nextAnswerIndex++;
            
            for ( int nextCourse : courseEnableOtherCourses[courseToTake] ) {
                prerequisitesOfCourses[nextCourse].remove(courseToTake);
                if (prerequisitesOfCourses[nextCourse].size() == 0) {
                    // the course i can be taken
                    queue.addLast(nextCourse);
                }
            }
        }
        
        if (nextAnswerIndex != numCourses) {
            // it is impossible to finish all courses
            return new int[0];
        }
        
        
        return answer;
    }
}
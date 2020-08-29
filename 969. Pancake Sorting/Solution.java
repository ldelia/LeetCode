class Solution {
    public List<Integer> pancakeSort(int[] A) {
    
        /**
        Runtime: 2 ms, faster than 52.64% of Java online submissions for Pancake Sorting.
        Memory Usage: 39.1 MB, less than 99.02% of Java online submissions for Pancake Sorting.
        */
        
        LinkedList<Integer> result = new LinkedList<>();
        
        for (int i=0; i<A.length; i++) {
            
            int currentLastIndex = A.length-1-i;
            
            // find the index of the max element in the subarray [0, len-i]
            int maxValueIndex = 0;
            for (int j=1; j<=currentLastIndex; j++) {
                if (A[j] > A[maxValueIndex]) {
                    maxValueIndex = j;
                }
            }
            
            if (maxValueIndex < currentLastIndex) {
                // the value is not at the end. We need to flip
                
                reverse(A, 0, maxValueIndex);
                result.add(maxValueIndex+1);

                reverse(A, 0, currentLastIndex);
                result.add(currentLastIndex+1);
                
                // Now, the max value of the subarray is at the end
            }
        }
        
        return result;
    }
    
    protected void reverse(int[] A, int from, int to) {
        
        for (int i=from; i<=((to-from)/2); i++) {
            int swap = A[i];
            A[i] = A[to-(i-from)];
            A[to-(i-from)] = swap;
        }
    }
    
}
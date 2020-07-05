class Solution {

/**
Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
Memory Usage: 38.1 MB, less than 6.82% of Java online submissions for Hamming Distance.
*/   
    public int hammingDistance(int x, int y) {
        
        int xor = x ^ y;
        
        int distance = 0;
        
        while ( xor > 0 ) {
            
            if ((xor >> 0 & 1) == 1) {
                distance++;
            }
            
            xor = xor >> 1;
        }
     
        return distance;
    }    
}
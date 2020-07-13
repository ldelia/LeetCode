public class Solution {
    
    /**
    Runtime: 1 ms, faster than 99.63% of Java online submissions for Reverse Bits.
    Memory Usage: 39.9 MB, less than 11.43% of Java online submissions for Reverse Bits.
    */
    
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int input = n;
        int output = 0;
        
        for (int i=0; i<32; i++) {
            
            output = output << 1;
            
            if ((input & 1) == 1) {
                output++;
            }
            
            input = input >> 1;
        }
        
        return output;
    }
}
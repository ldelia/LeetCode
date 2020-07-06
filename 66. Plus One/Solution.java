class Solution {
    
    /**
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
    Memory Usage: 37.5 MB, less than 98.13% of Java online submissions for Plus One.
    */
    public int[] plusOne(int[] digits) {
        
        int[] digitsPlusOne = digits.clone();

        int lastIndex = digits.length - 1;
        
        while (lastIndex >= 0) {
            
            if (digitsPlusOne[lastIndex] == 9) {
                digitsPlusOne[lastIndex] = 0;
                lastIndex--;
            } else {
                digitsPlusOne[lastIndex] = digits[lastIndex] + 1;
                return digitsPlusOne;
            }
        }
        
        digitsPlusOne = new int[ digitsPlusOne.length +1];
        digitsPlusOne[0] = 1;
        
        return digitsPlusOne;
    }
}
class Solution {

/**
Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
Memory Usage: 37.8 MB, less than 96.56% of Java online submissions for Excel Sheet Column Number.
*/

    public int titleToNumber(String s) {
        
        int number = (s.charAt(0) - 'A') + 1;
            
        for (int i=1; i<s.length(); i++){
            int offset = 26 * number;
            number = offset + (s.charAt(i) - 'A') + 1;
        }
        
        return number;
    }
}
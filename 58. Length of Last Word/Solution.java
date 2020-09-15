class Solution {

    /**
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
    Memory Usage: 37.2 MB, less than 98.32% of Java online submissions for Length of Last Word.
    */
    public int lengthOfLastWord(String s) {
        
        int lastIndex = s.length()-1;
        while (lastIndex>0 && s.charAt(lastIndex) == ' ') {
            lastIndex--;
        }
        
        int hi = lastIndex;
        while (hi>=0 && s.charAt(hi) != ' ') {
            hi--;
        }
        
        return lastIndex-hi;
    }
}

/**
Runtime: 1 ms, faster than 93.50% of Java online submissions for Decode Ways.
Memory Usage: 36.8 MB, less than 98.89% of Java online submissions for Decode Ways.
**/

class Solution {

    public int numDecodings(String s) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return numDecodings(s, 0, cache);
    }
    
    protected int numDecodings(String s, int from, HashMap<Integer, Integer> cache) {
        
        if (cache.containsKey(from)) return cache.get(from);
        if (s.length() < from ) return 0;
        if (s.length() == from ) return 1;
        
        int ans = 0;
        
        char c = s.charAt(from);
        
        if (c == '0') return ans;
        
        ans = numDecodings(s, from + 1, cache);
        
        if (c > '2' && c <= '9') return ans;
        
        if (c == '2' && s.length() > from+1 && s.charAt(from+1) > '6') return ans;
        
        ans = ans + numDecodings(s, from + 2, cache);
        
        cache.put(from, ans);
        
        return ans;
    }
}
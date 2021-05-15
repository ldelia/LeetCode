class Solution {

    /**
        Your runtime beats 26.89 % of java submissions.
        Your memory usage beats 68.44 % of java submissions.    
    */
    
    protected int getExponentialPosition(String s) {
        int ans = -1;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                return i;
            }
        }
        return -1;
    }
    
    protected int getDotPosition(String s, int from, int end) {
        int ans = -1;
        for (int i=from; i<=end; i++) {
            if (s.charAt(i) == '.') {
                return i;
            }
        }
        return -1;
    }    
    
    protected boolean isDecimalNumber(String s) {
        return isDecimalNumber(s, 0, s.length() - 1);
    }
    
    protected boolean isInteger(String s, boolean allowSign) {
        return isInteger(s, 0, s.length() - 1, allowSign);
    }
    
    protected boolean isInteger(String s, int from, int end, boolean allowSign) {
        if (from > end) return false;
        
        int f = from;
        if (s.charAt(f) == '+' || s.charAt(f) == '-') {
            if (! allowSign) return false;
            f++;
        }
        
        if (f > end) return false;
        
        for (int i=f; i<=end; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        
        return true;
    }    
    
    protected boolean isDecimalNumber(String s, int from, int end) {
        
        int f = from;
        
        if (f > end) return false;
        
        char initial = s.charAt(f);
        if (initial == '+' || initial == '-') {
            f++;
            if (f > end) return false;
            initial = s.charAt(f);
        }
        
        if (initial == '.') {
            return isInteger(s, f+1, end, false);
        }
        
        int dotPosition = getDotPosition(s, f, end);       
        if (dotPosition == -1) {
            return false;
        }
        
        if (! isInteger(s, f, dotPosition-1, false)) return false;
        
        if (dotPosition == end) return true;
        
        return isInteger(s, dotPosition+1, end, false);
    }    
    
    public boolean isNumber(String s) {
      
        int ePosition = getExponentialPosition(s);
        
        if (ePosition == -1) {
            if (isInteger(s, true) || isDecimalNumber(s)) {
                return true;
            }
        } else {
            if (
                (isInteger(s, 0, ePosition-1, true) || isDecimalNumber(s, 0, ePosition-1)) 
                && 
                (isInteger(s, ePosition+1, s.length()-1, true))
            ){
                return true;
            }
        }
        
        return false;
    }
}
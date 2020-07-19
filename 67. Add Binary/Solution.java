class Solution {
 
    /**
    Runtime: 2 ms, faster than 82.21% of Java online submissions for Add Binary.
    Memory Usage: 39.5 MB, less than 30.77% of Java online submissions for Add Binary.
    */
    public String addBinary(String a, String b) {
        
        int aLength = a.length()-1;
        int bLength = b.length()-1;
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        
        while (aLength >= 0 || bLength >= 0) {
            int sum = carry;
            if (aLength >=0 && a.charAt(aLength) == '1') {
                sum++;
            }
            if (bLength >=0 && b.charAt(bLength) == '1') {
                sum++;
            }
            if (sum==0 || sum==1) {
                sb.insert(0, sum);
                carry = 0;
            } else if (sum==3) {
                sb.insert(0, 1);
            }else {
                // carry
                sb.insert(0, 0);
                carry = 1;
            }
            aLength--;
            bLength--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        
        return sb.toString();
    }
}
class Solution {
    public String getHint(String secret, String guess) {
        
        /**
        Runtime: 1 ms, faster than 100.00% of Java online submissions for Bulls and Cows.
        Memory Usage: 38 MB, less than 98.54% of Java online submissions for Bulls and Cows.
        */
        
        int len = secret.length();
        
        int bulls = 0;
        int cows = 0;
        
        int[] notMatchedInSecret = new int[10];
        int[] notMatchedInGuess = new int[10];
        
        for (int i=0; i<len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                notMatchedInSecret[secret.charAt(i) - '0']++;
                notMatchedInGuess[guess.charAt(i) - '0']++;
            }
        }
        
        for (int i=0; i<10; i++) {
            cows += Math.min(notMatchedInSecret[i], notMatchedInGuess[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}
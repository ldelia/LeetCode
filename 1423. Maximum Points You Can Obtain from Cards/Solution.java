class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int currentSum = 0;        
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            currentSum += cardPoints[i];
        }
        
        if (cardPoints.length == k) return currentSum;
        
        int maxSum = currentSum;        
        
        for (int i = 0; i < k; i++) {
            int removeIndex = (cardPoints.length + (i-k)) % cardPoints.length; 
            currentSum -= cardPoints[removeIndex];
            currentSum += cardPoints[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

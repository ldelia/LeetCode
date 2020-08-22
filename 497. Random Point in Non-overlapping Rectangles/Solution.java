class Solution {

    private int sum;
    private int[][] rects;
    private TreeMap<Integer, Integer> distribution;
    private Random random;
    
    public Solution(int[][] rects) {
        
        this.rects = rects;
        this.random = new Random();
        this.distribution = new TreeMap<>();
        
        this.sum = 0;
        
        for (int i = 0; i<rects.length; i++) {
            
            int a = area(rects[i]);
            this.sum += a;

            distribution.put(this.sum, i);
        }
    }
    
    protected int area(int[] r) {
        
        int width = getWidth(r);
        int height = getHeight(r);
        
        return width * height;
    }
    
    protected int getWidth(int[] r) {
        return Math.abs(r[2] - r[0]) + 1;
    }
    
    protected int getHeight(int[] r) {
        return Math.abs(r[3] - r[1]) + 1;
    }
    
    public int[] pick() {
        
        int r = random.nextInt(this.sum + 1);        
        int key = distribution.ceilingKey(r);
        
        int[] rect = rects[distribution.get(key)];
        
        int width = getWidth(rect);
        int height = getHeight(rect);
        
        int rw = rect[0] + random.nextInt(width);
        int rh = rect[1] + random.nextInt(height);
        
        return new int[]{rw, rh};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
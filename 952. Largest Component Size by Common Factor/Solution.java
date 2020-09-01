class Solution {
    public int largestComponentSize(int[] A) {
        
        HashMap<Integer, Integer> factorsRelation = new HashMap<>();
        
        for (int n : A) {
            mapFactors(n, factorsRelation);
        }
    
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        int largest = 1;
        
        for (int n : A) {
            
            int parent = findParent(factorsRelation, n);
            
            int newCount = freq.getOrDefault(parent,0)+1;
            freq.put(parent, newCount);
            
            largest = Math.max(largest, newCount);
        }
        
        return largest;
    }
    
    protected void mapFactors(int n, HashMap<Integer, Integer> factorsRelation) {
        
        union(factorsRelation, n, n);
        
        int limit = (int) Math.sqrt(n);
        
        for (int i=2; i<=limit; i++) {
            if (n % i == 0) {
                union(factorsRelation, n, i);
                union(factorsRelation, n, n/i);
            }
        }
    }
    
    protected void union(HashMap<Integer, Integer> factorsRelation, int possibleParent, int factor) {
        
        if (factorsRelation.containsKey(factor)) {
            int parent = findParent(factorsRelation,factor);
            factorsRelation.put(findParent(factorsRelation,possibleParent), parent);            
            factorsRelation.put(factor, parent);
        } else {
            factorsRelation.put(factor, possibleParent);
        }
    }
    
    protected int findParent(HashMap<Integer, Integer> factorsRelation, int value) {
        if (factorsRelation.get(value) == value) {
            return value;
        } else {
            return findParent(factorsRelation, factorsRelation.get(value));
        }
    }
}
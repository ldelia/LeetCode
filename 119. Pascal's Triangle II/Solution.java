class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        int[] precalculations = new int[rowIndex+1];
        precalculations[0] = 1;
        
        for (int i=1; i<=rowIndex; i++) {
            
            for (int j=i-1; j>=1; j--) {
                precalculations[j] = precalculations[j-1] + precalculations[j];
            }
                
            precalculations[i] = 1;
        }
        
        List<Integer> result = new ArrayList<Integer>(precalculations.length);
        for (int i : precalculations) {
            result.add(i);
        }
        
        return result;
    }
}
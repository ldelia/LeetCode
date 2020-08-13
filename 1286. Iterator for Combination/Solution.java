     
class CombinationIterator {

    /**
    Runtime: 10 ms, faster than 97.67% of Java online submissions for Iterator for Combination.
Memory Usage: 41.2 MB, less than 80.93% of Java online submissions for Iterator for Combination.
    */
    
    String characters;
    int[] currentCombination;
    boolean hasNext;

    public CombinationIterator(String characters, int combinationLength) {
        
        this.characters = characters;
        this.currentCombination = new int[combinationLength];
        this.hasNext = true;
        
        for ( int i=0; i<currentCombination.length; i++) {
            currentCombination[i] = i;
        }
    }
    
    protected void incrementCombinationCounters() {
        
        int combinationMaxIndex = currentCombination.length-1;
        int charactersMaxIndex = characters.length()-1;
        
        for (int i=combinationMaxIndex; i>=0; i--) {

            if (currentCombination[i] == charactersMaxIndex-(combinationMaxIndex-i)) {
                if (i==0) {
                    this.hasNext = false;
                }                
            } else {
                currentCombination[i]++;
                for (int j=i+1; j<=combinationMaxIndex; j++) {
                    currentCombination[j] = currentCombination[j-1] + 1;
                }
                return;
            }
        }
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i : currentCombination) {
            sb.append(characters.charAt(i));
        }
        
        incrementCombinationCounters();
        
        return sb.toString();
    }
    
    public boolean hasNext() {
        return this.hasNext;
    }
}        
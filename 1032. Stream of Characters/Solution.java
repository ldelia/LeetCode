class TrieNode {
    TrieNode[] child;
    boolean isWord;
    
    public TrieNode() {
        this.child = new TrieNode[26];
        isWord = false;
    }
    
    public void addWord(String word) {
        addWord(word, 0);
    }
    
    protected void addWord(String word, int charIndex) {
        
        if (word.length() == charIndex) {
            // reached the final of the word
            isWord = true;
            return;
        }
        
        char c = word.charAt(charIndex);
        int childIndex = c - 'a';
        
        if (child[childIndex] == null) {
            child[childIndex] = new TrieNode();
        }
        
        child[childIndex].addWord(word, charIndex+1);
    }
    
    public TrieNode query(char c) {
        int childIndex = c - 'a';
        return child[childIndex];
    }
}

class StreamChecker {

    
    TrieNode root;
    List<TrieNode> lastResults;

    public StreamChecker(String[] words) {
        
        root = new TrieNode();
        
        for (String w : words) {
            root.addWord(w);
        }
        
        lastResults = new LinkedList<>();
        lastResults.add(root);

    }
    
    public boolean query(char letter) {
        
        boolean result = false;
        
        List<TrieNode> nextResults = new LinkedList<>();
        nextResults.add(root);
        
        for (TrieNode lr : lastResults) {
            
            TrieNode nlr = lr.query(letter);
            
            if (nlr != null) {
                
                nextResults.add(nlr);
                
                if (nlr.isWord) {
                    result = true;    
                } 
            } 
        }
    
        lastResults = nextResults;
        
        return result;        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
class TrieNode {
    
    HashMap<Integer, TrieNode> childs;
    boolean isWord;
    
    public TrieNode() {
        childs = new HashMap<>();
        isWord = false;
    }
    
    public void addWord(String word, int position) {
        
        if (word.length() == position) {
            isWord = true;
            return;
        }
        
        char c = word.charAt(position);
        int index = c - 'a';
        
        if (! childs.containsKey(index)) {
            childs.put(index, new TrieNode());
        }
        
        childs.get(index).addWord(word, position + 1);
    }
    
    public boolean search(String word, int position) {
        
        if (word.length() == position) {
            return this.isWord;
        }
        
        char c = word.charAt(position);
        int nextPosition = position + 1;

        if (c == '.') {
            for (Map.Entry entry : childs.entrySet()) {
                if (((TrieNode) entry.getValue()).search(word, nextPosition)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            if (! childs.containsKey(index)) {
                return false;
            } else {
                return childs.get(index).search(word, nextPosition);
            }            
        }        
    }
}

class WordDictionary {

    TrieNode rootTrieNode;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        rootTrieNode = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        rootTrieNode.addWord(word, 0);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return rootTrieNode.search(word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class TrieNode {

    static int ALPHABET_SIZE = 26;
    TrieNode[] TrieNodes;
    boolean isWord;

    public TrieNode() {
        TrieNodes = new TrieNode[ALPHABET_SIZE];
        isWord = false;
    }

    public TrieNode get(char c) {
        return TrieNodes[c - 'a'];
    }

    public void addWord(String word){
        addWord(word, 0);
    }

    protected void addWord(String word, int index){
        if (index == word.length()) {
            isWord = true;
            return;
        } 

        char c = word.charAt(index);
        if (TrieNodes[c - 'a'] == null) {
            TrieNodes[c - 'a'] = new TrieNode();
        }
        TrieNodes[c - 'a'].addWord(word, index+1);
    }
}

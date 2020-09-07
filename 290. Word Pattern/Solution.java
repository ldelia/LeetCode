class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        /**
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
		Memory Usage: 37.2 MB, less than 89.64% of Java online submissions for Word Pattern.
		*/

        
        String[] words = str.split(" ");
        
        if (words.length != pattern.length()) return false;
        
        HashMap<String, Character> mapStringLetter = new HashMap<>();
        Set<Character> usedLetters = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int w=0; w<words.length; w++) {

            char p = pattern.charAt(w);
            
            if (mapStringLetter.containsKey(words[w])){
                if (mapStringLetter.get(words[w]) != p) return false;
            } else {
                if (usedLetters.contains(p)) return false;
                mapStringLetter.put(words[w], p);
                usedLetters.add(p);
            }
        }
        
        return true;
    }
}
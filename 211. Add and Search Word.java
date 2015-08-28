public class WordDictionary {

    class TrieNode {
        // Initialize your data structure here.
        boolean isWordEnd;
        Map<Character, TrieNode> children;
    
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }
    }
    
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWordEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode cur){
        if (word.isEmpty())
            return cur.isWordEnd;
            
        char c = word.charAt(0);
        if (c != '.')
            return cur.children.containsKey(c) && search(word.substring(1), cur.children.get(c));
        else {
            for (TrieNode child : cur.children.values())
                if(search(word.substring(1), child))
                    return true;
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
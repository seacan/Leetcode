class TrieNode {
    // Initialize your data structure here.
    boolean isWordEnd;
    Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode next;
            if (cur.children.containsKey(c)) {
                next = cur.children.get(c);
            } else {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWordEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = find(root, word);
        return p != null && p.isWordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = find(root, prefix);
        return p != null;
    }
    
    private TrieNode find(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode child = cur.children.get(c);
            if (child == null) return null;
            else cur = child;
        }
        return cur;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
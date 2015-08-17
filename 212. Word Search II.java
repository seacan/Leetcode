public class Solution {
    // use set avoid adding 2 a in case of ["aa"], ["a"]
    private Set<String> res = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s : words) trie.insert(s);

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                traverse(board, visited, "", i, j, trie);

        return new ArrayList<String>(res);
    }

    private void traverse(char[][] board,boolean[][] visited, String curStr, int i, int j, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j]) return;

        // string is primitive types, not passed by reference
        curStr += board[i][j];

        // don't need to explorer the recursive solution when no string starts with curStr
        if (!trie.startsWith(curStr)) return;
        if (trie.search(curStr)) res.add(curStr);

        visited[i][j] = true;
        traverse(board, visited, curStr, i + 1, j, trie);
        traverse(board, visited, curStr, i - 1, j, trie);
        traverse(board, visited, curStr, i, j + 1, trie);
        traverse(board, visited, curStr, i, j - 1, trie);
        visited[i][j] = false;
    }
    
    class TrieNode {
        public boolean isWordEnd;
        public HashMap<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c))
                    node.children.put(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWordEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
            return node.isWordEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
            return true;
        }
    }
}
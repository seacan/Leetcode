class AutocompleteSystem {
    class TrieNode {
        public boolean isLeaf;
        public List<String> cands;
        HashMap<Character, TrieNode> children;
        public TrieNode() {
            isLeaf = false;
            children = new HashMap<Character, TrieNode>();
            cands = new LinkedList<String>();
        }
    }
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i ++) {
                HashMap<Character, TrieNode> children = node.children;
                char c = word.charAt(i);
                if (!children.containsKey(c)) {
                    children.put(c, new TrieNode());
                }
                children.get(c).cands.add(word);
                if (i == word.length() - 1) {
                    children.get(c).isLeaf = true;
                }
                node = node.children.get(c);
            }
        }

        private TrieNode searchNode(String pre) {
            HashMap<Character, TrieNode> children = root.children;
            TrieNode node = root;
            for (int i = 0; i < pre.length(); i ++) {
                if (!children.containsKey(pre.charAt(i))) {
                    return null;
                }
                node = children.get(pre.charAt(i));
                children = node.children;
            }
            return node;
        }
    }

    HashMap<String, Integer> count = new HashMap<String, Integer>();
    Trie trie = new Trie();
    String curr = "";
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i ++) {
            count.put(sentences[i], times[i]);
            trie.insert(sentences[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new LinkedList<String>();
        if (c == '#') {
            if (!count.containsKey(curr)) {
                trie.insert(curr);
                count.put(curr, 1);
            }
            else {
                count.put(curr, count.get(curr) + 1);
            }
            curr = "";
        }
        else {
            curr += c;
            res = getSuggestions();
        }

        return res;
    }

    private List<String> getSuggestions() {
        TrieNode node = trie.searchNode(curr);
        if (node == null) return new LinkedList<String>();

        List<String> res = new LinkedList<String>(node.cands);
        Collections.sort(res, (a, b) -> count.get(b) - count.get(a));

        return res.subList(0, 2);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
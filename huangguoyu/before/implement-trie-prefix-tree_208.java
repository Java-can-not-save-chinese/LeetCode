class Trie {

    private class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }
        public Node() {
            this(false);
        }
    }
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {
            cur.isWord = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(char c: word.toCharArray()) {
            if (cur.next.get(c)==null) return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c: prefix.toCharArray()) {
            if (cur.next.get(c)==null) return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
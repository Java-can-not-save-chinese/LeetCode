class MapSum {

    private class Node{
        Node[] childs;
        char key;
        int value;
        public Node(char key){
            this.key = key;
            this.childs = new Node[26];
            this.value = 0;
        }
    }
    Node head;
    /** Initialize your data structure here. */
    public MapSum() {
        head = new Node('1');
    }

    public void insert(String key, int val) {
        Node cur = head;
        for(int i = 0; i < key.length();i++){
            char curChar = key.charAt(i);
            int index = curChar - 'a';
            if(cur.childs[index] == null){
                cur.childs[index] = new Node(curChar);
            }
            cur = cur.childs[index];
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = head;
        for(int i = 0; i < prefix.length();i++){
            cur = cur.childs[prefix.charAt(i) - 'a'];
            if(cur == null) return 0;
        }
        return sum(cur);
    }
    public int sum(Node node){
        if(node == null) return 0;
        int sum = node.value;
        for(Node child : node.childs){
            sum += sum(child);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
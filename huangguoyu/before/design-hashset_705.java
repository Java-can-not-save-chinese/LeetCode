class MyHashSet {

    private boolean[] bool = new boolean[1000001];
    private int num = 1000001;

    /** Initialize your data structure here. */
    public MyHashSet() {
    
    }
    
    public void add(int key) {
        bool[key % num] = true;
    }
    
    public void remove(int key) {
        bool[key % num] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bool[key % num];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
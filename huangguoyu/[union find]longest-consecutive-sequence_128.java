class Solution {
    int res = 1;
    Map<Integer, Integer> parent = new HashMap<>();
    // 以num为父元素的集合有多少个元素
    Map<Integer, Integer> count = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        

        Set<Integer> el = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if (!el.contains(nums[i])) {
                el.add(nums[i]);
                parent.put(nums[i], nums[i]);
                count.put(nums[i], 1);
            }
        }

        for(Integer item : el) {
            if(el.contains(item + 1)) {
                union(item, item+1);
            }
        }
        return nums.length == 0 ? 0 : res;
    }

    public int find(int e) {
        if (e != parent.get(e)) parent.put(e, find(parent.get(e)));
        return parent.get(e);
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        if (proot != qroot) {
            parent.put(proot, qroot);
            count.put(qroot, count.get(qroot) + count.get(proot));
            if (count.get(qroot) > res) res = count.get(qroot);
        }
    }
}
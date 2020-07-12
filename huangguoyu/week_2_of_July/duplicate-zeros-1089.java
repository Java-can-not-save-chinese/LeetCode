class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int item : arr) {
            if (item == 0 ) {
                queue.add(item);
                if (queue.size() == arr.length) break;
            }
            queue.add(item);
            if (queue.size() == arr.length) break;
        }
        int i = 0;
        while(!queue.isEmpty()) {
            arr[i++] = queue.poll(); 
        }
    }
}
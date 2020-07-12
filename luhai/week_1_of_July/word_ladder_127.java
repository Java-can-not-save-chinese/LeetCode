class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int length = 0;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            length ++;
            while(size-- > 0){
                String current = queue.poll();
                if(current.equals(endWord)) return length;
                int j = 0;
                while(j < wordList.size()){
                    if(isAccess(current,wordList.get(j))){
                        queue.add(wordList.get(j));
                        wordList.remove(j);
                    }else{
                        j ++;
                    }
                }
            }
        }
        return 0;
    }
    public boolean isAccess(String current,String target){
        if(current.length() != target.length()){
            return false;
        }
        int diff = 0;
        for(int i = 0; i < current.length(); i++){
            if(current.charAt(i) != target.charAt(i)){
                diff++;
                if(diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
class WordsFrequency {

    private Map<String, Integer> words = new HashMap<>();

    public WordsFrequency(String[] book) {
        for(String s : book) {
            if(words.get(s) == null) {
                words.put(s, 1);
                continue;
            }
            words.put(s, words.get(s) + 1);
        }
    }
    
    public int get(String word) {
        return words.get(word) == null ? 0 : words.get(word);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */
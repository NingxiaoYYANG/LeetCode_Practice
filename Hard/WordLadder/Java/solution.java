class Solution {
    public int ladderlength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visted.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++){
                String current = q.poll();

                for (int j = 0 ; j < current.length(); j++){
                    char[] current_char_array = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++){
                        if (c == current_char_array[j]){
                            continue;
                        }
                        current_char_array[j] = c;
                        String newWord = new String(current_char_array);

                        if (newWord.equals(endWord)){
                            return level + 1;
                        }
                        
                        if (wordSet.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
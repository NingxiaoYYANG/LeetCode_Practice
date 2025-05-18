import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a set for O(1) lookup of words
        Set<String> wordSet = new HashSet<>(wordList);
        
        // If endWord is not in wordList, return 0
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        // Set to keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        // Level counter
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all words at current level
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // Try changing each character
                for (int j = 0; j < current.length(); j++) {
                    char[] charArray = current.toCharArray();
                    
                    // Try all possible lowercase letters
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == charArray[j]) continue;
                        
                        charArray[j] = c;
                        String newWord = new String(charArray);
                        
                        // If we found the end word
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        
                        // If the word is in wordList and not visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
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
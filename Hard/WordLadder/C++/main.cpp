#include <string>
#include <vector>
#include <queue>
#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        // Create a set for O(1) lookup of words
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        
        // If endWord is not in wordList, return 0
        if (wordSet.find(endWord) == wordSet.end()) {
            return 0;
        }
        
        // Queue for BFS
        queue<string> q;
        q.push(beginWord);
        
        // Set to keep track of visited words
        unordered_set<string> visited;
        visited.insert(beginWord);
        
        // Level counter
        int level = 1;
        
        while (!q.empty()) {
            int size = q.size();
            
            // Process all words at current level
            for (int i = 0; i < size; i++) {
                string current = q.front();
                q.pop();
                
                // Try changing each character
                for (int j = 0; j < current.length(); j++) {
                    char original = current[j];
                    
                    // Try all possible lowercase letters
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        
                        current[j] = c;
                        
                        // If we found the end word
                        if (current == endWord) {
                            return level + 1;
                        }
                        
                        // If the word is in wordList and not visited
                        if (wordSet.find(current) != wordSet.end() && 
                            visited.find(current) == visited.end()) {
                            q.push(current);
                            visited.insert(current);
                        }
                    
                    
                        // Restore the original character
                        current[j] = original;
                    }
            }
            
            level++;
        }
        
        return 0;
    }
};
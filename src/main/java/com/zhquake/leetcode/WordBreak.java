package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Sep 26, 2014
 */

public class WordBreak {
    public class Solution {
        public boolean wordBreak(String s, Set<String> dict) {
            // return wordBreakRecursive(s, dict);
            return wordBreakDP(s, dict);
        }

        private boolean wordBreakDP(String s, Set<String> dict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                dp[i] = false;
                for (String word : dict) {
                    if (word.length() > i) {
                        continue;
                    } else {
                        if (dp[i - word.length()] == true
                                && word.equals(s.substring(i - word.length(), i))) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }

            return dp[s.length()];
        }

        // have a bad performance
        private boolean wordBreakRecursive(String s, Set<String> dict) {
            Map<Character, List<String>> indexWords = new HashMap<Character, List<String>>();
            for (String word : dict) {
                if (!word.equals("")) {
                    Character index = word.charAt(0);
                    List<String> words = indexWords.get(index);
                    if (words == null) {
                        words = new ArrayList<String>();
                        indexWords.put(index, words);
                    }
                    words.add(word);
                    Collections.sort(words, Collections.reverseOrder());
                }
            }

            return wordBreakHelper(s, indexWords);
        }

        private boolean wordBreakHelper(String s,
                Map<Character, List<String>> indexWords) {
            if (s.equals(""))
                return true;
            Character ch = s.charAt(0);
            if (!indexWords.keySet().contains(ch))
                return false;
            else {
                for (String word : indexWords.get(ch)) {
                    int length = word.length();
                    if (length > s.length())
                        continue;
                    if (s.substring(0, length).equals(word)) {
                        if (wordBreakHelper(s.substring(length), indexWords))
                            return true;
                    }
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        WordBreak wbreak = new WordBreak();
        Solution solution = wbreak.new Solution();
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("bbb");
        set.add("bbbb");
        System.out.println(solution.wordBreak("bbbaab", set));
    }
}

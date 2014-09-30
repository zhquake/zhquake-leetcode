package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhquake.leetcode.WordBreak.Solution;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Sep 28, 2014
 */
public class WordBreakII {
    public class Solution {
        public List<String> wordBreak(String s, Set<String> dict) {
            return solution3(s, dict);
        }
    }

    private List<String> solution1(String s, Set<String> dict) {
        Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
        List<String> l = new ArrayList<String>();
        l.add("");
        result.put(0, l);

        for (int i = 1; i <= s.length(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                if (!result.get(j).isEmpty()
                        && dict.contains(s.substring(j, i))) {
                    for (String item : result.get(j)) {
                        list.add((item + " " + s.substring(j, i)).trim());
                    }
                }
            }
            result.put(i, list);
        }
        return result.get(s.length());
    }

    private List<String> solution2(String s, Set<String> dict) {
        Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
        ArrayList<String> l = new ArrayList<String>();
        l.add("");
        result.put(0, l);

        for (int i = 1; i <= s.length(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            for (String word : dict) {
                if (word.length() > i) {
                    continue;
                } else {
                    if (word.equals(s.substring(i - word.length(), i))) {
                        if (!result.get(i - word.length()).isEmpty()) {
                            for (String item : result.get(i - word.length())) {
                                list.add((item + " " + word).trim());
                            }
                        }
                    }
                }
            }
            result.put(i, list);
        }

        return result.get(s.length());
    }

    // Accepted
    private List<String> solution3(String s, Set<String> dict) {
        return searchWordBreak(s, dict,
                new HashMap<String, ArrayList<String>>());
    }

    private ArrayList<String> searchWordBreak(String s, Set<String> dict,
            Map<String, ArrayList<String>> solutions) {
        ArrayList<String> solution = solutions.get(s);
        if (solution != null) {
            return solution;
        }
        solution = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                for (String subfix : searchWordBreak(s.substring(i), dict,
                        solutions)) {
                    solution.add(prefix + " " + subfix);
                }
            }
        }
        if (dict.contains(s)) {
            solution.add(s);
        }
        solutions.put(s, solution);
        return solution;
    }

    public static void main(String[] args) {
        WordBreakII wbreak = new WordBreakII();
        Solution solution = wbreak.new Solution();
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("bbb");
        set.add("bbbb");
        System.out.println(solution.wordBreak("bbbaab", set));
    }
}

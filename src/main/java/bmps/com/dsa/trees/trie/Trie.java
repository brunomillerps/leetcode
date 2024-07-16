package bmps.com.dsa.trees.trie;

import java.util.HashMap;

import java.util.Map;

public class Trie {

    private Map<String, Map> dict = new HashMap<>();

    public void insert(String word) {

        var curDict = this.dict;

        for (String w : word.split("")) {
            curDict.putIfAbsent(w, new HashMap<>());
            curDict = curDict.get(w);
        }

        curDict.put(".", new HashMap<>());
    }

    public boolean exists(String word) {
        var curDict = this.dict;

        for (String w : word.split("")) {
            if (!curDict.containsKey(w)) return false;
            curDict = curDict.get(w);
        }

        return curDict.containsKey(".");
    }

    public boolean startsWith(String prefix) {
        var curDict = this.dict;

        for (String w : prefix.split("")) {
            if (!curDict.containsKey(w)) return false;
            curDict = curDict.get(w);
        }
        return true;
    }

}

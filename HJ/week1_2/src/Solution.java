import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap <String, Integer> mp = new HashMap<>();

        for (String p: participant){
            if(mp.containsKey(p)){
                int countKey = mp.get(p);
                mp.put(p, countKey+1);
            }
            else
                mp.put(p, 1);
        }

        for (String s: completion){
            if(mp.containsKey(s)){
                int countKey = mp.get(s);
                mp.put(s, countKey-1);
            }
        }

        for (String key : mp.keySet()){
            if (mp.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }
}

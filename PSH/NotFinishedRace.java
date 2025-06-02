import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        //참가자 명단을 해시맵에 저장(이릅, 등장횟수)
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        //완주자 명단 참고해 등장횟수-1
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        //값=1, 완주X
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return "";
    }
}


public class NotFinishedRace{
	public static void main(String[] args) {
		
	}
}

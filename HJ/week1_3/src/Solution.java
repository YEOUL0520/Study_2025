import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;

        //각 자리에서의 이동 계산
        for (int i = 0; i<name.length(); i++){
            answer += Math.min(90-name.charAt(i)+1, name.charAt(i)-65);
        }

        //각 자리로의 이동 계산
        int move = name.length()-1; //1
        for (int x = 0; x < name.length(); x++){
            int next = x+1;
            while (next <name.length() && name.charAt(next) == 65){
                next++;
            }
            //동시에 3개 비교 불가, 1-2 비교후 그 결과값과 3을 다시 비교
            move = Math.min(move, x*2 + name.length()-next);
            move = Math.min(move, (name.length()-next)*2+x);
        }
        answer += move;
        return answer;
    }
}
package test;
import java.util.*;

//가장 처음에는 A로만 (AAA(글자수만큼 길이))
class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len=name.length();
        int cursor=len-1; //커서 오른쪽 끝까지
        
        for(int i=0;i<len;i++) {
            //현재커서에서 변경 최소(위,아래)
        	answer+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
        	int idx=i+1; //다음 글자
        	//연속 A가 끝나는 지점(만들려는 글자가 이미 A면 조작필요X)
        	while(idx<len && name.charAt(idx)=='A') {
        		idx++;
        	}
        	//좌우이동 변경 최소
        	cursor=Math.min(cursor, i*2+len-idx); //오->왼
        	cursor=Math.min(cursor, (len-idx)*2+i); //왼->오
        }
        
        return answer+cursor;
    }
}

public class JoyStick {
	public static void main(String[] args) {

	}
}

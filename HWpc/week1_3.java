

class Solution {
    public int solution(String name) {
        int n = name.length();	// 문자열의 길이
    	int answer = 0;
        
    	
    	// 위 / 아래 이동 최소 횟수 
    	for(int i = 0; i < n; i++) {
    		// 알파벳은 26개인데 만약 X 같이 뒤에서 접근하는게 이동횟수가 더 작으면 뒤에서 접근하는 방식을 선택  
    		answer += Math.min( (name.charAt(i) - 'A') , ('Z' - name.charAt(i) + 1));
    	}

    	int move = n - 1;	// 기본 : 오른쪽으로 쭉 감
    	// 좌 / 우 이동 최소 횟수
    	// 'A' 가 있으면 뛰어넘음
//    	ex)
//    	0 1 2
//    	a a a
//    	j a z
//    	answer = 11 나와야함
//
//    	기본은 오른쪽으로 이동
//    	즉, 방향을 바꾸려면 커서 위치 1번 이동시켜야함
//    	위의 예는 a가 중앙에 포함되어 있어서 
//    	j에서 오른쪽 2번보다는 왼쪽 1번이 최소 이동 거리이기 때문에 왼쪽으로 이동함
//    	현재 위치는 2의 a이고 z로 가려면 아래로 1번 이동 하면 됨
//    	위 : 9 	왼 : 1	아래 : 1	
    	
    	for(int i = 0; i < n ; i++) {
    		// 문자 간 이동
    		// aaa이 아니라면 무조건 1번은 이동해야함
    		int next = i + 1;	// 초기값 1 
    		// 'A' 가 연속될 때 그 다음 문자 찾기
    		
    		// next 는 전체 길이인 n 보다는 작아야하고,
    		// 이 조건을 만족하면서 name 의 next 인덱스의 문자가 'A'와 같다면 
    		// next 를 +1 증가
    		while(next < n  && name.charAt(next) == 'A') next++;
    		
    		// 현재위치까지 갔다가, 뒤로 돌아서 맨 끝에서 next 까지 가는 경우의 수
    		move = Math.min( move, i + (n - next + Math.min( i, n - next )  ));
    	}
    	
    	answer += move;
        return answer;
    }
}

public class week1_3 {

    
}
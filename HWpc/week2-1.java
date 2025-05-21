

class Solution {
    boolean solution(String s) {
        
    	int open = 0;	// 괄호열기
    	int close = 0;	// 괄호닫기
    	
    	// 문자열 s 길이만큼 반복
    	for(int i = 0; i < s.length(); i++) {
    		// i 번째 인덱스의 문자에 접근
    		char c = s.charAt(i);
    		if(c == '(') {	// 괄호가 열리면 open 의 값 증가
    			open++;		
    		}else {			// 괄호가 닫히면 close 의 값 증가
    			close++;
    		}
    		// 만약 닫힌 괄호가 열린 괄호보다 크다면 false 반환
    		if(close > open) {return false;}	
    	}
    	// 열린 괄호와 닫힌 괄호의 수가 다르면 false 반환
    	if(open != close) {
    		return false;
    	}else {
    		return true;
    	}
    	
    	
    }
}

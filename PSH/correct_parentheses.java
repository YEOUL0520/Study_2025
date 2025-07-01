import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk=new Stack<Character>();
        //()면 true, 아니면 false
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	if(ch=='('){
        		stk.add(ch);
        	}
        	else { //')'인 경우,
        		if(stk.isEmpty()) {//'('가 없다. 매칭X
        			return false;
        		}
        		else
        			stk.pop();//매칭됨.'()'
        	}
        }

        return stk.isEmpty(); //비어있으면 true, 아니면 false반환
    }
}

public class correct_parentheses {
	public static void main(String[] args) {


	}
}

//처음 생각
//스택+count이용
//'()'가 한 쌍이고 마지막은 ')'로 닫혀야함
//if(마지막이 ')'면 count시작, 그 외 false
//')'면 +, '('면 -해서 count=0이면 true, 아니면 false
//import java.util.*;
//class Solution {
//    public static boolean solution(String s) {
//        Stack<Character> stk = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            stk.push(s.charAt(i));
//        }
//
//        int count = 0;
//        while (!stk.isEmpty()) {
//            char ch = stk.pop();
//            if (ch == ')') {
//                count++;
//            } else if (ch == '(') {
//                count--;
//            }
//
//            if (count < 0) {
//                return false;
//            }
//        }
//
//        // 열린 괄호와 닫힌 괄호 개수가 정확히 맞아야 true 반환
//        return count == 0;
//    }
//}

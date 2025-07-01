class Solution {
    boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 문자 하나씩 떼고
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else {
                count--;
                if (count < 0)
                    return false; // ( 이거 없는데 ) 얘를 빼줌
            }
        }
        return (count == 0);  // 0이면 true, 아니면 false 반환 (boolean solution)
    }
}
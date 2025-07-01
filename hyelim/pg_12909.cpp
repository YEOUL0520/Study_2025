// 프로그래머스 - 올바른 괄호 (12909) : 스택/큐


#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    stack<char> check;

    for (char i : s)
    {
        if (i == '(')  // '(' 가 왔을 때
            check.push(i);  // stack "check"에 값 push
        else if (i == ')')  // ')' 가 왔을 때
        {
            if (check.empty())  // 스택이 비어있다 == ( 괄호가 시작이 아님 == 무조건 오류
                return false;

            check.pop();  // stack "check"에 ( 괄호가 있다는 뜻이므로 올바르단 의미 > pop으로 값 제거
        }
    }

    return check.empty();  // 비어있으면(== 바르게 짝지어진 경우) true, 아니라면(== 바르게 짝지어 X) false
}
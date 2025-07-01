#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int n = s.size(); //s의 길이
    int check = 0;
    
    for (int i = 0; i < n; i++) {
        if ('(' == s[i])
            check ++;
        else
            check --;
        
        if (check <0) { //check가 음수 되는 순간 무조건 false
            answer = false;
            break;
        }
        else if (check != 0)
            answer = false;
        else
            answer = true;
    }

    return answer;
}
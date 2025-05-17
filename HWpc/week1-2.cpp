// [중] 완주하지 못한 선수 (Lv 1 | 해시)
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    
    for(int i = 0; i < completion.size(); i++){
        if(completion[i] != participant[i]){
            return participant[i];
        }
    }
    
    
    return participant.back();
}

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    sort(participant.begin(), participant.end()); //참가자 순서대로 정렬
    sort(completion.begin(), completion.end()); //완주자 순서대로 정렬
    int k = completion.size();
    for (int i = 0; i<k; i++) {
        if (participant[i] != completion[i]) { //순서대로 비교중 안맞다면
            return participant[i]; //이 사람이 완주X
            break; //반복문 종료
        }
    }
    
    return participant[k]; //끝까지 돌았는데 다 완주한 경우 마지막 사람 완주 x
}
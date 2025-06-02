// [중] 완주하지 못한 선수 (Lv 1 | 해시)
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    // template <typename T>
    // void sort(T start, T end, Compare comp);
    // void sort( 시작,     끝,    정렬);
    // 3번째 인자 입력 안 할 시 디폴트값은 오름차순   
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    
    // 문제 조건으로 인해 정렬을 시켰으면 완주하지 못한 선수 빼고는 모두 같아야 함
    // 따라서 만약 같은 인덱스의 값이 서로 다르다면 그 값 자체가 완주하지 못 한 선수이므로
    // 결과를 반환함
    for (int i = 0; i < completion.size(); i++) {
        if (completion[i] != participant[i]) {
            return participant[i];
        }
    }
    // completion의 길이가 completion길이보다 1 작으므로
    // 위의 반복문이 끝까지 돈다면 participant의 마지막 인덱스 값만 남음
    // 따라서 participant의 마지막 인덱스 값이 완주하지 못 한 선수임
    // vector.back(); 를 사용하여 vector의 마지막 요소 값을 반환함
    return participant.back();
}



// 출력 확인용
int main(void) {
    // case 1
    //vector<string> one = { "leo", "kiki", "eden" };
    //vector<string> two = { "eden", "kiki" };
    //cout << solution(one, two);

    // case 2
    //vector<string> one = { "marina", "josipa", "nikola", "vinko", "filipa"};
    //vector<string> two = { "josipa", "filipa" , "marina", "nikola"};
    //cout << solution(one, two);

    // case 3
    vector<string> one = { "mislav", "stanko", "mislav", "ana"};
    vector<string> two = { "stanko", "ana" , "mislav"};
    cout << solution(one, two);

    cout << endl;
    return 0;
}
//3주차 프로그래머스 구명 보트

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int psize = people.size(); //사람수
    int answer = 0, i = 0, j = psize - 1;;
    sort(people.begin(), people.end(), greater<int>()); //내림차순으로 사람정렬
    while (i <= j) { //i<j 하니까 마지막 한 명이 안 타짐
        if (people[i] + people[j] <= limit) { j--; }
        i++;
        answer++; // 보트 하나 사용
    }
    return answer;
}


/* 효율성 테스트 빵점...

int solution(vector<int> people, int limit) {
    int answer = 0;
    int psize = people.size(); //사람수
    sort(people.begin(),people.end(),greater<int>()); //내림차순으로 사람정렬
    for (int i=0; i<psize-1; i++) { //2명이서 탈 수 있는 경우
        for (int j=i+1; j<psize; j++) {
            if ((people[i]+people[j]<=limit)&&(people[i] != 0)&&(people[j] !=0)) {
                answer ++;
                people[i] = 0;
                people[j] = 0;
                break;
            }
        }
    }

    for (int i = 0; i<psize; i++) {
        if (people[i] != 0)
            answer++;
    }
    return answer;
} */
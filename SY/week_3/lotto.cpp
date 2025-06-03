//3주차 프로그래머스 - 로또의 최고 순위와 최저 순위

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int lcount = 0, wcount = 0; //횟수 세아리는 용
    int realres = 0, ifres = 0; //일치하는 번호 개수, 알아볼 수 없는 번호 수
    sort(win_nums.begin(), win_nums.end()); //순서대로 정렬
    sort(lottos.begin(), lottos.end()); //순서대로 정렬
    while ((lcount < 6) || (wcount < 6)) { //조건을 벗어나지 않는 데까지 반복
        if (lottos[lcount] == 0) { ifres++; lcount++; }
        else if (lottos[lcount] == win_nums[wcount]) { realres++; wcount++; }
        else if ((lottos[lcount] > win_nums[wcount]) && (wcount < 6)) { wcount++; }
        else if ((lottos[lcount] < win_nums[wcount]) && (lcount < 6)) { lcount++; }
        else
            wcount++;
    }

    int rankmin = 0, rankmax = 0; //최저순위, 최고순위
    rankmin = (realres > 1) ? 7 - realres : 6; //조건에 만족하면 순위 계산 아니라면 낙점(6)
    rankmax = (realres + ifres > 1) ? 7 - (realres + ifres) : 6; //조건에 만족하면 순위 계산 아니라면 낙점(6)

    answer.push_back(rankmax); //최고순위
    answer.push_back(rankmin); //최저순위
    return answer;
}
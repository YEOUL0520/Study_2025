// 프로그래머스 - 로또의 최고 순위외 최저 순위 (77484)


#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    int rank[7] = { 6, 6, 5, 4, 3, 2, 1 };  // 당첨 개수에 따른 순위
    int zero = 0, same = 0;  // 0의 개수, 같은 번호 개수

    unordered_set<int> win_sets(win_nums.begin(), win_nums.end());
    // 중복 허용X, 정렬되지 않은 해시 기반 자료구조 생성, 이 안에 당첨 번호를 넣음
    
    // 아래와 같음
    /*
    for (int num : win_nums) {
    win_set.insert(num);
    }
    */

    for (int i : lottos)
    {
        if (i == 0)  // 0 개수 찾기
            zero++;
        else if (win_sets.count(i))  // 같은 번호 개수 찾기
            same++;
    }

    return { rank[same + zero], rank[same] };
}
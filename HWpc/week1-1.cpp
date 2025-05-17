//[1주차] 나이순 정렬 / 하 
// "https://www.acmicpc.net/problem/10814"
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>    // sort 사용하기 위함
#include <tuple>

using namespace std;

int main() {

    // n명
    int n;
    // 데이터 입력 받기
    cin >> n;

    // 나이, 이름 벡터 생성 
    vector<int> age(n);
    vector<string> name(n);

    // 공백 구분해 입력 받기
    for(int i = 0; i < n; i++){
        cin >> age[i] >> name[i];
    }

    // 묶기 
    vector<tuple<int, int, string>> entries;
    for(int i = 0; i < n; i++){
        entries.emplace_back(i, age[i], name[i]);
    }
    
    // 나이 배열 순회하며 나이 작은 순으로 정렬 (나이가 같으면 입력 순서 보존함)
    stable_sort(entries.begin(), entries.end(), [](const auto& a, const auto& b){
        return get<1>(a) > get<1>(b);   // int 기준 내림차순
    });

    for (const auto& entry : entries){
        cout << get<1>(entry) << " " << get<2>(entry) << endl;
    }
    
    return 0;
}

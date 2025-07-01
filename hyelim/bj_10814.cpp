// 백준 - 나이순 정렬 (10814)


#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

struct Person {
    int age;
    string name;
};

int main() {
    int N;
    cin >> N;

    vector<Person> people(N);  // 벡터 사용 (장점: 크기 동적O, 메모리 관리 유연)

    // input
    for (int i = 0; i < N; ++i) {
        cin >> people[i].age >> people[i].name;
    }

    // stable_sort를 사용하여 나이 기준 정렬 (나이가 같으면 입력 순서 유지)
    stable_sort(people.begin(), people.end(), [](const Person& a, const Person& b){
        return a.age < b.age; // 나이가 작은 순으로 정렬
        });

    // stable_sort(begin, end, comp) 형태 (: 사용자 정의 기준으로 정렬)

    /* 람다 함수 (lambda)
    *  형태: [] (매개변수) { 함수 동작 } (호출 시 인자) ;
    *  이 문제에서는 나이가 같을 때 가입 순으로 유지되어야 함으로 람다 함수로 조건 사용
    */


    // 정렬된 회원 정보 출력
    for (const auto& member : people) {
        cout << member.age << " " << member.name << endl;
    }

    return 0;
}
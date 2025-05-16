#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <tuple>

int main() {
    int n;
    std::cin >> n; // n: 입력받을 데이터 개수
    // n개의 int와 string을 저장할 벡터 선언
    std::vector<int> nums(n);         // int 값을 저장할 벡터
    std::vector<std::string> strs(n); // string 값을 저장할 벡터
    // n번 반복하여 int와 string을 각각 입력받음 (공백 구분)
    for (int i = 0; i < n; ++i) {
        std::cin >> nums[i] >> strs[i];
    }

    // (입력 순서, int 값, string 값)을 묶어 저장할 벡터 선언
    std::vector<std::tuple<int, int, std::string>> entries;

    // 각 인덱스에 대해 튜플 형태로 묶어서 entries에 추가
    for (int i = 0; i < n; ++i) {
        // i: 입력 순서(index), nums[i]: int 값, strs[i]: string 값
        entries.emplace_back(i, nums[i], strs[i]);
    }

    // 오름차순 정렬
    // 1. int 값(nums[i])을 기준으로 오름차순 정렬
    // 2. int 값이 같은 경우 입력 순서를 기준으로 안정적으로 정렬(stable_sort)
    std::stable_sort(entries.begin(), entries.end(),
        [](const auto& a, const auto& b) {
            // std::get<1>(a): a 튜플의 int 값, std::get<1>(b): b 튜플의 int 값
            return std::get<1>(a) < std::get<1>(b); // 오름차순 비교
        });

    // 정렬된 결과 출력
    for (const auto& entry : entries) {
        // std::get<1>(entry): int 값, std::get<2>(entry): string 값
        std::cout << std::get<1>(entry) << " " << std::get<2>(entry) << "\n";
    }

    return 0;
}
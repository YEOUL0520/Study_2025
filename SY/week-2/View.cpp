//[S/W 문제해결 기본] 1일차 - View 

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;

	for (int i = 0; i < 10; i++) { //테스트 케이스 10개
		cin >> n;
		vector <int> buildings;
		int answer = 0; //조망권을 가진 세대 수

		for (int j = 0; j < n; j++) {
			int h; //높이
			cin >> h;
			buildings.push_back(h);
		}

		for (int j = 2; j < n - 2; j++) {
			int building_max = 0; //양옆으로 2칸 떨어져 있는 건물들 중 가장 높은 건물의 높이
			if ((buildings[j] > buildings[j - 1]) && (buildings[j] > buildings[j + 1]) && (buildings[j] > buildings[j - 2]) && (buildings[j] > buildings[j + 2])) { //양옆으로 2칸씩 떨어져 있는 건물들보다 높은 경우
				building_max = max({ buildings[j - 1], buildings[j + 1],buildings[j - 2], buildings[j + 2] }); //양옆으로 2칸 떨어져 있는 건물들 중 가장 높은 건물의 높이
				answer += (buildings[j] - building_max); //현재 건물 높이 - 양 옆으로 2칸 떨어져 있는 건물들 중 가장 높은 건물의 높이
			}
		}

		cout << "#" << i + 1 << " " << answer << endl; //테스트 케이스 번호와 조망권을 가진 세대 수 출력
	}
	return 0;
}
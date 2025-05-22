//[S/W �����ذ� �⺻] 1���� - View 

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;

	for (int i = 0; i < 10; i++) { //�׽�Ʈ ���̽� 10��
		cin >> n;
		vector <int> buildings;
		int answer = 0; //�������� ���� ���� ��

		for (int j = 0; j < n; j++) {
			int h; //����
			cin >> h;
			buildings.push_back(h);
		}

		for (int j = 2; j < n - 2; j++) {
			int building_max = 0; //�翷���� 2ĭ ������ �ִ� �ǹ��� �� ���� ���� �ǹ��� ����
			if ((buildings[j] > buildings[j - 1]) && (buildings[j] > buildings[j + 1]) && (buildings[j] > buildings[j - 2]) && (buildings[j] > buildings[j + 2])) { //�翷���� 2ĭ�� ������ �ִ� �ǹ��麸�� ���� ���
				building_max = max({ buildings[j - 1], buildings[j + 1],buildings[j - 2], buildings[j + 2] }); //�翷���� 2ĭ ������ �ִ� �ǹ��� �� ���� ���� �ǹ��� ����
				answer += (buildings[j] - building_max); //���� �ǹ� ���� - �� ������ 2ĭ ������ �ִ� �ǹ��� �� ���� ���� �ǹ��� ����
			}
		}

		cout << "#" << i + 1 << " " << answer << endl; //�׽�Ʈ ���̽� ��ȣ�� �������� ���� ���� �� ���
	}
	return 0;
}
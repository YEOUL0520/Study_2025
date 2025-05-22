//������ ���� �ű��

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int std, k = 0; //std = �л� ��, k = k��° �л�
		double kt_score = 0.0; //k��° �л��� ����
		cin >> std >> k;
		vector<double> tscore(std); //��ü �л� ����

		for (int j = 0; j < std; j++) {
			int score_1 = 0, score_2 = 0, score_3 = 0;//���� k�� ����, �߰�, �⸻, ���� ����
			cin >> score_1 >> score_2 >> score_3;

			tscore[j] = score_1 * 0.35 + score_2 * 0.45 + score_3 * 0.2; //���� ���

			if (j == k - 1) //k��° �л��� ������ ����
				kt_score = tscore[j];
		}

		int s = std / 10; // ������ ���� �ο��� �� �ִ� ��� ��
		sort(tscore.begin(), tscore.end(), greater<double>()); //�������� ����

		for (int j = 0; j < std; j++) {
			if (tscore[j] == kt_score) { //k��° �л��� ������ ������ ���
				if (j < s)
					cout << "#" << i + 1 << " " << "A+" << endl;
				else if (j < s * 2)
					cout << "#" << i + 1 << " " << "A0" << endl;
				else if (j < s * 3)
					cout << "#" << i + 1 << " " << "A-" << endl;
				else if (j < s * 4)
					cout << "#" << i + 1 << " " << "B+" << endl;
				else if (j < s * 5)
					cout << "#" << i + 1 << " " << "B0" << endl;
				else if (j < s * 6)
					cout << "#" << i + 1 << " " << "B-" << endl;
				else if (j < s * 7)
					cout << "#" << i + 1 << " " << "C+" << endl;
				else if (j < s * 8)
					cout << "#" << i + 1 << " " << "C0" << endl;
				else if (j < s * 9)
					cout << "#" << i + 1 << " " << "C-" << endl;
				else
					cout << "#" << i + 1 << " " << "D0" << endl;
			}
		}
	}
	return 0;
}
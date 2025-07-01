//조교의 성적 매기기
 
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
 
int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int std, k = 0; //std = 학생 수, k = k번째 학생
        double kt_score = 0.0; //k번째 학생의 점수
        cin >> std >> k;
        vector<double> tscore(std); //전체 학생 총점
 
        for (int j = 0; j < std; j++) {
            int score_1 = 0, score_2 = 0, score_3 = 0;//각각 k의 총점, 중간, 기말, 과제 점수
            cin >> score_1 >> score_2 >> score_3;
 
            tscore[j] = score_1 * 0.35 + score_2 * 0.45 + score_3 * 0.2; //총점 계산
 
            if (j == k - 1) //k번째 학생의 점수를 저장
                kt_score = tscore[j];
        }
 
        int s = std / 10; // 동일한 평점 부여할 수 있는 사람 수
        sort(tscore.begin(), tscore.end(), greater<double>()); //내림차순 정렬
 
        for (int j = 0; j < std; j++) {
            if (tscore[j] == kt_score) { //k번째 학생의 점수와 같으면 출력
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
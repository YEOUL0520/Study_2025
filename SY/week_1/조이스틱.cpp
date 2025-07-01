#include <string>
#include <algorithm> //min 함수 사용

using namespace std;

int solution(string name) {
    int answer = 0;
    int nsize = name.size(); //문자 길이
    int move = nsize-1; //오른쪽으로 이동하는 횟수
    for (int i = 0; i<nsize; i++) { //위아래 이동
        char c = name[i];
        answer += min(c - 'A','Z'-c+1); //위,아래중 이동횟수 더 적은걸 answer에 더함
    }
    
    for (int i = 0; i<nsize; i++) { //커서 이동
        int next = i+1; //오른쪽 기준 다음 위치
        while ((next <nsize) && (name[next] == 'A')) {next++;} //다음 글자가 A인 경우 건너뛰기
        int Lnext = i+nsize-next+min(i,nsize-next); //현재 위치 + 끝에서 다시 시작해야할 문자 수 + 왼쪽 or 오른쪽 최소값
        move = min(move,Lnext); //그냥 오른쪽으로 가기 vs 왼쪽으로 가서 돌아가기 비교한 뒤 짧은 거 선택
    }
    
    return answer + move; //상하, 좌우 움직임 횟수 합치기
}

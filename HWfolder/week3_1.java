import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zerocount = 0;  // 0개수 저장할 변수
        int matchcount = 0; // 맞은 개수 저장할 변수

        // 당첨 번호를 Set에 저장
        // Set은 중복을 허용하지 않는 데이터의 집합을 의미
        // 같은 값이 여러번 들어가도 한 번만 저장됨
        // 인덱스 신경 안 쓰고 값의 존재여부 빠르게 검사 가능

        // HashSet은 Set의 대표적인 구현체
        // 내부적으로 해시 알고리즘 사용함
        // 값을 넣을 때 정렬 안 됨
        Set<Integer> winset = new HashSet<>();
        for(int n :  win_nums) {
            winset.add(n);
        }

        // lottos 돌면서 0 개수와 맞은 번호 개수 체크
        for(int n :  lottos) {
            if(n==0) {zerocount++;}
            else if(winset.contains(n)) {matchcount++;}
        }

        // 0이 모두 맞았다고 가정
        int maxRank = getRank(matchcount+zerocount);
        // 0이 모두 틀렸다고 가정
        int minRank = getRank(matchcount);

        return new int[]{maxRank, minRank};

    }
    // 로또 순위 정하는 메서드
    private int getRank(int cnt){
        // 개수 6개
        //      맞은 개수
        // 7-   6       = 1등
        // 7-   5       = 2등
        // 7-   4       = 3등
        if(cnt >= 2) return 7-cnt;
        else return 6;
    }
}

public class week3_1 {
    public static void main(String[] args) {
        int[] lottos_main = new int[] {44, 1, 0, 0, 31, 25};
        int[] win_nums_main = new int[] {31, 10, 45, 1, 6, 19};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(lottos_main, win_nums_main)));

    }

}

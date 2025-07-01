// 구명보트 / 구명보트
// https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

class Solution3_2 {
    public int solution(int[] people, int limit) {
        // 배열 오름차순 정렬
        Arrays.sort(people);  // 정렬
        int boats = 0;  // 필요한 구명보트 수
        int left = 0;   // 가장 가벼운 사람
        int right = people.length - 1;  // 가장 무거운 사람

        // 투 포인터 알고리즘 시작
        // left가 right 보다 커지면 모든 사람을 확인한 것임
        while (left <= right) {
            // 한 명만 남은 경우
            if (left == right) {
                boats++;    // 마지막 남은 사람을 위해 보트 추가
                break;      // while 루프 종료
            }

            // 리미트 넘는지 확인
            if (people[left] + people[right] <= limit) {
                left++;     // 다음 가벼운 사람으로 이동
                right--;    // 다음 무거운 사람으로 이동
            } else {
                right--;    // 무거운 사람이 제한 초과하면 혼자 태움
            }
            boats++;        // 보트 수 증가
        }

        return boats;       // 필요한 총 보트 수 반환
    }
}

public class week3_2 {
    public static void main(String[] args) {
        int[] people_main;
        int limit_main = 100;
        people_main = new int[] {70, 50, 80, 50};

        Solution3_2 solution = new Solution3_2();
        System.out.println(solution.solution(people_main, limit_main));

    }
}

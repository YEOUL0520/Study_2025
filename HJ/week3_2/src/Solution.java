import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();  // 개행 문자 처리

        for (int test_case = 1; test_case <= T; test_case++) {
            String S = sc.nextLine();

            // 경우 1: 모든 '?'을 'L'로 치환
            int maxDistanceL = calculateMaxDistance(S.replace('?', 'L'));
            // 경우 2: 모든 '?'을 'R'로 치환
            int maxDistanceR = calculateMaxDistance(S.replace('?', 'R'));

            // 두 경우 중 최대 거리 출력
            System.out.println(Math.max(maxDistanceL, maxDistanceR));
        }
    }

    // 좌표 이동 후, 원점과의 최대 거리 계산 함수
    private static int calculateMaxDistance(String commands) {
        int position = 0;
        int maxDistance = 0;
        for (char cmd : commands.toCharArray()) {
            if (cmd == 'L') {
                position--;
            } else if (cmd == 'R') {
                position++;
            }
            maxDistance = Math.max(maxDistance, Math.abs(position));
        }
        return maxDistance;
    }
}
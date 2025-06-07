import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            String S = sc.nextLine();

            // ?가 전부 L인 경우
            int maxDistanceL = calculateMaxDistance(S.replace('?', 'L'));
            // ?가 전부 R인 경우
            int maxDistanceR = calculateMaxDistance(S.replace('?', 'R'));

            // 두 경우 중 최대 거리 출력
            System.out.println(Math.max(maxDistanceL, maxDistanceR));
        }
    }

    // 원점과의 최대 거리를 계산
    private static int calculateMaxDistance(String commands) {
        int position = 0;
        int maxDistance = 0;
        for (char cmd : commands.toCharArray()) {
            if (cmd == 'L') {
                position--; // L인 경우 왼쪽으로 이동
            } else if (cmd == 'R') {
                position++; // R인 경우 오른쪽으로 이동
            }
            maxDistance = Math.max(maxDistance, Math.abs(position));
        }
        return maxDistance;
    }
}
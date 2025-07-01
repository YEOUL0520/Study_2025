import java.util.Scanner;

public class week2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트케이스 10개이므로 1부터 10까지 10번 반복
        for(int test_case = 1; test_case <= 10; test_case++){
            // 건물의 개수
            int N = sc.nextInt();
            // 빌딩 배열 생성 및 입력 받기
            int[] buildings = new int[N];
            for(int i = 0; i < N; i++){
                buildings[i] = sc.nextInt();
            }
            // 조망권 가진 세대 전체
            int totalView = 0;
            for(int i = 2; i < N-2; i++) {
                int left1 = buildings[i - 2];
                int left2 = buildings[i - 1];
                int right1 = buildings[i + 2];
                int right2 = buildings[i + 1];

                // 네 건물 중 가장 높은 건물
                int MaxNeighbor = Math.max(Math.max(left1, left2), Math.max(right1, right2));
                // 양 옆 4개의 건물보다 높다면 그 건물에서 네 개의 건물 중 가장 높은 건물을 빼서 조망권 세대 구함
                if (MaxNeighbor < buildings[i]) {
                    totalView += buildings[i] - MaxNeighbor;
                }
            }
            // 출력
            System.out.println("#" + test_case + " " + totalView);


        }




    }

}
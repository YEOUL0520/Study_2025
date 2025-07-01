// [3주차] 로봇언어 / 상
// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&problemLevel=4&problemLevel=5&contestProbId=AZVqPrHaAy_HBIOy&categoryId=AZVqPrHaAy_HBIOy&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=5&pageSize=10&pageIndex=1

// 처음에는 그냥 L, R, ? 개수 세서 L-R 절대값 해서 ? 더해주면 될거라고 생각했다.
// 하지만 테스트케이스의 3번째가 결과값이 제대로 출력이 안 된다는 것을 깨닫고
// 문자열을 돌때마다 L, R에 따른 값을 증감하고 마지막에 절대값 취해서 ?에 대해서 값을 계산해야겠다.

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class week3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        sc.nextLine();


        for(int test_case = 0; test_case < T; test_case++) {
            String str = sc.nextLine();

            // 1. '?'을 모두 R로 가정한 이동 경로
            int posR = 0, maxR = 0, minR = 0;
            for (char c : str.toCharArray()) {
                if (c == 'R' || c == '?') posR++;
                else posR--;
                maxR = Math.max(maxR, posR);
                minR = Math.min(minR, posR);
            }

            // 2. '?'을 모두 L로 가정한 이동 경로
            int posL = 0, maxL = 0, minL = 0;
            for (char c : str.toCharArray()) {
                if (c == 'L' || c == '?') posL--;
                else posL++;
                maxL = Math.max(maxL, posL);
                minL = Math.min(minL, posL);
            }

            // 정답은 두 경로의 최대위치/최소위치 차이 중 큰 값
            int ans = Math.max(maxR - minR, maxL - minL);
            System.out.println(ans);

        }
    }
}

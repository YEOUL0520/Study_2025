import java.util.Arrays;
import java.util.Scanner;

public class testlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {

            int N = sc.nextInt();

            int[] buildings = new int[N];
            for(int i = 0; i < N; i++){
                buildings[i] = sc.nextInt();
            }

            int totalView = 0;
            for(int i = 2; i < N - 2; i++) {
                int left1 = buildings[i - 2];
                int left2 = buildings[i - 1];
                int right1 = buildings[i + 2];
                int right2 = buildings[i + 1];

                int maxbuildings = Math.max( Math.max(left1, left2), Math.max(right1, right2));

                if(maxbuildings < buildings[i]){
                    totalView += buildings[i] - maxbuildings;
                }
            }
            System.out.println("#" +test_case +" " + totalView);

        }

    }
}

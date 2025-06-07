import java.util.Scanner;
import java.io.FileInputStream;

class week3_3
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();

		for(int test_case = 0; test_case < T; test_case++) {
            String s = sc.nextLine();
            int sum = 0;
            int maxSum = 0;
            int qCount = 0;

            for(int c = 0; c < s.length(); c++) {
                char ch = s.charAt(c);
                if(ch == 'L') {
                    sum--;
                }else if(ch == 'R') {
                    sum++;
                }else if(ch == '?'){
                    qCount++;
                }
                // ? 를 L 이라고 가정
                int left = Math.abs(sum-qCount);
                // ? 를 R 이라고 가정
                int right = Math.abs(sum+qCount);

                maxSum = Math.max(maxSum, Math.max(left, right));

            }
            System.out.println(maxSum);
        }
	}
}

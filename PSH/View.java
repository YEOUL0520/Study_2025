import java.util.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] result=new int[10];
		
		for(int t=0;t<10;t++) { //총10개의 테스트케이스
			int N=sc.nextInt(); //건물의 개수
			int[] height=new int[N];
			
			for (int i = 0; i < N; i++) {
                height[i] = sc.nextInt();
            }
			
			int viewCount = 0;//조망권 확보 세대 수
			
			for (int i = 2; i < N - 2; i++) {
				//처음에 삼항연산자[n-1],[n+1]로 비교하려고 했는데 너무 복잡해짐...
				//비교+max를 구해야해서 Math.max로 최대값 구한다
				//어차피 max<현재높이니까 max를 구하고 비교
                int leftMax = Math.max(height[i - 1], height[i - 2]);
                int rightMax = Math.max(height[i + 1], height[i + 2]);
                int neighborMax = Math.max(leftMax, rightMax);

                if (height[i] > neighborMax) {
                    viewCount += height[i] - neighborMax;
                }
            }
			result[t] = viewCount;
			System.out.println("#"+(t+1)+" "+result[t]);
		}
	}
}

public class View {
	public static void main(String[] args) {

	}
}

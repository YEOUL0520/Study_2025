package newpj;

import java.util.*;
//나이순정렬
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();//회원수
		//1차원 배열? 2차원 배열?
		String[][] str=new String[N][2];
		for(int i=0;i<N;i++) {
			str[i][0]=sc.next();//나이
			str[i][1]=sc.next();//이름
		}
		//오름차순. 반환값이 0이면 그대로이기 때문에 가입한 순서 그대로.
		Arrays.sort(str, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
			}
		});
		for(int i=0;i<N;i++) {
			System.out.println(str[i][0]+" "+str[i][1]);
		}
	}
}

import java.util.*;

//Scanner와 Stringbuilder 의 차이?? 뭐가 더 낫지
//배열로 다 처리하려고 함.
//맵 정렬로 그냥 처리하는게 나을지도?
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] grade = {
        			"A+", "A0", "A-", 
        			"B+", "B0","B-", 
        			"C+", "C0", "C-", "D0"
        			};

        int T = sc.nextInt();//테스트케이스 수

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();//학생수, 10의배수
            int K = sc.nextInt();//K번째 학생

            Map<Integer, Double> scoreMap = new HashMap<>();//인덱스,점수
            for (int i = 1; i <= N; i++) {
                int mid = sc.nextInt();//중간
                int fin = sc.nextInt();//기말
                int hw = sc.nextInt();//과제
                double total = mid * 0.35 + fin * 0.45 + hw * 0.2;
                scoreMap.put(i, total);
            }

            //정렬을 위해 List에 옮김. Map은 기본적으로 key로 value를 빠르게 찾기 위함(검색용)
            //Map은 순서X,정렬도X -> 점수기준 정렬하려면 List로 변환 
            
            List<Map.Entry<Integer, Double>> list = new ArrayList<>(scoreMap.entrySet());
            //.entrySet() 사용 이유 : Map은 for-each로 직접 돌릴수X, entrySet()으로 전체 순회O
            //key와 value 한 쌍씩 묶은 Set 반환([(1=A),(2=B),...])
            //맵 정렬/전체순회할 때 사용
            //Set도 정렬불가능. List로 변환 후 정렬을 해야한다. 맵은 리스트로 바로 변환X
            //List는 .sort를 지원
            
            //람다식으로 내림차순 정렬
            //Map.Entry는 기본적으로 정렬기준X. 그래서 Comparator 직접 지정
            
            list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
            //.compare(a,b) 오름차순(디폴트)  a<b ->return-1(작은값이 음수 반환. 앞으로 온다.오름차순)
            //.compare(b,a) 내림차순        a>b ->return1

            int gradeGroupSize = N / 10;
            Map<Integer, String> gradeResult = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                int studentNo = list.get(i).getKey();
                gradeResult.put(studentNo, grade[i / gradeGroupSize]);
            }

            System.out.println("#" + t + " " + gradeResult.get(K));
        }
    }
}


public class grading {
	public static void main(String[] args) {

	}
}

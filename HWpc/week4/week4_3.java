// 4주차 상 요세푸스
package week4;

import java.util.*;

public class week4_3 {
//    // queue ver
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//
//        Queue<Integer> q = new LinkedList<>();
//        for(int i = 0; i < N; i++){
//            q.add(i+1);
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        while(!q.isEmpty()){
//            for(int i = 0; i < K - 1; i++){
//                q.add(q.poll()); // 앞에서 꺼낸 다음 뒤로 보냄
//            }
//            result.add(q.poll()); // k번째 제거
//        }
//        System.out.print("<");
//        for(int i = 0; i < result.size(); i++){
//            System.out.print(result.get(i));
//            if (i != result.size()-1){ System.out.print(", "); }
//        }
//        System.out.println(">");
//
//    }
    // list + index 계산
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> people = new ArrayList<>();
        for(int i = 0; i < n; i++){
            people.add(i+1);
        }

        List<Integer> result = new ArrayList<>();
        int idx = 0;

        while(!people.isEmpty()){
            idx = (idx + k-1) % people.size();  // 순환 인덱스 계산
            result.add(people.remove(idx)); // 해당 인덱스 제거
        }

        // 결과출력
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) System.out.print(", ");
        }
        System.out.println(">");

    }

}

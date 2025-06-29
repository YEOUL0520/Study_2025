package HWfolder.week4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Solution{
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++){
            if(attendance[i] == true){
                list.add(new int[]{rank[i], i});    // rank와 원래 인덱스 저장
            }
        }
        // rank 기준으로 오름차순 정렬
        list.sort(Comparator.comparingInt(a -> a[0]));
        
        int a = list.get(0)[1]; // 1등 인덱스
        int b = list.get(1)[1]; // 2등 인덱스
        int c = list.get(2)[1]; // 3등 인덱스

        return 10000 * a + 100 * b + c;
    }
}

public class GlobalContest {
    public static void main(String[] args) {
        int[] rank_arr = new int[] {3, 7, 2, 5, 4, 6, 1 };
        boolean[] attendance_arr = new boolean[] {false, true, true, true, true, false, false };
        
        Solution solution = new Solution();
        

        System.out.println(solution.solution(rank_arr, attendance_arr));

        
    }
}

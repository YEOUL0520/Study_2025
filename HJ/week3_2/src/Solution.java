import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {

        //일단 정렬을 하자
        Arrays.sort(people);

        int light = 0; //정렬 했으니까 가벼운 사람이 젤 먼저
        int heavy = people.length - 1;  //무거운 사람이 맨 끝
        int boat = 0; //구명보트 수 카운트

        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                //둘 다 들어갈 수 있음
                light++;
                heavy--;
            } else {
                heavy--;
            }
            boat++;
        }
        return boat;
    }
}
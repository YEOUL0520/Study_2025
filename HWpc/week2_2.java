// 처음에는 ArrayList랑 반복문으로 어떻게든 구현되지 않을까 했는데, 평점 출력하는 곳에서 막혀서 
// 새로운 접근법을 생각해보았다. 그래서 일단 학생 정보를 저장할 클래스를 하나 만들고 
// 리스트와 배열을 사용해서 입.출력을 제어했다.
// 처음에는 1개의 케이스별로 출력이 나오도록 중첩 반복문을 사용해서 접근을 했는데,
// 계속 문제가 틀렸다고 떠서 입력과 출력을 분리해서 각각 모두 출력하도록 바꿔야겠다고 생각했다.
// 그래서 테스트 케이스 별로 결과들을 배열에 넣어서 마지막에 따로 출력값들을 보일 수 있도록 바꾸었다.

//package HWjava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// [2주차] 조교의 성적 매기기 / 중
// "https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&contestProbId=AV5PwGK6AcIDFAUq&categoryId=AV5PwGK6AcIDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=JAVA&select-1=2&pageSize=10&pageIndex=2"
public class week2_2 {
    // 학생 정보를 저장할 클래스
    static class Student implements Comparable<Student>{
        int index;      // 학생의 입력 순번
        double score;   // 총점(중간 35% 기말 45% 과제 20%)
        
        // 매개변수 생성자 
        public Student(int index, double score){
            this.index = index;
            this.score = score;
        }
        // 정렬 기준 : 총점 내림차순 (score가 높은 학생이 먼저)
        @Override
        public int compareTo(Student other){
            return Double.compare(other.score, this.score);
        }

    }


    public static void main(String args[]) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        String[] grades = {
            "A+", "A0", "A-", "B+", "B0", "B-", "C+",
            "C0", "C-", "D0"
        };

        // 각 테스트 케이스별로 학생 수와, 등급 알고 싶은 학생 번호 저장
        int[] Ns = new int[T];
        int[] Ks = new int[T];
        // 학생 전체 점수 리스트 저장용
        List<List<Student>> allExams = new ArrayList<>();

        // 입력 전체 저장
        for (int t = 0; t < T; t++) {
            Ns[t] = scanner.nextInt();
            Ks[t] = scanner.nextInt();
            List<Student> exam = new ArrayList<>();
            // N명의 학생에 대한 점수 입력 받기
            for (int i = 1; i <= Ns[t]; i++) {
                int mid = scanner.nextInt();
                int fin = scanner.nextInt();
                int task = scanner.nextInt();
                // 총점 계산
                double totalscore = mid * 0.35 + fin * 0.45 + task * 0.2;
                // 리스트에 학생 객체 추가
                exam.add(new Student(i, totalscore));
            }
            // 각 테스트케이스별 학생 점수 리스트 저장 
            allExams.add(exam);
        }

        // 출력용 결과 배열 선언
        String[] outputs = new String[T];

        // 입력을 모두 받은 후, 각 테스트케이스 처리 
        for (int t = 0; t < T; t++) {
            int N = Ns[t];
            int K = Ks[t];
            List<Student> exam = allExams.get(t);
            Collections.sort(exam); // 총점 내림차순 정렬
            
            // K번 학생이 정렬 후 몇 번째(0-based 인덱스)에 위치하는지 찾기
            int targetIndex = 0;
            for (int i = 0; i < N; i++) {
                if (exam.get(i).index == K) {
                    targetIndex = i;
                    break;
                }
            }
            // 전체를 10등분하여 등급 인덱스 계산
            int gradeIndex = targetIndex * 10 / N;
            // 혹시 등급 배열을 넘어갈 경우 마지막 등급(D0)로 고정
            if (gradeIndex >= 10) gradeIndex = 9;
            // 출력용 문자열 저장 (케이스 번호는 1부터 시작)
            outputs[t] = String.format("#%d %s", t + 1, grades[gradeIndex]);
        }

        // 모든 출력 한 번에 출력
        for (String out : outputs) {
            System.out.println(out);
        }
    }
}

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;

class Solution
{
    // 학생 구조체 생성해서 순번이랑 총점 저장하기
    static class Student {
        int idx;
        double totalScore;
        public Student(int idx, double totalScore) {
            this.idx = idx;
            this.totalScore = totalScore;
        }
    }

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("input.txt"));
        //System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt() - 1; // 0-based index

            // 학생 점수 계산 및 저장
            double[] scores = new double[N];
            for (int i = 0; i < N; i++) {
                double m = sc.nextInt();
                double f = sc.nextInt();
                double a = sc.nextInt();
                scores[i] = m * 0.35 + f * 0.45 + a * 0.20;
            }

            // Max Heap 생성 (총점 내림차순)
            PriorityQueue<Student> maxHeap = new PriorityQueue<>((s1, s2) -> Double.compare(s2.totalScore, s1.totalScore));

            for (int i = 0; i < N; i++) {
                maxHeap.offer(new Student(i, scores[i]));
            }

            // Heap에서 순위별로 꺼내며 등수 계산
            int rank = 0;
            int K_rank = -1;
            while (!maxHeap.isEmpty()) {
                Student s = maxHeap.poll();
                if (s.idx == K) {
                    K_rank = rank;
                    break; // K번째 학생의 순위를 찾았으면 종료
                }
                rank++;
            }

            // 총 등급 단계가 10개
            int gradeIndex = K_rank * 10 / N;
            System.out.printf("#%d %s\n", test_case, grades[gradeIndex]);
        }
    }
}
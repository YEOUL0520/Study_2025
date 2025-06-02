/*나이, 이름 가입 순으로 주어짐
나이 오름차순, 같을 경우 먼저 가입한 순으로 정렬*/

/*첫째 줄에 주어지는 회원 수 N => malloc으로 구현
나이비교 => compare함수 사용*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct 
{
    int age;
    char name[101];
    int index;
} Member;

int compare(const void *a, const void *b) 
{
    Member *m1 = (Member *)a;
    Member *m2 = (Member *)b;

    if (m1->age != m2->age)
        return m1->age - m2->age;
    else
        return m1->index - m2->index;
}

int main() 
{
    unsigned int N;
    scanf("%d", &N); //

    Member *members = (Member *)malloc(sizeof(Member) * N);

    for (int i = 0; i < N; i++) {
        scanf("%d %s", &members[i].age, members[i].name);
        members[i].index = i;  // 가입 순서 저장
    }

    qsort(members, N, sizeof(Member), compare);

    for (int i = 0; i < N; i++) {
        printf("%d %s\n", members[i].age, members[i].name);
    }

    free(members);
    return 0;
}

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 순위 계산 함수
int rank(int match_count)
{
    return (match_count >= 2) ? (7-match_count) : 6;
}

// lottos_len은 배열 lottos의 길이입니다.
// win_nums_len은 배열 win_nums의 길이입니다.
int* solution(int lottos[], size_t lottos_len, int win_nums[], size_t win_nums_len) {
    int zero = 0;
    int matched = 0;
    
    int i = 0;    
    while(lottos != NULL && i < lottos_len)
    {
        if (lottos[i] == 0)
            zero++;
        i++;
    }
    
    i = 0;
    while(lottos != NULL && i < lottos_len)
    {
        if(lottos[i] != 0)
        {
            int j = 0;
            while(win_nums != NULL && j < win_nums_len)
            {
                if(lottos[i] == win_nums[j])
                    matched++;
                j++;
            }
        }
        i++;
    }
     
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int)*2);
    if (answer == NULL)
        return 0;
    answer[0] = rank(zero+matched); // 최고 순위
    answer[1] = rank(matched); // 최저 순위
    
    return answer;
}
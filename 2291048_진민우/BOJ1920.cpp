#include <iostream>
#include <stdio.h>
#include <algorithm>

using namespace std;

bool comp(int a, int b) {
    return a < b; //오름차순으로 정렬
}

/*이진 탐색*/
int BinarySearch(long long arr[], long long target, int length) {
    int high = length - 1;
    int low = 0;
    int mid;

    while (low <= high) {
        mid = (low + high) / 2;

        if (arr[mid] == target) {
            return 1;
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else if (arr[mid] < target) {
            low = mid + 1;
        }
    }
    return 0;
}

/*속도때문에 scanf와 printf사용*/
int main(void) {
    int N;
    int M;

    scanf("%d", &N);

    long long arr1[N];
    for (int i = 0; i < N; i++) {
        scanf("%lld", &arr1[i]);
    }
    sort(arr1, arr1 + N, comp); //오름차순으로 정렬
    int size_N = sizeof(arr1) / sizeof(arr1[0]); //배열의 길이 구함

    scanf("%d", &M);

    long long arr2[M];
    for(int i = 0; i < M; i++) {
        scanf("%lld", &arr2[i]);
    }

    for(int i = 0; i < M; i++) {
        if(BinarySearch(arr1, arr2[i], size_N) == 1) {
            printf("1\n");
        }
        else if(BinarySearch(arr1, arr2[i], size_N) == 0){
            printf("0\n");
        }
    }
}
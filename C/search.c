#include<stdio.h>

int main(){
    int arr[] = {1, 4, 5, 8, 11, 15};
    int len = sizeof(arr) / sizeof(int);
    int i, idx = -1, key = 11;

    // Linear Search
    // for(i = 0; i < len; i++){
    //     if(arr[i] == key){
    //         idx = i;
    //         break;
    //     } 
    // }
    
    // Binary Search
    // int low = 0, high = len - 1;
    // while(low <= high){
    //     int mid = (low + high) / 2;

    //     if(arr[mid] == key){
    //         idx = mid;
    //         break;
    //     }else if(arr[mid] > key){
    //         high = mid - 1;
    //     }else{
    //         low = mid + 1;
    //     }
    // }

    // (Linear) Interpolation Search
    int low = 0, high = len - 1;
    while(low <= high && key >= arr[low] && key <= arr[high]){
        if(low == high){
            idx = -1;
            break;
        }

        int pos = low + (
            (key - arr[low]) * (high - low) / 
            (arr[high] - arr[low])
        );

        if(arr[pos] == key){
            idx = pos;
            break;
        }else if(arr[pos] > key){
            high = pos - 1;
        }else{
            low = pos + 1;
        }
    }

    if(idx != -1) printf("Data found at index %d\n", idx);
    else printf("Data not found\n");

    return 0;
}
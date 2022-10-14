#include<stdio.h>

void multiply(int array1[4][4], int array2[4][4], int mul[4][4]){
    int i, j, k;

    for(i = 0; i < 4; i++){
        for(j = 0; j < 4; j++){
            mul[i][j] = 0;
            for(k = 0; k < 4; k++){
                mul[i][j] += array1[i][k] * array2[k][j];
            }
        }
    }

    for(i = 0; i < 4; i++){
        for(j = 0; j < 4; j++){
            printf("%d", mul[i][j]);
            printf("\t");
        }
        printf("\n");
    }
}

int main(){
    int array1[4][4];
    int array2[4][4];
    int mul[4][4];

    int i, k;

    printf("Enter first matrix elements: \n");
    for(i = 0; i < 4; i++){
        for(k = 0; k < 4; k++){
            scanf("%d", &(array1[i][k]));
        }
    }

    printf("\nEnter second matrix elements: \n");    
    for(i = 0; i < 4; i++){
        for(k = 0; k < 4; k++){
            scanf("%d", &(array2[i][k]));
        }
    }
    printf("\n");

    multiply(array1, array2, mul);

    return 0;
}
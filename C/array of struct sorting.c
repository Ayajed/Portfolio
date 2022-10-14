#include<stdio.h>
#include<string.h>

typedef struct Mhs{
    char nim[11];
    char name[20];
    double ipk;
} Mhs;

int main(){
    int i, j;
    double temp;
    char nimSwap[11], nameSwap[20];
    Mhs mhs[10];

    for(i = 0; i < 10; i++){
        printf("#%d\n", i+1);
        printf("NIM: ");
        scanf("%s", mhs[i].nim);
        printf("Name: ");
        scanf("%s", mhs[i].name);
        printf("IPK: ");
        scanf("%lf", &mhs[i].ipk);
    }

    for(i = 0; i < 10; i++){
        for(j = i+1; j < 10; j++){
            if(mhs[i].ipk > mhs[j].ipk){
                temp = mhs[i].ipk;
                mhs[i].ipk = mhs[j].ipk;
                mhs[j].ipk = temp;

                strcpy(nimSwap, mhs[i].nim);
                strcpy(mhs[i].nim, mhs[j].nim);
                strcpy(mhs[j].nim, nimSwap);

                strcpy(nameSwap, mhs[i].name);
                strcpy(mhs[i].name, mhs[j].name);
                strcpy(mhs[j].name, nameSwap);
            }
        }
    }

    printf("\n");
    printf("================================\n");
    printf("IPK\t   NIM       \tName\n");
    printf("================================\n");
    for(i = 0; i < 10; i++){
        printf("%.2lf\t%s\t%s\n", mhs[i].ipk, mhs[i].nim, mhs[i].name);
    }
    printf("================================\n");

    return 0;
}
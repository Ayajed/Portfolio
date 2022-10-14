#include<stdio.h>
#include<string.h>

void reverse(char a[50]){
    int len, i;

    len = strlen(a);

    for(i = 0; i <= len; i++){
        printf("%c", a[len - i]);
    }
    printf("\n");
}

int main(){
    char a[50];

    fgets(a, sizeof(a), stdin);

    reverse(a);
    
    return 0;
}
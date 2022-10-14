#include<stdio.h>
#include<string.h>

void reverse(char x[1000]){
    int len, i;
    static int number = 1;

    len = strlen(x);

    printf("Case #%d: ", number);
    for(i = 0; i <= len; i++){
        printf("%c", x[len - i]);
    }
    printf("\n");

    number++;
}

int main(){
    int input, i;
    char x[1000];

    scanf("%d", &input);

    if(input >= 1 && input <= 100){
        for(i = 0; i < input; i++){
            scanf("%s", x);
            reverse(x);
        }
    }else printf("Only input number between 1 and 100");
    
    return 0;
}
#include<stdio.h>
#include<string.h>

typedef struct Fruits {
    char fruitName[20];
} Fruits;

int main() {
    int i, j;
    char temp[20];
    Fruits fruits[10];

    strcpy(fruits[0].fruitName, "Durian");
    strcpy(fruits[1].fruitName, "Apple");
    strcpy(fruits[2].fruitName, "Grape");
    strcpy(fruits[3].fruitName, "Orange");
    strcpy(fruits[4].fruitName, "Guava");
    strcpy(fruits[5].fruitName, "Kiwi");
    strcpy(fruits[6].fruitName, "Watermelon");
    strcpy(fruits[7].fruitName, "Cherry");
    strcpy(fruits[8].fruitName, "Pear");
    strcpy(fruits[9].fruitName, "Avocado");

    for(i = 0; i < 10; i++) {
        for(j = i+1; j < 10; j++) {
            if(strncmp(fruits[i].fruitName, fruits[j].fruitName, 2) > 0) {
                strcpy(temp, fruits[i].fruitName);
                strcpy(fruits[i].fruitName, fruits[j].fruitName);
                strcpy(fruits[j].fruitName, temp);
            }
        }
    }
    
    for(i = 0; i < 10; i++) {
        printf("%s\n", fruits[i].fruitName);
    }

    return 0;
}
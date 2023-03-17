Given a number P which is of integer type. Print the resultant array result[] 
of size P+1, such that for each index I ( 0 <= I <= P), result[I] is the number 
of 1's in the binary represenation of I.

Input Format
-------------
Read an integer P.

Output Format
--------------
Number of 1's in the binary form of each index in the resultant array result[].


Sample input-1:
---------------
6

Sample output-1:
----------------
0 1 1 2 1 2 2

Explanation:
------------
Binary form of 0 is 0
Binary form of 1 is 1
Binary form of 2 is 10
Binary form of 3 is 11
Binary form of 4 is 100
Binary form of 5 is 101
Binary form of 6 is 110


Sample input-2:
---------------
3

Sample output-2:
----------------
0 1 1 2

Explanation:
------------
Binary form of 0 is 0
Binary form of 1 is 1
Binary form of 2 is 10
Binary form of 3 is 11

    

    
    
    
#include<bits/stdc++.h>

using namespace std;

// int main(){
//     int p;
//     cin >> p;
//     int arr[p + 1];
//     for (int i = 0; i <= p; i++) {
//         arr[i] = __builtin_popcount(i);
//     }
//     for (int i = 0; i <= p; i++) {
//         cout << arr[i] << " ";
//     }
//     return 0;
// }


int main(){
    int p;
    cin >> p;
    int arr[p + 1];
    for (int i = 0; i <= p; i++) {
        arr[i] = 0;
    }
    for (int i = 1; i <= p; i++) {
        if(i % 2 == 0){
            arr[i] = arr[i/2];
        }
        else{
            arr[i] = arr[i - 1] + 1;
        }
    }
    for (int i = 0; i <= p; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}

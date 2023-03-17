Given a matrix of dimension rows X cols with the elements 0's and 1's,

Your task is to convert all matrix elements to 0's by following 
the condition given below.

The condition is, in every operation, you could select any 
row or any column of the given matrix and toggle each element 
in that row or column.

Note: Toggle means changing all 0's to 1's and all 1's to 0's.

Print true if you could change all matirix elements to 0's 
by following given condition else print false.


Input Format
-------------
Line-1: Read two integers rows and cols(space separated).
Line-2: Read the matrix of dimension rows X cols.

Output Format
--------------
Print a boolean result.



Sample input-1:
---------------
5 5
0 0 1 0 0
0 0 1 0 0
1 1 0 1 1
0 0 1 0 0
0 0 1 0 0

Sample output-1:
----------------
true

Explanation:
------------
0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
0 0 1 0 0   row-3  0 0 1 0 0   cols-3  0 0 0 0 0
1 1 0 1 1   --->   0 0 1 0 0   --->    0 0 0 0 0
0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
0 0 1 0 0          0 0 1 0 0           0 0 0 0 0 


Sample input-2
--------------
2 2
1 1
0 1

Sample output-2
---------------
false


#include<bits/stdc++.h>
using namespace std;


int main() {
    int row, col;
    cin >> row >> col;
    int mat[row][col];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            cin >> mat[i][j];
        }
    }
    for (int i = 0; i < row - 1; i++) {
        int xorSum = 0; 
        for (int j = 0; j < col; j++) {
            xorSum += mat[i][j] ^ mat[i+1][j];
        }
        if(xorSum != col && xorSum != 0){ 
            cout << "false" << endl;
            return 0;
        }
    }
    cout << "true" << endl;
    return 0;
}

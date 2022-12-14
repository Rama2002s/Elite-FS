There are chocolate packets given to students in a class. Each packet have 
different number of chocolates. They arrange packets in a square grid form. You 
have to find the sum of the total chocolates in the packets found at diagonals.

Do the  sum of all the chocolates in the packets on the primary diagonal and 
all the chocolates in the packets on the secondary diagonal that are not part 
of the primary diagonal.

Input Format
-------------
Line 1: M and N, two space separated integers
Next M lines: N space separated integers, the square grid

Output Format
--------------
An integer which is sum of diagonal elements


Sample Input-1:
---------------
3 3
7 8 9
4 5 6
1 2 3

Sample Output-1:
----------------
25

Explanation:
------------
Diagonals sum: 7+5+3+9+1 = 25
Notice that element matrix[1][1] = 5 is counted only once.


Sample Input-2:
---------------
2 2    
1 1
1 1

Sample Output-2:
----------------
4

    
#include <bits/stdc++.h>
using namespace std;


int diagSum(vector<vector<int>> mat, int rows, int cols){
    int ans = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if(i == j){
                ans += mat[i][i];
            }
            else if(i + j == cols - 1){
                ans += mat[i][j];
            }
        }
    }
    return ans;
}
int main(){
    int rows , cols;
    cin >> rows >> cols;
    vector<vector<int>> mat(rows,vector <int>(cols,0));
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cin >> mat[i][j];
        }
    }
    cout << diagSum(mat,rows,cols);
    
    
}

You will be given the matrix of size R*C,

You have to return the matrix in special order as shown in the sample tescases.
 

Input Format:
-------------
Line-1 -> Two integers R and C, size of matrix.
Next R-Lines -> C space separated integers

Output Format:
--------------
Print R-Lines -> C space separated integers, in special order.


Sample Input-1:
---------------
3 3
1 2 3
4 5 6
7 8 9

Sample Output-1:
----------------
1 2 3
6 9 8
7 4 5


Sample Input-2:
---------------
3 4
1 2 3 4
5 6 7 8
9 10 11 12

Sample Output-2:
----------------
1 2 3 4
8 12 11 10
9 5 6 7


#include <bits/stdc++.h>
using namespace std;

vector<int> specialOrder(vector<vector<int>>& matrix, int r, int c) {
    vector<int> result;

    int top = 0, left = 0, bottom = r - 1, right = c - 1;

    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) {
            result.push_back(matrix[top][i]);
        }
        top++;
        for (int i = top; i <= bottom; i++) {
            result.push_back(matrix[i][right]);
        }
        right--;
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result.push_back(matrix[bottom][i]);
            }
            bottom--;
        }
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.push_back(matrix[i][left]);
            }
            left++;
        }
    }
    return result;
}

int main() {
    int r, c;
    cin >> r >> c;
    vector<vector<int>> matrix(r, vector<int>(c, 0));

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> matrix[i][j];
        }
    }

    vector<int> result = specialOrder(matrix, r, c);
    int ind = 0;
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
        ind++;
        if (ind == c) {
            cout << endl;
            ind = 0;
        }
    }

    return 0;
}

 


 

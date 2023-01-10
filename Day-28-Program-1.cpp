The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
	- You can start at any position in the grid, never visit a cell with no gold.
	- each time you visit a cell, you will grab all the gold in it.
	- You can move one step to the left, right, up or down.
	- You can't visit the same cell more than once.
	- You can stop at any cell.
	
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
0 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.

Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7

    
#include <bits/stdc++.h>

using namespace std;

int res = 0, temp = 0;

void backtrack(int mat[][1001], int row, int col, int m, int n) {
    temp += mat[row][col];
    int val = mat[row][col];
    res = max(res, temp);
    mat[row][col] = 0;
    int updates[4][2] = {
        {-1, 0},{ 0,-1},{1, 0},{0,1}
    };
    for (int i = 0; i < 4; i++) {
        int nr = row + updates[i][0];
        int nc = col + updates[i][1];
        if (0 <= nr && nr < m && 0 <= nc && nc < n) {
            if (mat[nr][nc] != 0) {
                backtrack(mat, nr, nc, m, n);
            }
        }
    }
    mat[row][col] = val;
    temp -= val;
}

int main() {
    int m, n;
    cin >> m >> n;
    int mat[1001][1001];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> mat[i][j];
        }
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] != 0) {
                temp = 0;
                backtrack(mat, i, j, m, n);
            }
        }
    }
    cout << res << endl;
    return 0;
}

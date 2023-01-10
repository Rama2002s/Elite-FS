Due to covid restrictions, the metro rail management decides that no two 
passengers sit next to each other. There are N seats each side of the metro rail. 
Each seat is numbered from 1 to N. In one seat only one passenger can sit.

A passenger can choose either to sit on a seat or stand.

Your task is to find the number of ways, the passengers can sit, such that 
no two passengers sit adjacent to each other on the same side of the metro rail.

NOTE:
-----
if a passenger is sit on the i-th seat on one side of the rail,
a passenger can also be sit on the i-th seat on the other side of the rail.


Input Format:
-------------
An integer N, number of seats in each side.

Output Format:
--------------
Print an integer result, the result should be 1000000007


Sample Input-1:
---------------
1

Sample Output-1:
----------------
4

Explanation:
------------
Possible arrangements:
1)  _

    _

2)  P

    _


3)  _

    P

4)  P

    P
Here, '_' -> empty seat
'P' -> seat occupied by a passenger.



Sample Input-2:
---------------
2

Sample Output-2:
----------------
9

Explanation:
------------
Possible arrangements:
1)  _ _

    _ _

2)  P _

    _ _


3)  _ P

    _ _

4)  _ _

    P _
    
5)  _ _

    _ P

6)  P _

    P _


7)  _ P

    P _

8)  P _

    _ P
    
9)  _ P

    _ P
    


#include <bits/stdc++.h>

using namespace std;

const int mod = 1000000007;
long dp[2][1001];

long backtrack(int n, bool prev) {
    if (n == 0) {
        return 1;
    }

    int k = 0;
    if (prev == false) {
        k = 1;
    }

    if (dp[k][n] != -1) {
        return dp[k][n];
    }
    long res = 0;
    if (prev == false) {
        res = (res + backtrack(n - 1, true)) % mod;
    }
    res = (res + backtrack(n - 1, false)) % mod;
    return dp[k][n] = res;
}

int main() {
    memset(dp, -1, sizeof(dp));
    int n;
    cin >> n;
    long res = backtrack(n, false);
    cout << (res * res) % mod << endl;
    return 0;
}

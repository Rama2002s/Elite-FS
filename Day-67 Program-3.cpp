Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I, 0 <= I <= 10^9

Output Format:
--------------
Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
    
    
    

#include <bits/stdc++.h>
using namespace std;

string toBBC(int n) {
    if (n == 0) {
        return "";
    } else if (n % 2 == 1) {
        return toBBC(n/2) + "0";
    } else {
        return toBBC((n-2)/2) + "1";
    }
}

int main() {
    int n;
    cin >> n;
    cout << toBBC(n) << endl;
    return 0;
}

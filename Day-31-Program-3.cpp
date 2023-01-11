There are n cartons of binary string of lenght n, where carton[i] is '0' if the ith
carton is empty and '1' if it contains one product.

In one operation, you can move one product from a carton to an adjacent carton.
cartoon i is adjacent to carton j if abs(i - j) == 1. Note that after doing so, there
may be more than one product in some cartons.

Return an array answer of size n, where answer[i] is the minimum number of operations
needed to move all the products to the ith carton

Each answer[i] is calculated considering the initial state of the cartons.


Input Format
------------
A string of zeroes and ones

Output Format
-------------
An integer array which is minimum no of operations

Example 1:

Input: cartons = "110"
Output: 1 1 3
Explanation: The answer for each cartoon is as follows:
1) First carton: you will have to move one product from the second carton to the first
carton in one operation.
2) Second carton: you will have to move one product from the first carton to the second 
carton in one operation.
3) Third carton: you will have to move one product from the first carton to the third carton 
in two operations, and move one product from the second product to the third carton in
one operation.

Example 2:

Input: cartoons = "001011"
Output: 11 8 5 4 3 4 

  
    
    
    
    
#include <bits/stdc++.h>
using namespace std;

void calculateCartons(string s, int n, int* left, int* right) {
    int cartons = 0;
    if (s[0] == '1') {
        cartons = 1;
    }

    for (int i = 1; i < n; i++) {
        left[i] = left[i-1] + cartons;
        if (s[i] == '1') {
            cartons += 1;
        }
    }

    cartons = 0;
    if (s[n-1] == '1') {
        cartons = 1;
    }
    for (int i = n-2; i >= 0; i--) {
        right[i] = right[i+1] + cartons;
        if (s[i] == '1') {
            cartons += 1;
        }
    }
}

int main() {
    string s;
    cin >> s;
    int n = s.length();
    int left[n];
    int right[n];
    for (int i = 0; i < n; i++) {
        left[i] = right[i] = 0;
    }
    calculateCartons(s,n,left,right);

    for (int i = 0; i < n; i++) {
        int q = left[i] + right[i];
        cout << q << " ";
    }
    return 0;
}


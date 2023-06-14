Siddu wants to get some rain coats before the rainy season begins. 
There are N rain coats in a store. He is provided an array price[], 
where price[i] represents the dollar price of the i-th rain coat. 
Siddu has D dollars to spend, and he wants to buy as many rain coats as 
he can to give to his family and friends as gifts.
Your task is to assist Siddu in purchasing the most number of rain coats 
possible using D dollars.

Note: Siddu can purchase the rain coats in any order.

Input Format:
-------------
Line-1: Two space separated integers, N and D
Line-2: N space separated integers, prices of N rain coats.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 15
6 12 7 5 13 10 1

Sample Output-1:
----------------
3

Explanation:
------------
Siddu purchases Rain coats with price [1$, 5$, 7$] or [1$, 6$, 7$] or [1$, 5$, 6$].


Sample Input-2:
---------------
10 3
15 13 11 4 11 5 9 14 14 5

Sample Output-2:
----------------
0

Explanation:
------------
Siddu can't purchase any rain coat, because he has only 3$s with him.




#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,d;
    cin >> n >> d;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    priority_queue<int, vector<int>, greater<int>> pq;
    for (auto i : arr) {
        pq.push(i);
    }
    int count = 0;
    while(d >0 ){
        d = d - pq.top();
        pq.pop();
        if(d >= 0)
            count++;
    }
    cout << count;
}


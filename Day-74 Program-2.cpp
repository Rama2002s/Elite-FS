Kittu playing a game, the game contains a panel of N cells.
Each cell in the panel is a number panel[i], 
Kittu will win when he reaches 0.

The rules to play the game are as follows:
	- Kittu's intital position is S.
	- When Kittu is at index i, he can move to position-(i + panel[i] ) or 
	position-(i - panel[i]).
	- Kittu cannot move outside the panel.
	- if he reaches any panel[i] has value 0, He wins.	

Your task to find that whether kittu wins or not.
if he wins print "true".
if there is no way to reach 0 then print "false".

NOTE: cell positions are numbered from 0 to N-1.
0<= panel[i] < N


Input Format:
-------------
Line-1: Two integers N and S, number of cells in the panel and 
		Kittu's initial position.
Line-2: N space separated integers.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
7 5
4 2 3 0 3 1 2

Sample Output-1:
----------------
true

Explanation: 
------------
All possible ways to reach at position 3 with value 0 are: 
position 5 -> position 4 -> position 1 -> position 3 
position 5 -> position 6 -> position 4 -> position 1 -> position 3 


Sample Input-2:
---------------
5 2
3 0 2 1 2

Sample Output-2:
----------------
false


#include <bits/stdc++.h>

using namespace std;

bool winnable(int n, int s, vector<int>& panels) {
    unordered_set<int> visited;
    queue<int> bfsQ;
    bfsQ.push(s);
    
    while (!bfsQ.empty()) {
        int curr = bfsQ.front();
        bfsQ.pop();
        
        if (panels[curr] == 0) {
            return true;
        }
        
        if (curr + panels[curr] < n && visited.find(curr + panels[curr]) == visited.end()) {
            visited.insert(curr + panels[curr]);
            bfsQ.push(curr + panels[curr]);
        }
        if (curr - panels[curr] >= 0 && visited.find(curr - panels[curr]) == visited.end()) {
            visited.insert(curr - panels[curr]);
            bfsQ.push(curr - panels[curr]);
        }
    }
    
    return false;
}

int main() {
    int n, s;
    cin >> n >> s;
    
    vector<int> panels(n);
    for (int i = 0; i < n; i++) {
        cin >> panels[i];
    }
    
    std::cout << (winnable(n,s,panels) ? "true" : "false" ) << std::endl;
    
    return 0;
}

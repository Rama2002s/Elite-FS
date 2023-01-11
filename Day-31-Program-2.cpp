To get the admission into 6th standard in a reputed school in Hyderabad, 
conducted an entrance test. one of the questions in the test was

There was a sequence of characters(String) given, student has to check 
in given String how many substrings are same as reverse of it (palindromic).

Input Format:
-------------
Read a String.

Output Format:
--------------
Print number of palindromic substrings of given string.



Sample Input-1
pqrs
Sample Output-1
4

Explanation: 
"p", "q", "r", "s" are palindromic substrings of given string.


Sample Input-2
pppp
Sample Output-2
10

Explanation: 
"p", "p", "p", "p", "pp", "ppp", "pppp", "pp", "ppp", "pp"  are 
palindromic substrings of given string. 

    
    
    
    
    
//Solution using dp
    
    
#include <bits/stdc++.h>
using namespace std;

int main(){
    string s;
    cin >> s;
    bool dp[s.size()][s.size()];
    int count = 0;
    for (int gap = 0; gap < s.size(); gap++) {
        for (int i = 0, j = gap; j < s.size(); j++, i++) {
            if(gap == 0){
                dp[i][j] = true;
            }
            else if(gap == 1){
                if(s[i] == s[j]){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = false;
                }
            }
            else{
                if(s[i] == s[j]){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
            }
            
            if(dp[i][j]){
                count++;
            }
        }
    }
    cout << count;
    return 0;
}




//Solution using 2 pointers (rolling window)


int main(){
    string s;
    cin >> s;
    int count = 0;
    for (int i = 0; i < s.size(); i++) {
        int left , right;
        left = i;
        right = i;
        while(left >= 0 and right < s.size() and s[left] == s[right]){
            count++;
            left--;
            right++;
        }
        left = i;
        right = i + 1;
        while(left >= 0 and right < s.size() and s[left] == s[right]){
            count++;
            left--;
            right++;
        }
    }
    cout << count;
}









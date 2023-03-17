AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false

// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     string s;
//     cin >> s;
//     int countStore[256] = {0};
//     for (int i = 0; i < s.size(); i++) {
//             countStore[s[i]]++;
//     }
//     int oddcount = 0;
//     for (int i = 0; i < 256; i++) {
//         if(countStore[i] % 2 == 1){
//             oddcount++;
//         }
//         if(oddcount > 1){
//             cout << "false";
//             break;
//         }
//     }
//     if(oddcount <= 1){
//         cout << "true";
//     }
    
//     return 0;
// }

#include<bits/stdc++.h>
using namespace std;

bool isAlphaCipherPalindrome(string s){
    int freq[26];
    for (int i = 0; i < 26; i++) {
        freq[i] = 0;
    }
    for(int i=0;i<s.size();i++){
        freq[s[i]-'a']++;
    }
    int oddcount=0;
    for(int i=0;i<26;i++){
        if(freq[i]%2!=0) oddcount++;
    }
    return oddcount<=1;
}

int main(){
    string s;
    cin>>s;
    cout << (isAlphaCipherPalindrome(s)?"true":"false")<<endl;
    return 0;
}

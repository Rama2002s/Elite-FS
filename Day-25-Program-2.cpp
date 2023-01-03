There is a String given as input, it is a sequence of integer-values and arithmetic-operators.
Your task is to print the resultant values after evaluating all the different possible ways 
to group integer-values and arithmetic-operators. 

Note: Print the evaluated values in sorted order.


Input Format:
-------------
Read a string

Output Format:
--------------
Print the evaluated values in sorted order

Sample test cases:

Sample input-1
------------
4-2-1

Sample output-1
---------------
1 3

Explanation
-----------
((4-2)-1)=1
(4-(2-1))=3


Sample input-2
------------
3*5-2*6

Sample output-2
---------------
-21 3 54 54 78

Explanation
------------
(3*(5-(2*6))) = -21
((3*5)-(2*6)) = 3
((3*(5-2))*6) = 54
(3*((5-2)*6)) = 54
(((3*5)-2)*6) = 78

#include <bits/stdc++.h>
using namespace std;

int eval(int a, char op, int b){
    if(op == '+')
        return a + b;
    if(op == '-')
        return a - b;
    if(op == '*')
        return a * b;
    if(op == '/' && b != 0)
        return a / b;
}
vector<int> evalAll(string &s, int low, int high){
    vector<int> result;
    
    if(low == high){
        result.push_back(s[low] - '0');
        return result;
    }
    
    if(low == high - 2){
        int temp = eval(s[low] - '0' , s[low + 1], s[low + 2] - '0');
        result.push_back(temp);
        return result;
    }
    
    for (int i = low + 1; i < high; i = i + 2) {
        vector<int> leftAns = evalAll(s, low, i - 1);
        vector<int> rightAns = evalAll(s, i + 1, high);
        
        for (int l1 = 0; l1 < leftAns.size(); l1++) {
            for (int l2 = 0; l2 < rightAns.size(); l2++) {
                int ans = eval(leftAns[l1],s[i],rightAns[l2]);
                result.push_back(ans);
            }
        }
    }
    
    return result;
}
int main(){
    string s;
    cin >> s;
    int len = s.size();
    vector<int> finalAns = evalAll(s,0,len - 1);
    int l = finalAns.size();
    sort(finalAns.begin(), finalAns.end());
    for (int i = 0; i < finalAns.size(); i++) {
        cout << finalAns[i] << " ";
    }
    
}


//Java code converted to c++

#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> helper(string str)
{
    vector<int> ls;
    for(int i = 0; i < str.length(); i++)
    {
        char c = str[i];
        if(!isdigit(c))
        {
            string a = str.substr(0, i);
            string b = str.substr(i + 1);
            vector<int> left = helper(a);
            vector<int> right = helper(b);
            for(int q : left)
            {
                for(int w : right)
                {
                    if(c == '-')
                    {
                        ls.push_back(q - w);
                    }
                    else if(c == '+')
                    {
                        ls.push_back(q + w);
                    }
                    if(c == '*')
                    {
                        ls.push_back(q * w);
                    }
                    if(c == '/' && w != 0)
                    {
                        ls.push_back(q / w);
                    }
                }
            }
        }
    }
    if(ls.size() == 0)
    {
        ls.push_back(stoi(str));
    }
    return ls;
}

int main()
{
    string s;
    cin >> s;
    vector<int> res = helper(s);
    sort(res.begin(), res.end());
    for(int i : res)
    {
        cout << i << " ";
    }

    return 0;
}


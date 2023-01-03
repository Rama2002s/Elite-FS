Naeem is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naeem will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naeem will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 

Can you help Naeem to convert the given expression into a list of words, 
in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[g,e]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]


#include <bits/stdc++.h>
using namespace std;

vector<string> words;

void formWords(string s, string t)
{
    int i = 0;
    while(i < s.length())
    {
        if(s[i] == '[')
        {
            string temp;
            i++;
            while(s[i] != ']')
            {
                temp += s[i];
                i++;
            }
            stringstream ss(temp);
            string word;
            while(getline(ss, word, ','))
            {
                formWords(s.substr(i+1), t + word);
            }
            return;
        }
        t += s[i];
        i++;
    }
    words.push_back(t);
}

int main()
{
    string s;
    cin >> s;
    formWords(s, "");
    sort(words.begin(), words.end());
    cout << "[";
    for (int i = 0; i < words.size(); i++) {
        if(i != 0){
            cout << ", ";
        }
        cout << words[i];
    } 
    cout << "]";
}

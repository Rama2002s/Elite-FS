Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"

import java.io.*;
import java.util.*;

class P1{
    
    static int find(int a, int parent[]){
        if(parent[a] == a){
            return a;
        }
        else{
            return parent[a] = find(parent[a], parent);
        }
    }
    static void union(int a, int b, int parent[]){
        a = find(a,parent);
        b = find(b,parent);
        if(a > b){
            parent[a] = b;
        }
        else if(b > a){
            parent[b] = a;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String q = sc.next();
        String t = sc.next();
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        for(int i = 0; i <p.length(); i++){
            int a = p.charAt(i) - 'a';
            int b = q.charAt(i) - 'a';
            union(a,b,parent);
        }
        String sb = "";
        for(int i = 0 ; i < t.length(); i++){
            int val = find(t.charAt(i) - 'a', parent);
            sb += (char)(val + 'a');
        }
        System.out.println(sb);
    }
}

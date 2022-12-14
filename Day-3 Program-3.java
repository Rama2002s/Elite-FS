Prabhath is working on words.  He used to take out every letter that was repeated 
in the word. 
A word W is given to Prabhath. His objective is to eliminate every duplicate 
letter from W such that the resultant word R contains every unique letter from W
and did not contain any duplicate letters. 
And R should be at the top of the dictionary order.

NOTE:
-----
He is not allowed to shuffle the relative order of the letters of the word W to
form the word R.

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resultant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos


import java.io.*;
import java.util.*;

class P3{
    public static void removeDuplicates(String w) {
        Stack<Character> s = new Stack<>();
        int[] counter = new int[26];
        boolean[] inStack = new boolean[26];
        int len = w.length();
        for (int i = 0; i < len; i++) {
            counter[w.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char ch = w.charAt(i);
            counter[ch - 'a']--;
            if (inStack[ch - 'a']) {
                continue;
            }
            while (!s.empty() && s.peek() > ch) {
                if (counter[s.peek() - 'a'] <= 0) {
                    break;
                }

                inStack[s.pop() - 'a'] = false;
            }

            s.push(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder(s.size());
        while (!s.empty()) {
            sb.append(s.pop());
        }

        System.out.println(sb.reverse().toString());
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String w = sc.next();
        removeDuplicates(w);
    }
    
}

There is a competetion conducted at a school where students are given string 
of English letters. String consits of lower case letters.

A student can alter the string and create a new string so that, when reversed, 
the altered and and its reveresed strings should be equal, designating a winner.

There is a constraint that each string can be altered atmost twice. 
In one operation, you can change any character of string to any other character.

The student has to return "true" if he is winner, otherwise return "false"

Input Format:
-------------
A string, S

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
xyzwyx

Sample Output-1:
----------------
true

Explanation:
------------
One way to alter the string such that it matches the given criteria,
using 1 operation is:

- Change s[2] to 'w'. Now, s = "xywwyx".
One operation could be performed to make our required string so return true.


Sample Input-2:
---------------
pp

Sample Output-2:
----------------
true

Explanation:
------------
One way to alter the string such that it matches the given criteria,
using 2 operations is:
- Change s[0] to 'q'. Now, s = "qp".
- Change s[1] to 'q'. Now, s = "qq".
Two operations could be performed to make our required string so return true.


Sample Input-3:
---------------
mnopqr

Sample Output-3:
----------------
false

Explanation:
------------
It is not possible to make string that matches the given criteria using 
one or two operations. So, return false.
  
  
  

import java.io.*;
import java.util.*;

class P3{
    static boolean makePalindrome(String[] s){
        int n = s.length;
        int check = 0;
        int j = n -1;
        int i =0;
        while(i <= j){
            if(!s[i].equals(s[j])){
                check++;
                if(check > 2){
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");
        // System.out.println(isPalindrome("PPPQ"));
        System.out.println(makePalindrome(s));
    }
}

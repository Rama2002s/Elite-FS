There is a String S given to a student of even length N whose indexes start from 0.
The number of open brackets '[' and close brackets ']' in the string S are equal.

Students have to balance the string S. The string is balanced if and only if
        -It is the empty string, or
        -It can be written as XY, where both X and Y are balanced strings, or
        -It can be written as [Z], where Z is a balanced string.
        -You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make string balanced.


Input Format:
-------------
Line-1: A string S, contains open '[' and close ']' brackets

Output Format:
--------------
An integer result, number of swaps


Sample Input-1:
---------------
][

Sample Output-1:
----------------
1

Explanation:
------------
String is balanced by swapping index 0 with index 1.
The resultant string is "[]".


Sample Input-2:
---------------
[][][][][]

Sample Output-2:
----------------
0

Explanation:
------------
You can do the following steps to make the string balanced:
- Swap index 0 with index 4. s = "[]][][[]".
- Swap index 1 with index 5. s = "[[][]][]".
The resulting string is "[[][]][]".


Sample Input-3:
---------------
]]][[[[]

Sample Output-3:
----------------
2

Explanation:
------------
The string is already balanced

import java.io.*;
import java.util.*;

class P1{
    static int noOfSwaps(String[] s){
        int count = 0;
        for (int i = 0; i < s.length; i++){
            if(s[i].equals("]") && count == 0){
                continue;
            }
            else if(s[i].equals("[")){
                count++;
            }
            else{
                count--;
            }
        }
        return (count + 1) / 2;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");
        System.out.println(noOfSwaps(s));
    }
}
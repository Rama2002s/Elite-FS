Murali playing a mobile game, Blast the letters.

In the game he is given a word W and value R.
Murali has to perform the blasting operation as follows:
	- He has to blast the mimeograph M of length R in W, 
	  a mimeograph is a string such that each letter in it should be same.
	- After blasting the mimeograph, the rest of the string on its
	  left side and right side, concatenated together.

Murali has to perform the blasting operation repeatedly, 
until no more blasting is possible. Your task is to return 
the final string after all the blast operations have been done.

Input Format:
-------------
Line-1: A string and an integer, W and R.

Output Format:
--------------
Print a string, the final string after all the blast operations have been done.


Sample Input-1:
--------------- 
ababbaaab 3

Sample Output-1:
----------------
aba


Sample Input-2:
--------------- 
caaabbbaacdddd 2

Sample Output-2:
----------------
cabc


//2nd code to be done

import java.io.*;
import java.util.*;

class P4{
    
    static String stringFunc(String w, int r){
        int counter = 1;
        for (int i = 0;  i < w.length() - 1;i++ ){
            if(w.charAt(i) == w.charAt(i+1)){
                counter++;
            }
            else{
                counter = 1;
            }
            if(counter == r){
                w = stringFunc(w.substring(0,i-r+2) + w.substring(i+2),r);
            }
        }
        return w;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String w = sc.next();
        int r = sc.nextInt();
        System.out.println(stringFunc(w,r));
    }
}

________________________________________________________________________________

import java.util.*;

class Pair
{
    int value;
    char key;
    Pair(char key,int value)
    {
        this.key=key;
        this.value=value;
    }
    
    char getKey()
    {
        return key;
    }
    int getValue()
    {
        return value;
    }
}


class d4p4
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            boolean flag=false;
            while(!st.isEmpty() && c==st.peek().getKey())
            {
                if(st.peek().getValue()==n-1)
                {
                    for(int j=0; j<n-1;j++)
                    {
                        st.pop();
                        flag=true;
                    }
                }
                else
                {
                    st.push(new Pair(c,st.peek().getValue()+1));
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                st.push(new Pair(c,1));
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty())
        {
            res.append(st.pop().getKey()+"");
        }
        res.reverse();
        System.out.println(res.toString());
    }
}

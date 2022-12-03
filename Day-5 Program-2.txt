A transitive law is "If a == b and b == c, then a == c"
Which also says "If a == b and b != c, then a != c"

You will be given a list of strings relations[], i.e, like p==q or p!=q.
Your task is to find out whether all the relations follow the transitive law or not.
If all of them followed return true, otherwise return false.

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true


import java.io.*;
import java.util.*;

class P2
{
    static int find(int[] parent,char a)
    {
        int x = a- 'a';
        return parent[x];
    }
    static void union(int[] parent,char a,char b)
    {
        int parA = a -'a';
        int parB = b -'a';
        int t=parent[parA];
        if(find(parent,a)!=find(parent,b))
        {
            parent[parA]=find(parent,b);
        }
        for(int i=0;i<26;i++)
        {
            if(t==parent[i])
            {
                parent[i]=find(parent,b);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String[] stringArr=sc.nextLine().split(" ");
        int[] parent=new int[26];
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }
        for(String s:stringArr)
        {
            char a=s.charAt(0);
            char b=s.charAt(3);
            if(s.charAt(1)=='=')
            {
                union(parent,a,b);
            }
        }
        for(String s:stringArr)
        {
            char a=s.charAt(0);
            char b=s.charAt(3);
            if(s.charAt(1)=='!')
            {
                if(parent[a-'a']==parent[b-'a'])
                {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }
}

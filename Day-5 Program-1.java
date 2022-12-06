Mansood Ali participated in a treasure-hunt conatins N boxes in it.
Each box is numbered from 0,1,2,3,...,N-1. 
All the boxes are intially locked with the passcodes, except Box-0.
The passcode is written in a envolope and marked with its concern box number.

Each box in the treasure hunt contains a list of envelopes, which has 
passcodes to open the other boxes. He can open the boxes in any order, 
but he has to start from box-0 intially.

The rule to win the treasure-hunt is to open all the boxes.
Your task is to find out, whether Mansood Ali win the treasure hunt or not.
If he win, print "Win", Otherwise, print "Lost"


Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4
3

Sample Output-1:
----------------
Win


Sample Input-2:
---------------
4
1 3
3 0 1
2
0

Sample Output-2:
----------------
Lost


import java.util.*;

class P1
{
    static void dfsHelper(boolean[] checker,ArrayList<ArrayList<Integer>>arr,int index)
    {
        checker[index]=true;
        List<Integer> qStorage=arr.get(index);
        for(int i=0;i<qStorage.size();i++)
        {
            if(!checker[qStorage.get(i)])
            {
                dfsHelper(checker,arr,qStorage.get(i));
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        boolean[] boolArr=new boolean[n];
        for(int i=0;i<n;i++)
        {
            String[] s=sc.nextLine().split(" ");
            ArrayList<Integer> temp=new ArrayList<>();
            for(String j:s)
            {
                temp.add(Integer.parseInt(j));
            }
            arr.add(temp);
        }
        dfsHelper(boolArr,arr,0);
        for(int i=0;i<n;i++)
        {
            if(!boolArr[i])
            {
                System.out.println("Lost");
                return;
            }
        }
        System.out.println("Win");
    }
}

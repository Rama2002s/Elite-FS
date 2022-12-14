There are N sticks of various lengths, stklen[], where stklen[i] is the length 
of the i-th stick.  And you need to break them into pieces of any length.
And you will be given another integer P, number of pieces you need to make.

You need to break the sticks to make P pieces of equal lengths.
You can consider the unwanted piece as scrap.

You can break a stick of length 6 as follows:
	- 6 pieces of length-1.
	- 1 piece of length-1 and 1 piece of length-2 and one piece of length-3.
	- 3 pieces of length-2, etc.
	
Your task is to check, can you break the sticks into P pieces of equal length,
if possible, retrun the maximum length of the pieces possible.
otherwise return 0.

Input Format:
-------------
Line-1: Two space separated integers, N and P.
Line-2: N space separated integers, length of the sticks.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 3
6 8 10

Sample Output-1:
----------------
6

Explanation:
------------
- Keep the stick-1 as it is.
- Break the stick-2 into two pieces, one of length 6 and one of length 2.
- Break the stick-3 into two pieces, one of length 6 and one of length 4.
Finally, you have 3 pieces of length 6.


Sample Input-2:
---------------
3 4
6 8 10

Sample Output-2:
----------------
5

Explanation:
------------
- Break the stick-1 into two pieces, one of length 5 and one of length 1.
- Break the stick-2 into two pieces, one of length 5 and one of length 3.
- Break the stick-3 into two pieces, one of length 5 and one of length 5.
Finally, you have 3 pieces of length 4.


Sample Input-3:
---------------
3 25
6 8 10

Sample Output-3:
----------------
0
  
import java.io.*;
import java.util.*;

class P1{
    static int n, p;
    static int[] sticks;
    static boolean works(int x){
        int count = 0;
        for(int i = 0; i < n; i++){
            count += sticks[i] / x;
        }
        if(count >= p){
            return true;
        }
        else{
            return false;
        }
    }
    static int sumMethod(int[] sticks, int n,int p){
        int low = 1;
        int high = sticks[n-1];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(works(mid) && !works(mid + 1)){
                return mid;
            }
            else if(!works(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return 0;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = sc.nextInt();
        sticks = new int[n];
        for(int i = 0; i < n ; i++){
            sticks[i] = sc.nextInt();
        }
        Arrays.sort(sticks); //Need to sort since some test cases give unsorted
        System.out.println(sumMethod(sticks,n,p));
    }
}

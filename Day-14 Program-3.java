In an international cricket stadium before starting of the game
players stand in a row with tshirt numbers 0's and 1's  randomly.

But the players with tshirt-number 1 wants to stand together.
Your task is to print the least number of interchages of places to group all
players with tshirt number 1.

Input Format:
-------------
Line-1: Read an integer R, number of players.
Line-2: Read R tshirt-numbers standing in a row.

Output Format:
--------------
Print an integer result.


Sample Input-1
--------------
5
1 0 1 0 1

Sample Output-1
---------------
1

Explanation
-----------
There are 3 ways to group all 1's together
1 1 1 0 0  after 1 interchange
0 1 1 1 0  after 2 interchanges
0 0 1 1 1  after 1 interchange
The least is 1.


Sample Input-2
--------------
7
1 0 1 0 1 0 1

Sample Output-2
---------------
2

Explanation
-----------
There are 4 ways to group all 1's together
1 1 1 1 0 0 0  after 2 interchanges
0 0 0 1 1 1 1  after 2 interchanges
0 1 1 1 1 0 0  after 2 interchanges
0 0 1 1 1 1 0  after 2 interchanges 
The minimum is 2.
 

Sample Input-3
--------------
6
0 1 0 0 0 0

Sample Output-3
---------------
0

Explanation
-----------
No interchange required.

import java.io.*;
import java.util.*;

class P3{
    static int minSwaps(int[] arr, int n){
        int oneCount = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] == 1){
                oneCount++;
            }
        }
        if(oneCount == 0 || oneCount == n)
            return 0;
        int c1 = 0;
        int c0 = 0;
        int i = 0, ans = n;
        for(int j = 0; j < n; j++){
            if(arr[j] == 0)
                c0++;
            else
                c1++;
            if(j - i + 1 == oneCount){
                ans = Math.min(ans,c0);
                if(arr[i] == 0)
                    c0--;
                else
                    c1--;
                i++;
            }
        }
        return ans;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minSwaps(arr,n));
    }
}

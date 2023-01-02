A Kid built a structure using building blocks, 
by placing the building-blocks adjacent to each other.

A building-block is a vertical alignment of blocks.
	                                ___
here one block each represents  as |___|.

The following structure made up of using building blocks

                          ___
                      ___|___|    ___
                     |___|___|_w_|___|___              ___
                  ___|___|___|___|___|___| w   _w_  w |___| 
              ___|___|___|___|___|___|___|_w__|___|_w_|___|____________
    
               0  1   3   4   2   3    2   0   1   0   2

Once the structure is completed, kid pour water(w) on it.

You are given a list of integers, heights of each building-block in a row.
 Now your task How much amount of water can be stored by the structure.

 Input Format:
 -------------
 Space separated integers, heights of the blocks in the structure. 

Output Format:
 --------------
 Print an integer, 
  
Sample Input:
-------------
 0 1 3 4 2 3 2 0 1 0 2
    
Sample Output:
--------------
6
    
Explanation:
 -----------
In the above structure,  6 units of water (w represents the water in the structure)
can be stored.

   
import java.io.*;
import java.util.*;

class P2{
    static int waterStored(int n, int[] arr){
        int left = 0; int right = n - 1;
        int rightMax = 0; int leftMax = 0;
        int ans = 0;
        while(left < right){
            rightMax = Math.max(rightMax, arr[right]);
            leftMax = Math.max(leftMax, arr[left]);
            
            if(leftMax < rightMax){
                ans += Math.max(0,leftMax - arr[left]);
                left++;
            }
            else if(rightMax <= leftMax){
                ans += Math.max(0,rightMax - arr[right]);
                right--;
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
        System.out.println(waterStored(n,arr)); 
    }
}

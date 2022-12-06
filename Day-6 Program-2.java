In an International school 9th standard students have been assigned a task.

Given a list of numbers nums[] and three values p, q and r.
They have to solve the equation function(x)=p(x^2)+q(x)+r, 
for each number(x) in the given list nums[],
and print the resultant values in the sorted order.

Input Format:
-------------
Line-1: An integer N, size of list nums[].
Next N lines: space separated integers, nums[]
Last Line: 3 space separated integers, P, Q and R.

Output Format:
--------------
Print a list of numbers[].


Sample Input-1:
---------------
4
-3 -2 2 4
2 3 5

Sample Output-1:
----------------
7 14 19 49



Sample Input-2:
---------------
4
-3 -2 1 2
-2 3 5

Sample Output-2:
----------------
-22 -9 3 6

import java.io.*;
import java.util.*;

class P2{
    static int formula(int x, int p, int q, int r){
        return (p * x * x) + (q * x) + r;
    }
    // static int findMid(int[] arr){
    //     int mid = 0;
    //     for(int i = 0 ; i < arr.length ; i++){
    //         if(arr[i] > 0){
    //             mid = i;
    //             break;
    //         }
    //     }
    //     return mid;
    // }
    static int[] finalFormula(int[] arr,int p, int q, int r){
        int[] resArray = new int[arr.length];
        int x = 0; int i = 0; int j = 0;
        if(p < 0){
            x = 0;
            i = 0; j = arr.length - 1;
            while(i <= j){
                if(formula(arr[i],p,q,r) < formula(arr[j],p,q,r)){
                    resArray[x++] = formula(arr[i++],p,q,r);
                }
                // else if(formula(arr[i],p,q,r) > formula(arr[j],p,q,r)){
                else{
                    resArray[x++] = formula(arr[j--],p,q,r);
                    
                }
            }
        }
        else{
            i = 0; j = arr.length - 1;
            x = arr.length - 1;
            while(i <= j){
                if(formula(arr[i],p,q,r) > formula(arr[j],p,q,r)){
                    resArray[x--] = formula(arr[i++],p,q,r);
                }
                // else if(formula(arr[i],p,q,r) > formula(arr[j],p,q,r)){
                else{
                    resArray[x--] = formula(arr[j--],p,q,r);
                }
            }
        }
        return resArray;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        // System.out.print(findMid(arr));
        // for(int i = 0; i < n ; i++){
        //     System.out.println(formula(arr[i],p,q,r));
        // }
        int[] ans;
        ans = finalFormula(arr,p,q,r);
        System.out.println(Arrays.toString(ans));
    }
}

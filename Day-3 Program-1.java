There are N computers in a network, all the computers are connected as tree 
structure. And one new connection is added in the Network. The computers in 
the network are identified with their IDs, the IDs are numbered between 1 to N.

The connections in the network is given as coonection[i] = [comp-A, comp-B], 
there is a connection between comp-A and comp-B.

Your task is to remove a connection in the network and print it, so that 
all the computers are connected as tree structure. If there are multiple 
options to remove, remove the connection that occurs last in the input.


Input Format:
-------------
Line-1: Two space separated integers N, number of computers.
Next N lines: Two space separated integers, comp-A & comp-B.

Output Format:
--------------
Print the connection which is removed.


Sample Input-1:
---------------
6
1 2
3 4
3 6
4 5
5 6
2 3

Sample Output-1:
---------------
5 6


Sample Input-2:
---------------
4
1 2
2 3
3 4
2 4

Sample Output-2:
---------------
2 4


import java.io.*;
import java.util.*;

class P1{
    static int[] parent;
    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }
    static void union(int a, int b){
        int f1 = find(a);
        int f2 = find(b);
        if(f1 != f2){
            parent[f1] = f2;
        }
        else{
            System.out.print(a + " " + b);
        }
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];
        int[][] conn = new int[n][2];
        for(int i = 0; i <n + 1; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < n ; i++){
            conn[i][0] = sc.nextInt();
            conn[i][1] = sc.nextInt();
        }
        for(int i = 0; i <n; i++){
            union(conn[i][0],conn[i][1]);
        }
    }
}

There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
Note: Look HINT for explanation.


import java.io.*;
import java.util.*;

class P3{
    static int find(int a, int parent[]){
        return parent[a];
    }
    static void union(int a, int b, int parent[]){
        int temp = parent[a];
        if(find(a,parent) != find(b,parent)){
            parent[a] = find(b,parent);
            for(int i = 0; i< parent.length; i++){
                if(parent[i] == temp){
                    parent[i] = find(b,parent);
                }
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] parent = new int[m];
        int[][] pair = new int[n][2];
        for(int i = 0; i < m ; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n; i++){
            pair[i][0] = sc.nextInt();
            pair[i][1] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            union(pair[i][0],pair[i][1],parent);
        }
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < m; i++){
            if(hs.add(parent[i])) 
                ans++;
        }
        System.out.println(ans);
    }
}

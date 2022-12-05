Ibrahim is an interior designer wants to color wall of size M*N. 
He plans to color the wall and put lights of two different colors

The designer can lit the wall using M*N lights.The lights are Blue or pink
in color.Blue colored lights represented with digit-1 and pink colored lights 
represented with digit-0.

The Blue colored lights forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
count the unique shapes formed by blue colored lights.

You will be given the decorated wall as a matrix wall[][].
Your task is to help Ibrahim to count the unique shapes by the lights.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by Blue Lights.


Sample Input-1:
---------------
4 5
1 1 0 1 1
1 1 0 0 1
0 0 0 0 0
1 1 0 0 0

Sample Output-1:
----------------
3


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes, 
1 1  		  1 1
1      and      1






import java.io.*;
import java.util.*;

class P1{
    static ArrayList<ArrayList<Integer>> temp;
    static void dfs(int[][] mat, int r, int c,int x, int y){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(r - x);
        list.add(c - y);
        temp.add(list);
        mat[r][c] = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] d: directions){
            int nr = r + d[0];
            int nc = c + d[1];
            if(0 <= nr && nr < mat.length && 0 <= nc && nc < mat[0].length){
                if(mat[nr][nc] != 0){
                    dfs(mat, nr, nc, x , y);
                }
            }
        }
        
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        Set<ArrayList<ArrayList<Integer>>> ans = new HashSet<>();
        for(int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    temp = new ArrayList<>();
                    dfs(mat,i,j,i,j);
                    ans.add(temp);
                }
            } 
        }
        System.out.println(ans.size());
    }
}

Sreedhar is a farmer, and he started harvesting the watermelon crop, 
the crop grown very well. There are several watermelons in the crop. 
Sreedhar started picking up the watermelons one by one.
After each pick, he keeps the watermelon in a truck placed inside the crop.

The crop is in the from of 2D grid of size m*n.
You will be given the positions of the truck, Sreedhar's, and the watermelons.  
Positions are represented by the cells in the 2D grid. 

Your task is to find the minimum distance for Sreedhar to collect 
all the watermelons and put them inside the truck one by one. 

Sreedhar can only take at most one watermelon at one time 
and can move in four directions - up, down, left and right, to the adjacent cell. 
The distance is represented by the number of moves.

Input Format:
-------------
Line-1: Two space separated integers m and n, size of crop. 
Line-2: Two space separated integers, position of the truck. 
Line-3: Two space separated integers, position of Sreedhar.
Line-4: An integer W, number of watermelons in the crop.
Next W lines: Two space separated integers, positions of watermelon. 

Output Format:
--------------
An integer, minimum distance covered by Sreedhar to pickup all the watermelons


Sample Input-1:
---------------
5 7		//size of the crop as 2D grid.
2 2		//Truck Position
4 4		//Sreedhar Position
2		//Number of watermelons
3 0		//Watermelon positions
2 5

Sample Output-1:
----------------
12


Sample Input-2:
---------------
5 7
2 2
4 4
5
1 4
2 6
3 0
2 5
4 5

Sample Output-2:
----------------
32


import java.io.*;
import java.util.*;

class P3{
    static int minDistance(int[][] mat){
        Arrays.sort(mat,(a,b) -> {return (a[2] - a [3]) - (b[2] - b[3]);});
        int distance = 0;
        distance += mat[0][2] + mat[0][3];
        for(int i = 1; i < mat.length; i++){
            distance += mat[i][3] * 2;
        }
        return distance;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int w = sc.nextInt();
        int[][] mat = new int[w][4];
        for(int i = 0 ; i < w ; i++){
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
            mat[i][2] = Math.abs(s1 - mat[i][0]) + Math.abs(s2 - mat[i][1]);
            mat[i][3] = Math.abs(t1 - mat[i][0]) + Math.abs(t2 - mat[i][1]);
        }
        System.out.println(minDistance(mat));
    }
}

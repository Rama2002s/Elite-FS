Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly he has prepared the plan and given as
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in 
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of 
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1
 
Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1
 
Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]


import java.io.*;
import java.util.*;

class Coordinate {
  int x;
  int y;
  Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
class P2 {
  static List < Integer > bfs(int i, int j, int grid[][], int vis[][]) {
    vis[i][j] = 1;
    Queue < Coordinate > q = new LinkedList < Coordinate > ();
    q.add(new Coordinate(i, j));
    int n = grid.length;
    int m = grid[0].length;
    List < Integer > l = new ArrayList < > ();
    l.add(i);
    l.add(j);
    while (!q.isEmpty()) {
      int row = q.peek().x;
      int col = q.peek().y;
      if ((row + 1 >= n || grid[row + 1][col] == 0) && (col + 1 >= m || grid[row][col + 1] == 0)) {
        l.add(row);
        l.add(col);
      }
      q.remove();
      int dir[][] = {
        {
          0,
          1
        },
        {
          1,
          0
        },
        {
          0,
          -1
        },
        {
          -1,
          0
        }
      };
      for (int x = 0; x < dir.length; x++) {
        int nrow = row + dir[x][0];
        int ncol = col + dir[x][1];
        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
          vis[nrow][ncol] = 1;
          q.add(new Coordinate(nrow, ncol));
        }
      }
    }
    return l;
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int grid[][] = new int[r][c];
    int vis[][] = new int[r][c];
    List < List < Integer >> l1 = new ArrayList < > ();
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == 1 && vis[i][j] == 0) {
          l1.add(bfs(i, j, grid, vis));
        }
      }
    }
    for (int i = 0; i < l1.size(); i++) {
      System.out.print(l1.get(i));
    }
  }
}
 

   

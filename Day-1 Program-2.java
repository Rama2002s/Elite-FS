Mr Suleman is given a checkerboard of size 400*400, where the indices starts 
from (-200,-200) and ends at (199,199). In one step, he can move the box from 
position (p,q) to one of the following positions in L shape like as follows: 
	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)

Initially the box is at (0,0) position, and need to move the box to position (m,n).
You will be given two integers m and n indicates the position(m,n).

Now your task is to help by Mr Suleman to find the minimum number of steps 
required to move the box from (0,0) to (m,n).

Note: It is allowed to move out of the board also.

Input Format:
-----------------
Two space separated integers, m and n, position.

Output Format:
------------------
Print an integer, minimum number of steps to reach (m,n).


Sample Input-1:
---------------
2 4

Sample Output-1:
----------------
2

Explanation:
-------------
Initially, you are at (0,0) position, you can reach (2,4) as follows:
(0,0) -> (1, 2) -> (2, 4) 


Sample Input-2:
---------------
4 7

Sample Output-2:
----------------
5

Explanation:
------------
Initially, you are at (0,0) position, you can reach (4,7) as follows:
(0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)


import java.io.*;
import java.util.*;

class P2{
    static class Coordinate{
        int x;
        int y;
        
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int minMoves(int m, int n){
        int[] directionX = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] directionY = {-1, 1, -2, 2, -2, 2, -1, 1};
        int moves = 0;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0,0));
        
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0 ; i < size; i++){
                Coordinate p = q.remove();
                if(p.x == m && p.y == n)
                    return moves;
                for(int j = 0; j < directionX.length; j++){
                    int newPx = p.x + directionX[j];
                    int newPy = p.y + directionY[j];
                    if(!visited.contains(newPx+","+newPy)){
                        q.add(new Coordinate(newPx, newPy));
                        
                        visited.add(newPx+","+newPy);
                    }
                }
            }
            
            moves++;
        }
        return -1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(minMoves(m,n));
        
        
    }
}

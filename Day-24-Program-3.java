Given a matrix of dimensions rows x cols, MAT[rows][cols] and the value of P(integer).
Move the matrix elements P number of times.

Every element movement consists of:
Move the element MAT[i][j] to MAT[i][j+1].
Move the element MAT[i][cols-1] to MAT[i+1][0].  
Move the element MAT[rows-1][cols-1] to  MAT[0][0].  

Print the matrix after moving the elements P number of times.   


Input Format:
-------------
Line-1: Read space separated values R(rows), C(cols) and P value
Line-2: Read matrix elements R rows.
Output Format:
--------------
Print resultant matrix of RxC dimension after moving the elements P times.



Sample test cases:

Sample Input-1
---------------
3 3 1         --------> rows, cols and P value
10 20 30       ------>input matrix of dimension rows x cols
40 50 60
70 80 90
Sample Output-1
----------------
90 10 20        ----> Resultant matrix after moving the elements P times.
30 40 50
60 70 80



Sample Input-2
---------------
4 4 4
2 7 3 9
18 6 1 4
5 8 12 16
10 0 24 17

Sample Output-2
----------------
10 0 24 17
2 7 3 9
18 6 1 4
5 8 12 16



Sample Input-3
---------------
3 3 9
3 2 1
6 5 4
9 8 7
Sample Output-3
----------------
3 2 1
6 5 4
9 8 7

  import java.io.*;
import java.util.*;

class P3{
    static int[][] mover(int rows, int cols, int p, int[][] mat){
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(j + p >= cols){
                    int temp = i + ((j+p) / cols);
                    ans[temp % rows][(j + p) % cols] = mat[i][j];
                }
                else{
                    ans[i % rows][(j + p) % cols] = mat[i][j];
                }
            }
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int p = sc.nextInt();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                mat[i][j] = sc.nextInt();
            } 
        }
        int[][] ans =  mover(rows,cols,p,mat);
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        } 
    }
}

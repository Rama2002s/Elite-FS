A graduate at University of California (UoC) has to follow certain rules.

UoC offering K subjects, the subjects are indexed from 0 to K-1.
To complete the subjets, you have to follow the conditions, like 
condition[i]= [Xi, Yi], which specifies you must take the subject Xi 
before the subject Yi.

Conditions can be indirect, i.e., take course-A to take course-B, and take 
course-B to take course-C, then you have to take course-A to take course-C.

You are given total number of subjects, a list of C condition pairs and 
a list of Q queries where queries[i] = [Ai, Bi]. For the ith query, 
you should answer whether you have to take course Ai to take course Bi or not 
and return the answers as a boolean list answers[].

NOTE:
It is guaranteed that the course conditional graph continas no cycle.

Input Format:
-------------
Line-1: 3 space separated integers, N, C and Q
Next C lines: Two space separated integers, conditions[]
Next Q lines: Two space separated integers, queries[]

Output Format:
--------------
Print Q boolean values as result.


Sample Input-1:
---------------
3 3 2
1 2
1 0
2 0
1 0
1 2

Sample Output-1:
----------------
true true


Sample Input-2:
---------------
5 4 3
0 1
0 2
1 4
1 3
0 2
1 3
1 2

Sample Output-2:
----------------
true false true



import java.util.*;

public class P2 {
    public static boolean dfs(Map<Integer, List<Integer>> hMap, int start, int end) {
        if (start == end)
            return true;
        if (!hMap.containsKey(start))
            return false;
        for (int i : hMap.get(start)) {
            if (dfs(hMap, i, end))
                return true;
        }
        return false;
    }

    public static boolean[] makeAnswer(int n, int[][] conditions, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        Map<Integer, List<Integer>> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hMap.put(i, new ArrayList<>());
        }
        for (int[] condition : conditions) {
            hMap.get(condition[0]).add(condition[1]);
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = dfs(hMap, queries[i][0], queries[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int q = sc.nextInt();
        int[][] conditions = new int[c][2];
        for (int i = 0; i < c; i++) {
            conditions[i][0] = sc.nextInt();
            conditions[i][1] = sc.nextInt();
        }
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        boolean[] ans = makeAnswer(n, conditions, queries);
        for (boolean b : ans) {
            System.out.println(b);
        }
    }
}

 

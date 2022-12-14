There are N cities, the cities are connected through one way routes and 
there is no cycle between the routes. Each city is numbered from 0 to N-1.

The map of the cities is given as follows: 
map[i] is a list of all the cities you can travel from city[i].
(i.e., there is a one-way route from city[i] to node[map[i][j]]).

Your task is to findout all the possible travel routes between city-[0] to 
city-[N-1]. 
 
Input Format:
-------------
Line-1: An integer N , number of cities.
Line-2: N space separated integers, number of outgoing routes from city[i], 0<=i<N.
Next N lines: "out[i]" space separated integers, routes from city[i] where 0<=i<N
 
Output Format:
--------------
Print the list of travel routes.

Hint: find the travel routes in the input order.

 
Sample Input-1:
---------------
4
2 1 1 0
1 2
3
3

Sample Output-1:
----------------
[[0, 1, 3], [0, 2, 3]]
 

Sample Input-2:
---------------
5
3 3 1 1 0
4 3 1
3 2 4
3
4
 
Sample Output-2:
----------------
[[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]


import java.io.*;
import java.util.*;

class P3{
    
    static void dfs(List<List<Integer>> ans , int a, int[] visited, List<Integer> temp, int n, List<List<Integer>> ls){
        if(a == n-1){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i = 0 ; i < ls.get(a).size(); i++){
            if(visited[ls.get(a).get(i)] == 0){
            visited[ls.get(a).get(i)] = 1;
            temp.add(ls.get(a).get(i));
            dfs(ans,ls.get(a).get(i),visited,temp,n,ls);
            temp.remove(temp.size()-1);
            visited[ls.get(a).get(i)] = 0;
            }
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] routes = new int[n];
        for(int i = 0 ; i < n; i++){
            routes[i] = sc.nextInt();
        }
        
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            ls.add(new ArrayList<>());
            for(int j = 0; j < routes[i]; j++){
                ls.get(i).add(sc.nextInt());
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[n];
        List<Integer> temp = new ArrayList<>();
        visited[0] = 1;
        temp.add(0);
        dfs(ans,0,visited,temp,n,ls);
        System.out.println(ans);
        
        
    }
}

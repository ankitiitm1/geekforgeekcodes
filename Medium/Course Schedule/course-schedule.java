//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     static void recurse(int node ,ArrayList<ArrayList<Integer>> graph,boolean arr[],int visited[]){
        if(arr[0]){
            return ;
        }
        if(visited[node]!=0){
            if(visited[node]==1){
                arr[0] = true;
                return;
            }
            return ;
        }
        visited[node]=1;
        for(int e:graph.get(node)){
            recurse(e,graph,arr,visited);
        }
        visited[node]=2;
    }
    static boolean havingCycle(ArrayList<ArrayList<Integer>> graph){
        boolean arr[] = new boolean[1];
        int visited[] = new int[graph.size()];
        recurse(0,graph,arr,visited);
        return arr[0];
    }
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        int[] inDegree = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> prerequisite : prerequisites) {
            int u = prerequisite.get(1);
            int v = prerequisite.get(0);
            inDegree[v]++;
            graph.get(u).add(v);
        }
        if(havingCycle(graph)){
            return new int[]{};
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            index++;
            
            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        if (index == n) {
            int[] order = new int[n];
            for (int i = 0; i < n; i++) {
                order[i] = result.get(i);
            }
            return order;
        } else {
            return new int[0];
        }
    }
}
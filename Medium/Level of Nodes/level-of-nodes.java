//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    
    ArrayList<Integer> vis=new ArrayList<>();
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
     int level=0;
     Queue<Integer> q=new LinkedList<>();
     q.add(0);
     
     while(!q.isEmpty()){
         int size=q.size();
         
         for(int i=0;i<size;i++){
            int curr=q.poll();
            if(curr==X) return level;
            for(int j=0;j<adj.get(curr).size();j++){
                int x= adj.get(curr).get(j);
                if(!vis.contains(x)) 
                {vis.add(x);
                q.add(x);}
            }
         }level++;
         
     }
     
     return -1;
     
    }
    
    
}
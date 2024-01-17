//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        boolean[] vis=new boolean[n];
        Set<ArrayList<Integer>> hst=new HashSet<>();
        ArrayList<Integer> curr=new ArrayList<>();
        
        Collections.sort(arr);
        check(arr,vis,hst,curr,res);
        return res;
    }
    
    
    static void check(ArrayList<Integer>  arr, boolean[] vis, 
    Set<ArrayList<Integer>>hst,ArrayList<Integer> curr,  ArrayList<ArrayList<Integer>> res){
        if(curr.size()==arr.size()){
            if(!hst.contains(curr)){
            hst.add(new ArrayList(curr));    
            res.add(new ArrayList(curr));
            }
            return;
        }
        
        for(int i=0;i<arr.size();i++){
            if(vis[i]==true){
                continue;
            }else{
                vis[i]=true;
                curr.add(arr.get(i));
            }
            check(arr,vis,hst,curr,res);
            vis[i]=false;
            curr.remove(curr.size()-1);
        }
    }
};
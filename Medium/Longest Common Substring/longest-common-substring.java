//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        
        int x=n;
        int y=m;
        int[][] t=new int[x+1][y+1];
        // your code here
        for (int i = 0; i < x+1; i++) {
            t[i][0]=0;
        }
        
        for (int i = 0; i < y+1; i++) {
            t[0][i]=0;
        }
        
        for(int i=1;i<x+1;i++){
            for(int j=1;j<y+1;j++){
                 if(S1.charAt(i-1)==S2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                 }else{
                     t[i][j]=0;
                 }
            }
        }
       
       int ans=0;
       for(int i=0;i<x+1;i++){
            for(int j=0;j<y+1;j++){
                 ans=Math.max(ans,t[i][j]);
            }
        
       }
       
        
        return ans;
    }
}
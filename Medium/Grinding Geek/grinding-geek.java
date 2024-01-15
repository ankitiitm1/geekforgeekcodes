//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int max_courses(int n, int total, int[] cost) {
        
        /*if total<=cost[i];
          total=total-0.1*cost[i]
          
          either buy or not;
        */ 
        
        
        int[][]dp = new int[n+1][total+1];
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=total;j++){
                int notTake = dp[i+1][j];
                int take = Integer.MIN_VALUE;
                if(cost[i]<=j){
                  take = 1+dp[i+1][j-cost[i]+(int)(Math.floor((double)cost[i]*0.9))];
                }
                
                dp[i][j] = Math.max(take, notTake);
            }
        }
        
        return dp[0][total];
        
        
        
    }
}


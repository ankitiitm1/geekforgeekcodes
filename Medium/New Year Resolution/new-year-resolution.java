//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static boolean isPossible(int N, int[] coins) {
    
        int sum=0;
        for(int x:coins){
            sum+=x;
        }
        if(sum==2024){
            return true;
        }
        boolean[][] dp=new boolean[N+1][sum+1];
        for(int i=0;i<N+1;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        
        for(int i=1;i<sum+1;i++){
            if(i%20==0 || i%24==0 ){
                if(dp[N][i]) return true;
            }
        }
                
        return false;
    }
}
        

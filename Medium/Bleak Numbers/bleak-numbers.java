//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        int m=n;
        int ceil=0;
        while(n>0){
            n=n/2;
            ceil++;
        }
    
        for(int i=m-1;i>=m-32;i--){
            if(i+countsetbits(i)==m) return 0;
            
        }
        
        return 1;
    }
    
    
    public int countsetbits(int i){
        int count=0;
        while(i>0){
            if((i&1)==1){
                count++;
            }
            i=i/2;
        }
        
        return count;
    }
}
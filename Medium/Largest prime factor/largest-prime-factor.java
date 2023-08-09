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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        int largestPrime=1;
        
        while(N%2==0){
            //System.out.println(N);
            largestPrime=2;
            N=N/2;
        }
        
        while(N%3==0){
            //System.out.println(N);
            largestPrime=3;
            N=N/3;
        }
        
        for(int i=5;i*i<=N;i=i+6){
            //System.out.println(N);
            //System.out.println(i);

            while(N%i==0){
                largestPrime=i;
                N=N/i;
            }
            
            while(N%(i+2)==0){
                largestPrime=i+2;
                 N=N/(i+2);

            }
            
            
        }
        
        if(N>3){
                largestPrime=N;
             
        }
        
        return largestPrime;
    }
}
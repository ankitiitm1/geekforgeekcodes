//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
    //   if(N==1){
    //         return Integer.toString(S);
    //     }
        
    //   if(S>9){
    //   return "9" + findLargest(N-1, S-9);
          
    //   }
    //   else{
    //       return Integer.toString(S)+findLargest(N-1, 0);
    //   }
        
        String ans="";
        
        if(S>9*N) return "-1";
        if(S==0 && N>1) return "-1";
        if(N==1 && S>9) return "-1";
        
        while(N>0){
          if(S>=9){
              ans=ans+"9";
              S=S-9;
              N=N-1;
          }else{
              ans=ans+Integer.toString(S);
              S=0;
              N--;
          } 
            
        }
        
         return ans;
       
    }
}
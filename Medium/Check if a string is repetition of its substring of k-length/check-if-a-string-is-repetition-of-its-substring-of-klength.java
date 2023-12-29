//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
       if(n%k!=0) return 0;
       HashMap<String, Integer> hm=new HashMap();
       int i=0;
       String str="";
       while(i<=n-k){
           str=s.substring(i,i+k-1);
           i=i+k;
           hm.put(str,hm.getOrDefault(str,0)+1);
       }
       
       int x=hm.size();
       
       if(x>2){ return 0;}
       
       else{
            int count=0;
            for (Map.Entry<String,Integer> entry : hm.entrySet()){
                if(entry.getValue()>1) count++;
                if(count>1) return 0;   
            }
            
       }
       
       
       return 1;
           
    }
}
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static ArrayList<String> arr=new ArrayList<String>(Arrays.asList("A","B","C","D","E","F"
        ,"G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
    String colName (long n)
    {  // ArrayList<String> arr=new ArrayList<String>(Arrays.asList('a','b'));
        if(n<=26){
         return arr.get((int)n-1);
        }
        
        long rem=n%26;
        if(rem==0){return colName(n/26-1)+"Z";}
        else{
        return colName(n/26)+arr.get((int)rem-1);}
    }
}
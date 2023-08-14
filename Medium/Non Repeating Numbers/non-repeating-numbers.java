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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int[] ans=new int[2];
        int xorResult = 0;

        // XOR all numbers to get XOR of distinct numbers
        for (int num : nums) {
            xorResult ^= num;
        }

        // Find a set bit in the XOR result
        int setBit = xorResult & -xorResult;

        int num1 = 0, num2 = 0;

        // Partition the array into two groups based on the set bit
        for (int num : nums) {
            if ((num & setBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        // Print the two distinct numbers in increasing order
        if (num1 < num2) {
            ans[0]=num1;
            ans[1]=num2;
        }else{
            ans[0]=num2;
            ans[1]=num1;
        }
        
       return ans; 
    }
        
        
        
    
}
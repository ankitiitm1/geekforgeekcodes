//{ Driver Code Starts
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
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        HashMap<String, Integer> hm=new HashMap();
     
        for(int i=0;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            
        }
        
        String str[] = new String[2];
        int max=Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> e: hm.entrySet())
        {       
            
               if(e.getValue()>max)
            {
                str[0]=e.getKey();
                str[1]=Integer.toString(e.getValue());
                max=e.getValue();
            }
            
            if(e.getValue()==max)
            {
                if(str[0].compareTo(e.getKey())>0)
                {str[0]=e.getKey();
                str[1]=Integer.toString(e.getValue());}
            }
            
        }
        
       
        return str;
    }
}



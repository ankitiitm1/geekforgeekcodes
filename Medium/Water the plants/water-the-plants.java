//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {   
        
        List<int[]> arr=new ArrayList();
        
        for(int i=0;i<n;i++){
            if(gallery[i]>-1){
                arr.add(new int[]{i-gallery[i],i+gallery[i]});
            }
        }
        
        
        Collections.sort(arr,(a,b)->a[0]-b[0]);
        int ans=0,target=0,i=0;
        
        while(target<n){
            if(i==arr.size()|| arr.get(i)[0]>target){
                return -1;
            }    
            int max_range=arr.get(i)[1];
            while(i+1<arr.size() && arr.get(i+1)[0]<=target){
                i++;
                max_range=Math.max(max_range,arr.get(i)[1]);
            }
            
            if(max_range<target){
                return -1;
            }
            ans++;
            target=max_range+1;
            i++;
        }
        return ans;
    }
}

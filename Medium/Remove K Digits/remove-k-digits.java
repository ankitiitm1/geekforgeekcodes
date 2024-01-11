//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        
        if(S.length()==K) return "0";
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<S.length()){
            while(K>0 && !st.isEmpty() && st.peek()>S.charAt(i)){
                st.pop();
                K--;
            }
            st.push(S.charAt(i));
            i++;
        }
        
        
        while(K>0){
            st.pop();
            K--;
        }
        
        StringBuilder s=new StringBuilder();
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        
        s=s.reverse();
        while(s.length()>1 && s.charAt(0)=='0'){ s.deleteCharAt(0);}
        return s.toString();
    }
}

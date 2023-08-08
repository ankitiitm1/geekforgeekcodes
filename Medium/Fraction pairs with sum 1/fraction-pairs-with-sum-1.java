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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Fraction {
    int numerator;
    int denominator;

    Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }
}

class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        
        HashMap<String,Integer> hm=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            int gcd=gcd(numerator[i],denominator[i]);
            numerator[i]=numerator[i]/gcd;
            denominator[i]=denominator[i]/gcd;
            String key=(denominator[i]-numerator[i])+"/"+denominator[i];
            String keycurr=numerator[i]+"/"+denominator[i];
            double x=(double) (numerator[i]/gcd)/(numerator[i]/gcd);
            
            if(hm.containsKey(key)){
                count=count+hm.get(key);
            }
            
            hm.put(keycurr,hm.getOrDefault(keycurr,0)+1);
        }
        
        return count;

        
    }
    
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
    
}
        

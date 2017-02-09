import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class floydwarshall {

    static Scanner sc = new Scanner(System.in);
    static int i()
    {
        return  sc.nextInt();
    }
    static final int max = Integer.MAX_VALUE/2-1;
    public static void main(String[] args) {
    
        int n = i();
        int e = i();
        int g[][] = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++)
        Arrays.fill(g[i],max);
        
        for(int i=0;i<e;i++)
        g[i()][i()] = i();
        
        for(int i=1;i<=n;i++)
            g[i][i] = 0;
        
        for(int k = 1;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                if( g[i][j] > g[i][k] + g[k][j] )
                g[i][j] = g[i][k] + g[k][j];
            }
        }
        
        int q = i();
        
        StringBuilder s = new StringBuilder();
        
        for(int i=1;i<=q;i++)
        {
            
            int val = g[i()][i()];
            if(val == max)
            val = -1;
            s.append(val+"\n");
        }
        System.out.print(s);
        
    }
}
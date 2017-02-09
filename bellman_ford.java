
//COMPLEXITY BELLMAN FORD O(v*(v-1))
//WORkS ONLY FOR DIRECTED GRAPH

import java.io.*;
import java.util.*;

public class bellman_ford {

    static Scanner sc = new Scanner(System.in);
  
    static int i(){
        return sc.nextInt();
    }
    
    int n,v,s;
    
    HashMap<Integer,Integer> parent = new HashMap();
    HashMap<Integer,Integer> dist = new HashMap();
    static StringBuilder ans = new StringBuilder();
    
    bellman_ford()
    {
       
        n = i();
        v = i();
        
        int edges[][] = new int[v][3];
        
        for(int i=0;i<v;i++)
        {
             edges[i][0] = i();
             edges[i][1] = i();
             edges[i][2] = i();
        }
        
        s = i();
        
        for(int i=1;i<=n;i++)
        dist.put(i,Integer.MAX_VALUE-1000000);
    
        dist.put(s,0);
        
        for(int i=1;i<=v-1;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(dist.get(edges[j][0])>dist.get(edges[j][1])+edges[j][2])
                {
                    dist.put(edges[j][0] , dist.get(edges[j][1])+edges[j][2]);
                    parent.put(edges[j][0],edges[j][1]);
                }
            }
        }
        
       
            for(int i=1;i<=n;i++)
            {
                if(i == s)
                continue;
                
                if(dist.get(i) == Integer.MAX_VALUE-1000000)
                ans.append("-1 ");
                else
                ans.append(dist.get(i)+" ");
            }
            ans.append("\n");
        
    }
    
    public static void main(String[] args)
	{
       
        int t = i();
        
        while(t-->0)
        {
            bellman_ford g = new bellman_ford();    
        }
		
        System.out.print(ans);
    }
    
}
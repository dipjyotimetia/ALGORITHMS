import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class graph {

    int n,e;
    HashMap<Integer,ArrayList<Integer>> list = new HashMap();
    boolean v[];
    int level[];
    ArrayDeque<Integer> q = new ArrayDeque();
    
    //Constructor takes input
    graph(){
       
       n = i();      //no of nodes 
       e = n-1;      //no of egdes
       
       for(int i=0;i<e;i++)               //creating adjacency list
       {
            int a = i();
            int b = i();
           
            if(!list.containsKey(a))
                list.put(a,new ArrayList());
           
            if(!list.containsKey(b))
                list.put(b,new ArrayList());
           
           list.get(a).add(b);
           list.get(b).add(a);
       }
       
       v = new boolean[n+1];
       level = new int[n+1];
      
    }
    
    public void bfs(int root)
    {
        
        add(root);           //Add to queue
        v[root] = true;      //mark visited
        while(!q.isEmpty())   //while queue not empty
        {
            root = remove();       //remove first element from queue
            ArrayList<Integer> ar = list.get(root);
            
            for(int i : ar)          //loop its neighbouring nodes
                if(!v[i])            //If they are not visited
                {
                    add(i);          //add them to end of queue
                    v[i] = true;     //and mark them visited
                }
        }
    }
    
    
    public static void main(String[] args)
    {
        graph g = new graph();
        g.bfs(1);
    }
    
    
   void add(int a)
   {
        q.addFirst(a);
   }
    
   int remove()
   {
        return  q.removeLast();
   }
    
   void p(int a)
   {
        System.out.print(a);
   }    
   void p(String s)
   {
        System.out.print(s);
   }
    
   static Scanner sc = new Scanner(System.in);
  
   static long l(){
        return sc.nextLong();
    }
    static int i(){
        return sc.nextInt();
    }
    static String s(){
        return sc.nextLine();
    }
}

public void bfs(int start)
{    
        node n = nodes.get(start); 
        
        boolean visited[] = new boolean[101];
      
	   ArrayDeque<node> q = new ArrayDeque(); 
        
        q.addFirst(n);
        visited[1] = true;
       
	   while(!q.isEmpty())
        {
            node n1 = q.removeLast();
            
            for(int i : n1.adj)
            {
                if(visited[i] == false)
                {
                    q.addFirst(nodes.get(i));
                    visited[i] = true;
                }
            }
        }
       
}
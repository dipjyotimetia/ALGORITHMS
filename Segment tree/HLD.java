int chainNo=0,chainHead[N],chainPos[N],chainInd[N],chainSize[N];


void hld(int cur) {
    if(chainHead[chainNo] == -1) 
    chainHead[chainNo]=cur;
    chainInd[cur] = chainNo;
    chainPos[cur] = chainSize[chainNo];
    chainSize[chainNo]++;

    int ind = -1,max = -1;
    for(int i = 0; i < adj[cur].length; i++)
    {         
    if(subsize[ adj[cur][i] ] > max)
        {
            max = subsize[ adj[cur][i] ];
            ind = i;
        }
    }

    if(ind >= 0) hld( adj[cur][ind] );

    for(int i = 0; i < adj[cur].sz; i++) {
        if(i != ind) {
            chainNo++;
            hld( adj[cur][i] );
        }
    }
}

//https://blog.anudeep2011.com/heavy-light-decomposition/

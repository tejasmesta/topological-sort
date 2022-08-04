class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int ans[] = new int[V];
        
        int indegree[] = new int[V];
        
        for(int i=0;i<V;i++)
        {
            for(Integer j:adj.get(i))
            {
                indegree[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        int k = 0;
        
        while(!q.isEmpty())
        {
            int rem = q.remove();
            
            ans[k] = rem;
            k++;
            
            for(Integer it:adj.get(rem))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        
        return ans;
    }
}


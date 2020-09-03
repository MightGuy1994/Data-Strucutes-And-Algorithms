class TreeDiameter {
    private int maxDepth = 0;
    private int farNode = -1;
    public int treeDiameter(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] edge : edges) {
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0],new ArrayList<>());
            if(!graph.containsKey(edge[1]))
                graph.put(edge[1],new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        dfs(edges[0][0], graph,visited,0);
        dfs(farNode,graph,visited,0);

        return maxDepth;
    }

    void dfs(int node, Map<Integer,List<Integer>> graph,Set<Integer> set, int d) {
        if(set.contains(node))
            return;
        set.add(node);

        if(d > maxDepth) {
            maxDepth = d;
            farNode = node;
        }
        for(int child : graph.get(node)){
            dfs(child,graph,set,d+1);
        }
        set.remove(node);
    }
}

// time complexity : O(n) is the number of nodes.
// space complexity: O(h) h is the height of tree
// logic : find the farthest node. and then from that node find the max depth.


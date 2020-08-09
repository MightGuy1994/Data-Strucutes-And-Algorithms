//this program is to find critical connection in a network i.e., A connection is called critical when removed, then you cannot reach all the
//nodes in the graph
// I followed a brute force approach. removed each connection and then check if the graph is connected or not. if its not connected, then
// it is called critical connection.
// In leet code its failing with time exceed exception. I need to follow another algorithm.

// time complexity. O(E+V) * E
// space complexity O(V)
class CriticalConnectionBrute {
    private Map<Integer,List<Integer>> graph = new HashMap();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> criticalConnections = new ArrayList();

        //build graph
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i =0; i<n; i++)
            graph.put(i,new ArrayList());

        for(List<Integer> edge : connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        //remove edge
        for(List<Integer> edge : connections){
            graph.get(edge.get(0)).remove(edge.get(1));
            graph.get(edge.get(1)).remove(edge.get(0));

            if(!connectedGraph(n,graph)){
                criticalConnections.add(edge);
            }
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        return criticalConnections;
    }
    //finds if graph is connected
    boolean connectedGraph(int n, Map<Integer,List<Integer>> graph){

        boolean[] visited = new boolean[n+1];
        dfs(graph,visited,0);
        int count =0;
        for(int i =0; i<visited.length;i++){
            if(visited[i])
                count++;
        }
        return (count == n)?true:false;
    }
    //dfs
    void dfs(Map<Integer,List<Integer>> graph, boolean[] visited, int n){
        if(visited[n] == true)
            return;
        visited[n] = true;
        for(int neighbor : graph.get(n)){
            dfs(graph,visited,neighbor);
        }
    }
}
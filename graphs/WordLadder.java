class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> graph = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        set.addAll(wordList);

        //adding nodes in graph
        graph.put(beginWord,new ArrayList<>());
        for(String word : wordList){
            graph.put(word,new ArrayList<>());
        }
        //add edges in graph.
        for(String node : graph.keySet()){
            for(String word : wordList){
                if(isNeighbor(node,word)){
                    graph.get(node).add(word);
                }
            }
        }
        if(graph.get(endWord) == null)
            return 0;

        return bfs(graph,set,beginWord,endWord);
    }

    boolean isNeighbor(String s1, String s2){
        int v = 0;
        for(int i =0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                v++;
            }
        }
        return (v ==1);
    }

    int bfs(Map<String,List<String>> map, Set<String> set, String begin, String end){
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.add(begin);
        set.remove(begin);
        level.add(1);

        while(!queue.isEmpty()){
            String n = queue.poll();
            int l = level.poll();
            if(n.equals(end)) {return l;}
            for(String neighbor : map.get(n)){
                if(set.contains(neighbor)){
                    queue.add(neighbor);
                    level.add(l+1);
                    set.remove(neighbor);
                }
            }
        }
        return 0;
    }
}

// Initially I thought it has hard problem. The logic, find neighbors and then build graph.
// Once graph is built, usd BFS to find shortest distance between the two neighbors.
// TIME Complexity: O(v+e)
// space complexity :O(ve)
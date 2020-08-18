class WordLadderII{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        set.add(beginWord);
        set.addAll(wordList);
        List<List<String>> ans = new ArrayList<>();
        int l = bfs(new HashSet(set),beginWord,endWord);
        dfs(new HashSet(set),beginWord,endWord,l,ans,new ArrayList());
        return ans;

    }

    void dfs(Set<String> set, String beginWord, String endWord,int l, List<List<String>> ans,List<String> list){
        list.add(beginWord);
        if(beginWord.equals(endWord)){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(String neighbor : getNeighbors(beginWord,set)){
            if(list.size()<l){
                dfs(set,neighbor,endWord,l,ans,list);
                list.remove(list.size()-1);
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    int bfs(Set<String> set, String begin, String end){
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.add(begin);
        set.remove(begin);
        level.add(1);
        while(!queue.isEmpty()){
            String n = queue.poll();
            int l = level.poll();
            if(n.equals(end)) {
                return l;
            }
            for(String neighbor : getNeighbors(n,set)){
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

//here I used BFS to find shortest distance and then dfs and back tracking to store list of paths with length equal to bfs.
// Time limit shows exceed in the leetcode. I should come up with the different solution.
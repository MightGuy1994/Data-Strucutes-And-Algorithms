class Solution {
    public String alienOrder(String[] words) {
        //build graph and also store nodes that has no parents

        Map<Character,List<Character>> graph = new HashMap<>();
        Map<Character,Integer> count = new HashMap<>();

        // insert graph nodes
        for(String s : words) {
            for(char ch : s.toCharArray()) {
                graph.put(ch,new ArrayList<>());
                count.put(ch,0);
            }
        }

        // build relationships from the string of words by comparing two words
        for(int i = 0; i <words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            // check if word 2 is a prefix of word1 then return empty string
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";

            for(int j = 0; j <Math.min(word1.length(),word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    count.put(word2.charAt(j),count.get(word2.charAt(j))+1);
                    break;
                }
            }
        }

        // do bfs
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(Character ch : count.keySet()) {
            if(count.get(ch)==0) {queue.add(ch);}
        }

        while (!queue.isEmpty()) {
            Character node = queue.poll();
            sb.append(node);
            for(Character child : graph.get(node)) {
                count.put(child,count.get(child)-1);
                if(count.get(child) == 0) {
                    queue.add(child);
                }
            }
        }
        if(sb.length() < count.size())
            return "";
        return sb.toString();

    }
}


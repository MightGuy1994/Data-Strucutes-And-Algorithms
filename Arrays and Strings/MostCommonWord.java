class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        String[] words = paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split("\\s+");

        for(String word : words){
            if(!set.contains(word)){
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        heap.addAll(map.keySet());
        return  heap.poll();

    }
}

// use heap and map to store the highest frequency word.
// O(nlogn)

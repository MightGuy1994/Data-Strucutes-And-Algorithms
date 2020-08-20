class CowsAndBulls {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();
        int cows = 0;
        int bulls =0;
        for(char ch : secret.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : guess.toCharArray()){

            if(map.get(ch) !=null){

                if(map.get(ch) > 0){
                    map.put(ch,map.get(ch)-1);
                    cows++;
                }
            }
        }
        for(int i =0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                cows--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}

// consider everything as cows.
// then compare each postion and then find bulls

// O(n)

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Map<int[],Double> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> Double.compare(map.get(a),map.get(b)));

        for(int[] point : points){
            map.put(point,getDistance(point));
        }

        heap.addAll(map.keySet());
        int i = 0;
        int[][] result = new int[K][2];
        while(!heap.isEmpty() && i<K){
            result[i] = heap.poll();
            i++;
        }
        return result;
    }

    public Double getDistance(int[] point) {
        int x = point[0]*point[0];
        int y = point[1]*point[1];
        Double d = Math.sqrt(x+y);
        return d;
    }
}

// time complexity : O(nlogk);
// space complexity : O(n)

// intuition: same has the top k frqeuent, here we should sort by minimum distance
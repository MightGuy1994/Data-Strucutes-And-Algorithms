class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int rooms = 0;
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int[] arr : intervals){
            if(!heap.isEmpty()){
                int[] earliestMeeting = heap.peek();
                if(earliestMeeting[1] <= arr[0]){
                    heap.poll();
                }
            }
            heap.add(arr);
        }
        return heap.size();
    }
}

// interesting question. Just sort by starting times of meetings. then use priority queue data struture to store only
// currently running meetings. when ever a new meeting pair occurs, poll the heap for the room that has least end time
// compare and if the end is greater than next meeting start, add this meeting
// else poll the completed meeting.
// heap size effectively determines the number of rooms.

// time complexity : O(Nlogn)

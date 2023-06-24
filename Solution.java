class Solution {
    public int videoStitching(int[][] clips, int time) {
        // for every clip with a start time smaller then or equal to our current time, 
        // pick the clip with the latest end time.
        int clippings = 0;
        int currTime = 0;
        int i = 0;
        int maxEndTime = 0;
	// sort clips by start time so we can order our choices for the greedy alg.
	clips = sortByStartTime(clips);

        while(currTime < time) {
            if(i >= clips.length) {
                return -1;
            }

            if(clips[i][0] > currTime) {
                if(maxEndTime < clips[i][0]) {
                    return -1;
                }
                clippings ++;
                currTime = maxEndTime;
            }
            
            else {
                if(maxEndTime < clips[i][1]){
                    maxEndTime = clips[i][1];
                }
                if(clips[i][1] >= time) {
                    return clippings + 1;
                }
                i ++;
            }

        }
        return clippings;
        
    }
    
    // note: using bubble sort as it is the easiest
    // sorting algorithm to code up, could speed up program
    // by using a more efficient sorting algorithm like merge sort or something
    private int[][] sortByStartTime(int[][] clips) {
        for(int i = 0; i < clips.length; i++) {
            for(int j = 0; j < clips.length - i - 1; j++) {
                if(clips[j][0] > clips[j + 1][0]) {
                    int[] ref = clips[j];
                    clips[j] = clips[j+1];
                    clips[j+1] = ref;
                }
            }
        }
        return clips;
    }
}

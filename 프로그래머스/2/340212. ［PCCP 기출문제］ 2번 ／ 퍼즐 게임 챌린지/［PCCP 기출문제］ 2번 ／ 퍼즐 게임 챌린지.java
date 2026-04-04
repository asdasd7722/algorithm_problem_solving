class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int len = diffs.length;
        int left = 0;
        int right = 0;
        for(int i = 0; i < len; ++i) {
            right = Math.max(right, diffs[i]);
        }
        
        while(true) {
            int mid = (left + right) / 2;
            if(left == mid) break;
            long time = 0;
            
            for(int i = 0; i < len; ++i) {
                int gap = diffs[i] - mid;
                
                if(gap > 0) time += (times[i - 1] + times[i]) * gap + times[i];
                else time += times[i];
            }
            
            if(time > limit) left = mid;
            else right = mid;
        }
        
        int answer = left + 1;
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
            
        int prev = -1;
        for(int i = 0; i < targets.length; ++i) {
            if(targets[i][0] >= prev) {
                answer++;
                prev = targets[i][1];
            }
        }
        return answer;
    }
}
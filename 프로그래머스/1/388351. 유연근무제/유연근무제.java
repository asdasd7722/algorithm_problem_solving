class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; ++i) {
            schedules[i] += 10;
            if(schedules[i] % 100 >= 60) schedules[i] += 40;
        }
        for(int i = 0; i < schedules.length; ++i) {
            boolean flag = true;
            for(int j = 0; j < 7; ++j) {
                int day = j + startday;
                if(day == 6 || day == 7 || day == 13) continue;
                if (schedules[i] < timelogs[i][j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
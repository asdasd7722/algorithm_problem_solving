class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] cnt = new int[n + 2];
        for(int i = 1; i <= n; ++i) {
            cnt[i] = 1;
        }
        for(int l : lost) {
            cnt[l]--;
        }
        for(int r : reserve) {
            cnt[r]++;
        }

        int answer = 0;

        for(int i = 1; i <= n; ++i) {
            if(cnt[i] == 0 && cnt[i - 1] == 2) {
                cnt[i - 1]--;
                cnt[i]++;
            }
            else if(cnt[i] == 0 && cnt[i + 1] == 2) {
                cnt[i + 1]--;
                cnt[i]++;
            }
        }

        for(int c : cnt) {
            if(c != 0) answer++;
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1;; ++i) {
            int sum = 0;
            int j = i;
            while(j-- > 0) {
                sum += j;
            }
            if((n - sum) % i == 0) answer++;
            if((n - sum) / i <= 1) break;
        }
        return answer;
    }
}